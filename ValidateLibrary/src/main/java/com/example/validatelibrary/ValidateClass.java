package com.example.validatelibrary;

import android.util.Patterns;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ValidateClass {

    private static final String PHONE_REGEX = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
    private static final String NAME_REGEX = "(\\b[A-Z]{1}[a-z]+)( )([A-Z]{1}[a-z]+\\b)";
    private static final String AGE_REGEX = "^(?:[1-9][0-9]?|1[01][0-9]|120)$";
    private static final String WEAK_PASSWORD_REGEX = "^.{1,7}$";
    private static final String MEDIUM_PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
    private static final String STRONG_PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
    private static final String DATE_REGEX = "^(0[1-9]|[1-2][0-9]|3[0-1])([-./])(0[1-9]|1[0-2])\\2\\d{4}$";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("ddMMyyyy");

    static {
        DATE_FORMAT.setLenient(false);
    }


    /**
     * Checks if the provided string matches the email pattern.
     *
     * @param email the email string to check
     * @return true if string matches the pattern, false otherwise
     */
    public static boolean checkEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    /**
     * Checks if the provided string matches the phone number pattern.
     *
     * @param number the phone number string to check
     * @return true if string matches the pattern, false otherwise
     */
    public static boolean checkPhoneNumber(String number) {
        return number.matches(PHONE_REGEX);
    }


    /**
     * Checks if the provided string matches the full name pattern.
     *
     * @param name the name string to check
     * @return true if string matches the pattern, false otherwise
     */
    public static boolean checkValidName(String name) {
        return name.matches(NAME_REGEX);
    }


    /**
     * Checks if the provided string matches the age pattern.
     *
     * @param age the age string to check
     * @return true if string matches the pattern, false otherwise
     */
    public static boolean checkAge(String age) {
        return age.matches(AGE_REGEX);
    }


    /**
     * Checks if the provided age is greater than the provided minimum age.
     *
     * @param age    the age to check
     * @param minAge the minimum age
     * @return true if age > minAge, false otherwise
     */
    public static boolean checkLegalAge(int age, int minAge) {
        return age > minAge;
    }


    /**
     * Checks if the provided string is considered a weak password.
     *
     * @param password the password string to check
     * @return true if string is a weak password, false otherwise
     */
    public static boolean checkWeakPassword(String password) {
        return password.matches(WEAK_PASSWORD_REGEX);
    }


    /**
     * Checks if the provided string is considered a medium password.
     *
     * @param password the password string to check
     * @return true if string is a medium password, false otherwise
     */
    public static boolean checkMediumPassword(String password) {
        return password.matches(MEDIUM_PASSWORD_REGEX);
    }


    /**
     * Checks if the provided string is considered a strong password.
     *
     * @param password the password string to check
     * @return true if string is a strong password, false otherwise
     */
    public static boolean checkStrongPassword(String password) {
        return password.matches(STRONG_PASSWORD_REGEX);
    }

    /**
     * Checks the type of the provided password.
     *
     * @param password the password string to check
     * @return PasswordTypes enum representing the password type
     * WEAK - 0
     * MEDIUM - 1
     * STRONG - 2
     * INVALID - 3
     */
    public static PasswordTypes checkPasswordType(String password) {
        PasswordTypes type = PasswordTypes.INVALID;
        if (checkWeakPassword(password))
            type = PasswordTypes.WEAK;
        if (checkMediumPassword(password))
            type = PasswordTypes.MEDIUM;
        if (checkStrongPassword(password))
            type = PasswordTypes.STRONG;
        return type;
    }

    /**
     * Checks if the provided string matches the date pattern.
     *
     * @param date the date string to check
     * @return true if string matches the pattern, false otherwise
     */
    public static boolean checkDateFormat(String date) {
        return date.matches(DATE_REGEX);
    }


    /**
     * Checks if the provided date can be a legal date of birth.
     *
     * @param date       the date string to check
     * @param minimumAge the minimum age for the date to be considered legal
     * @return true if the date is not in the future and age is greater than the minimum, false otherwise
     */
    public static boolean checkBirthDate(String date, int minimumAge) {
        if (!checkDateFormat(date)) {
            return false;
        }

        // Remove optional separators from the date string
        String cleanedDateOfBirth = date.replaceAll("[-./]", "");

        try {
            // Parse the date string
            Date parsedDate = DATE_FORMAT.parse(cleanedDateOfBirth);

            // Perform additional checks
            Date currentDate = new Date();

            // Check if the date is not in the future
            if (parsedDate.after(currentDate)) {
                return false;
            }

            Calendar currentDateCal = Calendar.getInstance();
            Calendar birthDate = Calendar.getInstance();
            birthDate.setTime(parsedDate);

            int age = currentDateCal.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

            // Check if the current date is before the birth date
            // to account for cases where the birthday hasn't happened yet this year
            if (currentDateCal.get(Calendar.MONTH) < birthDate.get(Calendar.MONTH) ||
                    (currentDateCal.get(Calendar.MONTH) == birthDate.get(Calendar.MONTH) &&
                            currentDateCal.get(Calendar.DAY_OF_MONTH) < birthDate.get(Calendar.DAY_OF_MONTH))) {
                age--;
            }

            return checkLegalAge(age, minimumAge);

        } catch (ParseException e) {
            // The date string is not in a valid format
            return false;
        }
    }
}