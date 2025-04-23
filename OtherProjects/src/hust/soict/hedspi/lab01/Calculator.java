package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double num1, num2;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the first number: ");
        num1 = scanner.nextDouble();
        System.out.println("Enter the second number: ");
        num2 = scanner.nextDouble();
        
        System.out.println("Sum of " + num1 + " and " + num2 + " is " + (num1 + num2));
        System.out.println("Difference of " + num1 + " and " + num2 + " is " + (num1 - num2));
        System.out.println("Product of " + num1 + " and " + num2 + " is " + (num1 * num2));
        System.out.println("Quotient of " + num1 + " and " + num2 + " is " + (num1 / num2));
        scanner.close();
        System.exit(0);
    }
}
