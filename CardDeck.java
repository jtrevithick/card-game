/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trevithickmastersjarizmendyp7;

import java.util.Random;

public class CardDeck {
    /*A ton of declarations*/
    Card cardArray[];
    Card card = new Card();
    boolean cardDealt[];
    Random rand = new Random();
    int index;
    int counter;
    Card lastCardReturned;
    
    CardDeck() {
        cardArray = new Card[52];
        fillCardArray();
        /*boolean arrays are initially set to false*/
        cardDealt = new boolean[52];
    }
    
    public Card getNextCard() {
        if(counter == 53) return lastCardReturned;
        while(true) {
            getRandomNumber();
            if(cardDealt[index] == false) {
                cardDealt[index] = true;
                counter++;
                break;
            }
        }
        lastCardReturned = cardArray[index];
        return cardArray[index];
    }
    
    public int getRandomNumber() {
        return index = rand.nextInt(50) + 1;
    }
    
    public void fillCardArray(){
        String[] currentSuit = {"spades", "hearts", "diamonds", "clubs"};
        int suitCounter = -1;
        for(int i = 0; i < cardArray.length; i++) {
            cardArray[i] = new Card();
            /*rank*/
            if((i % 13) == 0) {
                suitCounter++;
                cardArray[i].setRank(14);
            } else {
                cardArray[i].setRank(i);
            }
            cardArray[i].setSuit(currentSuit[suitCounter]);
            cardArray[i].setImageName(String.format(i+".png"));
        }
    }
        
}
