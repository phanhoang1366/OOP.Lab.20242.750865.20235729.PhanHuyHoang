package JavaBasics2;

import java.util.Scanner;

public class AddTwoMatrices {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter numbers of rows and columns:");
		
		int rows, columns;
		rows = kb.nextInt();
		columns = kb.nextInt();
		
		int[][] mat1 = new int[rows][columns];
		int[][] mat2 = new int[rows][columns];
		
		System.out.println("Enter values of matrix 1:");
		for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                mat1[i][j] = kb.nextInt();
            }
		}
		
		System.out.println("Enter values of matrix 2:");
		for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++){
                mat2[i][j] = kb.nextInt();
            }
		}
		
		int[][] sum = new int[rows][columns];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                sum[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        
        System.out.println("The result:");
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
        
        kb.close();
	}
}
