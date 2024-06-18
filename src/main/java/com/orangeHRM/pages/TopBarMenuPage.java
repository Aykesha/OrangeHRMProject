package com.orangeHRM.pages;

import com.orangeHRM.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class TopBarMenuPage extends BasePage {

    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']/ul/li")
    public List<WebElement> topBarOptions;

    @FindBy(xpath = "//nav[@class='oxd-topbar-body-nav']/ul/li/ul/li")
    public List<WebElement> dropDownTopBarOptions;

    /**
     * Метод для выбора опции в верхнем меню и в выпадающем меню (если оно есть).
     *
     * @param topBarOption Опция верхнего меню.
     * @param dropDownOption Опция выпадающего меню (может быть null).
     */
    public void selectOptionsOfTopBarMenuAndDropDownMenu(String topBarOption, String dropDownOption) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li")));

        WebElement topBarElement = findTopBarOption(topBarOption);
        webElementActions.click(topBarElement);

        // Если указан параметр dropDownOption, проверяем наличие выпадающего меню
        if (dropDownOption != null && !dropDownOption.isEmpty()) {
            // Проверяем, есть ли выпадающее меню
            boolean hasDropdown = hasDropdownMenu(topBarElement);

            if (hasDropdown) {
                // Метод для нахождения и клика по элементу из выпадающего меню
                clickDropdownOption(wait, dropDownOption);
            }
        }
    }

    /**
     * Приватный метод для поиска опции верхнего меню.
     *
     * @param topBarOption Опция верхнего меню.
     * @return WebElement найденной опции.
     */
    private WebElement findTopBarOption(String topBarOption) {
        for (int attempts = 0; attempts < 5; attempts++) {
            try {
                return topBarOptions.stream()
                        .filter(o -> o.getText().trim().equals(topBarOption))
                        .findFirst()
                        .orElseThrow(() -> new NoSuchElementException("Опция верхнего меню не найдена: " + topBarOption));
            } catch (StaleElementReferenceException e) {
                // Повторное нахождение элементов при исключении StaleElementReferenceException
                refreshTopBarOptions();
            }
        }
        throw new NoSuchElementException("Опция верхнего меню не найдена после нескольких попыток: " + topBarOption);
    }

    /**
     * Приватный метод для обновления списка опций верхнего меню.
     */
    private void refreshTopBarOptions() {
        topBarOptions = DriverManager.getDriver().findElements(By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li"));
    }

    /**
     * Приватный метод для проверки наличия выпадающего меню.
     *
     * @param topBarElement Элемент верхнего меню.
     * @return true, если выпадающее меню есть, иначе false.
     */
    private boolean hasDropdownMenu(WebElement topBarElement) {
        try {
            return topBarElement.findElement(By.xpath("./ul")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Приватный метод для нахождения и клика по элементу из выпадающего меню.
     *
     * @param wait Объект WebDriverWait для ожидания.
     * @param dropdownOption Опция выпадающего меню.
     */
    private void clickDropdownOption(WebDriverWait wait, String dropdownOption) {
        boolean optionClicked = false;
        int attempts = 0;

        while (!optionClicked && attempts < 5) {
            try {
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//nav[@class = 'oxd-topbar-body-nav']/ul/li/ul/li")));
                optionClicked = dropDownTopBarOptions.stream()
                        .filter(option -> option.getText().trim().equals(dropdownOption))
                        .findFirst()
                        .map(option -> {
                            webElementActions.click(option);
                            return true;
                        })
                        .orElse(false);
            } catch (StaleElementReferenceException e) {
                attempts++;
                // Повторный запрос на получение элементов, если произошло исключение StaleElementReferenceException
                refreshDropdownOptions();
            }
        }
    }

    /**
     * Приватный метод для обновления списка опций выпадающего меню.
     */
    private void refreshDropdownOptions() {
        dropDownTopBarOptions = DriverManager.getDriver().findElements(By.xpath("//nav[@class='oxd-topbar-body-nav']/ul/li/ul/li"));
    }
}