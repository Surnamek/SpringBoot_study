package com.example.Vaildation.validator;

import com.example.Vaildation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {

    private String dataForm;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.dataForm = constraintAnnotation.dateForm();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        try{
            LocalDate localDate = LocalDate.parse(value, DateTimeFormatter.ofPattern(this.dataForm));
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
