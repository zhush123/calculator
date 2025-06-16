import javax.swing.*;
import java.awt.event.*;

public class ElectromagneticInductionCalculatorGUI {

    public void showCalculator() {
        JFrame frame = new JFrame("Solenoid Time Constant Calculator");
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null); // Center window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Inductance
        JLabel inductanceLabel = new JLabel("Inductance L (H):");
        inductanceLabel.setBounds(20, 20, 200, 25);
        frame.add(inductanceLabel);

        JTextField inductanceField = new JTextField("0.0875"); // 87.5 mH
        inductanceField.setBounds(220, 20, 180, 25);
        frame.add(inductanceField);

        // Resistance
        JLabel resistanceLabel = new JLabel("Resistance R (Ω):");
        resistanceLabel.setBounds(20, 60, 200, 25);
        frame.add(resistanceLabel);

        JTextField resistanceField = new JTextField("0.250");
        resistanceField.setBounds(220, 60, 180, 25);
        frame.add(resistanceField);

        // Voltage
        JLabel voltageLabel = new JLabel("Voltage V (V):");
        voltageLabel.setBounds(20, 100, 200, 25);
        frame.add(voltageLabel);

        JTextField voltageField = new JTextField();
        voltageField.setBounds(220, 100, 180, 25);
        frame.add(voltageField);

        // Percentage
        JLabel percentageLabel = new JLabel("Percentage of Max Current (%):");
        percentageLabel.setBounds(20, 140, 200, 25);
        frame.add(percentageLabel);

        JTextField percentageField = new JTextField("63"); // Default to 63% as per example
        percentageField.setBounds(220, 140, 180, 25);
        frame.add(percentageField);

        // Result label
        JLabel resultLabel = new JLabel("Time Constant τ (s) / Time to Reach (s):");
        resultLabel.setBounds(20, 220, 400, 25);
        frame.add(resultLabel);

        // Calculate button
        JButton calcButton = new JButton("Calculate");
        calcButton.setBounds(220, 180, 180, 25);
        frame.add(calcButton);

        calcButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double L = Double.parseDouble(inductanceField.getText());
                    double R = Double.parseDouble(resistanceField.getText());
                    double V = voltageField.getText().isEmpty() ? 0 : Double.parseDouble(voltageField.getText());
                    double percent = Double.parseDouble(percentageField.getText()) / 100.0;

                    if (R == 0) {
                        resultLabel.setText("Resistance cannot be zero.");
                        return;
                    }

                    double tau = L / R; // Time constant

                    double t = 0;
                    if (V > 0 && percent > 0 && percent <= 1) {
                        // Time to reach percent of max current I = (V/R)(1 - e^(-t/τ))
                        // For 63%, I/I_max = 0.63 = 1 - e^(-t/τ)
                        double fraction = 1 - percent;
                        t = -tau * Math.log(fraction);
                    } else if (percent <= 0 || percent > 1) {
                        resultLabel.setText("Percentage must be between 0 and 100.");
                        return;
                    }

                    String result = String.format("Time Constant (τ) = %.4e s", tau);
                    if (t > 0) {
                        result += String.format(", Time to Reach %.0f%% = %.4e s", percent * 100, t);
                    }

                    resultLabel.setText(result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Use numeric values only.");
                }
            }
        });

        frame.setVisible(true);
    }
}