import java.util.Scanner;

/**
 * Student Name: Guntas Singh Chugh
 * Student Number: 041091309
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * The Vegetable class is a subclass of FoodItem and represents a specific type of food item
 * that is a vegetable, with additional information about the farm it comes from.
 */
public class Vegetable extends FoodItem {
    private String farmName;

    /**
     * Constructs a Vegetable object with the given attributes, including farm name.
     *
     * @param itemCode            The unique code for the vegetable item.
     * @param name                The name of the vegetable item.
     * @param itemQuantityInStock The quantity of the vegetable item in stock.
     * @param cost                The cost of the vegetable item.
     * @param salesPrice          The sales price of the vegetable item.
     * @param farmName            The name of the farm where the vegetable is sourced.
     */
    public Vegetable(int itemCode, String name, int itemQuantityInStock, double cost, double salesPrice, String farmName) {
        super(itemCode, name, itemQuantityInStock, cost, salesPrice);
        this.farmName = farmName;
    }

    /**
     * Overrides the addItem method to add a new vegetable item with user input values.
     *
     * @param scanner A Scanner object for user input.
     * @return true if the vegetable item was added successfully; false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        // Implement addItem specific to Vegetable, if needed.
        return super.addItem(scanner);
    }
}
