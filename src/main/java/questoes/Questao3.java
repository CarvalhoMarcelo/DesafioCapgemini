package questoes;

import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Questao3 {

    /**
     * Amount of anagrams found
     */
    static int anagramsNumber = 0;

    /**
     * List of the anagrams words found
     */
    static List<String> resultList = new ArrayList<>();


    /**
     * Method to check if a world contains anagrams
     *
     * @param input A string input from user
     *
     * @return A string with the amount of anagrams founded
     */
    public static String getAnagrams(String input) {

        int startIndex = 0;
        int endIndex = 1;
        List<String> strList = new ArrayList<String>();

        // Loop para criar um array de strings que será usado para criar permutações
        // O loop irá gerar arrays individuais com tamanhos de 1 ao comprimento maximo da palavra
        // sempre pegando o proximo caracter do array para compor a palavra, e depois será esvaziado
        // para criar o proximo array com strings de comprimento maior
        // Ex. Palavra 'abcdefg', array1[a,b,c,d,e,f,g], array2[ab,bc,cd,ef..], array3[abc,bcd,cde...]
        for (int i = 0; i < input.length(); i++) {
            if(startIndex+endIndex <= input.length()){
                strList.add(input.substring(startIndex,startIndex+endIndex));
                startIndex++;
            }
            // Após a criação de cada array, antes de finalizar o loop, inicia a verificação de anagramas
            if((i + 1) == input.length()){
                checkArray(strList); // Verifica se existem anagramas
                strList = new ArrayList<String>(); // limpa o array para criar um novo com a proxima combinação
                i = -1; // Reinicia a variavel para o loop não finalizar até todas as combinações serem formadas
                startIndex = 0;
                endIndex++; // Incrementa o indice que irá controlar a finalização do loop após todas as combinações terem sido criadas
            }
            if(endIndex > input.length()){ // Finaliza o loop após esgotado todas as combinações na palavra original
                break;
            }
        }
        int result = anagramsNumber;
        anagramsNumber = 0; // Limpa a variavel estatica para não ter risco de ter algo na memória e gerar contagem falsa.
        System.out.println(result);
        return String.valueOf(result);
    }

    /**
     * Method that will check and compare if there are anagrans in the input list
     *
     * @param strArray Array with the user input split
     */
    public static void checkArray(List<String> strArray){

        // controle de final do array principal após todas as iterações
        int indexCount = 0;

        // array temporário que será utilizado na comparação de strings
        List<String> compareStrArray = new ArrayList<>();

        //Leitura do array de strings com a palavra escolhida pelo usuario
        for (int j = 0; j < strArray.size(); j++) {

            // Criar um novo array somente com as strings diferentes da string que será comparada
            if (j != indexCount){
                compareStrArray.add(strArray.get(j));
            }
            // Se na proxima iteração for o final do array, fazer a comparação antes de finalizar o loop
            if(j+1 == strArray.size()){
                if(indexCount < strArray.size()){ // Verifica se o array principal foi lido completamente

                    // Utiliza o array temporario e cria um novo array de resultados
                    // com todas as permutações possíveis para cada string do array
                    // obtendo assim todas as possibilidades de anagramas para cada string
                    List<String> result = new ArrayList<String>();
                    for (String s : compareStrArray) {
                        String[] tempStrArray = s.split("");
                        Util.strPermute(tempStrArray, "",compareStrArray.get(0).length(),compareStrArray.get(0).length(), result);
                    }

                    // Verifica se o array de resultados possue uma string igual a string do array principal
                    // que será pesquisada, pois o array de resultados contem todas as possiveis permutações
                    // de palavras e anagramas do array principal, e caso uma dessas permutações seja igual
                    // a string pesquisada significa que existe um anagrama para aquela palavra.
                    if(result.contains(strArray.get(indexCount))){
                        if(!resultList.contains(strArray.get(indexCount))){ // Evita duplicidade de anagramas já encontrado
                            resultList.add(strArray.get(indexCount)); // armazena o anagrama encontrado
                            strArray.remove(strArray.get(indexCount)); // remove a string pesquisada do array principal para evitar duplicidade e falso resultado
                            anagramsNumber++; // incrementa o contador de anagramas encontrados
                        }
                    }
                }
                indexCount++; // incrementa o controle do array original para garantir o final do loop no momento certo
                j = -1; // volta o indice do array original para o inicio, pois o outro indice é que irá controlar o final
                compareStrArray = new ArrayList<String>(); // limpa o array temporario de comparações
            }
            if(indexCount > strArray.size()){ // após todas as comparações e permutações, encerra o loop do array original
                break;
            }
        }
    }



}
