package com.example.validateprofile;

import androidx.lifecycle.ViewModel;

import com.example.validatelibrary.ValidEasyClass;

public class ValidViewModel extends ViewModel {

    public String validate(String input, ValidEasyType type) {
        switch (type) {
            case EMAIL:
                return ValidEasyClass.checkEmail(input) ? "Valid Email" : "Invalid Email";
            case PHONE:
                return ValidEasyClass.checkPhoneNumber(input) ? "Valid Phone" : "Invalid Phone";
            case NAME:
                return ValidEasyClass.checkValidName(input) ? "Valid Name" : "Invalid Name";
            case AGE:
                return checkAge(input);
            case PASSWORD:
                return "Password Type: " + ValidEasyClass.checkPasswordType(input).toString();
            case DATE:
                return checkDate(input);
            default:
                return "Invalid Input";
        }
    }

    private String checkAge(String age) {
        if (ValidEasyClass.checkAge(age)) {
            int ageValue = Integer.parseInt(age);
            return ValidEasyClass.checkLegalAge(ageValue, 18) ? "Valid and Legal Age" : "Valid but Illegal Age";
        } else {
            return "Invalid Age";
        }
    }

    private String checkDate(String date) {
        if (ValidEasyClass.checkDateFormat(date)) {
            return ValidEasyClass.checkBirthDate(date, 18) ? "Legal Date" : "Illegal Date";
        } else {
            return "Invalid Date";
        }
    }
}