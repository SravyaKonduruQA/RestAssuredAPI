package Utils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
public class TestDataUtil {




        private static JsonNode testData;

        static {
            try {
                ObjectMapper mapper = new ObjectMapper();
                InputStream inputStream = TestDataUtil.class
                        .getClassLoader()
                        .getResourceAsStream("TestData.json");

                if (inputStream == null) {
                    throw new RuntimeException("testdata.json not found in resources folder!");
                }

                testData = mapper.readTree(inputStream);
                System.out.println("✅ JSON Loaded: " + testData.toPrettyString());
            } catch (Exception e) {
                throw new RuntimeException("Failed to load testdata.json", e);
            }
        }
    public static String getBaseUrl() {
        String url = testData.path("baseUrl").asText();
        if (url == null || url.isEmpty()) {
            throw new RuntimeException("baseUrl is missing in JSON!");
        }
        return url;
    }

        public static String getUserId() {
            return testData.path("user").path("userId").asText();
        }

        public static String getSessionId() {
            return testData.path("user").path("sessionId").asText();
        }

        public static String getContentType() {
            return testData.path("user").path("contentType").asText();
        }
    public static String getPokemonName() {
        return testData.path("user").path("pokemonName").asText();
    }

    public static String getPokemonEndPoint() {
            return testData.path("endpoints").path("getPokemon").asText();
    }
}

