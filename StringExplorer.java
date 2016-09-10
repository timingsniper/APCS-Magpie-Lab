/**
 * ******The project was modified by Percy Jang******
 * A program to allow students to try out different 
 * String methods. 
 * @author Laurie White
 * @version April 2012
 */
public class StringExplorer
{

	public static void main(String[] args)
	{
		String sample = "The quick brown fox jumped over the lazy dog.";
		
		//  Demonstrate the indexOf method.
		int position = sample.indexOf("quick");
		System.out.println ("sample.indexOf(\"quick\") = " + position);
		
		//  Demonstrate the toLowerCase method.
		String lowerCase = sample.toLowerCase();
		System.out.println ("sample.toLowerCase() = " + lowerCase);
		System.out.println ("After toLowerCase(), sample = " + sample);
		
		//  Try other methods here:
		int notFoundPsn = sample.indexOf("slow");
		System.out.println("sample.indexOf(\"slow\") = " + notFoundPsn); //Instruction test
		
		//Testing indexOf method with two parameters: indexOf(String str, int fromIndex)
		String sample2 = "Never say no, no!!!"; //Sample string with two no s to test. First no is in position 10, the second one is in position 14.
		int answer = sample2.indexOf("no" , 13); // This statement will look for position of "no" after position 13.
		System.out.println("The position of \"no\" found after position 13 is: " + answer); //The answer should return 14.

	
	}

}
