import java.util.Scanner;

/**
 * Student Name: Guntas Singh Chugh
 * Student Number: 041091309
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * The FoodItem class represents a food item with information such as item code, name,
 * quantity in stock, cost, sales price, and supplier.
 */
public class FoodItem {
    private int itemCode;
    private String name;
    private int itemQuantityInStock;
    private double cost;
    private double salesPrice;
    private String supplier;

    /**
     * Constructs a FoodItem object with the given attributes.
     *
     * @param itemCode            The unique code for the food item.
     * @param name                The name of the food item.
     * @param itemQuantityInStock The quantity of the food item in stock.
     * @param cost                The cost of the food item.
     * @param salesPrice          The sales price of the food item.
     */
    public FoodItem(int itemCode, String name, int itemQuantityInStock, double cost, double salesPrice) {
        this.itemCode = itemCode;
        this.name = name;
        this.itemQuantityInStock = itemQuantityInStock;
        this.cost = cost;
        this.salesPrice = salesPrice;
        this.supplier = supplier; // Note: The supplier parameter appears to be missing.
    }

    /**
     * Returns a string representation of the FoodItem.
     *
     * @return A string containing item code, name, quantity, cost, sales price, and supplier.
     */
    public String toString() {
        return "Item Code: " + itemCode + " Item:  " + name + " Quantity: " + itemQuantityInStock
                + " Price: $" + String.format("%.2f", salesPrice) + " Cost: $" + String.format("%.2f", cost)
                + " Supplier: " + supplier;
    }

    /**
     * Adds a new food item with user input values.
     *
     * @param scanner A Scanner object for user input.
     * @return true if the item was added successfully; false otherwise.
     */
    public boolean addItem(Scanner scanner) {
        System.out.print("Enter the code for the item: ");
        if (scanner.hasNextInt()) {
            itemCode = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } else {
            System.out.println("Invalid input for item code.");
            return false;
        }

        System.out.print("Enter the name for the item: ");
        name = scanner.nextLine();

        System.out.print("Enter the quantity for the item: ");
        if (scanner.hasNextInt()) {
            itemQuantityInStock = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } else {
            System.out.println("Invalid input for quantity.");
            return false;
        }

        System.out.print("Enter the cost of the item: ");
        if (scanner.hasNextDouble()) {
            cost = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
        } else {
            System.out.println("Invalid input for cost.");
            return false;
        }

        System.out.print("Enter the sales price of the item: ");
        if (scanner.hasNextDouble()) {
            salesPrice = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
        } else {
            System.out.println("Invalid input for sales price.");
            return false;
        }
        
        System.out.print("Enter the supplier of the item: ");
        if (scanner.hasNext()) {
        	supplier = scanner.next();
        	scanner.nextLine(); // Consume the newline character
        } else {
        	System.out.println("Invalid input for supplier.");
        	return false;
        }

        return true;
    }

    /**
     * Updates the quantity of the food item.
     *
     * @param amount The amount to add or subtract from the quantity.
     * @return true if the update was successful; false otherwise.
     */
    public boolean updateItem(int amount) {
    	  if (itemQuantityInStock + amount >= 0) {
              itemQuantityInStock += amount;
              return true;
          } else {
              System.out.println("Quantity cannot be negative.");
              return false;
          }
    }

    /**
     * Checks if the given item code matches the item's code.
     *
     * @param itemCode The item code to compare.
     * @return true if the item codes match; false otherwise.
     */
    public boolean isEqual(int itemCode) {
        return this.itemCode == itemCode;
    }
}
