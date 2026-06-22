// Siyona Shah
// Date: 6/22/2026
// UnitConverter.java
// Working on: Converting units and calling methods and D & I variables. 
/* This program accepts the number of inches in integers from a user then prints
* the equivalent amount of feet, yards, and centimeters in decimals to
* 2 decimal places. 
*
* Pseudocode
* class header
* main header
*  D & I constant for inches
*  inches = call getUserInput()
*  feet = call inchesToFeet(send in parameter inches)
*  yards = call inchesToYards(send in parameter inches)
*  centimeters = call inchesTocentimeters(send in parameter inches)  
*  call print(send in parameter feet, yards, centimeters)
* getUserInput()
*  prompt user for inches
*  read input
*  return inches
* inchesToFeet(receive parameter inches)
*  D & I feet
*  feet = inches/12
*  return feet
* inchesToYards(receive parameter inches)
*  D & I yards
*  yards = inches/36
*  return yards
* inchesToCentimeters(receive parameter inches)
*  D & I centimeters
*  centimeters = inches*2.54
*  return centimeters
* Print(receive parameter ft, yd, cm)
*  print inchesToFeet()
*  print inchesToYards()
*  print inchesTocentimeters()
*/

import java.util.Scanner;
	
public class UnitConverter
{
	public static void main(String[] args)
	{
		int inches = 0;
		double feet = 0.0;
		double yards = 0.0;
		double centimeters = 0.0;
		inches = getUserInput();
		feet = inchesToFeet(inches);
		yards = inchesToYards(inches);
		centimeters = inchesToCentimeters(inches);
		print(feet, yards, centimeters);
	}
	
	public static int getUserInput()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of inches: ");
		int inches = sc.nextInt();
		return inches;
	}
	
	public static double inchesToFeet(int inches)
	{
		double ft2 = 0.0;
		ft2 = inches/12.0;
		return ft2;
	}
	
	public static double inchesToYards(int inches)
	{
		double yd2 = 0.0;
		yd2 = inches/36.0;
		return yd2;
	}
	
	public static double inchesToCentimeters(int inches)
	{
		double cm2 = 0.0;
		cm2 = inches*2.54;
		return cm2;
	}
	
	public static void print(double ft, double yd, double cm)
	{
		System.out.printf("Feet: %.2f%n", ft);
		System.out.printf("Yards: %.2f%n", yd);
		System.out.printf("Centimeters: %.2f%n", cm);
	}
}
