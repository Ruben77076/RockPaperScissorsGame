
package rockpaperscissorsgame;

import java.util.Random;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
import java.util.HashMap;
import java.util.Map;
 *
 * @author Ruben Ramirez
 */
public class RockPaperScissorsGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //int[] pickOptions = {1,2,3};
        
        int[] scores = {0, 0, 0}; // initialize scoreboard
        
        do {
            
            Random cpu = new Random();
            int cpuPick = cpu.nextInt(1,4); //create a random number from 1-3
            
//<editor-fold defaultstate="collapsed" desc="number input">  String userInput = JOptionPane.showInputDialog(null,"Choose an option:\n "
//                    + "1 = Rock\n 2 = Paper\n 3 = Scissors\n\n",
//                    "Rock Paper Scissors",JOptionPane.INFORMATION_MESSAGE);
//            int userPick = Integer.parseInt(userInput);
//</editor-fold>            
            String userInput = showComboBox();
            if (userInput == null) {
                break; //input cannot be null will 
            }
            int userPick = Integer.parseInt(userInput); //checks if userinput is an integer then assigns to userPick
            
            viewAIpick(cpuPick);               
                
            getWinner(cpuPick, userPick, scores); //executes getWinner method
            
            viewScore(scores); //executes viewScore method
            
            
        } while (JOptionPane.showConfirmDialog(null, 
                "Wanna battle again???","Rock Paper Scissors",
                JOptionPane.INFORMATION_MESSAGE)== JOptionPane.YES_OPTION);
               //this while looping will ask after game is over if you want to play again 
    }
    
    private static void viewScore(int[] scores){
        JOptionPane.showMessageDialog(null, "Your wins: " + scores[0] 
                + "\nA.I. Wins: " + scores[1] + "\nTied Games: " + scores[2],
                "Rock Paper Scissors",JOptionPane.INFORMATION_MESSAGE);
    }   //will display the scoreboard according to the array scores with 3 indexes: Your win, Ai wins, Ties
    
    private static void getWinner(int cpuPick, int userPick, int[] scores){
        if (userPick == cpuPick) {
            JOptionPane.showMessageDialog(null, "It's a tie! What are the chances!"
            , "Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
            scores[2]++;
        } else if (
                (userPick == 1 && cpuPick == 3) || 
                (userPick == 2 && cpuPick == 1) ||
                (userPick == 3 && cpuPick == 2)
                //this is the logic that looks for when you win vs AI.
        ) {
            JOptionPane.showMessageDialog(null, "        You Win! \uD83D\uDE0E"
                    ,"Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
            scores[0]++;
            
        } else {
            JOptionPane.showMessageDialog(null, "        A.I. wins! \uD83D\uDE1F"
                    ,"Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
            scores[1]++;
        }
        
    }
    
    private static void viewAIpick(int cpuPick){
        if (cpuPick == 1) {
            JOptionPane.showMessageDialog(null, "AI chooses ROCK! "
            ,"Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
        }else if (cpuPick == 2) {
            JOptionPane.showMessageDialog(null, "AI chooses PAPER! "
            ,"Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "AI chooses SCISSORS! "
            ,"Rock Paper Scissors", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
    private static String showComboBox(){
        //create the combo box for the beginning input of game. Removes issues with validation.
        String[] picks = {"ROCK","PAPER","SCISSORS"};
        JComboBox<String> comboBox = new JComboBox<>(picks);
        int choice = JOptionPane.showConfirmDialog(null,
        comboBox, "Rock Paper Scissors Game", JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.PLAIN_MESSAGE);
        
        if (choice == JOptionPane.OK_OPTION) {
            return Integer.toString(comboBox.getSelectedIndex() + 1);
        }else {
            return null;
        }
//<editor-fold defaultstate="collapsed" desc="number input or emoji map">Integer[] picks = {1,2,3};
//        Map<Integer, String> emojiMap = new HashMap<>();
//        emojiMap.put(1,"\uD83E\uDD1A");
//        emojiMap.put(2,"\uD83D\uDCDC");
//        emojiMap.put(3,"\u2702");
//        
//        Object[] options = {emojiMap.get(1) + "Rock", emojiMap.get(2) + "Paper"
//                , emojiMap.get(3) + "Scissors"};
//        JComboBox<Object> comboBox = new JComboBox<>(options);
//        int choice = JOptionPane.showConfirmDialog(null, comboBox,
//   "Rock Paper Scissors", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//        
//        if (choice == JOptionPane.OK_OPTION) {
//            String selectedOption = comboBox.getSelectedItem().toString();
//            return selectedOption.substring(0, 1);
//        } else {
//            return null;
//        }
//</editor-fold>
    }
    
}
