
class Card
{
   public enum Suit  { clubs, diamonds, hearts, spades };
   
   private char value;
   private Suit suit;
   boolean errorFlag;
   
   //default constructor. Sets card to ace of spades
   public Card()
   {
      this.set('A', Suit.spades);
   }
   
   //overloaded constructor. Takes in value and suit parameters
   public Card (char value, Suit suit)
   {
      this.set(value, suit);
   }
   
   //formats value and suit data members to a readable string format. If errorFlag is true the method returns "illegal" as the value.
   public String toString()
   {
      if (errorFlag)
      {
         return ("** illegal **");   
      }
      else
      {
         return (value + " of " + suit);
      }
   }
   
   //evaluates the parameters for validity and sets the errorFlag accordingly. data members are set regardless of input
   public boolean set(char value, Suit suit)
   {
      if (isValid(value, suit))
      {
         this.errorFlag = false;
      }
      else
      {
         this.errorFlag = true;
      }
      
      this.value = value;
      this.suit = suit;
      return true;
   }
   
   //returns the suit data member
   public Suit getSuit()
   {
      return suit;
   }
   
   //returns the value data member
   public char getValue()
   {
      return value;
   }
   
   //returns the error flag
   public boolean getErrorFlag()
   {
      return errorFlag;
   }
   
   //checks to see if another card is equal to this
   public boolean eqauls(Card card)
   {
      if ((card.getSuit() == this.suit) && (card.getValue() == this.value))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   //check the validity of an entry. Verifies the suit is in the enum then check if value is valid. returns true if both cases are met
   private boolean isValid(char value, Suit suit)
   {
      for (Suit type : Suit.values())
      {
         if (type == suit)
         {
            switch (value)
            {
            case 'A':
               return true;
            case '2':
               return true;
            case '3':
               return true;
            case '4':
               return true;
            case '5':
               return true;
            case '6':
               return true;
            case '7':
               return true;
            case '8':
               return true;
            case '9':
               return true;
            case 'T':
               return true;
            case 'J':
               return true;
            case 'Q':
               return true;
            case 'K':
               return true;
            }
         }
      }
      
      return false;
   }
   // Testing Card Class Here
   public static void main(String[] args) 
   {
      
      System.out.println("Card class test:");
      Card card1 = new Card();
      Card card2 = new Card('0', Card.Suit.clubs);
      Card card3 = new Card('K', Card.Suit.hearts);
      
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
      System.out.println("\n");
      
      card1.set('v', Card.Suit.diamonds);
      card2.set('T', Card.Suit.diamonds);
      
      System.out.println(card1.toString());
      System.out.println(card2.toString());
      System.out.println(card3.toString());
      System.out.println("\n");
   }
}