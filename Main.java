import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class for Lucas Numbers program.
 * <p>
 * This program generates the first N Lucas numbers and allows the user
 * to interact with them through a menu. The menu supports:
 * <ul>
 * <li>Printing all Lucas numbers</li>
 * <li>Printing only cubic Lucas numbers</li>
 * <li>Changing the number of Lucas numbers generated</li>
 * <li>Exiting the program</li>
 * </ul>
 * <p>
 *
 * Usage from command line:
 * java Main [N]
 * where N is an optional number of Lucas numbers to generate
 */
public class Main {
    /**
     * Main method. Entry point of the program.
     *
     * @param args command line arguments; args[0] can be a number of Lucas numbers
     *             to generate
     */
    public static void main(String[] args) {
        System.out.println("\n\n\n");
        Scanner scanner = new Scanner(System.in);
        // Number of Lucas numbers
        int N = 0;
        boolean readedFromCMD = false;
        System.out.println("\tBasics of java\n");
        System.out.println("This program will calculate amount of cubes among the Luca Numbers!");

        // Reading number of numbers from command line
        if (args.length > 0 && !args[0].isEmpty()) {
            try {
                N = Integer.parseInt(args[0]);
                readedFromCMD = true;
            } catch (NumberFormatException e) {
                System.out.println(
                        "Something went wrong during reading data from command line.\nAutomatically switching to keyboard input...");

            }
        }
        // Reading number of numbers from keyboard
        System.out.println("Enter number of Luca Numbers you want to inspect: ");
        if (!readedFromCMD) {
            while (N <= 0 || N > 75) {
                System.out.println("Enter a positive number(1 - 75): ");
                try {
                    N = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Wrong input! Please enter a number");
                    scanner.nextLine();
                    continue;
                }
            }
        }

        // array of objects
        LucasNumber[] arr = new LucasNumber[N];
        if (N >= 1)
            arr[0] = new LucasNumber(1, 1);
        if (N >= 2)
            arr[1] = new LucasNumber(2, 3);

        for (int i = 2; i < N; i++) {
            long value = arr[i - 1].value + arr[i - 2].value;
            arr[i] = new LucasNumber(i + 1, value);
        }

        System.out.println("Luca Numbers were generated!\nWelcome to menu");
        boolean inMenu = true;

        // Menu
        while (inMenu) {
            System.out.println("\n");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option.getNumber() + ". " + option.getDescription());
            }

            MenuOption selected = null;
            int choice = -1;

            while (selected == null) {
                System.out.println("Enter your choice: ");
                try {
                    choice = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please enter only digits!");
                    scanner.nextLine();
                    continue;
                }
                selected = MenuOption.fromNumber(choice);

                if (selected == null) {
                    System.out.println("Wrong choice!\n Try again\n");

                }

            }

            if (selected != null) {
                switch (selected) {
                    case PRINT_ALL_NUMBERS: {
                        for (int i = 0; i < arr.length; i++) {
                            System.out.println(arr[i]);
                        }
                        break;
                    }
                    case PRINT_ONLY_CUBES: {

                        for (int i = 0; i < arr.length; i++) {

                            if (arr[i].isCube()) {
                                System.out.printf("Number %d is the cube of %d\n", arr[i].value,
                                        Math.round(Math.cbrt(arr[i].value)));
                            }

                        }
                        break;
                    }
                    case CHANGE_NUMBER_OF_NUMBERS: {
                        System.out.println("Enter new number of Luca Numbers (1 - 75): ");
                        int newN = -1;
                        while (newN <= 0 || newN > 75) {
                            try {
                                newN = scanner.nextInt();
                                if (newN <= 0) {
                                    System.out.println("Please enter a positive number");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Wrong input! Please enter a number");
                                scanner.nextLine();
                            }
                        }

                        arr = new LucasNumber[newN];
                        if (newN >= 1)
                            arr[0] = new LucasNumber(1, 1);
                        if (newN >= 2)
                            arr[1] = new LucasNumber(2, 3);

                        for (int i = 2; i < newN; i++) {
                            long value = arr[i - 1].value + arr[i - 2].value;
                            arr[i] = new LucasNumber(i + 1, value);
                        }

                        System.out.println("New Luca Numbers generated!");
                        break;
                    }
                    case EXIT: {
                        System.out.println("Thanks for using!\nExiting...");
                        System.exit(0);
                    }

                }
            }
        }

        scanner.close();
        System.out.println("\n\n\n");

    }

}
