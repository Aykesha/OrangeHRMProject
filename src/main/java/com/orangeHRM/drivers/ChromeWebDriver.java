package com.orangeHRM.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import static com.orangeHRM.utils.ConfigReader.getValue;

public class ChromeWebDriver {
    public static WebDriver loadChromeDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();     // добавили объект Option(настройки, сертификаты, )
        options.addArguments("--remote-allow-origins=*"); // передаем, чтобы запускать эти тесты не локально, а ч/з удаленный сервер
        options.addArguments("--disable-extensions");  //  отключает все установленные расширения в браузере Chrome
        options.addArguments("--window-size-1920,1080");    // если метод maximize не сработает, то даем исп-ть это расширение --window-size-1920,1080
        options.addArguments("--no-sandbox");    // работаей по определ-му сервису

        if (Boolean.parseBoolean(getValue("headless"))) { // если в апп.проперти тру, то запарсь getValue("headless)
            options.addArguments("--headless");// идея headlessa - тестируй без открытия браузера
        }

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
