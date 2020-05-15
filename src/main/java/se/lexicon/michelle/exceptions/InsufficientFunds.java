package se.lexicon.michelle.exceptions;

public class InsufficientFunds extends Exception{
    public InsufficientFunds(String errorMessage) {
        super(errorMessage);
    }
}
