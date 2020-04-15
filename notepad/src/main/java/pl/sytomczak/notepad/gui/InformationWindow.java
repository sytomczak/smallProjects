package pl.sytomczak.notepad.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InformationWindow extends JFrame {
    private JTextArea authorJPanel;
    private JPanel panel1;

    public InformationWindow() {

        setContentPane(panel1);
        setTitle("Author");
        panel1.setPreferredSize(new Dimension(600, 100));
        setLocationRelativeTo(getParent());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
}
