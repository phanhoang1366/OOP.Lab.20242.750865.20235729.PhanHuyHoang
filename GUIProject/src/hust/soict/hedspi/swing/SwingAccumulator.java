package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Integer:"));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(e -> {
            try {
                int input = Integer.parseInt(tfInput.getText());
                sum += input;
                tfOutput.setText(String.valueOf(sum));
                tfInput.setText("");
            } catch (NumberFormatException ex) {
                tfOutput.setText("Invalid input. Please enter an integer.");
            }
        });

        cp.add(new JLabel("The accumulated sum is:"));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setTitle("Swing Accumulator");
        setSize(300, 100);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingAccumulator accumulator = new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int input = Integer.parseInt(tfInput.getText());
                sum += input;
                tfOutput.setText(String.valueOf(sum));
                tfInput.setText("");
            } catch (NumberFormatException ex) {
                tfOutput.setText("Invalid input. Please enter an integer.");
            }
        }
    }
}
