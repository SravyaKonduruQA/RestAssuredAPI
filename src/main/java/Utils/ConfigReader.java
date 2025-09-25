package Utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Arrays;
import java.util.List;
public class ConfigReader {




        private static Properties prop;

        static {
            try {
                FileInputStream fis = new FileInputStream("target/Stage.properties");
                prop = new Properties();
                prop.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static String getProperty(String key) {
            return prop.getProperty(key);
        }

        public static String getEnvBaseUri(String apiType) {
            String env = getProperty("env");
            return getProperty(env + ".baseUri." + apiType);
        }

        public static List<String> getList(String key) {
            String value = getProperty(key);
            return Arrays.asList(value.split(","));
        }
    }

