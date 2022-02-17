package questoes;

import util.Util;

public class Questao2 {

    /**
     * Method to check if password is strong according to defined criteria
     */
    public static String checkPassword(String input) {

        final int passwordMissingLength = Util.checkPasswordLength(input);
        final int missingChars = Util.validRegex(input);
        final int minLengthPassword = 6;
        String result = "";

        if(input.length() <= (minLengthPassword / 2)) {
            result = String.valueOf(minLengthPassword - input.length());
        } else {
            if (missingChars > 0) {
                if (missingChars >= passwordMissingLength || passwordMissingLength >= minLengthPassword) {
                    result = String.valueOf(missingChars);
                } else {
                    result = String.valueOf(passwordMissingLength);
                }
            } else if (input.length() < 6) {
                result = String.valueOf(minLengthPassword - input.length());
            }
        }
        System.out.println(result);

        return result;
    }

}
