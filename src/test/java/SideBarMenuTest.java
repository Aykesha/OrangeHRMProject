import com.orangeHRM.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.orangeHRM.endpoints.SideBarMenuEndpoints.ADMIN;

public class SideBarMenuTest extends BasePageTest {

    @BeforeClass
    public void authorisationFormTest() throws InterruptedException {
        browserHelper.open(ConfigReader.getValue("baseURL"));
        randomUtils.fillUpAuthorisationsForms();
        webElementActions.click(authorisationPage.getLoginButton());
        Thread.sleep(10000);
    }

    @Test
    public void testChooseRandomSideBarMenu(){
        //browserHelper.openRandomEndPoint();
        sideBarMenu.openEndpoint1(ADMIN);

    }
}
