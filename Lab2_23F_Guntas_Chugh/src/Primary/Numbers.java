package Primary;

/**
 * The Numbers class represents an array of Float values and provides various operations on them.
 */
public class Numbers {
    private Float[] values;
    private int size;
    private int count;

    /**
     * Default constructor that initializes the array size to 5.
     */
    public Numbers() {
        this.size = 5;
        this.values = new Float[size];
        this.count = 0;
    }

    /**
     * Constructor that allows specifying the size of the array.
     *
     * @param size The size of the array.
     */
    public Numbers(int size) {
        this.size = size;
        this.values = new Float[size];
        this.count = 0;
    }

    /**
     * Adds a Float value to the array if there is space.
     *
     * @param value The value to be added.
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
     * @return The average value rounded to two decimal places.
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
     * @return A formatted string with minimum, maximum, and modulo information.
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
     * @return The modulus result or Float.NaN for undefined result.
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
     * Finds the factorial of the maximum value in the array after dropping the decimal part.
     *
     * @return The factorial value.
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
            sb.append(values[i]).append(" \n");
        }
        return sb.toString();
    }

    /**
     * Gets the count of values in the array.
     *
     * @return The count of values.
     */
    public int getCount() {
        return count;
    }

    /**
     * Gets the value at a specific index in the array.
     *
     * @param index The index of the value to retrieve.
     * @return The value at the specified index or -1 for an invalid index.
     */
    public float getValue(int index) {
        if (index >= 0 && index < count) {
            return values[index];
        }
        return -1; // Return -1 for an invalid index
    }
}
