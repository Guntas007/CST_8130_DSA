package Primary;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class serves as the driver program for interacting with the Numbers class,
 * allowing the user to initialize an array, add values, perform calculations,
 * and display results.
 * 
 * Student Name: [Your Name]
 * Student Number: [Your Student Number]
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * 
 * @author/Professor James Mwangi PhD.
 */
public class Lab1_Driver {
    public static void main(String[] args) {
        Numbers numbers = null;
        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    
                	numbers = new Numbers();
                	System.out.println("Default array of length 5 is initialized.");
                	break;
                	
                case 2:
                    int maxSize = getUserInput("Enter the max size of the array: ");
                    numbers = new Numbers(maxSize);
                    System.out.println("Array initialized with max size " + maxSize);
                    break;
                case 3:
                    try {
                        if (numbers == null) {
                            System.out.println("Please initialize the array first.");
                        } else {
                            float value = getUserFloatInput("Enter a value to add to the array: ");
                            numbers.addValue(value);
                            System.out.println("Value added to the array.");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("An error occurred while adding the value to the array.");
                    }
                    break;
                case 4:
                    if (numbers == null) {
                        System.out.println("Please initialize the array first.");
                    } else {
                        System.out.println("Numbers are:\n" + numbers.toString());
                    }
                    break;
                case 5:
                    if (numbers == null) {
                        System.out.println("Please initialize the array first.");
                    } else {
                        float average = numbers.calcAverage();
                        String minMax = numbers.findMinMax();
                        float maxModMin = numbers.findModulusOfMinMax(); // Call the new method
                        long factorialMax = numbers.getFactorialMax();

                        // Use try-catch block to handle potential ArrayIndexOutOfBoundsException
                        try {
                            // Attempt to split the minMax string into two parts
                            String[] minMaxParts = minMax.split("\n");
                            String minPart = minMaxParts[0].substring(15);
                            String maxPart = minMaxParts[1].substring(15);

                            // Replace placeholders with actual values
                            String output = String.format(
                                "Average is: %.2f, Minimum value is %s, Maximum value is %s, max mod min is %.2f factorial of Max is %d",
                                average, minPart, maxPart, maxModMin, factorialMax
                            );

                            System.out.println(output);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("An error occurred while formatting the result.");
                        }
                    }
                    break;
                    
              

                case 6:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    /**
     * Displays the main menu with available options.
     */
    public static void displayMainMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Initialize a default array");
        System.out.println("2: To specify the max size of the array");
        System.out.println("3: Add value to the array");
        System.out.println("4: Display values in the array");
        System.out.println("5: Display average of the values, minimum value, maximum value, max mod min, factorialMax");
        System.out.println("6: To Exit");
        System.out.print("> ");
    }

    /**
     * Gets the user's choice from the menu.
     *
     * @return The user's choice as an integer.
     */
    public static int getUserChoice() {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);

        try {
            choice = scanner.nextInt();
        } catch (NumberFormatException e) {
            // Invalid input, do nothing
        } catch (InputMismatchException e) {
        	// Invalid input, do nothing
        }

        return choice;
    }

    /**
     * Gets user input as an integer.
     *
     * @param prompt The prompt message for the user.
     * @return The user's input as an integer.
     */
    public static int getUserInput(String prompt) {
        int value = -1;
        Scanner scanner = new Scanner(System.in);

        while (value < 0) {
            try {
                System.out.print(prompt);
                value = scanner.nextInt();
                if (value < 0) {
                    System.out.println("Please enter a non-negative value.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                // Clear the input buffer
                scanner.nextLine();
            }
        }

        return value;
    }

    /**
     * Gets user input as a floating-point number.
     *
     * @param prompt The prompt message for the user.
     * @return The user's input as a floating-point number.
     */
    public static float getUserFloatInput(String prompt) {
        float value = 0.0f;
        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);

        while (!validInput) {
            try {
                System.out.print(prompt);
                value = scanner.nextFloat();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid floating-point number.");
                // Clear the input buffer
                scanner.nextLine();
            }
        }

        return value;
    }
}
