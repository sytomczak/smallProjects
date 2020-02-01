import pl.sytomczak.calkulateAgeInSecond.CalkulateSecond;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private javax.swing.JPanel JPanel;
    private JTextField minutesTextField;
    private JTextField hoursTextField;
    private JTextField daysTextField;
    private JButton convertButton;
    private JLabel minutesLabel;
    private JLabel hoursLabel;
    private JLabel daysLabel;
    private JLabel resultLabel;

    public Main() {
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int days = Integer.valueOf(daysTextField.getText());
                int hours = Integer.valueOf(hoursTextField.getText());
                int minutes = Integer.valueOf(minutesTextField.getText());
                String result = String.valueOf(CalkulateSecond.convert(days, hours, minutes));
                resultLabel.setText(result);

            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("CalkulateAgeInSecond");
        frame.setContentPane(new Main().JPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
