package se.lexicon.michelle.model;

import se.lexicon.michelle.interfaces.IVikingJewelry;
import se.lexicon.michelle.interfaces.Product;

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
        return null;
    }

    @Override
    public String use() {
        return null;
    }

    @Override
    public int getProductID() {
        return 0;
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public String getProductName() {
        return null;
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

    public String getMaterial() {
        return material;
    }

    public int getCOST() {
        return COST;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }
}
