package se.lexicon.michelle.model;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.data.ProductSequencer;

import static org.junit.Assert.*;

public class CandyTest {

    Candy candy;
    String[] ingredients;

    @Before
    public void setUp() throws Exception {

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
    public void arrayContainsString() {
    }

    @Test
    public void addStringToArray() {
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
        assertArrayEquals(expected, candy.getIngredients());;

    }
    @Test(expected = IllegalArgumentException.class)
    public void given_null_addIngredients_should_add_ingredient()  throws IllegalArgumentException{

        candy.addIngredients(null , ingredients);

    }

    @Test
    public void examine() {
    }

    @Test
    public void getCost() {
    }

    @Test
    public void use() {
    }

    @Test
    public void getProductID() {
    }

    @Test
    public void getCalories() {
    }

    @Test
    public void getProductName() {
    }

    @Test
    public void getBrand() {
    }

    @Test
    public void getIngredients() {
    }

    @Test
    public void setBrand() {
    }

    @Test
    public void setCalories() {
    }

    @Test
    public void setProductName() {
    }

    @Test
    public void setIngredients() {
    }
}