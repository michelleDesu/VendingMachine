package se.lexicon.michelle.interfaces;

import java.util.Arrays;

public interface Product {

    String examine();
    String use();
    int getProductID();
    int getCost();
    String getProductName();

    static boolean arrayContainsString(String[] array, String string){
        for (String s : array){
            if(s.equalsIgnoreCase(string)){
                return true;
            }
        }
        return false;
    }
    static String[] addStringToArray(String[] array, String toAdd){
        String[] newArray = Arrays.copyOf(array, array.length+ 1);
        newArray[array.length-1] = toAdd;
        return newArray;
    }



}
