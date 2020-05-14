package se.lexicon.michelle.data;

public class ProductSequencer {
    private static int productId = 0;

    public static int nextID(){
        return ++productId;
    }

    public static void resetProductId(){
        productId = 0;
    }
}
