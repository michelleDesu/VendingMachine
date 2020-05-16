package se.lexicon.michelle.model;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.data.ProductSequencer;
import se.lexicon.michelle.interfaces.Product;

import static org.junit.Assert.*;

public class VikingJewelryTest {
   private VikingJewelry jewelry;
   private String[] materials;

    @Before
    public void setUp() throws Exception {
        ProductSequencer.resetProductId();
        materials = new String[]{
                "Gold",
                "Silver",
                "Bronze"
        };
        jewelry = new VikingJewelry(
                "P-51",
                ProductSequencer.nextID(),
                600,
                "Tortoise brooch",
                "Put on apron dress",
                materials
        );
    }

    @Test
    public void given_string_addStringToArray_should_add_string_to_array() {
     String[] expected = {
             "Diamonds",
     };
     String[] actual = new String[0];
     actual = Product.addStringToArray(actual , "Diamonds");
     assertArrayEquals(expected, actual);
    }


    @Test
    public void given_materials_addMaterials_should_add_Material() {
     String[] expected = {
             "Gold",
             "Silver",
             "Bronze",
             "Diamond"
     };
     jewelry.addMaterials(materials , "Diamond");
     assertArrayEquals(expected, jewelry.getMaterials() );
    }
    @Test(expected = IllegalArgumentException.class)
    public void given_null_addMaterials_should_add_material()  throws IllegalArgumentException{

        jewelry.addMaterials(materials , null);

    }

    @Test
    public void examine() {
        StringBuilder expectedProductInfo = new StringBuilder();
        expectedProductInfo.append("Name: P-51\n");
        expectedProductInfo.append("ID: 1\n");
        expectedProductInfo.append("Price: 600\n");
        expectedProductInfo.append("Type: Tortoise brooch\n");
        expectedProductInfo.append("Functionality: Put on apron dress\n");
        expectedProductInfo.append("The materials are:\n");
        for (String material : materials) {
            expectedProductInfo.append(material).append("\n");
        }
        String actual = jewelry.examine();

        assertEquals(expectedProductInfo.toString(), actual);
    }

    @Test
    public void use() {
        String expected = "you now received a "
                + jewelry.getProductName() + " with the id of " +
                jewelry.getProductID() + " That you immediately put on\n";
        assertEquals(expected, jewelry.use());
    }

    @Test
    public void setType() {
        String expected = "Brooch";
        jewelry.setType("Brooch");
        assertEquals(expected, jewelry.getType());
    }

    @Test
    public void setFunction() {
        String expected = "Pin on your chest";
        jewelry.setFunctionality("Pin on your chest");
        assertEquals(expected, jewelry.getFunctionality());
    }


 @Test
    public void getProductID() {
     int expected = 1;
     assertEquals(expected, jewelry.getProductID());
    }

    @Test
    public void getCost() {
        int expected = 600;
        assertEquals(expected, jewelry.getCost());
    }


    @Test
    public void getProductName() {
        String expected= "P-51";
        assertEquals(expected, jewelry.getProductName());
    }

    @Test
    public void setProductName() {
        String expected = "Haithaby Finding";
        jewelry.setProductName("Haithaby Finding");
        assertEquals(expected, jewelry.getProductName());
    }

    @Test
    public void getFunction() {
        String expected= "Put on apron dress";
        assertEquals(expected, jewelry.getFunctionality());
    }

    @Test
    public void getMaterials() {
        String[] expected = materials;
        assertArrayEquals(expected, jewelry.getMaterials());
    }

    @Test
    public void testEquals_and_hashcode() {
        // equals and hashCode check name field value
       VikingJewelry expected = new VikingJewelry(
               "P-51",
               1,
               600,
               "Tortoise brooch",
               "Put on apron dress",
               materials
        );
        assertTrue(expected.equals(jewelry) && jewelry.equals(expected));
        assertEquals(expected.hashCode(), jewelry.hashCode());

    }

}