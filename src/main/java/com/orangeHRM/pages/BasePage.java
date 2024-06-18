package com.orangeHRM.pages;

import com.orangeHRM.drivers.DriverManager;
import com.orangeHRM.helper.BrowserHelper;
import com.orangeHRM.helper.WebElementActions;
import org.openqa.selenium.support.PageFactory;

public abstract class  BasePage {

    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

        public WebElementActions webElementActions = new WebElementActions();

  public BrowserHelper browserHelper = new BrowserHelper(DriverManager.getDriver());

    }

