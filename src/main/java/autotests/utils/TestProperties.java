package autotests.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    private final Properties properties = new Properties();

    private static TestProperties INSTANCE = null;

    private TestProperties(){
        System.setProperty("application", "application");
        try {
            properties.load(new FileInputStream(new File("./" + System.getProperty("application") + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestProperties getInstance() {
        if (INSTANCE == null){
            INSTANCE = new TestProperties();
        }
        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}


/*
#language: ru

        Функционал: Добавление и удаление товаров

@web
  Сценарий: iphone

          * выполнена авторизация на сервисе с логином - "comedy.standup.best@gmail.com" и паролем - "123456qwerty"
          * выполнен поиск по "iphone"
          * цена ограничена до "60000" руб
          * в корзину добавлены первые 8 "нечетных" товаров
          * выполнен переход в корзину
          * все добавленные ранее товары находятся в корзине
          * итоговая цена "смартфонов" равна сумме цен добавленных товаров
          * из корзины удалены все товары
          * выполнен выход из сервиса
          * выполнена авторизация на сервисе с логином - "comedy.standup.best@gmail.com" и паролем - "123456qwerty"
          * выполнен переход в корзину
          * корзина содержит заголовок "Корзина пуста"*/
