package pl.sytomczak.temperatureConverter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JPanel panel1;
    private JRadioButton distanceRadioButton;
    private JRadioButton temperatureRadioButton;
    private JList inputUnitsList;
    private JTextField typingTextField;
    private JButton convertButton;
    private JList outputUnitList;


    public MainWindow() {
        temperatureRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUnits();
            }
        });
        distanceRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUnits();
            }
        });
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double result = TemperatureConverter.convert(
                        (String) inputUnitsList.getSelectedValue(),
                        (String) outputUnitList.getSelectedValue(),
                        Double.valueOf(typingTextField.getText()));

                typingTextField.setText(String.valueOf(result));
            }
        });
    }

    public void setUnits(){
        if(temperatureRadioButton.isSelected()){
            ListModel model = new DefaultListModel();
            ((DefaultListModel) model).add(0, "C");
            ((DefaultListModel) model).add(1, "F");
            ((DefaultListModel) model).add(2, "K");
            inputUnitsList.setModel(model);
            outputUnitList.setModel(model);
        } else {
            ListModel model = new DefaultListModel();
            ((DefaultListModel) model).add(0, "Cm");
            ((DefaultListModel) model).add(1, "M");
            ((DefaultListModel) model).add(2, "Foki");
            inputUnitsList.setModel(model);
            outputUnitList.setModel(model);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("temperatureConverter");
        frame.setContentPane(new MainWindow().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}