package fa.training.problem03.utils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValueInput {
    public String enterId() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String id = scanner.nextLine();
            if (id.length() >= 1 && id.length() <= 7) {
                return id;
            } else {
                System.out.println("Độ dài ID phải từ 1 đến 7 ký tự.");
                System.out.print("Enter customer id: ");
            }
        }
    }

    public LocalDate enterDate(String message) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                LocalDate date = LocalDate.parse(input);
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập lại theo định dạng ");
                System.out.print("Enter "+message+" (yyyy-MM-dd): ");
            }
        }
    }
}
