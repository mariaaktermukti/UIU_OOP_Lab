import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FootInchConverter {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Foot-Inch Converter");
        frame.setSize(400, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel footLabel = new JLabel("Foot:");
        JTextField footField = new JTextField(10);

        JLabel inchLabel = new JLabel("Inch:");
        JTextField inchField = new JTextField(10);

        JButton convertToInchBtn = new JButton("Convert to Inch");
        JButton convertToFootBtn = new JButton("Convert to Foot");

        convertToInchBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try {
                    double foot = Double.parseDouble(footField.getText());
                    double inch = foot * 12;
                    inchField.setText(String.format("%.2f", inch));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input in Foot field.");
                }
            }
        });

        convertToFootBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                try {
                    double inch = Double.parseDouble(inchField.getText());
                    double foot = inch / 12;
                    footField.setText(String.format("%.2f", foot));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input in Inch field.");
                }
            }
        });

        frame.add(footLabel);
        frame.add(footField);
        frame.add(inchLabel);
        frame.add(inchField);
        frame.add(convertToInchBtn);
        frame.add(convertToFootBtn);
        
        frame.setVisible(true);
    }
}
