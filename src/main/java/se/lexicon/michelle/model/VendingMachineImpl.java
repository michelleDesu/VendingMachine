package se.lexicon.michelle.model;

import se.lexicon.michelle.exceptions.*;
import se.lexicon.michelle.interfaces.Product;
import se.lexicon.michelle.interfaces.VendingMachine;
import se.lexicon.michelle.enums.*;

import java.util.Arrays;

public class VendingMachineImpl implements VendingMachine {
    private int depositPool;
    Product[] products;

    /**
     * default constructor
     */
    public VendingMachineImpl() {
        products = new Product[0];
        depositPool = 0;
    }


    /**
     *
     * @param depositPool int
     */
    private void setDepositPool(int depositPool) {
        this.depositPool = depositPool;
    }

    /**
     * Add to the deposit pool.
     * @param amount int
     */
    @Override
    public void addCurrency(int amount) {
        /*
            checks if the amount is a valid denomination by comparing it to values in the denomination Enum.
         */
        boolean isValidDenomination = false;
       for(Denomination d : Denomination.values()){
           if(d.getMaxDenomination() == amount){
               isValidDenomination = true;
               setDepositPool(depositPool + amount);
               break;
           }
       }
       //throws exception if the amount is illegal.
        if(!isValidDenomination){
            throw new IllegalArgumentException("The amount is not a valid denomination");
        }

    }

    /**
     * Buy a Product. retunr the bought product
     * @param productNumber int
     * @return Product
     * @throws NonExistingProduct exception
     * @throws InsufficientFunds exception
     */
    @Override
    public Product request(int productNumber) throws NonExistingProduct, InsufficientFunds{
        for (Product product : products){
            if(product.getProductID() == productNumber){
                if( depositPool - product.getCost() >= 0){
                    depositPool -= product.getCost();
                    return product;
                }
                //throws exception if the amount you are trying to buy is lower than 0
                throw new InsufficientFunds("You don't have enough money");
            }
        }

        //if product does not exist
       throw new NonExistingProduct("The product does not exist");
    }

    //Returns change and resets the deposit pool.
    @Override
    public int endSession() {
        int restDeposit = depositPool;
        depositPool = 0;
        return restDeposit;
    }

    //View a product description
    @Override
    public String getDescription(int productNumber) throws NonExistingProduct {

        for (Product product : products){
            if(product.getProductID() == productNumber){
                return product.examine();
            }
        }
        throw new NonExistingProduct("The product does not exist, therefore no description found");
    }

    //Returns the deposit pool amount
    @Override
    public int getBalance() {
        return depositPool;
    }

    //Returns all Products' names and product numbers
    @Override
    public String[] getProducts() {
        String[] newProducts = new String[0];
        for (Product product: products){
            newProducts = addStringToArray(
                    newProducts,
                    product.getProductName() + " " + product.getProductID()
            );
        }
        return Arrays.copyOf(newProducts, newProducts.length);
    }

    @Override
    public Product[] addProduct(Product[] productsArray, Product product) {
        if(product == null){
            throw new IllegalArgumentException("The specified product can not be null");
        }
        Product[] newProducts = Arrays.copyOf(products, products.length + 1);
        newProducts[newProducts.length - 1] = product;
        products = newProducts;

        return Arrays.copyOf(products, products.length);

    }

    private static String[] addStringToArray(String[] array, String toAdd){
        String[] newArray = Arrays.copyOf(array, array.length+ 1);
        newArray[newArray.length-1] = toAdd;
        return newArray;
    }
    //Mainly for testing
    public void clear() {
        products = new Product[0];

    }
    //Mainly for testing
    public void resetDepositPool(){
        depositPool = 0;
    }

}
