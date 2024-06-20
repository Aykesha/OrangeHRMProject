package com.orangeHRM.pages;

import lombok.*;
import org.testng.annotations.BeforeClass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OrangeHRMPages extends BasePage {

    protected AuthorisationPage authorisationPage;
    protected SideBarMenu sideBarMenu;


    @BeforeClass(alwaysRun = true)
    public void setUp() {

       authorisationPage = new AuthorisationPage();
       sideBarMenu = new SideBarMenu();


    }

}
