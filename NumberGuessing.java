import java.util.*;

public class NumberGuessing {
    static ArrayList<Integer> totalScore = new ArrayList<Integer>();

    public static void main(String[] args) {
        NumberGuessing options = new NumberGuessing();
        options.menu(totalScore);
    }

    public void menu(ArrayList<Integer> totalScore) {
        NumberGuessing options = new NumberGuessing();
        Scanner sc = new Scanner(System.in);
        System.out.println("----------------------------------");
        System.out.println("Welcome to the number game");
        System.out.println("1) Play the Game");
        System.out.println("2) Score Board");
        System.out.println("3) Exit the game");
        System.out.println("-----------------------------------");
        try {
            System.out.print("What action would you like to do from the above actions? ");
            int menuOption = sc.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.print("\n" + "What would you like the range of the numbers to be? ");
                    int numberRange = sc.nextInt();
                    int randomNumber = options.randomNumber(numberRange);
                    options.guessNumber(randomNumber);
                    break;
                case 2:
                    options.displaytotalScore();
                    break;
                case 3:
                    System.out.println("\n" + "Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.Could you please Try again later!!!!!!!!!");
            }
        } catch (InputMismatchException e) {
            System.err.println("\n" + e.getMessage() + "\n");
            menu(totalScore);
        }
    }

    public int randomNumber(int numberRange) {
        Random random = new Random();
        int randomNumber = random.nextInt(numberRange) + 1;
        return randomNumber;
    }

    public void guessNumber(int randomNumber) {
        Scanner sc = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            userGuess = sc.nextInt();
            guess++;
            if (userGuess > randomNumber) {
                System.out.println("guess the number lower/lesser than previous");
            } else if (userGuess < randomNumber) {
                System.out.println("guess the number higher/greater than previous");
            }
        } while (randomNumber != userGuess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        totalScore.add(guess);
        System.out.println(" ");
        menu(totalScore);
    }

    public void displaytotalScore() {
        System.out.println("......................");
        System.out.println("Score Board");
        System.out.println("..........................");
        System.out.println("Your fastest games today out of all tries is: " + "\n");
        Collections.sort(totalScore);
        for (Integer scores : totalScore) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(totalScore);
    }
}