// Siyona Shah
// 6/22/2026
// NumberSequence.java
/* This program displays a number sequence game. The user is shown a sequence
* of numbers that increase by a consistent step and is asked to guess the next
* number and describe the pattern. The program uses random numbers, if-else
* logic, and loops to implement the game.
* Working on: Using if-else, using math.random, and do-whiles.
*/
import java.util.Scanner;
public class NumberSequence
{
	/* These are the field variables in my code. They include
	 * a scanner being created, an integer called startingNum, and
	 * an integer called steppingNum. The integer called startingNum
	 * stores the first number of the sequence, which is needed by multiple methods.
	 * While steppingNum stores the increment between numbers, which must
	 * be there for guessing and pattern checking. No other variables need to
	 * persist between methods, so only these two are fields other than scanner.
	 */
	// Scanner object to read input from the user
	private Scanner reader = new Scanner(System.in);
	// startingNum stores the first number in the sequence
	private int startingNum;
	// steppingNum stores the value to increment each number in the sequence
	private int steppingNum;
	/* Constructor for NumberSequence which initializes the field variables.
	 * It sets startingNum and steppingNum to 0 before the game starts.
	 */
	public NumberSequence()
	{
		startingNum = 0;
		steppingNum = 0;
	}
	/* Main method. Creates an instance of NumberSequence and calls
	 * playGame() to start the program.
	 */
	public static void main(String[] args)
	{
		NumberSequence ns = new NumberSequence();
		ns.playGame();
	}
	/* playGame() method handles the flow of the game:
	 * 1. Displays a welcome message
	 * 2. Generates a random number sequence
	 * 3. Calculates the correct next number
	 * 4. Prompts the user to guess the next number
	 * 5. Asks the user to describe the pattern
	 */
	public void playGame()
	{
		welcome();
		generateNumbers();
		int correct = startingNum + steppingNum * 5;
		guessNextNumber(correct);
		askPattern();
	}
	/* welcome() prints the game instructions and the three blank lines at the start.
	 */
	public void welcome()
	{
		System.out.println("\n\n\n");
		System.out.println("Welcome to the Number Sequence Game!");
		System.out.println("You will be shown a series of numbers that follow a " 
		+ "pattern.");
		System.out.println("Your job is to guess the next number in the sequence "
		+ "and describe the pattern.");
		System.out.println("Take your time and think carefully as you only have "
		+ "3 tries!");
		System.out.println();
	}
	/* generateNumbers() creates a random starting number and step value,
	 * prints a sequence of five numbers incremented by the step, and
	 * shows a blank spot for the next number to guess.
	 */
	public void generateNumbers()
	{
		startingNum = (int)(Math.random() * 21) - 10;
		steppingNum = (int)(Math.random() * 10) + 1;
		int currentNumber = startingNum;
		System.out.print("Here is your sequence: ");
		for (int i = 0; i < 5; i++)
		{
			System.out.print(currentNumber + " ");
			currentNumber = currentNumber + steppingNum; // add the step to get 
			//next number
		}
		System.out.println(", ___"); // indicates the missing number
		System.out.println();
	}
	/* guessNextNumber receives the parameter correct as an int and allows the
	 * user to guess the next number in the sequence up to 3 times. It checks
	 * each guess against the correct number.
	 */
	public void guessNextNumber (int correct)
	{
		int tries = 0; // counts the number of attempts
		boolean done = false; // tracks if the user guessed correctly
		while (tries < 3 && done == false)
		{
			System.out.print("What is the next number? ");
			int guess = reader.nextInt();
			if (guess == correct)
			{
				System.out.println("Correct!");
				System.out.println();
				done = true; // ends the loop if correct
			}
			else
			{
				tries++;
				if (tries < 3)
				{
					System.out.println("Incorrect. Try again."); // prompt again
				}
			}
		}
		if (done == false)
		{
			System.out.println("Incorrect. The correct next number was "
			+ correct + ".");
			System.out.println();
		}
	}
	/* askPattern() prompts the user to describe the pattern of the sequence.
	 * It accepts several variations of correct answers and checks if the 
	 * input matches.
	 */
	public void askPattern()
	{
		reader.nextLine();
		System.out.print("What is the pattern? ");
		String Guess = reader.nextLine().toLowerCase();
		// boolean to check if user input matches any correct pattern description
		boolean correct = Guess.equals("add " + steppingNum) ||
				Guess.equals("plus " + steppingNum) ||
				Guess.equals("increment by " + steppingNum) ||
				Guess.equals("increase by " + steppingNum);
		if (correct)
		{
			System.out.println("Correct, it was " + Guess + ".");
		}
		else
		{
			System.out.println("Incorrect. It was add " + steppingNum + ".");
		}
		System.out.println("\n\n\n");
	}
}  // end class
