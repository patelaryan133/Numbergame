import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        final int MIN = 1, MAX = 100, MAX_ATTEMPTS = 7;
        int roundsWon = 0, rounds = 0;
        String again;
        do {
            rounds++;
            int target = rnd.nextInt(MAX - MIN + 1) + MIN;
            boolean won = false;
            System.out.println("\nRound " + rounds + ": Guess the number between " + MIN + " and " + MAX
                    + " (" + MAX_ATTEMPTS + " attempts)");
            for (int i = 1; i <= MAX_ATTEMPTS; i++) {
                System.out.print("Attempt " + i + " - Enter guess: ");
                while (!sc.hasNextInt()) {
                    System.out.print("Invalid. Enter a number: ");
                    sc.next();
                }
                int guess = sc.nextInt();
                if (guess == target) {
                    System.out.println("Correct! Guessed in " + i + " attempt(s).");
                    won = true;
                    roundsWon++;
                    break;
                } else if (guess > target) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Too low!");
                }
            }
            if (!won) System.out.println("Out of attempts. The number was " + target);
            System.out.println("Score: " + roundsWon + " won out of " + rounds + " round(s)");
            System.out.print("Play again? (y/n): ");
            again = sc.next();
        } while (again.equalsIgnoreCase("y"));
        System.out.println("Final score: " + roundsWon + "/" + rounds + ". Thanks for playing!");
        sc.close();
    }
}
