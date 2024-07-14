package com.example.validateprofile;

import androidx.lifecycle.ViewModel;
import com.example.validatelibrary.PasswordTypes;
import com.example.validatelibrary.ValidateClass;

public class ValidateViewModel extends ViewModel {

    public String validate(String input, ValidateType type) {
        switch (type) {
            case EMAIL:
                return ValidateClass.checkEmail(input) ? "Valid Email" : "Invalid Email";
            case PHONE:
                return ValidateClass.checkPhoneNumber(input) ? "Valid Phone" : "Invalid Phone";
            case NAME:
                return ValidateClass.checkValidName(input) ? "Valid Name" : "Invalid Name";
            case AGE:
                return checkAge(input);
            case PASSWORD:
                return "Password Type: " + ValidateClass.checkPasswordType(input).toString();
            case DATE:
                return checkDate(input);
            default:
                return "Invalid Input";
        }
    }

    private String checkAge(String age) {
        if (ValidateClass.checkAge(age)) {
            int ageValue = Integer.parseInt(age);
            return ValidateClass.checkLegalAge(ageValue, 18) ? "Valid and Legal Age" : "Valid but Illegal Age";
        } else {
            return "Invalid Age";
        }
    }

    private String checkDate(String date) {
        if (ValidateClass.checkDateFormat(date)) {
            return ValidateClass.checkBirthDate(date, 18) ? "Legal Date" : "Illegal Date";
        } else {
            return "Invalid Date";
        }
    }
}