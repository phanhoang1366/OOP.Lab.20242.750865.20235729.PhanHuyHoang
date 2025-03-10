package JavaBasics2;

import java.util.Scanner;

public class DaysOfMonth {
	private static int daysInMonth(int month) {
	    switch(month) {
	        case 2:
	            return 28; // Tháng 2 có 28 ngày
	        case 4:
	        case 6:
	        case 9:
	        case 11:
	            return 30; // Các tháng 4, 6, 9, 11 có 30 ngày
	        default:
	            return 31; // Các tháng còn lại có 31 ngày
	    }
	}
	
	private static int isLeapYear(int year) {
	    // Một năm là năm nhuận nếu chia hết cho 4
	    // Trừ trường hợp năm chia hết cho 100 nhưng không chia hết cho 400
	    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
	        return 1; // Trả về 1 nếu là năm nhuận
	    } else {
	        return 0; // Trả về 0 nếu không phải là năm nhuận
	    }
	}
	
	private static int parseMonth(String month) {
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December"};
		String[] abbreviations = {"Jan.", "Feb.", "Mar.", "Apr.", "May", "Jun.", "Jul.", "Aug.", "Sep.", "Oct.", "Nov.", "Dec."};
		String[] threeLetters = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

		for (int i = 0; i < months.length; i++) {
			if (month.equals(months[i]) || month.equals(abbreviations[i]) || month.equals(threeLetters[i]) || month.equals(String.valueOf(i + 1))) {
				return i + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int parsedMonth, year;
		
		while (true) {
			String month = keyboard.next();
			year = keyboard.nextInt();
			if (year < 100 || (parsedMonth = parseMonth(month)) == -1) {
					System.out.println("Please enter again");
			}
			else break;
		}
		
		int answer = daysInMonth(parsedMonth) + (parsedMonth == 2 ? isLeapYear(year) : 0);
		
		System.out.println("The answer is: " + answer + " days.");
		
		keyboard.close();
	}
}
