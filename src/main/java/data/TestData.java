package data;

import com.github.javafaker.Faker;

public class TestData {
    // Базовый URL
    public static final String BASE_URI = "https://stellarburgers.education-services.ru";

    // Генерируем данные для пользователя
    static Faker user = new Faker();
    public static final String EMAIL = user.name().lastName().toLowerCase() +
            System.currentTimeMillis() + user.regexify("[0-9]{4}") + "@yandex.ru";
    public static final String PASSWORD = user.regexify("[0-9]{6}");
    public static final String INVALID_PASSWORD = user.regexify("[0-9]{5}");
    public static final String NAME = user.name().firstName() + System.currentTimeMillis();

    // Эндпоинты
    public static final String CREATE_USER = "/api/auth/register";
    public static final String DELETE_USER = "/api/auth/user";
}
