public class ChatBot{

  /*
  * Get a default greeting
  * @return a greeting
  */
  public String getGreeting(){
    return "Hello, let's talk.";
  }

  /*
  * Gives a response to a user statement
  * @param statement
  * @return a response based on the rules given
  */
  public String getResponse(String statement){
    String response = "";
    statement = statement.trim();
    if(findKeyword(statement, "no", 0)>=0){
      response = "Why so negative?";
    }else if(findKeyword(statement, "mother", 0)>=0 || findKeyword(statement, "father", 0)>=0 || findKeyword(statement, "sister", 0)>=0 || findKeyword(statement, "brother", 0)>=0 ){
      response = "Tell me more about your family.";
    }else if(findKeyword(statement, "cat", 0)>=0 || findKeyword(statement, "dog", 0)>=0){
      response = "Tell me more about your pets";
    }else if(findKeyword(statement, "zeller", 0)>=0){
      response = "He is a great teacher.";
    }else if(statement.length() == 0){
      response = "Please enter something.";
    } else if(findKeyword(statement, "class", 0)>=0){
      response = "What is your favorite class?";
    }else if(findKeyword(statement, "food", 0)>=0){
      response = "Describe to me your favorite food.";
    }else if(findKeyword(statement, "work", 0)>=0){
      response = "Where do your work?";
    }else if(findKeyword(statement, "I want to", 0)>=0){
      response = (transformIWantToStatement(statement));
      System.out.println("I want to");
    }else if(findKeyword(statement, "you", 0)>=0 && findKeyword(statement, "me", 0)>=0 && statement.toLowerCase().indexOf("you")<statement.toLowerCase().indexOf("me")){
      response = (transformYouMeStatement(statement));
    }else if(findKeyword(statement, "I want", 0)>=0){
     response = transformIWantStatement((statement));
    }else if(findKeyword(statement, "i", 0)>=0 && findKeyword(statement, "you", 0)>=0 && statement.toLowerCase().indexOf("i")<statement.toLowerCase().indexOf("you")){
      response = transformIYouStatement((statement));
    }else{
       response = getRandomResponse();
       }
       return response;
  }

 //public String getResponse(String statement){
   // String response = "";
    //statement = statement.trim();
//    if(statement.indexOf("no")>=0){
  //    response = "Why so negative?";
    //}else if(statement.indexOf("mother")>=0 ||  statement.indexOf("father")>=0 || statement.indexOf("sister")>=0 || statement.indexOf("brother")>0){
//      response = "Tell me more about your family.";
  //  }else if(statement.indexOf("cat")>=0 || statement.indexOf("dog")>=0){
    //  response = "Tell me more about your pets";
//    }else if(statement.indexOf("zeller")>=0 || statement.indexOf("Zeller")>=0){
  //    response = "He is a great teacher.";
    //}else if(statement.length() == 0){
      //response = "Please enter something.";
    //} else if(statement.indexOf("school")>=0){
      //response = "What is your favorite class?";
    //}else if(statement.indexOf("food")>=0){
      //response = "Describe to me your favorite food.";
    //}else if(statement.indexOf("work")>=0){
      //response = "Where do your work?";
    //}else{
      //response = getRandomResponse();
    //}
    //return response;
  //}
  /*
  * Pick a default response to use if nothing else fits.
  * @return a non-commital string
  */
  private String getRandomResponse(){
    int numberOfResponses = 6;
    double r = Math.random();
    int whichResponse = (int)(r*numberOfResponses);
    String response = "";

    if(whichResponse==0){
      response = "Interesting, tell me more.";
    }else if(whichResponse==1){
      response = "Hmmm.";
    }else if(whichResponse==2){
      response = "Do you really think so?";
    }else if(whichResponse==3){
      response = "You don't say.";
    }else if(whichResponse==4){
      response = "Oh wow.";
    }else if(whichResponse==5){
      response = "I didn't know that.";
    }
    return response;
  }
//uses Math.random to generate a number which will then point towards which response to return using the if statement

  /*
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
  private int findKeyword(String statement, String goal, int startPos){
    String phrase = statement.trim().toLowerCase();
    goal = goal.toLowerCase();

    int psn = phrase.indexOf(goal, startPos);

    while(psn>=0){
      String before = " ";
      String after = " ";
      if(psn>0){
        before = phrase.substring(psn-1, psn);
      }
      if(psn+goal.length()<phrase.length()){
        after = phrase.substring(psn+goal.length(), psn+goal.length()+1);
      }
      if(((before.compareTo("a")<0) || (before.compareTo("z")>0)) && ((after.compareTo("a")<0) || (after.compareTo("z")>0))){
        return psn;
      }

      psn = phrase.indexOf(goal, psn+1);
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
	private int findKeyword(String statement, String goal){
		return findKeyword(statement, goal, 0);
	}

  /*
	 * Take a statement with "I want to <something>." and transform it into
	 * "What would it mean to <something>?"
	 * @param statement the user statement, assumed to contain "I want to"
	 * @return the transformed statement
	 */
	private String transformIWantToStatement(String statement){
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")){
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "I want to", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "What would it mean to " + restOfStatement + "?";
	}

  /*
	 * Take a statement with "you <something> me" and transform it into
	 * "What makes you think that I <something> you?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement){
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")){
			statement = statement.substring(0, statement.length() - 1);
		}

		int psnOfYou = findKeyword (statement, "you", 0);
		int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);

		String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
		return "What makes you think that I " + restOfStatement + " you?";
	}
  

	private String transformIWantStatement(String statement){
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")){
			statement = statement.substring(0, statement.length() - 1);
		}
		int psn = findKeyword(statement, "I want ", 0);
		String restOfStatement = statement.substring(psn + 7).trim();
		return "Would you be really happy if you had " + restOfStatement + "?";
	}

private String transformIYouStatement(String statement){
		statement = statement.trim();
		String lastChar = statement.substring(statement.length() - 1);
		if (lastChar.equals(".")){
			statement = statement.substring(0, statement.length() - 1);
		}

		int psnOfYou = findKeyword (statement, "i", 0);
		int psnOfMe = findKeyword (statement, "you", psnOfYou + 1);

		String restOfStatement = statement.substring(psnOfYou + 1, psnOfMe).trim();
		return "What do you " + restOfStatement + " me?";
	}

}

