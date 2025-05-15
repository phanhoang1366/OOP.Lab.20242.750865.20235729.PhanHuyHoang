package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an Integer:"));

        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("The accumulated sum is:"));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        setTitle("AWT Accumulator");
        setSize(300, 100);
        setVisible(true);


    }

    public static void main(String[] args) {
        AWTAccumulator accumulator = new AWTAccumulator();
        accumulator.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        //accumulator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
