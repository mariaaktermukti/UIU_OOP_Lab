import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CtoFConverter extends JFrame {
    private JTextField celsiusField;
    private JTextField fahrenheitField;
    private JButton convertButton;

    public CtoFConverter()
    {
        super("CtoF Converter - OOP Final");

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel celsiusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        celsiusPanel.add(new JLabel("Enter celsius value:"));
        celsiusField = new JTextField(6);
        celsiusPanel.add(celsiusField);
        celsiusPanel.add(new JLabel("C"));
        add(celsiusPanel);

        JPanel buttonPanel = new JPanel();
        convertButton = new JButton("Convert to Fahrenheit");
        buttonPanel.add(convertButton);
        add(buttonPanel);

        JPanel fahrenheitPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fahrenheitPanel.add(new JLabel("Fahrenheit value:"));
        fahrenheitField = new JTextField(6);
        fahrenheitField.setEditable(false);
        fahrenheitPanel.add(fahrenheitField);
        fahrenheitPanel.add(new JLabel("F"));
        add(fahrenheitPanel);

        convertButton.addActionListener(e -> {
            String text = celsiusField.getText().trim();
            try {
                double c = Double.parseDouble(text);
                double f = (c * 9.0 / 5.0) + 32;
                fahrenheitField.setText(String.format("%.1f", f));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Enter a valid number!",
                        "Input Error",
                        JOptionPane.ERROR_MESSAGE
                );
                fahrenheitField.setText("");
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new CtoFConverter().setVisible(true);
            }
        });
    }
}
