import javax.swing.*;
import java.awt.event.*;

public class CoulombsLawCalculatorGUI {

    public void showCalculator() {
        JFrame frame = new JFrame("Coulomb's Law Calculator");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Charge q1
        JLabel q1Label = new JLabel("Charge q1 (C):");
        q1Label.setBounds(20, 20, 120, 25);
        frame.add(q1Label);

        JTextField q1Field = new JTextField();
        q1Field.setBounds(150, 20, 200, 25);
        frame.add(q1Field);

        // Charge q2
        JLabel q2Label = new JLabel("Charge q2 (C):");
        q2Label.setBounds(20, 60, 120, 25);
        frame.add(q2Label);

        JTextField q2Field = new JTextField();
        q2Field.setBounds(150, 60, 200, 25);
        frame.add(q2Field);

        // Distance
        JLabel rLabel = new JLabel("Distance r (m):");
        rLabel.setBounds(20, 100, 120, 25);
        frame.add(rLabel);

        JTextField rField = new JTextField();
        rField.setBounds(150, 100, 200, 25);
        frame.add(rField);

        // Result
        JLabel resultLabel = new JLabel("Force (N):");
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
                    double q1 = Double.parseDouble(q1Field.getText());
                    double q2 = Double.parseDouble(q2Field.getText());
                    double r = Double.parseDouble(rField.getText());

                    if (r == 0) {
                        resultLabel.setText("Distance cannot be zero.");
                        return;
                    }

                    double k = 8.9875e9;
                    double force = k * Math.abs(q1 * q2) / (r * r);

                    resultLabel.setText("Force (F) = " + force + " Newtons");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input. Please enter valid numbers.");
                }
            }
        });

        frame.setVisible(true);
    }
}
