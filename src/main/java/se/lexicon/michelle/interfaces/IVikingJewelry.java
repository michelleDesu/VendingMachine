package se.lexicon.michelle.interfaces;

public interface IVikingJewelry extends Product{
    void setType(String type);
    void setFunction(String function);
    void addMaterials(String[] materials, String material);
}
