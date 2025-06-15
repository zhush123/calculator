import javax.swing.*;
import java.awt.event.*;

public class CapacitorEnergyCalculatorGUI {

    public void showCalculator() {
        JFrame frame = new JFrame("Capacitor Energy Calculator");
        frame.setSize(420, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Capacitance input
        JLabel capacitanceLabel = new JLabel("Capacitance (F):");
        capacitanceLabel.setBounds(20, 20, 150, 25);
        frame.add(capacitanceLabel);

        JTextField capacitanceField = new JTextField();
        capacitanceField.setBounds(180, 20, 200, 25);
        frame.add(capacitanceField);

        // Voltage input
        JLabel voltageLabel = new JLabel("Voltage (V):");
        voltageLabel.setBounds(20, 60, 150, 25);
        frame.add(voltageLabel);

        JTextField voltageField = new JTextField();
        voltageField.setBounds(180, 60, 200, 25);
        frame.add(voltageField);

        // Charge input
        JLabel chargeLabel = new JLabel("Charge (C):");
        chargeLabel.setBounds(20, 100, 150, 25);
        frame.add(chargeLabel);

        JTextField chargeField = new JTextField();
        chargeField.setBounds(180, 100, 200, 25);
        frame.add(chargeField);

        // Result label
        JLabel resultLabel = new JLabel("Energy Stored (J) / Capacitance (F):");
        resultLabel.setBounds(20, 180, 350, 25);
        frame.add(resultLabel);

        // Button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(180, 140, 200, 25);
        frame.add(calculateButton);

        // Action
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double C = capacitanceField.getText().isEmpty() ? 0 : Double.parseDouble(capacitanceField.getText());
                    double V = Double.parseDouble(voltageField.getText());
                    double Q = chargeField.getText().isEmpty() ? 0 : Double.parseDouble(chargeField.getText());

                    if (V < 0) {
                        resultLabel.setText("Voltage must be positive.");
                        return;
                    }

                    if (Q != 0 && V != 0) {
                        C = Q / V; // Calculate capacitance if charge and voltage are provided
                        capacitanceField.setText(String.format("%.4e", C));
                    } else if (C <= 0 && (Q == 0 || V == 0)) {
                        resultLabel.setText("Provide valid Capacitance, or both Charge and Voltage.");
                        return;
                    }

                    double W = 0.5 * C * V * V;
                    resultLabel.setText(String.format("Energy Stored (W) = %.4e J, Capacitance (C) = %.4e F", W, C));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Enter numbers only.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CapacitorEnergyCalculatorGUI().showCalculator());
    }
}