import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/*
 * This class contains JUnit tests for the Inventory class, specifically testing the
 * `updateQuantity` method for buying and selling items.
 *
 * Student Name: Guntas Singh Chugh
 * Student Number: 041091309
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 */
/**
 * This class represents test class
 */
public class buysellTests {
	/**
	 * Declaring variable
	 */
    private Inventory inventory; //Variable
    /**
     * this method populates the inventory before every test
     */
    @Before
    public void setUp() {
        // Initialize an inventory and add some food items for testing.
        inventory = new Inventory();
        inventory.addItem(new FoodItem(1, "Item 1", 10, 5.0, 10.0));
        inventory.addItem(new FoodItem(2, "Item 2", 20, 7.0, 15.0));
    }

    /**
     * Test case for successfully updating the quantity of an item by buying.
     */
    @Test
    public void testUpdateQuantity_BuyItem_Success() {
        assertTrue(inventory.updateQuantity(1, 5, true));
    }

    /**
     * Test case for successfully updating the quantity of an item by selling.
     */
    @Test
    public void testUpdateQuantity_SellItem_Success() {
        assertTrue(inventory.updateQuantity(2, 5, false));
    }

    /**
     * Test case for attempting to update the quantity of an item that is not found in the inventory.
     */
    @Test
    public void testUpdateQuantity_ItemNotFound() {
        assertFalse(inventory.updateQuantity(3, 5, true));
    }

    /**
     * Test case for attempting to sell an item with insufficient stock.
     */
    @Test
    public void testUpdateQuantity_InsufficientStock_Selling() {
        assertFalse(inventory.updateQuantity(1, 20, false));
    }

    /**
     * Test case for successfully updating the quantity of an item by buying a negative quantity.
     */
    @Test
    public void testUpdateQuantity_BuyNegativeQuantity() {
        assertTrue(inventory.updateQuantity(1, -5, true));
    }

    /**
     * Test case for successfully updating the quantity of an item by selling a negative quantity.
     */
    @Test
    public void testUpdateQuantity_SellNegativeQuantity() {
        assertTrue(inventory.updateQuantity(2, -5, false));
    }

    /**
     * Test case for successfully selling an item with zero initial stock, ensuring the stock remains at zero.
     */
    @Test
    public void testUpdateQuantity_SellWithZeroStock() {
        assertTrue(inventory.updateQuantity(1, 10, false));
        assertFalse(inventory.updateQuantity(1, 5, false)); // Cannot sell more
    }

    /**
     * Test case for successfully buying an item with a negative initial stock.
     */
    @Test
    public void testUpdateQuantity_BuyWithNegativeStock() {
        assertTrue(inventory.updateQuantity(1, -10, true));
        assertTrue(inventory.updateQuantity(1, 5, true));
    }
}
