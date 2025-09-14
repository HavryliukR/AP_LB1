/**
 * Enum representing the options in the menu for the Lucas Numbers program.
 * <p>
 * Each option has a number and a description. The number is used to select
 * the option in the menu, and the description is displayed to the user.
 * <p>
 */

enum MenuOption {
    /** Option to print all Lucas numbers. */
    PRINT_ALL_NUMBERS(1, "Print all Luca numbers"),
    /** Option to print only Lucas numbers that are perfect cubes. */
    PRINT_ONLY_CUBES(2, "Print only Luca numbers, that are cubes"),
    /** Option to change the number of Lucas numbers generated. */
    CHANGE_NUMBER_OF_NUMBERS(3, "Change number of numbers"),
    /** Option to exit the program. */
    EXIT(0, "Exit");

    /** Numeric identifier of the menu option. */
    private final int number;
    /** Description of the menu option. */
    private final String description;

    /**
     * Constructor for MenuOption.
     *
     * @param number      numeric identifier for this option
     * @param description textual description of the option
     */
    MenuOption(int number, String description) {
        this.number = number;
        this.description = description;
    }

    /**
     * Returns the numeric identifier of this menu option.
     *
     * @return the number of the menu option
     */
    int getNumber() {
        return number;
    }

    /**
     * Returns the description of this menu option.
     *
     * @return the description of the menu option
     */
    String getDescription() {
        return description;
    }

    /**
     * Returns the MenuOption corresponding to the given number.
     *
     * @param number the number to look up
     * @return the corresponding MenuOption, or null if no option has that number
     */
    public static MenuOption fromNumber(int number) {

        for (MenuOption option : MenuOption.values()) {
            if (option.getNumber() == number) {
                return option;
            }
        }
        return null;
    }

}