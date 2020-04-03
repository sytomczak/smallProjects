package pl.sytomczak.SzyfrowanieHarcerze;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JTextField EnterThePAswordTextField;
    private JTextField resultTextField;
    private JButton convertButton;
    private javax.swing.JPanel JPanel;
    private JRadioButton decryptRadioButton;
    private JRadioButton encryptRadioButton;


    public Main() {
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = EnterThePAswordTextField.getText();
                String result = "";

                if (encryptRadioButton.isSelected()) {
                    result = SzyfrowanieHarcerze.decryptEncrypt(input, Constants.encryptorKey);
                } else {
                    result = SzyfrowanieHarcerze.decryptEncrypt(input, Constants.decryptorKey);
                }

                resultTextField.setText(result);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SzyfrowanieHarcerze");
        frame.setContentPane(new Main().JPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
