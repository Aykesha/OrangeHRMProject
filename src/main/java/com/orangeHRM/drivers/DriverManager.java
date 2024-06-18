package com.orangeHRM.drivers;

import com.orangeHRM.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverManager {  // через этот класс мы будем управлять классами браузеров

    private static WebDriver driver; // создали инстанс и не проинициализировали

    public static WebDriver getDriver(){     // создали метод статичный, который будет возвращать интерфейс WebDriver и дали название getDriver()
        if (driver == null){                 // добавляем условие, если driver == null
            switch (ConfigReader.getValue("browser").toLowerCase()){   // если null, найди файл и найди значение этого браузера, если там chrome то используй метод в классе Chrome
                case "chrome":               // если будет chrome, то возьми значение ChromeWebDriver.loadChromeDriver();
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                // чтобы дальше не ушел в другой кейс

                default:
                    throw new IllegalArgumentException("You provided wrong Driver name");
            }
        }
        return driver;
    }


    public static void closeDriver() {
        try {
            if (driver != null) {
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            System.err.println("Error while closing driver");
        }

    }
}