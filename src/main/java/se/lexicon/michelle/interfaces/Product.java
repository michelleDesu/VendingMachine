package se.lexicon.michelle.interfaces;

import java.util.Arrays;

public interface Product {

    String examine();
    String use();
    int getProductID();
    int getCost();
    String getProductName();

    static String[] addStringToArray(String[] array, String toAdd){
        String[] newArray = Arrays.copyOf(array, array.length+ 1);
        newArray[newArray.length-1] = toAdd;
        return newArray;
    }



}
