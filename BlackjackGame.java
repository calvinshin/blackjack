import java.util.Scanner;
import java.util.Random;

public class BlackjackGame {
    public static void main(String[] args) {
//        initialize variables for system (random, scanner)
        Scanner userInput = new Scanner(System.in);
        Random random = new Random();
//        initialize aesthetic lines
        String dashes = "-------------------------------\n";
//        initialize variables related to player (total)
        int total;
//        STRETCH: initialize variables for dealer
//        initialize game variables: playAgain = yes; gameActive = true; action;
        String playAgain = "yes";
        boolean gameActive = true;
        String action;
//        Welcome player to game of blackjack
        System.out.print(dashes);
        System.out.print("Welcome to a game of Blackjack!");
        System.out.println();
//        create a while loop for the game
        while(playAgain.equals("yes")) {
//          reset the game variables (total = card1+2), gameActive = true;
//        create the first hand with 2 random cards (with 2 variables)
            gameActive = true;
            int card1 = random.nextInt(10) + 1;
            int card2 = random.nextInt(10) + 1;
            total = card1 + card2;
//          display 2 cards and total
            System.out.println("Drawn cards: " + card1 + " " + card2);
            System.out.println("Total: " + total);
//        while statement (gameActive == true)
//            NEEDS TO BE SET AS A LOGICAL COMPARISON, not a setting of the variable
            while(gameActive == true) {
//              prompt user for actions, hit or stay?
                System.out.println("What would you like to do? (Options are 'hit' or 'stay')");
//              take in user input and set to variable action
                action = userInput.next();
//              use a while loop for validation (action == "hit" || action == "stay")
                while (!(action.equalsIgnoreCase("hit") || action.equalsIgnoreCase("stay"))) {
                    System.out.println("Unknown command. Please try again. (Options are 'hit' or 'stay')");
                    action = userInput.next();
                }
                switch (action.toLowerCase()) {
//                  for hit: draw a new random card
//                          display the new card
//                          display the total
                    case "hit":
                        int card3 = random.nextInt(10) + 1;
                        total += card3;
                        System.out.println("You chose to hit!");
                        System.out.println("You drew a " + card3 + ".");
                        System.out.println("Your new total is " + total + ".");
//                          if > 21, declare bust and set gameActive = false
                        if(total > 21) {
                            System.out.println("You bust!");
                            gameActive = false;
                        }
//                          (nothing else, as this returns to the beginning of the while statement)
                        break;
                    case "stay":
                        System.out.println("Your total is " + total + ".");
                        gameActive = false;
                        System.out.println();
//                  for stay: resummarize the total
//                       set gameActive = false;
                }
            }
//        while statement (gameActive = false)
//                  Ask if they want to playAgain (validation)
            System.out.println("Do you want to play again? (Options: yes/no)");
            playAgain = userInput.next();
//          end everything if it playAgain = no
            while(!(playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("no"))) {
                System.out.println("Invalid input. Try again. (Options: yes/no)");
                playAgain = userInput.next();
            }
            switch (playAgain.toLowerCase()){
                case "no":
                    System.out.println("Thanks for playing! Goodbye!");
                    System.exit(0);
                    break;
                case "yes":
                    System.out.println(dashes);
                    System.out.println("Let's play again!");
                    break;
            }

        }
    }
}