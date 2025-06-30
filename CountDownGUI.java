import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CountDownGUI
{
    private static int count = 0;
    private static final String[] texts = {"3 ...", "2 ...", "1 ...", "GO!"};

    public static void main(String[] args) {
        JFrame frame = new JFrame("Countdown");
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel label = new JLabel("");
        JButton button = new JButton("Start");

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (count < texts.length)
                {
                    label.setText(texts[count]);
                    count++;
                }
            }
        });

        frame.add(label);
        frame.add(button);

        frame.setVisible(true);
    }
}
