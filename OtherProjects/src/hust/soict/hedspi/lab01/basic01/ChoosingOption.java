package hust.soict.hedspi.lab01.basic01;
import javax.swing.JOptionPane;

public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
		
		if(option == JOptionPane.CANCEL_OPTION) System.exit(1);

		JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
		
		Object[] options = {"I do", "I don't"};
		
		option = JOptionPane.showOptionDialog(null, "Do you want to change to the first class ticket?", "Choose an option", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if(option == JOptionPane.CLOSED_OPTION) System.exit(1);

		JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION ? "Yes" : "No"));
		
		System.exit(0);
	}
}
