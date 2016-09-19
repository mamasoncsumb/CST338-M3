public class Main {

   public static void main(String[] args) 
   {
      //Create input object
      Scanner keyboard = new Scanner(System.in);
      
      //Ask user for number of players
      System.out.println("Enter the number of hands (1-10, Please): ");
      int numHands = keyboard.nextInt();
      
      while((numHands < 1) || (numHands > 11))
      {
         System.out.println("Enter a valid number of hands (1-10, Please): ");
         numHands = keyboard.nextInt();
      }
      
      //Instantiate pack of cards
      Deck deck = new Deck(1);
      
      //Create array to hold all player hands
      Hand[] players = new Hand[numHands];
            
      for (int i = 0; i < players.length; i++)
      {
         players[i] = new Hand();
      }
     
      //Deal cards to players
      while(deck.getTopCard() != null)
      {
         for (int i = 0; i < players.length; i++)
         {
            players[i].takeCard(deck.dealCard());
            
            if(deck.getTopCard() == null)
            {
               break;
            }
         }
      }
      
      //Display all hands
      for (int i = 0; i < players.length; i++)
      {
         System.out.println("Hand " + (i + 1) + ": " + players[i].toString());
      }
           
      System.out.println('\n');
      System.out.println("Here are our hands, from SHUFFLED deck:");
            
      //Reset and shuffle deck
      deck.init(1);
      deck.shuffle();
      
      //Reset hands
      for (int i = 0; i < players.length; i++)
      {
         players[i].resetHand();
      }
      
      //Deal again
      while(deck.getTopCard() != null)
      {
         for (int i = 0; i < players.length; i++)
         {
            players[i].takeCard(deck.dealCard());
            
            if(deck.getTopCard() == null)
            {
               break;
            }
         }
      }
      
      //Display all hands
      for (int i = 0; i < players.length; i++)
      {
         System.out.println("Hand " + (i + 1) + ": " + players[i].toString());
      }
      
      //Close keyboard object
      keyboard.close();
   }

}
   
