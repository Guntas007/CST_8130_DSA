package Primary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The Lab2_Driver class contains the main program for interacting with the Numbers class.
 */
public class Lab2_Driver {
    /**
     * The main method where the program starts execution.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Numbers numbers = null; // Initialize the Numbers object
        boolean exit = false; // A flag to control the main loop

        while (!exit) {
            displayMainMenu(); // Display the main menu
            int choice = getUserChoice(); // Get user choice

            switch (choice) {
                case 1:
                    numbers = new Numbers(); // Initialize with default size
                    System.out.println("Default array of length 5 is initialized.");
                    break;
                case 2:
                    int maxSize = getUserInput("Enter the max size of the array: ");
                    numbers = new Numbers(maxSize); // Initialize with user-defined size
                    System.out.println("Array initialized with max size " + maxSize);
                    break;
                case 3:
                    try {
                        if (numbers == null) {
                            System.out.println("Please initialize the array first.");
                        } else {
                            float value = getUserFloatInput("Enter a value to add to the array: ");
                            numbers.addValue(value); // Add a value to the array
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
                        System.out.println("Numbers are:\n" + numbers.toString()); // Display array values
                    }
                    break;
                case 5:
                    if (numbers == null) {
                        System.out.println("Please initialize the array first.");
                    } else {
                        float average = numbers.calcAverage(); // Calculate average
                        String minMax = numbers.findMinMax(); // Find min, max, and mod values
                        float maxModMin = numbers.findModulusOfMinMax(); // Calculate max modulo min
                        long factorialMax = numbers.getFactorialMax(); // Get factorial of max value

                        // Use try-catch block to handle potential ArrayIndexOutOfBoundsException
                        try {
                            // Attempt to split the minMax string into two parts
                            String[] minMaxParts = minMax.split("\n");
                            String minPart = minMaxParts[0].substring(15);
                            String maxPart = minMaxParts[1].substring(15);

                            // Replace placeholders with actual values and display the result
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
                    int numValues = getUserInput("How many values do you wish to add? ");
                    if (numbers == null) {
                        System.out.println("Please initialize the array first.");
                    } else {
                        for (int i = 0; i < (numValues); i++) {
                            try {
                                float value = getUserFloatInput("Enter value: ");
                                numbers.addValue(value); // Add multiple values to the array
                            } catch (NullPointerException e) {
                                System.out.println("An error occurred while adding values to the array.");
                            }
                        }
                    }
                    break;
                case 7:
                    try {
                        if (numbers == null) {
                            System.out.println("Please initialize the array first.");
                        } else {
                            String fileName = getUserStringInput("Name of the file to read from: ");
                            readValuesFromFile(numbers, fileName); // Read values from a file
                            System.out.println("Values read from file.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while reading from the file.");
                    }
                    break;
                case 8:
                    try {
                        if (numbers == null) {
                            System.out.println("Please initialize the array first.");
                        } else {
                            String fileName = getUserStringInput("Name of the file to save to: ");
                            saveValuesToFile(numbers, fileName); // Save values to a file
                            System.out.println("Values saved to file.");
                        }
                    } catch (IOException e) {
                        System.out.println("An error occurred while saving to the file.");
                    }
                    break;
                case 9:
                    exit = true; // Exit the program
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    /**
     * Displays the main menu options.
     */
    public static void displayMainMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Initialize a default array");
        System.out.println("2: To specify the max size of the array");
        System.out.println("3: Add value to the array");
        System.out.println("4: Display values in the array");
        System.out.println("5: Display the average of the values, minimum value, maximum value, maxValue mod minValue, maxFactorial");
        System.out.println("6: Enter multiple values");
        System.out.println("7: Read values from file");
        System.out.println("8: Save values to file");
        System.out.println("9: To Exit");
        System.out.print("> ");
    }

    /**
     * Gets the user's choice from the menu.
     *
     * @return The user's choice.
     */
    public static int getUserChoice() {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);

        try {
            choice = scanner.nextInt();
        } catch (NumberFormatException e) {
            // Invalid input, do nothing
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, enter options 1-9");
        }

        return choice;
    }

    /**
     * Gets an integer input from the user.
     *
     * @param prompt The prompt to display to the user.
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
            } catch (InputMismatchException e) {
            	System.out.println("Invalid input. Please enter a valid integer.");
                // Clear the input buffer
                scanner.nextLine();
            }
        }

        return value;
    }

    /**
     * Gets a floating-point input from the user.
     *
     * @param prompt The prompt to display to the user.
     * @return The user's input as a float.
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

    /**
     * Gets a string input from the user.
     *
     * @param prompt The prompt to display to the user.
     * @return The user's input as a string.
     */
    public static String getUserStringInput(String prompt) {
        String input = null;
        Scanner scanner = new Scanner(System.in);

        while (input == null || input.isEmpty()) {
            try {
                System.out.print(prompt);
                input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Please enter a non-empty string.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid string.");
            }
        }

        return input;
    }

    /**
     * Reads values from a file and adds them to the Numbers object.
     *
     * @param numbers  The Numbers object to add values to.
     * @param fileName The name of the file to read from.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static void readValuesFromFile(Numbers numbers, String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int numValues = scanner.nextInt();

        for (int i = 0; i < numValues; i++) {
            float value = scanner.nextFloat();
            numbers.addValue(value);
        }

        scanner.close();
    }

    /**
     * Saves values from the Numbers object to a file.
     *
     * @param numbers  The Numbers object containing the values to be saved.
     * @param fileName The name of the file to save to.
     * @throws IOException If an I/O error occurs while writing to the file.
     */
    public static void saveValuesToFile(Numbers numbers, String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);
        writer.write(numbers.getCount() + "\n");
        for (int i = 0; i < numbers.getCount(); i++) {
            writer.write(numbers.getValue(i) + "\n");
        }
        writer.close();
    }
}
