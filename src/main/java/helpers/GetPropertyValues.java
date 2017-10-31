package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class GetPropertyValues {
    public static String result = "";
    private static FileInputStream inputStream;

    public static String getPropValues(String propertyName) throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = System.getProperty("user.dir") + "/src/main/resources/config/config.properties";
            inputStream = new FileInputStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());
            String propertyValue = prop.getProperty(propertyName);
            result = propertyValue;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }

        return result;
    }

    public static String getChromeBinary() throws IOException {
        return  getPropValues("chrome.binary.dir");
    }
    public static String getEnv() throws IOException {
        return getPropValues("env");
    }
    public static String getHub() throws IOException {
        return getPropValues("hub");
    }
    public static String getNodeBrowser() throws IOException {
        return getPropValues("node_browser");
    }
    public static String getNodeBrowserVersion() throws IOException {
        return getPropValues("node_browser_version");
    }
    public static int getWidth() throws IOException {
        return Integer.parseInt(getPropValues("width"));
    }
    public static int getHeight() throws IOException {
        return Integer.parseInt(getPropValues("height"));
    }


}
