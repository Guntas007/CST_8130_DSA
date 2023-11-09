package Primary;

import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and its processing
 * Student Name: Guntas Singh Chugh
 * Student Number: 041091309
 * Course: CST8130 - Data Structures
 * CET-CS-Level 3
 * 
 * This class provides methods for managing a dynamic array of floating-point numbers,
 * including adding values, calculating the average, finding the minimum and maximum values,
 * calculating MaxValue modulo MinValue, and finding the factorial of MaxValue.
 * 
 */
public class Numbers {
    protected Float[] values;
    protected int size;
    protected int count;

    /**
     * Default constructor that initializes the array with a default size of 5.
     */
    public Numbers() {
        this.size = 5;
        this.values = new Float[size];
        this.count = 0;
    }

    /**
     * Constructor that initializes the array with a given size.
     *
     * @param size The size of the array to be created.
     */
    public Numbers(int size) {
        this.size = size;
        this.values = new Float[size];
        this.count = 0;
    }

    /**
     * Adds a value to the array.
     *
     * @param value The value to be added to the array.
     */
    public void addValue(Float value) {
        if (count < size) {
            values[count++] = value;
        } else {
            System.out.println("Array is full. Cannot add more values.");
        }
    }

    /**
     * Calculates the average of the values in the array.
     *
     * @return The average of the values in the array.
     */
    public float calcAverage() {
        if (count == 0) {
            System.out.println("No values in the array.");
            return 0.0f;
        }
        float sum = 0.0f;
        for (int i = 0; i < count; i++) {
            sum += values[i];
        }
        return Math.round((sum / count) * 100.0) / 100.0f; // Round to 2 decimal places
    }

    /**
     * Finds the minimum and maximum values in the array and calculates MaxValue modulo MinValue.
     *
     * @return A string containing information about the minimum value, maximum value,
     *         and MaxValue modulo MinValue.
     */
    public String findMinMax() {
        if (count == 0) {
            return "No values in the array.";
        }

        float min = values[0];
        float max = values[0];

        for (int i = 1; i < count; i++) {
            if (values[i] < min) {
                min = values[i];
            }
            if (values[i] > max) {
                max = values[i];
            }
        }

        if (min == 0) {
            return String.format("Minimum Value: %.2f\nMaximum Value: %.2f\nMaxValue modulo MinValue: Undefined (division by zero)", min, max);
        } else {
            float maxModMin = max % min;
            return String.format("Minimum Value: %.2f\nMaximum Value: %.2f\nMaxValue modulo MinValue: %.2f", min, max, maxModMin);
        }
    }

    /**
     * Finds the modulus of the maximum and minimum values in the array.
     *
     * @return The modulus of the maximum and minimum values.
     */
    public float findModulusOfMinMax() {
        if (count == 0) {
            System.out.println("No values in the array.");
            return Float.NaN; // Return NaN (Not-a-Number) for undefined result
        }

        float min = values[0];
        float max = values[0];

        for (int i = 1; i < count; i++) {
            if (values[i] < min) {
                min = values[i];
            }
            if (values[i] > max) {
                max = values[i];
            }
        }

        if (min == 0) {
            System.out.println("Division by zero. Modulus result is undefined.");
            return Float.NaN;
        } else {
            float maxModMin = max % min;
            return maxModMin;
        }
    }

    /**
     * Finds the factorial of the maximum value after dropping the decimal part.
     *
     * @return The factorial of the maximum integer value in the array.
     */
    public long getFactorialMax() {
        if (count == 0) {
            System.out.println("No values in the array.");
            return 0;
        }
        float max = values[0];
        for (int i = 1; i < count; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        int maxInt = (int) max; // Drop decimal part
        long factorial = 1;
        for (int i = 1; i <= maxInt; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /**
     * Converts the array values to a string.
     *
     * @return A string representation of the array values.
     */
    public String toString() {
        if (count == 0) {
            return "No values in the array.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(values[i]).append(" ");
        }
        return sb.toString();
    }
}
