package model;

import lombok.*;


// Авторизировать зарегистрированного пользователя
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginModel {

    private String email;
    private String password;

}
