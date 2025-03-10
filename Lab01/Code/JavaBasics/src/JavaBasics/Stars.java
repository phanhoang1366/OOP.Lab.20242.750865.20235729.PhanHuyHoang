package JavaBasics;
import java.util.Scanner;

public class Stars {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		int num = keyboard.nextInt();
		int rBound = (num - 1) * 2 + 1;
		
		for (int i = 0; i < num; i++) {
			int numStars = (i < num) ? i * 2 + 1 : rBound - i * 2 + 1;
			int numSpaces = (rBound - numStars) / 2;

			for (int j = 0; j < numSpaces; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < numStars; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		keyboard.close();

	}

}
