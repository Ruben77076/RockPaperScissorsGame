
package rockpaperscissorsgame;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruben Ramirez
 */
public class RockPaperScissorsGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //String[] pickOptions = {"Rock","Paper","Scissors"};
        //int[] pickOptions = {1,2,3};
        int[] scores = {0, 0, 0};
        
        do {
            
            Random cpu = new Random();
            int cpuPick = cpu.nextInt(1,4);
            
            String userInput = JOptionPane.showInputDialog(null,"Choose an option:\n "
                    + "1 = Rock\n 2 = Paper\n 3 = Scissors\n\n",
                    "Rock Paper Scissors",JOptionPane.INFORMATION_MESSAGE);
            int userPick = Integer.parseInt(userInput);
            
            getWinner(cpuPick, userPick, scores);
            
            viewScore(scores);
        } while (JOptionPane.showConfirmDialog(null, 
                "Wanna battle again???","Rock Paper Scissors",
                JOptionPane.INFORMATION_MESSAGE)== JOptionPane.YES_OPTION);
                
    }
    
    private static void viewScore(int[] scores){
        JOptionPane.showMessageDialog(null, "Your wins: " + scores[0] 
                + "\nA.I. Wins: " + scores[1] + "\nTied Games: " + scores[2],
                "Rock Paper Scissors",JOptionPane.INFORMATION_MESSAGE);
    }
    private static void getWinner(int cpuPick, int userPick, int[] scores){
        if (userPick == cpuPick) {
            JOptionPane.showMessageDialog(null, "It's a tie! What are the chances!"
            , "Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
            scores[2]++;
        } else if (
                (userPick == 1 && cpuPick == 3) || 
                (userPick == 2 && cpuPick == 1) ||
                (userPick == 3 && cpuPick == 2)
        ) {
            JOptionPane.showMessageDialog(null, "        You Win! \uD83D\uDE0E"
                    ,"Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
            scores[0]++;
        } else {
            JOptionPane.showMessageDialog(null, "        A.I. wins! \uD83D\uDE1F"
                    ,"Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
            scores[1]++;
        }
        //U+1F60E,U+1F61F
    }
    
}
