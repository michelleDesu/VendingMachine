package se.lexicon.michelle.model;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.data.ProductSequencer;
import se.lexicon.michelle.exceptions.InsufficientFunds;
import se.lexicon.michelle.exceptions.NonExistingProduct;
import se.lexicon.michelle.interfaces.Product;

import static org.junit.Assert.*;

public class VendingMachineImplTest {
    private VendingMachineImpl vendingMachine;
    private Candy chocolate,
            ahlgrensBilar;
    private String[] ingredients;
    private Product[] products;

    @Before
    public void setUp() throws Exception {
        vendingMachine = new VendingMachineImpl();
        products = new Product[0];
        ProductSequencer.resetProductId();
        vendingMachine.clear();
        vendingMachine.addCurrency(100);

        ingredients = new String[]{
                "milk",
                "wheat",
                "gelatine"
        };
        chocolate = new Candy(
                ProductSequencer.nextID(),
                "Milk chocolate",
                20,
                "Marabou",
                "1536",
                ingredients
        );
        ahlgrensBilar = new Candy(
                ProductSequencer.nextID(),
                "Ahlgrens Bilar",
                15,
                "Ahlgrens",
                "250",
                ingredients
        );

        products = vendingMachine.addProduct(products, chocolate);
        products = vendingMachine.addProduct(products, ahlgrensBilar);
    }

    @Test (expected = IllegalArgumentException.class)
    public void given_nullParameter_addProduct_should_throw_exception() throws IllegalArgumentException {
        products = vendingMachine.addProduct(products, null);
    }

    @Test
    public void given_correct_amount_addCurrency() {
        int expected = 200;
        vendingMachine.addCurrency(100);
        assertEquals(expected, vendingMachine.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_incorrect_amount_addCurrency() {
        vendingMachine.addCurrency(102);
    }

    @Test
    public void given_existing_id_request() throws InsufficientFunds, NonExistingProduct {
        Product expected = new Candy(
                1,
                "Milk chocolate",
                20,
                "Marabou",
                "1536",
                ingredients
        );
        Product actual = vendingMachine.request(1);
        assertEquals(expected, actual);

    }
    @Test(expected = InsufficientFunds.class)
    public void given_Existing_id_request_throw_InsufficientFunds() throws InsufficientFunds, NonExistingProduct {
        vendingMachine.resetDepositPool();
        ProductSequencer.resetProductId();

        Product actual = vendingMachine.request(1);

    }

    @Test(expected = NonExistingProduct.class)
    public void given_nonExisting_id_request() throws InsufficientFunds, NonExistingProduct {
        Product actual = vendingMachine.request(5);

    }

    @Test
    public void endSession() throws InsufficientFunds, NonExistingProduct {
        int expectedChange = 80,
                expectedBalance = 0;
        Product actual = vendingMachine.request(1);
        int actualChange = vendingMachine.endSession(),
                actualBalance = vendingMachine.getBalance();

        assertEquals(expectedChange, actualChange);
        assertEquals(expectedBalance, actualBalance);

    }

    @Test
    public void given_correct_id_getDescription_should_return_description() throws NonExistingProduct {

        StringBuilder expectedProductInfo = new StringBuilder();
        expectedProductInfo.append("Name: Milk chocolate\n");
        expectedProductInfo.append("ID: 1\n");
        expectedProductInfo.append("Price: 20\n");
        expectedProductInfo.append("Brand: Marabou\n");
        expectedProductInfo.append("Calories: 1536\n");
        expectedProductInfo.append("The ingredients are:\n");
        for (String ingredient : ingredients) {
            expectedProductInfo.append(ingredient).append("\n");
        }
        String actual = vendingMachine.getDescription(1);

        assertEquals(expectedProductInfo.toString(), actual);
    }

    @Test(expected = NonExistingProduct.class)
    public void given_incorrect_id_getDescription_should_throwException() throws NonExistingProduct {

        vendingMachine.getDescription(0);

    }


    @Test
    public void getBalance() {
        int expected = 300;
        vendingMachine.addCurrency(200);
        assertEquals(expected, vendingMachine.getBalance());
    }

    @Test
    public void getProducts() {
        String[] expectedProducts = new String[2];
        expectedProducts[0] = chocolate.getProductName() + " " + chocolate.getProductID();
        expectedProducts[1] = ahlgrensBilar.getProductName() + " " + ahlgrensBilar.getProductID();


        assertArrayEquals(expectedProducts, vendingMachine.getProducts());
    }
}
