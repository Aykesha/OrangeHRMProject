package com.orangeHRM.utils;

import com.orangeHRM.entities.AuthorisationPageEntities;
import com.orangeHRM.endpoints.SideBarMenuEndpoints;
import com.orangeHRM.pages.AuthorisationPage;
import java.util.Random;

public class RandomUtils {

    private static final String NAME = ConfigReader.getValue("name");
    private static final String PASSWORD = ConfigReader.getValue("password");
    private static final Random RANDOM = new Random();


    public AuthorisationPageEntities createUser() {
        return AuthorisationPageEntities.builder()
                .userNameInput(NAME)
                .passwordInput(PASSWORD)
                .build();
    }

    public void fillUpAuthorisationsForms() {
        AuthorisationPage authorisationPage = new AuthorisationPage();
        authorisationPage.getUsernameField().sendKeys(createUser().getUserNameInput());
        authorisationPage.getPasswordField().sendKeys(createUser().getPasswordInput());
    }

    public static String getRandomSideBarMenu() {
        SideBarMenuEndpoints[] values = SideBarMenuEndpoints.values();
        int randomIndex = RANDOM.nextInt(values.length);
        return values[randomIndex].getSideBarMenuEnum();
    }

}


