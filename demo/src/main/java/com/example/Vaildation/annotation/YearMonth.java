package com.example.Vaildation.annotation;

import com.example.Vaildation.validator.YearMonthValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = YearMonthValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface YearMonth {
    String message() default "날짜 입력 양식에 맞지 않습니다. ex) yyyyMMdd";

    String dateForm() default "yyyyMMdd";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
