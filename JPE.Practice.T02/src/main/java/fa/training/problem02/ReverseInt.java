package fa.training.problem02;

import fa.training.problem01.CourseRegister;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class ReverseInt {
    public static int reverseInt(int input) {
        int reversed = 0;
        while (input != 0) {
            int digit = input % 10;
            reversed = reversed * 10 + digit;
            input /= 10;
        }
        return reversed;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int a = sc.nextInt();
        System.out.println("The reverse is: " + String.valueOf(reverseInt(a)));
    }
}