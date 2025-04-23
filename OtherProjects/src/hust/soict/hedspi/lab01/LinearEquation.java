package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;
public class LinearEquation {
	public static void main(String[] args) {
		// ax + b = 0
		String a, b;
		a = JOptionPane.showInputDialog("Enter a: ");
		b = JOptionPane.showInputDialog("Enter b: ");
		
		double a1 = Double.parseDouble(a);
		double b1 = Double.parseDouble(b);
		
		if (a1 == 0) {
			if (b1 == 0) {
				JOptionPane.showMessageDialog(null, "Infinite solutions");
			} else {
				JOptionPane.showMessageDialog(null, "No solution");
			}
		} else {
			double x = -b1 / a1;
			JOptionPane.showMessageDialog(null, "x = " + x);
		}
	}
}

