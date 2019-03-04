/*
 * Sarah Masters
 * version 1 of Card class
 */
package trevithickmastersjarizmendyp7;

public class Card {
    String ImageName;
    String suit;
    int rank;
    
    Card() {
        ImageName = "";
        suit = "";
        rank = 0;
    }
    
    /*setters*/
    public void setImageName(String im) {
        ImageName = im;
    }
    
    public void setRank(int r) {
        rank = r;
    }
    
    public void setSuit(String s) {
        suit = s;
    }
    
    /*getters*/
    public String getImageName() {
        return ImageName;
    }
    
    public int getRank() {
        return rank;
    }
    
    public String getSuit() {
        return suit;
    }
}