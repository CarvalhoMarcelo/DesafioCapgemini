package questoes;

import util.Util;

public class Questao1 {

    /**
     * Method to design a kind of ladder of asterisks based on a chosen number
     *
     * @param input A string input from user
     *
     * @return A string with a kind of ladder made of asterisks
     */
    public static String fillAsterisks(String input) {

        int number = 0;
        StringBuilder stringBuilder = new StringBuilder();


        if(Util.validOption(input)) {
            number = Integer.parseInt(input);
        }

        for (int index = number; index >= 1; index--) {
            stringBuilder.append(" ".repeat(Math.max(0, index - 1)));
            stringBuilder.append(index > 1 ? "*".repeat(Math.max(0, (number - (index - 1)))).concat("\n") : "*".repeat(number));
        }

        System.out.print(stringBuilder);

        return stringBuilder.toString();

    }

}
