package se.lexicon.michelle.interfaces;

public interface IVikingJewelry extends Product{
    void setType(String type);
    void setFunctionality(String functionality);
    void addMaterials(String[] materials, String material);
}
