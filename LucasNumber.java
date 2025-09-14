import java.lang.Math;

/**
 * Class representing a Lucas Number.
 * <p>
 * Each LucasNumber object stores its index in the sequence and its value.
 * Provides methods to get the index, get the value, check if the number
 * is a perfect cube, and print the number as a string.
 * <p>
 */
public class LucasNumber {
    /** Index of the Lucas number in the sequence. */
    int index;
    /** Value of the Lucas number. */
    long value;

    /**
     * Constructs a LucasNumber with the specified index and value.
     *
     * @param index the position of the number in the Lucas sequence
     * @param value the value of the Lucas number
     */
    LucasNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Returns the index of this Lucas number in the sequence.
     *
     * @return the index
     */
    int Get_index() {
        return this.index;
    }

    /**
     * Returns the value of this Lucas number.
     *
     * @return the value
     */
    long Get_value() {
        return this.value;
    }

    /**
     * Returns a string representation of this Lucas number.
     *
     * @return a string in the format "Number index - X, Number value - Y"
     */
    @Override
    public String toString() {

        return "Number index - " + index + ", Number value - " + value;
    }

    /**
     * Checks whether this Lucas number is a perfect cube.
     *
     * @return true if the number is a perfect cube, false otherwise
     */
    boolean isCube() {
        int k = (int) Math.round(Math.cbrt(this.value));

        return k * k * k == this.value;
    }

}
