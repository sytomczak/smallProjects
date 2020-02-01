import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JButton startButton;
    private JLabel player1JLabel;
    private JLabel player2JLabel;
    private javax.swing.JPanel JPanel;
    private JLabel winnerJLabel;
    private String winner;

    public Main() {
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String rzutGraczaA = wykonajRuch("A");
                String rzutGraczaB = wykonajRuch("B");
                player1JLabel.setText(rzutGraczaA);
                player2JLabel.setText(rzutGraczaB);

            }
        });
    }

    public static void main(String[] args){

        JFrame frame = new JFrame("RockPaperScissors");
        frame.setContentPane(new Main().JPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }


    private String wykonajRuch(String gracz) {
        double randomGraczA = Math.random();
        double randomGraczB = Math.random();

        double wartoscRzutu = 0;

        if(gracz == "A"){
            wartoscRzutu = randomGraczA;
        }else{
            wartoscRzutu = randomGraczB;
        }

        if(wartoscRzutu <= 0.33){
            return "kamień";
        }else if(wartoscRzutu >= 0.66){
            return  "nożyce";
        }else{
            return "papier";
        }
    }
}
