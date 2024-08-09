package fa.training.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputValidator {

    // Validate if a string is a valid integer
    public static boolean isValidInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Validate if a string is a valid date in the format YYYY-MM-DD
    public static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // Validate if a string is not empty and not null
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Validate if an ISBN is valid (basic example, you might need more complex validation)
    public static boolean isValidIsbn(String isbn) {
        // Basic validation: check if it's not empty and has 10 or 13 characters
        return isbn != null && (isbn.length() == 10 || isbn.length() == 13);
    }
}
