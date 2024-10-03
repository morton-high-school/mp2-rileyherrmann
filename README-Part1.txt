In this MP you will be working with and adding functionality to a chat bot. When
done correctly, chat bots can engage a user with conversation that is dependent
on their responses.

Task 1
Functionality for the chat bot is stored within ChatBot.java. ChatBotRunner.java
contains code that will allow the use to interact with the chat bot. Run
ChatBotRunner.java and have a conversation.

How does the chat bot respond to the following phrases:

My mother and I talked last night.
Answer:Tell me more about your family.

I said no!
Answer: Why so negative?

The weather is nice.
Answer: Interesting, tell me more.

Do you know my brother?
Answer:Why so negative?

Done

Task 2
Take a look at the code inside ChatBot.java. Notice how the if statements select
a response to return. Take a look at the getRandomResponse() method and note how
it functions.

Done

Task 3
Edit the code to have the chatbot respond "Tell me more about your pets" when
the statement contains the word "dog" or "cat".

Done

Task 4
Edit the code to have the chatbot to respond favorably when the name of your
teacher is used.

Done

Task 5
Check that the statement has at least one character. You can use the trim()
method to remove white space from the beginning and end and then check the new
string's length. If there are no characters, the chatbot should prompt the user
to enter something.

Done

Task 6
Add two more noncommittal responses to the possible random responses.

Done

Task 7
Pick three more keywords, such as "no" and "brother" and edit the getResponse()
method to respond to each of these.

Done

Question 1
What are some unintended issues that can occur with the chatbot?

If the first letter of the word is not capitalized, then it won't register. It also will choose 
the response that comes first in the If statement, for example, if you said no, my mother is, it will 
respond to the no. If mother is not, is said, then it will still respond to the no first.
If no is a part of a different word, such as know or another, it will take that response in as just the word
"no." Also, if the word that the code is checking for is the first word, then it wouldn't register since
it wasn't checking for the index of 0.

Done

