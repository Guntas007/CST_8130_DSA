import java.util.Scanner;
/**
 * Student Name: Guntas Singh Chugh
 * Student Number: 041091309
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 */
public class Assign1 {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case 1:
                    addItemToInventory(scanner, inventory);
                    break;
                case 2:
                    displayInventory(inventory);
                    break;
                case 3:
                    buyItem(scanner, inventory);
                    break;
                case 4:
                    sellItem(scanner, inventory);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Incorrect value entered. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Add Item to Inventory");
        System.out.println("2: Display Current Inventory");
        System.out.println("3: Buy Item(s)");
        System.out.println("4: Sell Item(s)");
        System.out.println("5: To Exit");
        System.out.print("> ");
    }

    /**
     * Reads the user's choice from the console input.
     *
     * @param scanner The Scanner object to read user input.
     * @return The user's choice as an integer.
     */
    private static int getUserChoice(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }
    }
    /**
     * Adds a new food item to the inventory based on user input.
     *
     * @param scanner   The Scanner object for user input.
     * @param inventory The Inventory object to add the item to.
     */
    private static void addItemToInventory(Scanner scanner, Inventory inventory) {
        System.out.println("Adding an item to inventory...");
        System.out.print("Do you wish to add a fruit(f), vegetable(v), or a preserve(p)? ");
        String itemType = scanner.next().toLowerCase();

        switch (itemType) {
            case "f":
                Fruit fruit = new Fruit(0, "", 0, 0.0, 0.0, "");
                if (fruit.addItem(scanner)) {
                    inventory.addItem(fruit);
                    System.out.println("Item added to inventory successfully.");
                }
                break;
            case "v":
                Vegetable vegetable = new Vegetable(0, "", 0, 0.0, 0.0, "");
                if (vegetable.addItem(scanner)) {
                    inventory.addItem(vegetable);
                    System.out.println("Item added to inventory successfully.");
                }
                break;
            case "p":
                Preserve preserve = new Preserve(0, "", 0, 0.0, 0.0, 0);
                if (preserve.addItem(scanner)) {
                    inventory.addItem(preserve);
                    System.out.println("Item added to inventory successfully.");
                }
                break;
            default:
                System.out.println("Invalid item type.");
        }
    }

    /**
     * Displays the current inventory by calling the displayInventory method of the Inventory object.
     *
     * @param inventory The Inventory object representing the inventory to display.
     */
    private static void displayInventory(Inventory inventory) {	
    	inventory.displayInventory();    	
    }

    /**
     * Handles the process of buying items and updating the inventory based on user input.
     *
     * @param scanner   The Scanner object for user input.
     * @param inventory The Inventory object to update when buying items.
     */
    private static void buyItem(Scanner scanner, Inventory inventory) {
        System.out.println("Buying item(s)...");
        System.out.print("Enter the code for the item: ");
        int itemCode = scanner.nextInt();
        System.out.print("Enter valid quantity to buy: ");
        int quantity = scanner.nextInt();

        boolean success = inventory.updateQuantity(itemCode, quantity, true);

        if (success) {
            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Error...could not buy item.");
        }
    }
    
    /**
     * Handles the process of selling items and updating the inventory based on user input.
     *
     * @param scanner   The Scanner object for user input.
     * @param inventory The Inventory object to update when selling items.
     */
    private static void sellItem(Scanner scanner, Inventory inventory) {
        System.out.println("Selling item(s)...");
        System.out.print("Enter the code for the item: ");
        int itemCode = scanner.nextInt();
        System.out.print("Enter valid quantity to sell: ");
        int quantity = scanner.nextInt();

        boolean success = inventory.updateQuantity(itemCode, quantity, false);

        if (success) {
            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Error...could not sell item.");
        }
    }
}
