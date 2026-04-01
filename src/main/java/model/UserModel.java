package model;
import lombok.*;

// Создать пользователя
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private String email;
    private String password;
    private String name;
}