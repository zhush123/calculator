import javax.swing.*;
import java.awt.event.*;

public class ElectricPotentialCalculatorGUI {

    public void showCalculator() {
        JFrame frame = new JFrame("Electric Potential Calculator");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Charge input
        JLabel chargeLabel = new JLabel("Charge Q (C):");
        chargeLabel.setBounds(20, 20, 120, 25);
        frame.add(chargeLabel);

        JTextField chargeField = new JTextField();
        chargeField.setBounds(150, 20, 200, 25);
        frame.add(chargeField);

        // Distance input
        JLabel distanceLabel = new JLabel("Distance r (m):");
        distanceLabel.setBounds(20, 60, 120, 25);
        frame.add(distanceLabel);

        JTextField distanceField = new JTextField();
        distanceField.setBounds(150, 60, 200, 25);
        frame.add(distanceField);

        // Result label
        JLabel resultLabel = new JLabel("Electric Potential (V):");
        resultLabel.setBounds(20, 140, 350, 25);
        frame.add(resultLabel);

        // Button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 100, 200, 25);
        frame.add(calculateButton);

        // Action
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double q = Double.parseDouble(chargeField.getText());
                    double r = Double.parseDouble(distanceField.getText());

                    if (r == 0) {
                        resultLabel.setText("Distance cannot be zero.");
                        return;
                    }

                    double k = 8.9875e9;
                    double potential = k * q / r;

                    resultLabel.setText(String.format("Electric Potential (V) = %.4e V", potential));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Enter numbers only.");
                }
            }
        });

        frame.setVisible(true);
    }
}
