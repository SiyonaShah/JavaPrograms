// Siyona Shah
// 9-4-26
// Worksheet.java
// This program asks the user for a starting and ending number range, then
// generates 20 random addition and subtraction problems using numbers from that
// range. It formats these problems into a clean worksheet layout and saves them
// to a text file. An answer key is included at the end of the file for easy checking.
// Working on: arrays, try-catch, file output

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Worksheet
{
	// Constant that stores the amount of math problems
	private static final int TOTAL_PROBLEMS = 20;
	private int[] firstNums = new int[TOTAL_PROBLEMS]; // Stores first number
	private int[] secondNums = new int[TOTAL_PROBLEMS]; // Stores second number
	private int[] answers = new int[TOTAL_PROBLEMS]; // Stores correct answer
	private char[] operators = new char[TOTAL_PROBLEMS]; // Stores operator
	private Scanner input = new Scanner(System.in); // Scanner to get input

	public static void main(String[] args)
	{
		Worksheet worksheet = new Worksheet();
		worksheet.run();
	}
	
	// This method called run() will get the user's starting value and ending value.
	// It will call the createWorksheet() method and will call the printWorksheet() 
	// method. It will state if it has been successfully created at the end. It
	// also prints the prompt.
	private void run()
	{
		int startRange;
		int endRange;
		System.out.print("\n\n\n"); // print three blank lines
		System.out.println("\tWelcome to Worksheet.java!\n"
				+ "This program creates a math worksheet with random\n"
				+ "addition and subtraction problems and an answer key.\n");
		startRange = getInput("Enter the starting value: ");
		endRange = getInput("Enter the ending value: ");
		if (endRange < startRange)
		{
			System.out.println("Ending value must be greater than starting value.");
			System.out.print("\n\n\n"); // print three blank lines
			System.exit(1);
		}
		createWorksheet(startRange, endRange);
		printWorksheet(startRange, endRange);
		System.out.println("Worksheet.txt has been created!");
		System.out.print("\n\n\n"); // print three blank lines
		input.close();
	}
	
	// This method, called getInput, reads an integer value entered from the 
	// keyboard, and then returns that value to the calling method.
	private int getInput(String prompt)
	{
		int user = 0;
		System.out.print(prompt);
		user = input.nextInt();
		return user;
	}
	
	// This method, called createWorksheet, generates random numbers within the 
	// given range, stores them in the first and second number arrays, randomly
	// selects either addition or subtraction for each problem, and calculates
	// and stores the correct answers.
	private void createWorksheet(int startRange, int endRange)
	{
		Random rand = new Random();
		for (int i = 0; i < TOTAL_PROBLEMS; i++)
		{
			firstNums[i] = rand.nextInt(endRange - startRange + 1) + startRange;
			secondNums[i] = rand.nextInt(endRange - startRange + 1) + startRange;
			if (rand.nextBoolean()	) // a method to make a random boolean - true / false 
			{
				operators[i] = '+'; // Addition
				answers[i] = firstNums[i] + secondNums[i];
			}
			else
			{
				operators[i] = '-'; // Subtraction
				answers[i] = firstNums[i] - secondNums[i];
			}
		}
	}
	
	// This method, called printWorksheet, writes the formatted math worksheet
	// to a text file, including the header, math problems, spacing for student
	// work, and an answer key at the end of the file.
	private void printWorksheet(int startRange, int endRange)
	{
		try (PrintWriter pw = new PrintWriter("Worksheet.txt"))
		{
			pw.println(String.format("%80s", "Name___________________________"));
			pw.println(String.format("%80s", "Date______________"));
			pw.println("Addition and subtraction practice using numbers "
				+ startRange + " to " + endRange);
			pw.println();
			for (int i = 0; i < TOTAL_PROBLEMS; i++)
			{
				String problem = "";
				problem = String.format("%2d. %3d %c %3d =", i + 1,
					firstNums[i], operators[i], secondNums[i]);
				pw.print(String.format("%-20s", problem)); // prints formatted
				if ((i + 1) % 4 == 0)
				{
					pw.println("");
					pw.println(""); // blank line for student
				}
			}
			// 5 blank lines before Answer Key
			for (int i = 0; i < 5; i++)
			{
				pw.println();
			}
			pw.println("Answer Key\n");
			for (int i = 0; i < TOTAL_PROBLEMS; i++)
			{
				String answer = "";
				answer = String.format("%2d. %3d", i + 1, answers[i]);
				pw.print(String.format("%-20s", answer));
				// New line every 4 problems
				if ((i + 1) % 4 == 0)
				{
					pw.println();
				}
			}
		}
		catch (IOException e)
		{
			System.out.println("Error writing file");
			System.exit(2);
		}
	}
}
