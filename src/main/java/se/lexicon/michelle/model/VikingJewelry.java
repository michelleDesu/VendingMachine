package se.lexicon.michelle.model;

import se.lexicon.michelle.interfaces.IVikingJewelry;
import se.lexicon.michelle.interfaces.Product;

import java.util.Arrays;
import java.util.Objects;

public class VikingJewelry implements IVikingJewelry {
    private String  function,
                    productName,
                    type;
    private final int COST;
    private final int PRODUCT_ID;
    String[] materials;


    /**
     * constructor
     * @param productName String
     * @param productID String
     * @param cost int
     * @param type String
     * @param function String
     * @param materials String[]
     */
    public VikingJewelry( String productName, int productID, int cost, String type, String function, String[] materials) {
        setFunction(function);
        setProductName(productName);
        setType(type);
        this.materials = materials;

        this.COST = cost;
        this.PRODUCT_ID = productID;
    }


    /**
     * Set the type of the jewelry
     * @param type String
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set the functionality of the jewelry
     * @param function String
     */
    @Override
    public void setFunction(String function) {
        this.function = function;
    }

    /**
     * adds a material to the list of materials
     * @param materials String[]
     * @param material String
     */
    @Override
    public void addMaterials(String[] materials, String material) {
        if(material == null){
            throw new IllegalArgumentException("material can't be empty");
        }
        materials = Product.addStringToArray(materials, material);
        setMaterials(materials);
    }

    /**
     * adds all the data for a jewelry in a string.
     * @return String
     */
    @Override
    public String examine() {
        StringBuilder productInfo = new StringBuilder();
        productInfo.append("Name: ").append(getProductName()).append("\n");
        productInfo.append("ID: ").append(getProductID()).append("\n");
        productInfo.append("Price: ").append(getCost()).append("\n");
        productInfo.append("Type: ").append(getType()).append("\n");
        productInfo.append("Functionality: ").append(getFunction()).append("\n");
        productInfo.append("The materials are:\n");
        for(String material : materials){
            productInfo.append(material).append("\n");
        }
        return productInfo.toString();
    }

    /**
     * returns a string describing what you got and what you did with it.
     * @return String
     */
    @Override
    public String use() {
        return "you now received a " + getProductName() + " with the id of " + getProductID() + " That you immediately put on\n";
    }


    /**
     * returns the Id of the product
     * @return int
     */
    @Override
    public int getProductID() {
        return PRODUCT_ID;
    }

    /**
     * returns the cost of the product
     * @return int
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * returns the name of the product
     * @return String
     */
    @Override
    public String getProductName() {
        return productName;
    }

    /**
     * sets the products name
     * @param productName String
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * sets the materials to the specified materials.
     * @param materials String[]
     */
    private void setMaterials(String[] materials) {
        this.materials = materials;
    }

    /**
     * returns type of jewelry
     * @return String
     */
    public String getType() {
        return this.type;
    }

    /**
     * returns the functionality of a jewelry
     * @return String
     */
    public String getFunction() {
        return function;
    }

    /**
     * returns a copy of the materials in the materials array
     * @return String[]
     */
    public String[] getMaterials() {
        return Arrays.copyOf(materials,materials.length);
    }

    /**
     *  overrides the equal method
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VikingJewelry that = (VikingJewelry) o;
        return COST == that.COST &&
                PRODUCT_ID == that.PRODUCT_ID &&
                Objects.equals(function, that.function) &&
                Objects.equals(productName, that.productName) &&
                Objects.equals(type, that.type) &&
                Arrays.equals(materials, that.materials);
    }

    /**
     *  overrides the hashcode method
     * @return int
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(function, productName, type, COST, PRODUCT_ID);
        result = 31 * result + Arrays.hashCode(materials);
        return result;
    }
}
