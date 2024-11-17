package Task;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {

    public static final int MAX_ATTEMPTS = 10;
    public static final int RANGE_START = 1;
    public static final int RANGE_END = 100;
    public int score = 0;
    public int round = 1;

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Guess the Number Game!");

        while (true) {
            System.out.println("\nRound " + round + " - Guess a number between " + RANGE_START + " and " + RANGE_END);
            int randomNumber = generateRandomNumber();
            int attempts = playRound(randomNumber, scanner);

            // Calculate score based on number of attempts
            int points = (MAX_ATTEMPTS - attempts) * 10;
            score += points > 0 ? points : 0;
            System.out.println("Round " + round + " completed! Attempts: " + attempts + ", Points earned: " + points);
            System.out.println("Current score: " + score);


            System.out.print("Would you like to play another round? (y/n): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
            round++;
        }

        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }

    public int playRound(int randomNumber, Scanner scanner) {
        int attempts = 0;
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                return attempts;
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        System.out.println("You've used all attempts. The correct number was: " + randomNumber);
        return attempts;
    }

    public int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(RANGE_END - RANGE_START + 1) + RANGE_START;
    }

    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame();
        game.startGame();
    }
    }


