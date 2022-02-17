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

        for (int i = 0; i < input.length(); i++) {
            if(startIndex+endIndex <= input.length()){
                strList.add(input.substring(startIndex,startIndex+endIndex));
                startIndex++;
            }
            if((i + 1) == input.length()){
                checkArray(strList);
                strList = new ArrayList<String>();
                i = -1;
                startIndex = 0;
                endIndex++;
            }
            if(endIndex > input.length()){
                break;
            }
        }
        int result = anagramsNumber;
        anagramsNumber = 0;
        System.out.println(result);
        return String.valueOf(result);
    }

    /**
     * Method that will check and compare if there are anagrans in the input list
     *
     * @param strArray Array with the user input split
     */
    public static void checkArray(List<String> strArray){

        int indexCount = 0;
        List<String> compareStrArray = new ArrayList<>();

        for (int j = 0; j < strArray.size(); j++) {

            if (j != indexCount){
                compareStrArray.add(strArray.get(j));
            }
            if(j+1 == strArray.size()){
                if(indexCount < strArray.size()){

                    List<String> result = new ArrayList<String>();
                    for (String s : compareStrArray) {
                        String[] tempStrArray = s.split("");
                        Util.StrPermute(tempStrArray, "",compareStrArray.get(0).length(),compareStrArray.get(0).length(), result);
                    }

                    if(result.contains(strArray.get(indexCount))){
                        if(!resultList.contains(strArray.get(indexCount))){
                            resultList.add(strArray.get(indexCount));
                            strArray.remove(strArray.get(indexCount));
                            anagramsNumber++;
                        }
                    }
                }
                indexCount++;
                j = -1;
                compareStrArray = new ArrayList<String>();
            }
            if(indexCount > strArray.size()){
                break;
            }
        }
    }



}
