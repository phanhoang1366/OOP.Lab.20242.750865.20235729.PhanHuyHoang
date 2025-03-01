import javax.swing.JOptionPane;
public class LinearSystem {
	public static void main(String[] args) {
		double a11, a12, b1, a21, a22, b2;
		String input;
		input = JOptionPane.showInputDialog("Enter a11: ");
		a11 = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Enter a12: ");
		a12 = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Enter b1: ");
		b1 = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Enter a21: ");
		a21 = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Enter a22: ");
		a22 = Double.parseDouble(input);
		input = JOptionPane.showInputDialog("Enter b2: ");
		b2 = Double.parseDouble(input);
		double d = a11 * a22 - a12 * a21;
		double d1 = b1 * a22 - b2 * a12;
		double d2 = a11 * b2 - a21 * b1;
		if (d == 0) {
			if (d1 == 0 && d2 == 0) {
				JOptionPane.showMessageDialog(null, "Infinitely many solutions");
			} else {
				JOptionPane.showMessageDialog(null, "No solution");
			}
		} else {
			double x = d1 / d;
			double y = d2 / d;
			JOptionPane.showMessageDialog(null, "x = " + x + " and y = " + y);
		}
	}
}
