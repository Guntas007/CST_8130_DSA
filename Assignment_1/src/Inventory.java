/**
 * Student Name: Guntas Singh Chugh
 * Student Number: 041091309
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * The Inventory class represents a collection of food items, providing methods
 * to manage the inventory, add items, update quantities, and display the inventory.
 */
public class Inventory {
    private FoodItem[] inventoryArray;
    private int itemCount;

    /**
     * Constructs an Inventory object with an initial capacity of 20.
     */
    public Inventory() {
        inventoryArray = new FoodItem[20];
        itemCount = 0;
    }

    /**
     * Adds a food item to the inventory.
     *
     * @param item The FoodItem object to be added.
     */
    public void addItem(FoodItem item) {
        if (itemCount < inventoryArray.length) {
            inventoryArray[itemCount] = item;
            itemCount++;
        } else {
            System.out.println("Inventory is full. Cannot add more items.");
        }
    }

    /**
     * Searches for a food item in the inventory based on its item code.
     *
     * @param itemCode The item code to search for.
     * @return The index of the found item in the inventory array, or -1 if not found.
     */
    public int alreadyExists(int itemCode) {
        for (int i = 0; i < itemCount; i++) {
            if (inventoryArray[i].isEqual(itemCode)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Updates the quantity of a food item in the inventory.
     *
     * @param itemCode   The item code of the item to update.
     * @param quantity   The quantity to add or subtract.
     * @param buyOrSell  True if the update is for a purchase, false for a sale.
     * @return True if the update was successful; false otherwise.
     */
    public boolean updateQuantity(int itemCode, int quantity, boolean buyOrSell) {
        int index = alreadyExists(itemCode);
        if (index == -1) {
            System.out.println("Item code not found in inventory.");
            return false;
        }

        if (buyOrSell) {
            return inventoryArray[index].updateItem(quantity);
        } else {
            if (inventoryArray[index].updateItem(-quantity)) {
                return true;
            } else {
                System.out.println("Insufficient stock in inventory.");
                return false;
            }
        }
    }

    /**
     * Displays the current inventory by printing the details of each food item.
     */
    public void displayInventory() {
        System.out.println("Inventory:");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(inventoryArray[i].toString());
        }
    }
}
