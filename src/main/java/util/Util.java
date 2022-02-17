package util;

import java.util.regex.Pattern;

public class Util {


    /**
     * Method to validate if a String contains a valid number based on a defined regex of numbers
     *
     * @param option A String that will be checked if its matches with a regex of numbers
     *
     * @return true if the String parameter matches to the defined regex of numbers otherwise false
     */

    public static boolean validOption(String option) {

        final String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(option).matches();
    }

    /**
     * Method to validate if a String/password attend the minimum length
     *
     * @param input A String/password that will have the length checked according criteria
     *
     * @return int value of the String/password length or respective calc if it is lower than the requested length
     */
    public static int checkPasswordLength(String input) {

        final int size = 6;

        if(input.length() < size){
            return (size - input.length());
        }

        return input.length();
    }

    /**
     * Method to validate if a String contains valid chars based on defined regex
     *
     * @param input A String that will be checked if its matches with a defined regex
     *
     * @return int value with the number of missing chars not be found into defined regex
     */
    public static int validRegex(String input){

        final String regexUpperCase = ".*[A-Z].*";
        final String regexLowerCase = ".*[a-z].*";
        final String regexNumbers = ".*[0-9].*";
        final String regexSpecialChars = ".*[!@#$%^&*()-+].*";

        int result = 0;

        result += (getPattern(regexUpperCase,input) ? 0 : 1);
        result += (getPattern(regexLowerCase,input) ? 0 : 1);
        result += (getPattern(regexNumbers,input) ? 0 : 1);
        result += (getPattern(regexSpecialChars,input) ? 0 : 1);

        return result;

    }

    /**
     * Method return if a string is found into a regex
     *
     * @param regex The regex that will be compiled in pattern
     * @param input The String to be checked by the regex
     *
     * @return true if string is find in regex otherwise false.
     */
    private static boolean getPattern(String regex, String input){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input).matches();
    }

}
