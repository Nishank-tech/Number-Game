import java.util.Scanner;
import java.util.Random;

public class numberGuess {

    public static void numGuess(){
        Random random = new Random(); // Create a random number generator
        Scanner sc = new Scanner(System.in); // Create a scanner to get user input
        int userInput;
        int randomNum = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int attempts = 11; // Set the number of tries the user has
        int again;
        int score = 0;

        // Ask the user to enter a number
        System.out.println("Enter a number between 1-100 (you have 11 tries):");
        userInput = sc.nextInt();

        // Keep asking the user until they run out of tries or guess the right number
        while(attempts > 0 && userInput != randomNum){
            if(userInput < randomNum){
                // Tell the user to guess a larger number
                System.out.println("Pick a larger number!!");
            } else if(userInput > randomNum){
                // Tell the user to guess a smaller number
                System.out.println("Pick a smaller number!!");
            } 
            attempts--; // Decrease the number of tries left
            System.out.println(attempts + " tries remaining.");

            // If there are tries left, ask for another number
            if(attempts > 0){
                System.out.println("Enter a number:");
                userInput = sc.nextInt();
            }
        }

        // Decrease tries left one more time after the loop
        attempts--;
        // Calculate the score based on tries left
        score = attempts * 10;

        // Check if the user guessed the right number
        if(userInput == randomNum){
            System.out.println("CONGRATULATIONS!! You guessed the right number");
            System.out.println("Your score is: " + score);
        } else {
            System.out.println("You lost! The correct number was: " + randomNum);
        }

        // Ask if the user wants to play again
        System.out.println("Do you want to play again (0 = No, 1 = Yes):");
        again = sc.nextInt();
        
        // If yes, start the game again
        if(again == 1){
            numGuess();
        } else {
            // If no, say goodbye
            System.out.println("Goodbye! Hope to see you again soon.");
        }
        //close the Scanner object
        sc.close();
    }

    public static void main(String[] args){
        System.out.println("####### Number Guess Game #######");
        numGuess(); // Start the game
    }
}
