// Siyona Shah
// 6/23/2026
// GrowthPattern.java
/* This program displays a vertical histogram showing a plant’s height over time.
* It uses an array to store height data, compares values to show growth changes,
* and calculates the plant’s average rate of growth.
* Working on: Arrays, methods, formatting
*/
public class GrowthPattern
{
	// This is my field variable, an array called height which contains all the 
	// height values.
	private int[] height = {-1, -3, 1, 2, 3, 4, 3, 4, 4, 6, 8, 6, 6, 7, 10, 12};
	
	// Main method which calls growIt by making an instance.
	public static void main(String[] args)
	{
		GrowthPattern gp = new GrowthPattern();
		gp.growIt();
	}
	
	// This growIt method manages the plant growth histogram by comparing each
	// height to the previous one to decide whether to display +, -, or o, and
	// formats each line so the correct number of symbols appear. It also calls 
	// printRate() and prints the welcome statement.
	public void growIt()
	{
		char symbol;
		symbol = 'o';
		System.out.println("\n\n\n"); // prints three blank lines
		System.out.print("\t\tWelcome to GrowthPattern.java!\nThis program displays"
			+ " a vertical histogram showing a plant's height over time.\n");
		System.out.println();
		printSymbols(0, symbol, height[0]);
		for (int time = 1; time < height.length; time++)
		{
			symbol = decideSymbols(height[time], height[time - 1]);
			printSymbols(time, symbol, height[time]);
		}
		printRate();
	}
	
	// The decideSymbols method compares the current height of the plant with
	// the previous height and returns a symbol: '+' if the plant has grown, '-'
	// if it has decreased, or 'o' if there is no change.
	public char decideSymbols(int currentHeight, int previousHeight)
	{
		if (currentHeight > previousHeight)
		{
			return '+';
		}
		else if (currentHeight < previousHeight)
		{
			return '-';
		}
		else
		{
			return 'o';
		}
	}
	
	// This printSymbols method shows the time and prints the right number of
	// symbols for the plant’s height so each row of the histogram looks correct
	// and easy to read. It takes in the time, symbol, and value.
	public void printSymbols(int time, char symbol, int value)
	{
		int baseOffset;
		int numberOfSymbols;
		
		baseOffset = 5;
		numberOfSymbols = baseOffset + value;
		System.out.printf("t%-4d", time);
		for (int i = 0; i < numberOfSymbols; i++)
		{
			System.out.print(symbol);
		}
		System.out.println();
	}
	
	// This printRate method figures out how much the plant grew overall by 
	// subtracting the first height from the last height, then divides that
	// growth by the total time to find the average growth per time unit, and 
	// prints the result so it clearly shows how fast the plant grew during the 
	// whole experiment.
	public void printRate()
	{
		int startingHeight;
		int endingHeight;
		double changeInHeight;
		double totalTime;
		double rateOfGrowth;
		
		startingHeight = height[0];
		endingHeight = height[height.length - 1];
		changeInHeight = endingHeight - startingHeight;
		totalTime = height.length - 1;
		rateOfGrowth = changeInHeight / totalTime;
		
		System.out.println();
		System.out.printf("Rate of growth: %.2f mm per unit of time%n", rateOfGrowth);
		System.out.println("\n\n\n"); // prints three blank lines
	}
}
