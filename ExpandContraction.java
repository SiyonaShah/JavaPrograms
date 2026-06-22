/* Siyona Shah
* 6/22/2026
* ExpandContraction.java
* Working on: Expands contractions into full two worded forms. Exceptions include
* don't, can't, won't, shant. Other n't contractions are expanded by adding "not".
*/

import java.util.Scanner;

public class ExpandContraction
{
	private String contracted; // User input contraction as a String
	private String expanded;   // Expanded version as a String
	private Scanner kb;        // Scanner used for input
	
	// Constructor which initializes all the values.
	public ExpandContraction()
	{
		contracted = "";
		expanded = "";
		kb = new Scanner(System.in);
	}

	// Main method which calls the expandIt method after making an instance. 
	public static void main(String[] args)
	{
		ExpandContraction ec = new ExpandContraction();
		ec.expandIt();
	}

	// This method called expandIt will maket he program continue to loop to
	// repeatedly expand the contractions provided until the user types quit. 
	// It can be in any form of upper or lower case.
	public void expandIt()
	{
		String response = "";
		System.out.println("\n\n\n"); // print 3 blank lines
		do
		{
			getInput();
			processString();
			printResult();
			System.out.println("Would you like to expand another contraction? "
				+ "Type quit to stop");
			response = kb.nextLine();
			System.out.println("");
			} while (!response.equalsIgnoreCase("quit"));
		System.out.println("\n\n\n"); // print 3 blank lines
	}

	// Prompt user for contraction
	public void getInput()
	{
		System.out.println("What contraction would you like to expand?");
		contracted = kb.nextLine();
	}

	// This method called processString will make the contraction into the exact
	// expanded form. It has 4 exceptions which are noted in the method. Otherwise 
	// if it ends with n't, the program will add a not in the expanded version instead.
	public void processString()
	{
		if (contracted.equalsIgnoreCase("don't"))
		{
			expanded = "do not";
		}
		else if (contracted.equalsIgnoreCase("can't"))
		{
			expanded = "can not";
		}
		else if (contracted.equalsIgnoreCase("won't"))
		{
			expanded = "will not";
		}
		else if (contracted.equalsIgnoreCase("shant"))
		{
			expanded = "shall not";
		}
		else if (contracted.endsWith("n't"))
		{
			expanded = contracted.substring(0, contracted.length() - 3) + " not";
		}
		else
		{
			expanded = "this is not a valid contraction";
		}
	}

	// This method called printResult will print either the expanded form or 
	// an invalid message.
	public void printResult()
	{
		if (expanded.equals("this is not a valid contraction"))
		{
			System.out.println(contracted + " is not a valid contraction.\n");
		}
		else
		{
			System.out.println("The expanded form of " + contracted + " is "
				+ expanded + ".\n");
		}
	}
}
