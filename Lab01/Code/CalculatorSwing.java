import javax.swing.JOptionPane;
public class CalculatorSwing {
	public static void main(String[] args) {
		String firstNumber = JOptionPane.showInputDialog("Input the first number");
		String secondNumber = JOptionPane.showInputDialog("Input the second number");
		double number1 = Double.parseDouble(firstNumber);
		double number2 = Double.parseDouble(secondNumber);
		
		double sum = number1 + number2;
		double difference = number1 - number2;
		double product = number1 * number2;
		double quotient = number1 / number2;

		JOptionPane.showMessageDialog(null, "The sum is " + sum, "Sum of Two Numbers", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "The difference is " + difference, "Difference of Two Numbers", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "The product is " + product, "Product of Two Numbers", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "The quotient is " + quotient, "Quotient of Two Numbers", JOptionPane.INFORMATION_MESSAGE);
	}
}
