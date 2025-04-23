package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;
public class QuadraticEquation {
	public static void main(String[] args) {
		String a = JOptionPane.showInputDialog("Enter a: ");
		String b = JOptionPane.showInputDialog("Enter b: ");
		String c = JOptionPane.showInputDialog("Enter c: ");
		
		double a1 = Double.parseDouble(a);
		double b1 = Double.parseDouble(b);
		double c1 = Double.parseDouble(c);
		double discriminant = b1 * b1 - 4 * a1 * c1;
		
		if (a1 == 0) {
			// become a linear equation
			if (b1 == 0) {
				if (c1 == 0) {
					JOptionPane.showMessageDialog(null, "Infinite solutions");
				} else {
					JOptionPane.showMessageDialog(null, "No solution");
				}
			} else {
				JOptionPane.showMessageDialog(null, "One solution: " + -c1 / b1);
			}
		} else {
			if (discriminant > 0) {
				double r1 = (-b1 + Math.sqrt(discriminant)) / (2 * a1);
				double r2 = (-b1 - Math.sqrt(discriminant)) / (2 * a1);
				JOptionPane.showMessageDialog(null, "Two solutions: " + r1 + " and " + r2);
			} else if (discriminant == 0) {
				double r = -b1 / (2 * a1);
				JOptionPane.showMessageDialog(null, "One solution: " + r);
			} else {
				JOptionPane.showMessageDialog(null, "No solution");
			}
		}
	}
}
