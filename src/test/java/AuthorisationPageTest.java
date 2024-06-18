import com.orangeHRM.utils.ConfigReader;
import org.testng.annotations.Test;

public class AuthorisationPageTest extends BasePageTest {

    @Test(description = "Verify login input")
    public void authorisationFormTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL"));
        randomUtils.fillUpAuthorisationsForms();
        webElementActions.click(authorisationPage.getLoginButton());
        Thread.sleep(10000);
    }
}
















