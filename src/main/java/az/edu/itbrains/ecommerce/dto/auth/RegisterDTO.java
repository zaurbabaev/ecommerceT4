package az.edu.itbrains.ecommerce.dto.auth;


import az.edu.itbrains.ecommerce.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String name;
    private String surname;
    private LocalDate birthdayDate;
    private String email;
    private String password;
    private Gender gender;
}

