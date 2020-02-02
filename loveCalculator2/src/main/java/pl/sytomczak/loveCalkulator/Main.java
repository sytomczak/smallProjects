package pl.sytomczak.loveCalkulator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel JPanel;
    private JTextField nameTextField;
    private JTextField name2TextField;
    private JButton actionButton;
    private JLabel nameJLabel;
    private JLabel name2JLabel;


    public Main() {
        actionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actionButton.setText(String.valueOf(LoveCalculatorLogic.calculate(nameTextField.getText(), name2TextField.getText())));
            }
        });
    }

    public static void main(String[] args) {

        System.out.println(LoveCalculatorLogic.calculate("foka", "fok"));

        JFrame frame = new JFrame("loveCalkulator");
        frame.setContentPane(new Main().JPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}

