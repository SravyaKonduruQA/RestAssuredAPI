package Utils;

public class EndPointProvider {

        public static String getPokemonEndpoint(String pokemonName) {
            return "/pokemon/" + pokemonName;
        }

        public static String getUserEndpoint(String userId) {
            return "/users/" + userId;
        }
    }
