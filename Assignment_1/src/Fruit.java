import java.util.Scanner;

/**
 * Student Name: Guntas Singh Chugh
 * Student Number: 041091309
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * The Fruit class is a subclass of FoodItem and represents a specific type of food item
 * that is a fruit, with additional information about the orchard it comes from.
 */
public class Fruit extends FoodItem {
    private String orchardName;

    /**
     * Constructs a Fruit object with the given attributes, including orchard name.
     *
     * @param itemCode            The unique code for the fruit item.
     * @param name                The name of the fruit item.
     * @param itemQuantityInStock The quantity of the fruit item in stock.
     * @param cost                The cost of the fruit item.
     * @param salesPrice          The sales price of the fruit item.
     * @param orchardName         The name of the orchard where the fruit is sourced.
     */
    public Fruit(int itemCode, String name, int itemQuantityInStock, double cost, double salesPrice, String orchardName) {
        super(itemCode, name, itemQuantityInStock, cost, salesPrice);
        this.orchardName = orchardName;
    }

    /**
     * Overrides the addItem method to add a new fruit item with user input values.
     *
     * @param scanner A Scanner object for user input.
     * @return true if the fruit item was added successfully; false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        // Implement addItem specific to Fruit, if needed.
        return super.addItem(scanner);
    }
}
