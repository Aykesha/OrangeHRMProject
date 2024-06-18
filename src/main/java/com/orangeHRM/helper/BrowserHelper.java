package com.orangeHRM.helper;

import com.orangeHRM.utils.ConfigReader;
import com.orangeHRM.utils.RandomUtils;
import org.openqa.selenium.WebDriver;
import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {   // Помощник по управлению браузером

    private WebDriver driver;

    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.navigate().to(url);    // открывает страницу
    }

//    public void openRandomEndPoint(){
//        open(ConfigReader.getValue("baseURL") + RandomUtils.getRandomSideBarMenu());
//    }

    public void goBack() {   // Стрелка назад, вперед, переключение с/у вкладками, обновление  не относится к WebElements поэтому для них создаем отдельный класс
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().back();   // вперед
    }

    public void refreshThePage() {
        driver.navigate().back();
    }

    public Set<String> getWindowHandles() {    // В Set чтобы не было дубликатов, и храниться список вкладок
        return driver.getWindowHandles();
    }

    public void switchToWindow(int index) {   // переключиться на это окошко / по индексам
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());   // должны положить все активные вкладки с этого SETа
        // и в параметрах прописываем меод, кот-ый возвращает Set с уникальными значениями

        for (String window : windowsId) {   // перебрали все вкладки по 1му
            System.out.println(window);
        }

        if (index < 0 || index > windowsId.size())
            throw new IllegalArgumentException("Invalid Index: " + index);  // если после IF одна строка, то тело не обязательно

        driver.switchTo().window(windowsId.get(index));
    }


    public void switchToParentWindow() {
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());

        driver.switchTo().window(windowsId.get(0));   // просит вернуться к родитеской вкладке
    }

    // создадим метод, который закроет все вкладки и возвратиться к родительской вкладке
    public void switchToParentWithChildClose() {
        switchToParentWindow(); // переключаемся к родительской вкладке
        LinkedList<String> windowsId = new LinkedList<>(getWindowHandles());

        // if (windowsId.size() < 2)
        //логика: родитель под 0 индексом и мы его не берем, индекс с 1 до конца всех вкладок
        for (int i = 1; i < windowsId.size(); i++) {
            driver.switchTo().window(windowsId.get(i));  // перебираем по 1му
            driver.close();
        }
        switchToParentWindow();
    }


}