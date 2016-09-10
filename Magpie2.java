/**
 * ******The project was modified by Percy Jang******
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{   
		String response = "";
		/*
		 * This statement is to check if the input is empty- if it is empty, the statement
		 * "Say something, please." is returned.
		 */
		if(statement.trim().length() == 0){
			response = "Say something, please.";
		}
		
		else if (findKeyword(statement, "no") >= 0)  //findKeyword method now used to find keywords(as instructed in activity 3)
		{
			response = "Why so negative?";
		}
		
		else if (findKeyword(statement, "mother") >= 0
				|| findKeyword(statement, "father") >= 0
				|| findKeyword(statement, "sister") >= 0
				|| findKeyword(statement, "brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
		
		/*
		 * Any input with the word "dog" or "cat" will result in response
		 * "Tell me more about your pets."
		 */
		else if(findKeyword(statement, "dog")>=0 || findKeyword(statement,"cat")>=0) //Check if input contains word "dog" or "cat"
		{
			response = "Tell me more about your pets.";
		}
		/*
		 * Any input with Ms.Yang's name will result in Magpie freaking out with exclamation:
		 * "OH MY GOD SHE IS SO AWESOME I LOVE HER SOOOO MUCH"
		 */
		else if(findKeyword(statement,"Ms.Yang")>=0){
			response = "OH MY GOD SHE IS SO AWESOME I LOVE HER SOOOO MUCH";
		}
		
		/*
		 * New 3 Keywords: "GPA", "java", "hair"
		 * Input with word GPA will return "WHOOOA JESUS DON'T YOU EVER ASK THAT QUESTION AGAIN"
		 * Input with word java will return "You mean that super weird language that can't even tell between capital and small letters?";
		 * Input with word hair will return "DUANG."
		 */
		else if(findKeyword(statement,"GPA")>=0){ //Check word "GPA"
			response = "WHOOOA JESUS DON'T YOU EVER ASK THAT QUESTION AGAIN";
		}
		
		else if(findKeyword(statement,"java")>=0){ //Check word "java"
			response = "You mean that super weird language that can't even tell between capital and small letters?";
		}
		else if(findKeyword(statement,"hair")>=0){ //Check word "hair"
			response = "DUANG.";
		}
		else
		{
			response = getRandomResponse();
		}
		
		return response;  //Appropriate response returned
	}
	
	//findKeyWord method from activity 3 added
	
	
	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no").
	 *
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @param startPos
	 *            the character of the string to begin the
	 *            search at
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal,
			int startPos)
	{
		String phrase = statement.trim().toLowerCase();
		goal = goal.toLowerCase();

		// The only change to incorporate the startPos is in
		// the line below
		int psn = phrase.indexOf(goal, startPos);

		// Refinement--make sure the goal isn't part of a
		// word
		while (psn >= 0)
		{
			// Find the string of length 1 before and after
			// the word
			String before = " ", after = " ";
			if (psn > 0)
			{
				before = phrase.substring(psn - 1, psn);
			}
			if (psn + goal.length() < phrase.length())
			{
				after = phrase.substring(
						psn + goal.length(),
						psn + goal.length() + 1);
			}

			// If before and after aren't letters, we've
			// found the word
			if (((before.compareTo("a") < 0) || (before
					.compareTo("z") > 0)) // before is not a
											// letter
					&& ((after.compareTo("a") < 0) || (after
							.compareTo("z") > 0)))
			{
				return psn;
			}

			// The last position didn't work, so let's find
			// the next, if there is one.
			psn = phrase.indexOf(goal, psn + 1);

		}

		return -1;
	}

	/**
	 * Search for one word in phrase. The search is not case
	 * sensitive. This method will check that the given goal
	 * is not a substring of a longer string (so, for
	 * example, "I know" does not contain "no"). The search
	 * begins at the beginning of the string.
	 * 
	 * @param statement
	 *            the string to search
	 * @param goal
	 *            the string to search for
	 * @return the index of the first occurrence of goal in
	 *         statement or -1 if it's not found
	 */
	private int findKeyword(String statement, String goal)
	{
		return findKeyword(statement, goal, 0);
	}
	
	
	
	
	

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6; //4 originally since 3 random responses existed- 6 now since I added 2 more random possible responses
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4){ //First random statement added
			response = "Percy is so awesome.";
		}
		
		else if (whichResponse == 5){ //Second random statement added
			response = "This is life.";
		}

		return response; //Appropriate response returned.(Actually randomly.)
		
		/*
		 * Question: What happens when a keyword is included in another word? 
		 * Consider statements like “I know all the state capitals” and “I like vegetables smothered in cheese.” 
		 * Explain the problem with the responses to these statements.
		 * 
		 * Answer: Although he user did not intend to say anything negative by saying "no", but indexOf statement in getResponse method
		 *         will see that the word "no" is included in the first statement, "I know all the state capitals” and return
		 *         "Why so negative?". For the second statement “I like vegetables smothered in cheese.” , the indexOf statement will
		 *         detect the word "mother" and return "Tell me more about your family.", while the user did not intend to talk about
		 *         its family.(but instead the cheese)
		 */
	}
}
