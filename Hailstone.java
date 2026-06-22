// Siyona Shah
// 6/22/2026
// Hailstone.java
/* This program displays the Hailstone Sequence proposed by German mathematician
 * Lothar Collatz. The sequence always ends in a 1, although it has yet to be proven.
 * The sequence works this way: pick a number, if it is even then half it,
 * if it is odd then multiply by 3 and add one. Continue this process until 
 * the number becomes one.
 *
 * Working on: Using structures such as while, if-else and do-while. We will also
 * be asking the user for input.
 */
 
// importing scanner to be able to take in user input and create a scanner.
import java.util.Scanner;

public class Hailstone
{
	// Declaring field variables of my program
	int num; // The fielf variable called num is the number the user enters which
	// is an int. It is the number that is put as the starting value of the sequence.
	// If it is not a valid number, the sequence will not be printed.
	int counter; // The field variable called counter is an int which keeps track
	// of how many times it has been going in the sequence. When it is 10, it
	// has to go to the next line. I made this a field variable as I need it
	// for my printSequence() method. It is the number of iteration of the sequence 
	// until it becomes finally becomes one.
	
	/* Constructor for Hailstone which initializes the field
	 * variables. It sets num to -1 as the starting or sentinel value
	 * and initializes counter to 0.
	 */
	public Hailstone()
	{
		num = -1;
		counter = 0;
	}
	
	/* Main method. It creates an instance of the Hailstone class
	 * named hs, which initializes the necessary variables through
	 * the constructor. Then, it calls the findIt() method using that
	 * object to begin running the program.
	 */
	public static void main(String[] args)
	{
		Hailstone hs = new Hailstone(); // creates instamce of Hailstone class
		hs.findIt(); // calls findIt() method using that object
	}
	
	/* This findIt() method first prints the promt and calls blankLines() at the
	 * start, then repeatedly asks the user for input using userInput(). It
	 * first calls the blankLines() method to get three blank lines. After that,
	 * it asks for user input from the userInput() method. It checks if it is a valid
	 * number and calls printSequence() and printLoop() while num doesn't equal 1.
	 */
	public void findIt()
	{
		blankLines();
		System.out.println("Hello! Welcome to my program called Hailstone. It"
		+ " displays the Hailstone Sequence proposed by the German mathematician"
		+ " Lothar Collatz. After entering a number, if it is even then the"
		+ " program will half it, if it is odd then the program will multiply by"
		+ " 3 and add one. It will do this process until the number becomes one.\n");
		do {
			userInput(); 
			if (num >= 1 && num <= 10000)
			{
				printSequence();
				printLoop();
			}
			else if (num != -1)
			{
				printLoop();
			}
			else
			{
				printLoop();
			}
		}
		while (num != -1);
	}
	
	/* The userInput() method prompts the user to enter a number
	 * for the Hailstone sequence. It creates a Scanner object
	 * to read input, displays a message asking for a value between
	 * 1 and 10000 (or -1 to quit), and then stores the user’s
	 * input in the variable num.
	 */
	public void userInput()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a positive integer ( 1 - 10000 ). To quit, enter -1:\t");
		num = input.nextInt();
	}
	
	/* The printSequence() method generates and displays the Hailstone sequence
	 * for the current value of num. It starts by resetting the counter and a
	 * variable to track how many numbers have been printed on the current line.
	 * In a loop, it prints each number followed by a tab, increments the counter,
	 * and moves to a new line after every ten numbers. For each number, if it is
	 * even, it is divided by two. If it is odd, it is multiplied by three and
	 * increased by one.
	 */
	public void printSequence()
	{
		counter = 0;
		int perLine = 0;
		System.out.print("\t");
		while (num != 1)
		{
			System.out.print(num + "\t");
			counter++;
			perLine++;
			if (perLine == 10)
			{
				System.out.print("\n\t");
				perLine = 0;
			}
			if (num % 2 == 0)
			{
				num = num / 2;
			}
			else
			{
				num = 3 * num + 1;
			}
		}
		System.out.print(num + "\n");
		counter++;
	}
	
	/* The printLoop() method checks the value of num and prints the message
	 * based on different conditions. If num is less than 1 or greater than 10000,
	 * it tells the user that the input is out of range. If num is -1, it prints a
	 * thank you message signaling the end of the program. Otherwise, for valid
	 * inputs, it prints the number of times the Hailstone sequence loop executed.
	 */
	public void printLoop()
	{
		if (num == -1)
		{
			System.out.println("Thank you for playing Hailstone.");
			blankLines(); // calls method to prnt three blank lines
		}
		else if (num < 1 || num > 10000)
		{
			System.out.println("\nEnter a value within range, please!\n");
		}
		else
		{
			System.out.println("The loop executed " + counter + " times.\n");
		}
	}
	
	/* The blankLines() method prints three blank lines before and after the code 
	 * when it is called upon. It is a void and does not return any value. Moreover,
	 * it is pubic.
	 */
	public void blankLines()
	{
		System.out.print("\n\n\n");
	}
} // end class
