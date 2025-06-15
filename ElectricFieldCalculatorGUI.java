import java.awt.event.*;
import javax.swing.*;

public class ElectricFieldCalculatorGUI {

    public void showCalculator() {
        JFrame frame = new JFrame("Electric Field Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Electric Field input
        JLabel fieldLabel = new JLabel("Electric Field E (N/C):");
        fieldLabel.setBounds(20, 20, 120, 25);
        frame.add(fieldLabel);

        JTextField fieldField = new JTextField("");
        fieldField.setBounds(150, 20, 200, 25);
        frame.add(fieldField);

        // Distance input
        JLabel distanceLabel = new JLabel("Distance r (m):");
        distanceLabel.setBounds(20, 60, 120, 25);
        frame.add(distanceLabel);

        JTextField distanceField = new JTextField("");
        distanceField.setBounds(150, 60, 200, 25);
        frame.add(distanceField);

        // Force input
        JLabel forceLabel = new JLabel("Force F (N):");
        forceLabel.setBounds(20, 100, 120, 25);
        frame.add(forceLabel);

        JTextField forceField = new JTextField("");
        forceField.setBounds(150, 100, 200, 25);
        frame.add(forceField);

        // Result label
        JLabel resultLabel = new JLabel("Charge q (C):");
        resultLabel.setBounds(20, 180, 350, 25);
        frame.add(resultLabel);

        // Button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 140, 200, 25);
        frame.add(calculateButton);

        // Action
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double E = Double.parseDouble(fieldField.getText());
                    double r = Double.parseDouble(distanceField.getText());
                    double F = forceField.getText().isEmpty() ? 0 : Double.parseDouble(forceField.getText());
                    double k = 9e9; // Coulomb's constant

                    if (r == 0) {
                        resultLabel.setText("Distance cannot be zero.");
                        return;
                    }

                    if (F > 0) {
                        // Calculate charge q from F = E * q
                        double q = F / E;
                        resultLabel.setText("Charge (q) = " + q + " C");
                    } else {
                        // Calculate charge q from E = k * q / r^2
                        double q = (E * r * r) / k;
                        resultLabel.setText("Charge (q) = " + q + " C");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Enter numbers only.");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ElectricFieldCalculatorGUI().showCalculator());
    }
}