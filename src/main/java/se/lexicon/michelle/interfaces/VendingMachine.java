package se.lexicon.michelle.interfaces;

import se.lexicon.michelle.exceptions.InsufficientFunds;
import se.lexicon.michelle.exceptions.NonExistingProduct;
import se.lexicon.michelle.model.Candy;

public interface VendingMachine {
    void addCurrency (int amount);
    Product request (int productNumber) throws NonExistingProduct, InsufficientFunds;
    int endSession ();
    String getDescription (int productNumber) throws NonExistingProduct;
    int getBalance ();
    String [] getProducts ();
    Product[] addProduct(Product[] products, Product product);
}
