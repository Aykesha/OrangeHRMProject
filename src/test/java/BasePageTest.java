import com.orangeHRM.drivers.DriverManager;
import com.orangeHRM.helper.BrowserHelper;
import com.orangeHRM.helper.WebElementActions;
import com.orangeHRM.pages.AuthorisationPage;
import com.orangeHRM.pages.OrangeHRMPages;
import com.orangeHRM.pages.SideBarMenu;
import com.orangeHRM.pages.TopBarMenuPage;
import com.orangeHRM.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasePageTest {

    protected WebDriver driver;

    protected WebElementActions webElementActions;

    protected RandomUtils randomUtils;

    protected BrowserHelper browserHelper;

    protected OrangeHRMPages orangeHRMPages;

    protected AuthorisationPage authorisationPage;

    protected SideBarMenu sideBarMenu;

    protected TopBarMenuPage topBarMenuPage;


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.getDriver();
        webElementActions = new WebElementActions();
        browserHelper = new BrowserHelper(driver);
        orangeHRMPages = new OrangeHRMPages();
        orangeHRMPages.setUp();  // Вызов метода для инициализации страниц, созданного в OrangeHRMPages;
        authorisationPage = new AuthorisationPage();
        randomUtils = new RandomUtils();
        sideBarMenu = new SideBarMenu();
        topBarMenuPage = new TopBarMenuPage();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverManager.closeDriver();
    }


}