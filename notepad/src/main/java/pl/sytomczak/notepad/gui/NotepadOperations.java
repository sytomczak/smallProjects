package pl.sytomczak.notepad.gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

public class NotepadOperations {

    private JTextArea textArea;
    private JPanel panel;
    private String filePath;

    public NotepadOperations(JTextArea textArea, JPanel panel) {
        if (textArea == null)
            return;

        this.textArea = textArea;
        this.panel = panel;
    }

    public void New() {
        if (textArea == null)
            return;
        if (filePath != null)
            if (JOptionPane.showConfirmDialog(JOptionPane.getRootFrame(), "Do you want to overwrite changes?") == 0)
                SaveNew();

        textArea.selectAll();
        textArea.replaceSelection("");
    }

    public File OpenOrSaveDialog(Boolean openOrSave) {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Texts", "txt"));
        int returnVal = 0;
        if (openOrSave && (fc.showOpenDialog(panel) == 1)) {
            return null;
        } else
            fc.showSaveDialog(panel);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            System.out.println((file.getPath()));
            filePath = file.getPath();
            return file;
        } else
            return null;
    }

    public void Open() {
        if (textArea == null)
            return;

        try {
            File openOrSave = OpenOrSaveDialog(true);
            if (openOrSave == null)
                return;

            try (BufferedReader br = new BufferedReader(new FileReader(openOrSave))) {
                String line;
                String allText = "";
                while ((line = br.readLine()) != null) {
                    allText += line + "\n";
                }
                textArea.setText(allText);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Save(Boolean showDialog) {
        if (textArea == null)
            return;

        String content;
        content = textArea.getText();
        try {
            if (!content.equals("")) {
                if (filePath == null || showDialog) {
                    filePath = OpenOrSaveDialog(showDialog).getPath();
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

                writer.write(textArea.getText());
                writer.close();
            } else {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "The file can't be empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void SaveNew() {
        if (textArea == null)
            return;

        try {
            if (filePath == null) {
                filePath = OpenOrSaveDialog(false).getPath();
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

                writer.write(textArea.getText());
                writer.close();
            } else {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "The file can't be empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SaveAs(Boolean showDialog) {
        if (textArea == null)
            return;

        String content;
        content = textArea.getText();
        try {
            if (!content.equals("")) {
                filePath = OpenOrSaveDialog(showDialog).getPath();

                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

                writer.write(textArea.getText());
                writer.close();
            } else {
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "The file can't be empty");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Close() {
        System.exit(0);
    }

    public void Cut() {
        Clipboard clipboard;
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        String cutString = textArea.getSelectedText();
        StringSelection cutSelection = new StringSelection(cutString);
        clipboard.setContents(cutSelection, cutSelection);
        textArea.replaceRange("", textArea.getSelectionStart(), textArea.getSelectionEnd());
    }

    public void Copy() {

        Clipboard clipboard;
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        String copyText = textArea.getSelectedText();
        StringSelection copySelection = new StringSelection(copyText);
        clipboard.setContents(copySelection, copySelection);
    }

    public void Paste() {
        Clipboard clipboard;
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        try {
            Transferable pasteText = clipboard.getContents(textArea);
            String str = (String) pasteText.getTransferData(DataFlavor.stringFlavor);
            textArea.replaceRange(str, textArea.getSelectionStart(), textArea.getSelectionEnd());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SelectAll() {
       textArea.selectAll();
    }

    DefaultHighlighter.HighlightPainter highlightPainter = new myHighlighter(Color.yellow);

    public void removeHighLight(JTextComponent textComponent){
        Highlighter removeHighlighter = textComponent.getHighlighter();
        Highlighter.Highlight[] remove = removeHighlighter.getHighlights();

        for(int i = 0; i<remove.length; i++){
            if(remove[i].getPainter() instanceof myHighlighter){
                removeHighlighter.removeHighlight(remove[i]);
            }
        }
    }

    public void Search(JTextComponent textComponent, String textString){
        removeHighLight(textComponent);

        try{
            Highlighter highlighter = textComponent.getHighlighter();
            Document doc = textComponent.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            while((pos = text.toUpperCase().indexOf(textString.toUpperCase(), pos)) >= 0) {
                highlighter.addHighlight(pos, pos+textString.length(), highlightPainter);
                pos += textString.length();
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}

class myHighlighter extends DefaultHighlighter.DefaultHighlightPainter {
    public  myHighlighter(Color color) {
        super(color);
    }
}