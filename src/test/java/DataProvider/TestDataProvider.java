package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestDataProvider
{
    @DataProvider(name = "data-provider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"qweqweqwe@asdasd.com", true}, {"123123@123.org", false}, {"asdasd", false}, {"sdfsdfsdf", false},
                              {"----@----.--", false}, {"", false}, {"q@q.q", false}};
    }
}
