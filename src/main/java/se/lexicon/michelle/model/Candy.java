package se.lexicon.michelle.model;
import se.lexicon.michelle.data.ProductSequencer;
import se.lexicon.michelle.interfaces.ICandy;
import se.lexicon.michelle.interfaces.Product;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.Objects;

public class Candy implements ICandy {
    String calories,
            productName,
            brand;
    String[] ingredients;

    private final int COST;
    private final int PRODUCT_ID;


    /**
     *Constructor
     */
    public Candy(int productId, String productName, int cost, String brand, String calories, String[] ingredients) {
        setCalories(calories);
        setProductName(productName);
        setBrand(brand);
        setIngredients(ingredients);
        this.COST = cost;
        this.PRODUCT_ID =productId;
    }


    /**
     * Adds an ingredient to the array of ingredients.
     * @param ingredient String
     * @param ingredients String[]
     * @throws IllegalArgumentException exception
     */
    @Override
    public void AddIngredients(String ingredient, String[] ingredients){
            if(ingredient == null){
                throw new IllegalArgumentException("ingredient can't be empty");
            }
            ingredients = Product.addStringToArray(ingredients, ingredient);
    }


    /**
     * show product info.
     * @return String
     */
    @Override
    public String examine() {
        StringBuilder productInfo = new StringBuilder();
        productInfo.append("Name: ").append(getProductName()).append("\n");
        productInfo.append("ID: ").append(getProductID()).append("\n");
        productInfo.append("Price: ").append(getCost()).append("\n");
        productInfo.append("Brand: ").append(getBrand()).append("\n");
        productInfo.append("Calories: ").append(getCalories()).append("\n");
        productInfo.append("The ingredients are:\n");
        for(String ingredient : ingredients){
            productInfo.append(ingredient).append("\n");
        }
        return productInfo.toString();
    }

    /**
     * returns the price of the product
     * @return int
     */
    @Override
    public int getCost() {
        return COST;
    }


    /**
     * use / consume the product.
     * @return String
     */
    @Override
    public String use() {
        return "you now consumed a " + getProductName() + " with the id of " + getProductID();
    }

    @Override
    public int getProductID() {
        return PRODUCT_ID;
    }
    public String getCalories() {
        return calories;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    public String getBrand() {
        return brand;
    }


    public String[] getIngredients() {
        return Arrays.copyOf(ingredients , ingredients.length);
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }



    public void setCalories(String calories) {
        this.calories = calories;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candy candy = (Candy) o;
        return COST == candy.COST &&
                PRODUCT_ID == candy.PRODUCT_ID &&
                Objects.equals(calories, candy.calories) &&
                Objects.equals(productName, candy.productName) &&
                Objects.equals(brand, candy.brand) &&
                Arrays.equals(ingredients, candy.ingredients);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(calories, productName, brand, COST, PRODUCT_ID);
        result = 31 * result + Arrays.hashCode(ingredients);
        return result;
    }
}
