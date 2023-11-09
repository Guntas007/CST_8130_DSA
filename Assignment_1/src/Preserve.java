import java.util.Scanner;

/**
 * Student Name: Guntas Singh Chugh
 * Student Number: 041091309
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * The Preserve class is a subclass of FoodItem and represents a specific type of food item
 * that is a preserve, with additional information about the jar size in milliliters.
 */
public class Preserve extends FoodItem {
    private int jarSizeInMl;

    /**
     * Constructs a Preserve object with the given attributes, including jar size in milliliters.
     *
     * @param itemCode            The unique code for the preserve item.
     * @param name                The name of the preserve item.
     * @param itemQuantityInStock The quantity of the preserve item in stock.
     * @param cost                The cost of the preserve item.
     * @param salesPrice          The sales price of the preserve item.
     * @param jarSizeInMl         The size of the jar containing the preserve in milliliters.
     */
    public Preserve(int itemCode, String name, int itemQuantityInStock, double cost, double salesPrice, int jarSizeInMl) {
        super(itemCode, name, itemQuantityInStock, cost, salesPrice);
        this.jarSizeInMl = jarSizeInMl;
    }

    /**
     * Overrides the addItem method to add a new preserve item with user input values.
     *
     * @param scanner A Scanner object for user input.
     * @return true if the preserve item was added successfully; false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        // Implement addItem specific to Preserve, if needed.
        return super.addItem(scanner);
    }
}
