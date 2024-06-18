package com.orangeHRM.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    private static Properties properties;

    private ConfigReader() {

    }

    static {

        try {
            String path = "src/main/resources/drivers/app.properties";           // в обычный стринг положили путь к файлу
            FileInputStream fileInputStream = new FileInputStream(path);  // создали класс FIS(path) - открыли поток и в этот объект попадают все данные с app.properties
            properties = new Properties();                                // создаем объект и инициализировали properties
            properties.load(fileInputStream);                             // хотим положить все данные (содержимое), кот-ые были в fileIS
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValue(String key) {   // создаем метод "получить значения" и будем запрашивать ключ
        return properties.getProperty(key).trim(); // возвращаем объект с содержимым файла и вызываем метод, запрашивая что-то конкретное без пробелов
    }


}


