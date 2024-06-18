package com.orangeHRM.pages;

import com.orangeHRM.endpoints.SideBarMenuEndpoints;
import com.orangeHRM.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarMenu extends BasePage {

    @FindBy(className = "oxd-topbar-body")   // это родительский xpath
    public WebElement topBarBody;

    @FindBy(className = "oxd-sidepanel-body")
    public WebElement sideBarMenu;





    // Метод для открытия соответствующего эндпоинта
    public void openEndpoint1(SideBarMenuEndpoints endpoint) {
     //   browserHelper.open("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        browserHelper.open(ConfigReader.getValue("baseURL") + endpoint.getSideBarMenuEnum());

    }


}

