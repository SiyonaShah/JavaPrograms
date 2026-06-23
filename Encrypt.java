/* Siyona Shah
* 6/23/2026
* Encrypt.java
* This program will encrypt messages using a simple method.
* It will accept input from the user, process the text using String methods,
* and display the encrypted version. The program may include loops to handle
* multiple inputs from the user until they choose to quit.
* Working on: Getting user input, declare constants, shift letters
*/

import java.util.Scanner;

public class Encrypt
{
	// This is a final int, its value is 2 and its name is constant.
	private static final int CONSTANT = 2;
	// This is a declared field variable, a string named as line.
	private static String line;

	// Make an instance of the class and call the method named as rotate13times.
	public static void main(String[] args)
	{
		Encrypt enc = new Encrypt();
		enc.rotate13Times();
	}

	// The method called getString() retrieves the user input and prints the 
	// welcome statement. It informs the user how their input must be a word,
	// phrase, or sentence. It starts by creating a scanner called input and
	// prints three blank lines at the start of the computer.
	public static void getString()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n\n"); // 3 blank lines at start of program
		System.out.println("Welcome to Encrypt.java. Please enter a word, phrase, or");
		System.out.println("sentence.");
		System.out.print("-> ");
		line = input.nextLine();
	}

	// Encrypts the string by shifting letters 2 positions
	public static void encryptString()
	{
		String encryptedLine = "";
		for (int i = 0; i < line.length(); i++)
		{
			char character = line.charAt(i);
			if (character >= 'A' && character <= 'Z')
			{
				char newChar = (char) (character + CONSTANT);
				if (newChar > 'Z') {
					newChar = (char) (newChar - 26);
				}
				encryptedLine += newChar;
			}
			else if (character >= 'a' && character <= 'z')
			{
				char newChar = (char) (character + CONSTANT);
				if (newChar > 'z')
				{
					newChar = (char) (newChar - 26);
				}
				encryptedLine += newChar;
			}
			else
			{
				encryptedLine += character;
			}
		}
		line = encryptedLine;
	}
	
	// Prints the encrypted string
	public static void printString(int encryptionNumber)
	{
		System.out.println("\nEncryption " + encryptionNumber + ":");
		System.out.println(line);
	}
	
	// Controls the 13 encryptions
	public static void rotate13Times()
	{
		getString();
		for (int i = 1; i <= 13; i++)
		{
			encryptString();
			printString(i);
		}
		// 3 blank lines at end of program
		System.out.println("\n\n\n");
	}
}
