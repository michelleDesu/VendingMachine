package se.lexicon.michelle.exceptions;

public class NonExistingProduct extends Exception{
    public NonExistingProduct(String ErrorMessage) {
        super(ErrorMessage);
    }
}
