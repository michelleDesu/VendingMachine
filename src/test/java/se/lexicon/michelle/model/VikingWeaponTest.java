package se.lexicon.michelle.model;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.michelle.data.ProductSequencer;
import se.lexicon.michelle.interfaces.Product;

import static org.junit.Assert.*;

public class VikingWeaponTest {
    VikingWeapon weapon;
    @Before
    public void setUp() throws Exception {
        ProductSequencer.resetProductId();
        weapon = new VikingWeapon(
                "Ståltunga",
                ProductSequencer.nextID(),
                1500,
                "Seax",
                "Stabbing Weapon",
                false);
    }

    @Test
    public void given_string_addStringToArray_should_add_string_to_array() {
        String[] expected = {
                "string",
        };
        String[] actual = new String[0];
        actual = Product.addStringToArray(actual , "string");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void setType() {
        String expected = "Sword";
        weapon.setType("Sword");
        assertEquals(expected, weapon.getType());
    }

    @Test
    public void setFunction() {
        String expected = "Swings around";
        weapon.setFunctionality("Swings around");
        assertEquals(expected, weapon.getFunctionality());
    }

    @Test
    public void setAmmunition() {
        weapon.setAmmunition(true);
        assertTrue(weapon.haveAmmunition());
    }

    @Test
    public void examine() {

        String expectedProductInfo = "Name: " + weapon.getProductName() + "\n" +
                "ID: " + weapon.getProductID() + "\n" +
                "Price: " + weapon.getCost() + "\n" +
                "Type: " + weapon.getType() + "\n" +
                "Functionality: " + weapon.getFunctionality() + "\n" +
                "Have Ammunition: " + weapon.haveAmmunition() + "\n";
        assertEquals(expectedProductInfo, weapon.examine());
    }

    @Test
    public void use() {
        String expected = "you now received a " + weapon.getProductName()
                + " with the id of " + weapon.getProductID()
                + " That you immediately try out\n";
        assertEquals(expected, weapon.use());
    }

    @Test
    public void getProductID() {
        int expected = 1;
        assertEquals(expected, weapon.getProductID());
    }

    @Test
    public void getCost() {
        int expected = 1500;
        assertEquals(expected, weapon.getCost());
    }

    @Test
    public void getProductName() {
        String expected = "Ståltunga";
        assertEquals(expected, weapon.getProductName());
    }

    @Test
    public void haveAmmunition() {
        assertFalse(weapon.haveAmmunition());
    }

    @Test
    public void getFunctionality() {
        String expected = "Stabbing Weapon";
        assertEquals(expected, weapon.getFunctionality());
    }

    @Test
    public void getType() {
        String expected = "Seax";
        assertEquals(expected, weapon.getType());
    }

    @Test
    public void setProductName() {
        String expected = "Skuld";
        weapon.setProductName("Skuld");
        assertEquals(expected, weapon.getProductName());
    }

    @Test
    public void testEquals_and_hashcode() {
        // equals and hashCode check name field value
        VikingWeapon expected = new VikingWeapon(
                "Ståltunga",
                1,
                1500,
                "Seax",
                "Stabbing Weapon",
                false
        );
        assertTrue(expected.equals(weapon) && weapon.equals(expected));
        assertEquals(expected.hashCode(), weapon.hashCode());

    }

}