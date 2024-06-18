package com.orangeHRM.entities;
import lombok.*;
import org.openqa.selenium.WebElement;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class AuthorisationPageEntities {
    private String userNameInput;
    private String passwordInput;
}
