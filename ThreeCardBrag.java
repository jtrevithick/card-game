/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trevithickmastersjarizmendyp7;

/**
 *
 * @author Family PC
 */
public class ThreeCardBrag{
    private final CardDeck cardD = new CardDeck(); 
    private Card[] hand1 = new Card[3];
    private Card[] hand2 = new Card[3];
    
    public int winner;

   public ThreeCardBrag(){
       
   }
   
   public void setPlayerHads(Card hand1[],Card hand2[]){
       
       this.hand1 = hand1;       
       this.hand2 = hand2;
       
       whoWon();
   }
   
   //finished the whoWon method (jt)
   
     private void whoWon() {
        int rank1 = getHandRank(hand1);
        int rank2 = getHandRank(hand2);
       
        if(rank1 > 0 && rank1 == rank2){
            winner=3;
        }
      
        else if (rank1 < rank2){
            winner=2;
        }
        else if(rank1 > rank2) {
            winner=1;
        }
   
        else{
            winner=0;
        }
 
    }
    //created a gethand method to code the whoWon method easier (jt)
    private int getHandRank(Card hand[]) {
        int threes = 0;
        //check for ace
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getRank() == 1) return 3;
        }
        
        //check for three threes
        for (int i = 0; i < hand.length; i++) {
            if (hand[i].getRank() == 3) {
                threes++;
            }
            if (threes == 3) return 3;
        }
        
        //Check for two or three of a kind
        for (int i =0; i < hand.length; i++){
            Card card= hand[i];
            
            for (int k=i+1; k < hand.length; k++){
                if (card.rank==hand[k].rank)return 2;
            
            }
        }
        
        //check king queen jack
        for (int j=0; j< hand.length; j++){
            if (hand[j].getRank() == 11 || hand[j].getRank() == 12 || hand[j].getRank() == 13){ return 1;}
                    
        }
        
    
      
        //check for 3 3's
        //return rank 3
        
        //check for 2 or 3 of kind
        //return rank 2
        
        //check for king, queen or jack
        //return rank 1
        
      // else{ 
        return 0;
    }
   
   public int getWinningHand(){      
       
       return winner;
   }
   
   public String getRules(){
       
       String rules = "Each players recive 3 card. " + 
               "Both hands are discarded each time a new had is dealt. " +
               "Game continues until there is no more cards in the deck. " +
               "";
       return rules; 
   }
}
