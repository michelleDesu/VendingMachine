package se.lexicon.michelle.model;

import se.lexicon.michelle.interfaces.IVikingWeapon;

import java.util.Objects;

public class VikingWeapon implements IVikingWeapon {
    private boolean ammunition;
    private String  function,
            type,
            productName;
    private final int   PRODUCT_ID,
                COST;

    /**
     * Constructor for viking weapons
     * @param productName String
     * @param productId int
     * @param price int
     * @param type String
     * @param function String
     * @param ammunition boolean
     */
    public VikingWeapon( String productName, int productId, int price, String type, String function, boolean ammunition ) {
        setAmmunition(ammunition);
        setFunction(function);
        setType(type);
        setProductName(productName);
        this.PRODUCT_ID = productId;
        this.COST = price;
    }

    /**
     * sets the type of the weapon
     * @param type String
     */
    @Override
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the functionality of the weapon
     * @param function String
     */
    @Override
    public void setFunction(String function) {
        this.function = function;
    }

    /**
     * sets if the weapon has ammunition or not
     * @param ammunition boolean
     */
    @Override
    public void setAmmunition(boolean ammunition) {
        this.ammunition = ammunition;
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
        productInfo.append("Have Ammunition: ").append(haveAmmunition()).append("\n");

        return productInfo.toString();

    }

    /**
     * returns a string describing what you got and what you did with it.
     * @return String
     */
    @Override
    public String use() {
        return "you now received a " + getProductName()
                + " with the id of " + getProductID()
                + " That you immediately try out\n";
    }

    /**
     * Returns the weapons id
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
     * returns the name of the product
     * @return String
     */
    @Override
    public String getProductName() {
        return productName;
    }

    /**
     * returns true if weapon have ammunition
     * @return boolean
     */
    public boolean haveAmmunition() {
        return ammunition;
    }

    /**
     * returns the functionality of the weapon
     * @return String
     */
    public String getFunction() {
        return function;
    }

    /**
     * returns the type of weapon
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * sets the name of the product
     * @param productName String
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Overrides the equal method
     * @param o Object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VikingWeapon that = (VikingWeapon) o;
        return ammunition == that.ammunition &&
                PRODUCT_ID == that.PRODUCT_ID &&
                COST == that.COST &&
                Objects.equals(function, that.function) &&
                Objects.equals(type, that.type) &&
                Objects.equals(productName, that.productName);
    }

    /**
     * overrides the hashCode method
     * @return int
     */
    @Override
    public int hashCode() {
        return Objects.hash(ammunition, function, type, productName, PRODUCT_ID, COST);
    }
}
