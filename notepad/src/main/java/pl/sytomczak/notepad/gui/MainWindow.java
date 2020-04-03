package pl.sytomczak.notepad.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private JPanel panel1;
    private JTextArea textArea1;
    private JTextField searchField;

    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuHelp;
    JMenuItem fNew, fOpen, fSave, fSaveAs, fClose, eCut, eCopy, ePaste, eSelectAll;
    JButton searchButton;
    NotepadOperations notepadOperations;

    public MainWindow() {
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        notepadOperations = new NotepadOperations(textArea1, panel1);

        InitializeTopMenuItems();
        InitializeMenuItemMethods();
    }

    private void InitializeTopMenuItems() {


        menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        menuEdit = new JMenu("Edit");

        setJMenuBar(menuBar);
        setContentPane(panel1);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);

        fNew = new JMenuItem("New");
        fOpen = new JMenuItem("Open");
        fSave = new JMenuItem("Save");
        fSaveAs = new JMenuItem("Save as");
        fClose = new JMenuItem("Close");

        eCut = new JMenuItem("Cut");
        eCopy = new JMenuItem("Copy");
        ePaste = new JMenuItem("Paste");
        eSelectAll = new JMenuItem("Select all");

        menuFile.add(fNew);
        menuFile.add(fOpen);
        menuFile.add(fSave);
        menuFile.add(fSaveAs);
        menuFile.add(fClose);

        menuEdit.add(eCut);
        menuEdit.add(eCopy);
        menuEdit.add(ePaste);
        menuEdit.add(eSelectAll);
    }

    private void InitializeMenuItemMethods() {
        fNew.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notepadOperations.New();
            }
        });
        fOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notepadOperations.Open();
            }
        });
        fSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notepadOperations.Save(false);
            }
        });
        fSaveAs.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notepadOperations.SaveAs(false);
            }
        });
        fClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notepadOperations.Close();
            }
        });

        eCut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notepadOperations.Cut();
            }
        });
        eCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notepadOperations.Copy();
            }
        });
        ePaste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notepadOperations.Paste();
            }
        });
        eSelectAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notepadOperations.SelectAll();
            }
        });


        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                notepadOperations.Search(textArea1, searchField.getText());
                    }
                });

    }

    public static void main(String[] args) {
        MainWindow appMenu = new MainWindow();
        appMenu.setVisible(true);

    }
}