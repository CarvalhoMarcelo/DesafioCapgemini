import questoes.Questao1;
import questoes.Questao2;
import questoes.Questao3;
import util.Util;

import java.util.Scanner;

public class DesafioCapgemini {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite uma das opções que estão entre os parenteses abaixo: ");
        System.out.println("(1) - Questão 1 - Gerar asteriscos");
        System.out.println("(2) - Questão 2 - Verificar password");
        System.out.println("(3) - Questão 3 - Buscar anagramas");
        System.out.println("Qualquer outro caracter para sair");

        final String choice = scanner.next();

        getChoice(choice);

    }

    /**
     * Method to choose what question will be called
     *
     * @param choice A String between 1 and 3 otherwise the program will be finished
     */
    private static void getChoice(String choice){

        if(Util.validOption(choice)){
            int number = Integer.parseInt(choice);
            switch (number) {
                case 1 :
                    Questao1.fillAsterisks(getInputQuestao1());
                    break;
                case 2 :
                    Questao2.checkPassword(getInputQuestao2());
                    break;
                case 3 :
                    Questao3.getAnagrams(getInputQuestao3());
                    break;
                default :
                    break;
            }
        }
    }

    /**
     * Method to request the input for the Questao 1
     *
     * @return a String with the user input
     */
    public static String getInputQuestao1(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite um numero maior que 0: ");
        final String input = scanner.next();
        scanner.close();
        return input;
    }

    /**
     * Method to request the input for the Questao 2
     *
     * @return a String with the user input
     */
    public static String getInputQuestao2(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor digite uma senha forte conforme os critérios abaixo:");
        System.out.println("No mínimo 6 caracteres.");
        System.out.println("No mínimo 1 digito");
        System.out.println("No mínimo 1 letra em minúsculo.");
        System.out.println("No mínimo 1 letra em maiúsculo.");
        System.out.println("No mínimo 1 caractere especial. Os caracteres especiais são: !@#$%^&*()-+");

        final String input = scanner.next();
        scanner.close();
        return input;
    }

    /**
     * Method to request the input for the Questao 3
     *
     * @return a String with the user input
     */
    public static String getInputQuestao3(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor digite uma palavra para verificar se possue anagramas:");
        final String input = scanner.next();
        scanner.close();
        return input;
    }


}
