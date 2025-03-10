package JavaBasics2;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
	public static void main(String[] args) {
		int n;
		int sum = 0;
		
		System.out.print("Enter array size: ");
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		int[] test = new int[n];
		
		System.out.print("Enter the values of the array: ");
		for (int i = 0; i < test.length; i++) {
			test[i] = kb.nextInt();
		}
		
		Arrays.sort(test);
		
		for (int a : test) {
			System.out.print(a + " ");
			sum += a;
		}
		
		double avg = sum / n;
		
		System.out.println();
		System.out.println("Sum: " + sum);
		System.out.println("Average: " + avg);
		
		kb.close();
	}
}
