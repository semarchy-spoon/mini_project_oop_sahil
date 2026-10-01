package main.java.org.example.studentgrademanager.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputHelperUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static void displayUserChoices() {

        System.out.print("""

            1. Add Student
            2. Record Grade
            3. Calculate Student Average
            4. Update Grade
            5. Remove Grade
            6. Show Top Scoring Student
            7. Show Last Grade Entered
            8. Exit

            Enter your choice:  """);
    }

    public static int readInteger(String errorMessage) {
        while (true) {
            try {
                int inputValue = scanner.nextInt();
                scanner.nextLine();

                return inputValue;

            } catch (InputMismatchException e) {
                if (scanner.hasNextDouble()) {
                    System.out.print(
                            "\nInvalid input.\nDecimal numbers are not allowed." +
                                    " Please enter a whole number: \n" + errorMessage
                    );
                } else {
                    System.out.print("\nInvalid input.\n" + errorMessage);
                }
                scanner.nextLine();
            }
        }
    }

    public static String readNonEmptyString() {
        while (true) {
            String inputValue = scanner.nextLine().trim();
            if (!inputValue.isEmpty()) {
                return inputValue;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }

    }
}