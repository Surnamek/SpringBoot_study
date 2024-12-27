package com.example.Vaildation.model;

import com.example.Vaildation.annotation.PhoneNumber;
import com.example.Vaildation.annotation.YearMonth;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

//    @NotBlank
    private String name;

    private String nickName;

    @Size(min = 1, max = 12)
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private int age;

    @Email
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @YearMonth
    private String registerAt;


    //중복되는 조건이면 method를 만들어 사용
    @AssertTrue(message = "name or nickName 중 반드시 한개는 존재해야 합니다.")
    public boolean isNameCheck() {

        if(Objects.nonNull(name) && !name.isBlank()){
            return true;
        }
        if(Objects.nonNull(nickName) && !nickName.isBlank()){
            return true;
        }
        return false;
    }
}
