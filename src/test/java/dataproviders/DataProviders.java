package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "test")
    public static Object[][] searchExistData() {
        return new Object[][]{
                {"ellina.frolova@bigdropinc.com", "Aa1234567", "ELLINA FROLOVA"}
        };
    }
}
