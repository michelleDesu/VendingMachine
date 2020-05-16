package se.lexicon.michelle.model;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.data.ProductSequencer;
import se.lexicon.michelle.interfaces.Product;

import static org.junit.Assert.*;

public class CandyTest {

    Candy candy;
    String[] ingredients;

    @Before
    public void setUp() throws Exception {
        ProductSequencer.resetProductId();

        ingredients = new String[]{
                "Milk",
                "Cacao",
                "Wheat"
        };
        candy = new Candy(
                ProductSequencer.nextID(),
                "Chocolate",
                20,
                "Marabou",
                "1365",
                ingredients
        );

    }


    @Test
    public void given_string_addStringToArray_should_add_string_to_array() {
        String[] expected = {
                "Milk",
        };
        String[] actual = new String[0];
        actual = Product.addStringToArray(actual , "Milk");
        assertArrayEquals(expected, actual);

    }

    @Test
    public void given_ingredient_addIngredients_should_add_ingredient() {
        String[] expected = {
                "Milk",
                "Cacao",
                "Wheat",
                "sugar"
        };
        candy.addIngredients("sugar" , ingredients);
        assertArrayEquals(expected, candy.getIngredients());

    }
    @Test(expected = IllegalArgumentException.class)
    public void given_null_addIngredients_should_add_ingredient()  throws IllegalArgumentException{

        candy.addIngredients(null , ingredients);

    }

    @Test
    public void examine() {
        StringBuilder expectedProductInfo = new StringBuilder();
        expectedProductInfo.append("Name: Chocolate\n");
        expectedProductInfo.append("ID: 1\n");
        expectedProductInfo.append("Price: 20\n");
        expectedProductInfo.append("Brand: Marabou\n");
        expectedProductInfo.append("Calories: 1365\n");
        expectedProductInfo.append("The ingredients are:\n");
        for (String ingredient : ingredients) {
            expectedProductInfo.append(ingredient).append("\n");
        }
        String actual = candy.examine();

        assertEquals(expectedProductInfo.toString(), actual);
    }
    @Test
    public void use() {

        String expected= "you now received a " + candy.getProductName() +
                " with the id of " + candy.getProductID()
                + "\n";

        assertEquals(expected,candy.use() );
    }

    @Test
    public void getCost() {
        int expected = 20;
        assertEquals(expected, candy.getCost());
    }

    @Test
    public void getProductID() {
        int expected = 1;
        assertEquals( expected, candy.getProductID());
    }

    @Test
    public void getCalories() {
        String expected = "1365";
        assertEquals(expected, candy.getCalories());
    }

    @Test
    public void getProductName() {
        String expected = "Chocolate";
        assertEquals(expected, candy.getProductName());
    }

    @Test
    public void getBrand() {
        String expected = "Marabou";
        assertEquals(expected, candy.getBrand());
    }

    @Test
    public void getIngredients() {
       String[] expected = ingredients;
       assertArrayEquals(expected, candy.getIngredients());
    }

    @Test
    public void setBrand() {
        String expected = "Änglamark";
        candy.setBrand("Änglamark");
        assertEquals(expected, candy.getBrand());
    }

    @Test
    public void setCalories() {
        String expected = "200";
        candy.setCalories("200");
        assertEquals(expected, candy.getCalories());
    }

    @Test
    public void setProductName() {
        String expected = "Ahlgrens Bilar";
        candy.setProductName("Ahlgrens Bilar");
        assertEquals(expected, candy.getProductName());
    }

    @Test
    public void setIngredients() {
        String[] expected = {
                "Milk",
                "Cacao",
                "Wheat",
                "sugar"
        };
        String[] newIngredients = {
                "Milk",
                "Cacao",
                "Wheat",
                "sugar"
        };
        candy.setIngredients(newIngredients);
        assertArrayEquals(expected, candy.getIngredients());
    }

    @Test
    public void testEquals_Symmetric() {
         // equals and hashCode check name field value
        Candy expected = new Candy(
                1,
                "Chocolate",
                20,
                "Marabou",
                "1365",
                ingredients
        );
        assertTrue(expected.equals(candy) && candy.equals(expected));
        assertEquals(expected.hashCode(), candy.hashCode());
    }
}