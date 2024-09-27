import java.util.Scanner;

public class ChatBotRunner{
    public static void main(String[] args){
      ChatBot alan = new ChatBot();

      System.out.println(alan.getGreeting());
      Scanner input = new Scanner(System.in);
      String statement = input.nextLine();

      while(!statement.equals("Bye")){
        System.out.println(alan.getResponse(statement));
        statement = input.nextLine();
      }
    }
}
