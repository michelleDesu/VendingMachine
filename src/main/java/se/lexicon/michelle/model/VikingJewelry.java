package se.lexicon.michelle.model;

import se.lexicon.michelle.interfaces.IVikingJewelry;
import se.lexicon.michelle.interfaces.Product;

import java.util.Arrays;

public class VikingJewelry implements IVikingJewelry {
    private String  function,
                    productName,
                    material,
                    type;
    private final int COST;
    private final int PRODUCT_ID;
    String[] materials;

    public VikingJewelry( String productName, int productID, int cost, String type, String function, String material) {
        setFunction(function);
        setProductName(productName);
        setMaterial(material);
        materials = new String[0];

        this.COST = cost;
        this.PRODUCT_ID = productID;
    }



    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public void addMaterials(String[] materials, String material) {
        if(material == null){
            throw new IllegalArgumentException("material can't be empty");
        }
        materials = Product.addStringToArray(materials, material);
        setMaterials(materials);
    }

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

    private String getType() {
        return this.type;
    }

    @Override
    public String use() {
        return "you now received a " + getProductName() + " with the id of " + getProductID();
    }

    @Override
    public int getProductID() {
        return PRODUCT_ID;
    }

    @Override
    public int getCost() {
        return COST;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    private void setMaterial(String material) {
        this.material = material;
    }
    private void setMaterials(String[] materials) {
        this.materials = materials;
    }

    public String getFunction() {
        return function;
    }

    public String[] getMaterials() {
        return Arrays.copyOf(materials,materials.length);
    }

    public String getMaterial() {
        return material;
    }

}
