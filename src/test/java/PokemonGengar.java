
import SpecFactory.RequestSpecFactory;
import SpecFactory.ResponseSpecFactory;
import Utils.ConfigReader;
import Utils.EndPointProvider;
import Utils.POJO.PokemonPOJO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class PokemonGengar {

    private static final Logger log = LoggerFactory.getLogger(PokemonGengar.class);

    @Test(enabled = false)
        public void getGengarDetailsDynamic() {

            String pokemonName = "gengar";
            String baseUri = "https://pokeapi.co/api/v2";

            // Example headers or query params (null if not needed)
            Map<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/json");
         Map<String, String> cookies= new HashMap<>();
         cookies.put("sessionId", "223343");
         cookies.put("user", "sravya34");
            Map<String, String> queryParams = null;

            given()
                    .spec(RequestSpecFactory.createRequestSpec(baseUri, headers,cookies, queryParams))
                    .when()
                    .get("/pokemon/{name}", pokemonName)
                    .then()
                    .spec(ResponseSpecFactory.createResponseSpec(200))
                    .body("name", equalToIgnoringCase(pokemonName))
                    .body("abilities.size()", greaterThan(0));
                    //.log().all();
        }
        @Test(enabled = false)
    public void getGengarResponseCookies() {

        String pokemonName = "gengar";
        String baseUri = "https://pokeapi.co/api/v2";

        // Example headers or query params (null if not needed)
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        Map<String, String> cookies= new HashMap<>();
        cookies.put("sessionId", "223343");
        cookies.put("user", "sravya34");
        Map<String, String> queryParams = null;
System.out.println(cookies);
Response res= RestAssured.given()
                .spec(RequestSpecFactory.createRequestSpec(baseUri, headers, cookies, queryParams))
                .when()
                .get("/pokemon/{name}", pokemonName)
                .then()
                .spec(ResponseSpecFactory.createResponseSpec(200)).extract().response();
        //.log().all();
String rescookie= res.getCookie("sessionId");
System.out.println("cookie:" +rescookie);
    }


    @DataProvider(name = "pokemonNames")
    public static Object[][] pokemonData() {
        return new Object[][] {
                {ConfigReader.getProperty("pokemon1")},
                {ConfigReader.getProperty("pokemon2")},
                {ConfigReader.getProperty("pokemon3")}
        };
    }
    @Test(dataProvider = "pokemonNames", dataProviderClass = PokemonGengar.class)
    public void getPokemonDetails(String pokemonName) {
        String baseUri = ConfigReader.getProperty(ConfigReader.getProperty("env") + ".baseUri.pokemon");
        System.out.println(baseUri);

        Response response = given()
                .spec(RequestSpecFactory.createRequestSpec(baseUri, null,null,null))
                .when()
                .get(EndPointProvider.getPokemonEndpoint(pokemonName))
                .then()
                .spec(ResponseSpecFactory.createResponseSpec(200))
                .extract().response();
        PokemonPOJO pokemon= response.as(PokemonPOJO.class);//response.as(PojoUtil.class) converts the JSON response into a Java object of type Pokemon.
      assertThat(pokemon.getName(), equalToIgnoringCase(pokemonName));
        assertThat(pokemon.getAbilities().size(), greaterThan(0));
        System.out.println("Pokemon: " + pokemon.getName() + " | Abilities: " + pokemon.getAbilities().size());
    }


    }


