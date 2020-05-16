package se.lexicon.michelle.model;
import se.lexicon.michelle.data.ProductSequencer;
import se.lexicon.michelle.interfaces.ICandy;
import se.lexicon.michelle.interfaces.Product;
import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.Objects;

public class Candy implements ICandy {
    private String calories,
            productName,
            brand;
    private String[] ingredients;

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
    public void addIngredients(String ingredient, String[] ingredients){
            if(ingredient == null){
                throw new IllegalArgumentException("ingredient can't be empty");
            }
            ingredients = Product.addStringToArray(ingredients, ingredient);
            setIngredients(ingredients);
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
     * use / consume the product.
     * @return String
     */
    @Override
    public String use() {
        return "you now received a " + getProductName() +
                " with the id of " + getProductID() + "\n";
    }
    /**
     * returns the products id
     * @return int
     */
    @Override
    public int getProductID() {
        return PRODUCT_ID;
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
     * returns the calories in the specified product
     * @return String
     */
    public String getCalories() {
        return calories;
    }

    /**
     * returns the products name
     * @return String
     */
    @Override
    public String getProductName() {
        return productName;
    }

    /**
     * returns the brand of the product
     * @return String
     */
    public String getBrand() {
        return brand;
    }

    /**
     * returns a copy of the ingredients array
     * @return String[]
     */
    public String[] getIngredients() {
        return Arrays.copyOf(ingredients , ingredients.length);
    }

    /**
     * sets the brand of the product
     * @param brand String
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * sets the calories of a product
     * @param calories String
     */
    public void setCalories(String calories) {
        this.calories = calories;
    }

    /**
     * Sets the name of the product
     * @param productName String
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * sets an array of ingredients
     * @param ingredients String
     */
    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * overrides the equal method
     * @param o object
     * @return boolean
     */
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

    /**
     * overrides the hashcode method
     * @return int
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(calories, productName, brand, COST, PRODUCT_ID);
        result = 31 * result + Arrays.hashCode(ingredients);
        return result;
    }
}
