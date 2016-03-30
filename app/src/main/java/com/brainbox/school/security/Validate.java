package com.brainbox.school.security;

/**
 * Created by adityaagrawal on 09/02/16.
 */
public class Validate {

    public static boolean isValidEmailAddress(String email) {
        if (email.length() > 0)
            return true;
        return false;
    }

    public static boolean isPasswordValid(String password) {
        if (password.length() > 0)
            return true;
        return false;
    }

    public static boolean isMobileValid(String mobile) {
        if (mobile.length() == 10)
            return true;
        return false;
    }

    public static boolean isCityValid(String school) {
        if (school.length() > 0)
            return true;
        return false;
    }

    public static boolean isStreetValid(String school) {
        if (school.length() > 0)
            return true;
        return false;
    }

    public static boolean isNameValid(String school) {
        if (school.length() > 0)
            return true;
        return false;
    }

    public static boolean isStateValid(String school) {
        if (school.length() > 0)
            return true;
        return false;
    }

    public static boolean isPincodeValid(String school) {
        if (school.length() == 6)
            return true;
        return false;
    }

    public static boolean isSchoolNameValid(String school) {
        if (school.length() > 0)
            return true;
        return false;
    }

}
