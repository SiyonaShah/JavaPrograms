// Siyona Shah
// 6/23/2026
// GradeStats.java
/* This program allows the user to enter student scores until "Quit" is typed.
* It stores the scores in an array, prints each student’s score,
* identifies which students scored below 75%, and calculates statistics
* including minimum, maximum, average, and median.
* Working on: Arrays, methods, input processing, formatting
*/

import java.util.Scanner;

public class GradeStats
{
	static int[] scores; // field variable score as an array with ints
	static int count; // field variable count which is stored as an int
	
	public static void main(String[] args)
	{
		GradeStats gs = new GradeStats();
		gs.calculateIt();
	}
	
	// The constructor that initializes all the field variables. It sets scores 
	// to an array that can store 20 values. It initializes count to zero.
	public GradeStats()
	{
		scores = new int[20];
		count = 0;
	}
	
	// This calculateIt method calls getInput() to read scores,
	// then prints the data, checks for scores below 75%,
	// calculates statistics, orders scores, finds the median,
	// and prints all results.
	public static void calculateIt()
	{
		int min;
		int max;
		double avg;
		double median;
		
		count = getInput(scores);
		printData(scores, count);
		printBelow75(scores, count);
		min = findMin(scores, count);
		max = findMax(scores, count);
		avg = findAverage(scores, count);
		orderScores(scores, count);
		median = findMedian(scores, count);
		
		System.out.printf("%-20s%d%n", "Number of scores:", count);
		System.out.printf("%-20s%d%n", "Minimum:", min);
		System.out.printf("%-20s%d%n", "Maximum:", max);
		System.out.printf("%-20s%.1f%n", "Average:", avg);
		System.out.printf("%-20s%.1f%n", "Median:", median);
		System.out.print("\n\n\n"); // print 3 blank lines
	}
	
	// This getInput method reads scores from the user until
	// the word quit is entered. Each input is converted to an
	// integer and stored in the scores array. It returns the
	// number of scores entered.
	public static int getInput(int[] scores)
	{
		Scanner input = new Scanner(System.in);
		boolean done = false;
		String userInput;
		System.out.print("\n\n\n"); // print 3 blank lines
		System.out.println("\t\tWelcome to GradeStats.java!\nA program which "
		+ "provides information based on scores.");
		System.out.println("");
		while (!done)
		{
			System.out.print("Type in the score. Type \"Quit\" to end the program --> ");
			userInput = input.nextLine();
			if (userInput.equalsIgnoreCase("quit"))
			{
				done = true;
			}
			else
			{
				scores[count] = Integer.parseInt(userInput);
				count++;
			}
		}
		return count;
	}
	
	// This printData method displays each student's score.
	// Numbers can be formatted for alignment if needed.
	public static void printData(int[] scores, int count)
	{
		System.out.println("\nHere is the data you entered:");
		for (int i = 0; i < count; i++)
		{
			System.out.printf("Student %d's score: %d\n", (i + 1), scores[i]);
		}
	}
	
	// This printBelow75 method identifies which students scored below 75%.
	// It counts the number of students below 75% and prints their student numbers.
	public static void printBelow75(int[] scores, int count)
	{
		int belowCount = 0;
		for (int i = 0; i < count; i++)
		{
			if (scores[i] < 75)
			{
				belowCount++;
			}
		}
		System.out.print("\nThere were " + belowCount + " students who scored below 75%: ");
		boolean first = true;
		for (int i = 0; i < count; i++)
		{
			if (scores[i] < 75)
			{
				if (!first)
				{
					System.out.print(", ");
				}
				System.out.print("student " + (i + 1));
				first = false;
			}
		}
		System.out.println(".\n");
	}
	
	// This findMin method scans the scores array
	// to find the minimum score. It compares each score
	// without using Math methods and returns the smallest.
	public static int findMin(int[] scores, int count)
	{
		int min = scores[0];
		for (int i = 1; i < count; i++)
		{
			if (scores[i] < min)
			{
				min = scores[i];
			}
		}
		return min;
	}
	
	// This findMax method scans the scores array to find the maximum score.
	// It uses Math.max() for comparisons and returns the largest score.
	public static int findMax(int[] scores, int count)
	{
		int max = scores[0];
		for (int i = 1; i < count; i++)
		{
			max = Math.max(max, scores[i]);
		}
		return max;
	}
	
	// This findAverage method calculates the average of all entered scores.
	// It sums all scores and divides by the count, returning a double.
	public static double findAverage(int[] scores, int count)
	{
		int sum = 0;
		double value = 0.0;
		for (int i = 0; i < count; i++)
		{
			sum += scores[i];
		}
		value = (double) sum / count;
		return value;
	}
	
	// This orderScores method sorts the scores array in ascending order.
	// It uses a simple nested loop to swap values as needed.
	// Sorting is necessary for correctly getting the median.
	public static void orderScores(int[] scores, int count)
	{
		int temp = 0;
		for (int i = 0; i < count - 1; i++)
		{
			for (int j = i + 1; j < count; j++)
			{
				if (scores[i] > scores[j])
				{
					temp = scores[i];
					scores[i] = scores[j];
					scores[j] = temp;
				}
			}
		}
	}
	
	// This findMedian method calculates the median score.
	// If the number of scores is odd, it returns the middle value.
	// If even, it returns the average of the two middle values.
	public static double findMedian(int[] scores, int count)
	{
		double value = 0.0;
		if (count % 2 == 1)
		{
			value = scores[count / 2];
			return value;
		}
		else
		{
			value = (scores[count / 2 - 1] + scores[count / 2]) / 2.0;
			return value;
		}
	}
}
