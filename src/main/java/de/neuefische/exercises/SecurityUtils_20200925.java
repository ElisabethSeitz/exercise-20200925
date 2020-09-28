package de.neuefische.exercises;

public class SecurityUtils_20200925 {


    public static boolean validatePassword(String inputStr) {
        boolean out = isLongEnough(inputStr) && containsNumber(inputStr) && containsLowerCase(inputStr) && containsUpperCase(inputStr);
        return out;
    }

    public static boolean[] arrayPassword (String [] arrayPassword){
        boolean [] ausgabeArray = new boolean[arrayPassword.length];

        for (int i = 0; i < arrayPassword.length ; i++) {
            ausgabeArray[i] = validatePassword(arrayPassword[i]);
        }
        return ausgabeArray;
    }

    public static boolean isLongEnough(String inputStr){
        boolean out = inputStr.length()>=8;
        return out;
    }

    public static boolean containsNumber(String inputStr) {
        boolean out =inputStr.matches(".*[0-9].*");
        return out;
    }

    public static boolean containsUpperCase (String inputStr) {
        boolean upperCase = inputStr.matches(".*[A-Z].*");
        return upperCase;
    }

    public static boolean containsLowerCase (String inputStr) {
        boolean lowerCase = inputStr.matches(".*[a-z].*");
        return lowerCase;
    }

}
