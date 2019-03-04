//James Trevithick              jtrevithick2@cnm.edu        TrevithickMastersJarizmendyP7
//FXMLDocumentController.java

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trevithickmastersjarizmendyp7;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author james
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextArea taheader;
    @FXML
    private TextField tfplayer1;
    @FXML
    private TextField tfplayer2;

    @FXML
    private Button bcards;

    @FXML
    private Button bwinner;

    @FXML
    private ImageView imgPlayer1Card1, imgPlayer1Card2, imgPlayer1Card3,  imgPlayer2Card1, imgPlayer2Card2, 
        imgPlayer2Card3;
    
    CardDeck cardDeck = new CardDeck();
    ThreeCardBrag tCardBrag = new ThreeCardBrag();
    Card p1[] = new Card[3];
    Card p2[] = new Card[3];
    
    private String pName1;
    private String pName2;
    
    
    private int counter = 0;

  //cards button handler
    @FXML
    private void handleDealButtonAction(ActionEvent event)
    {
        if(counter<8){
        
        pName1 = tfplayer1.getText();
        pName2 = tfplayer2.getText();
        
        dealTheCards();
        
        imgPlayer1Card1.setImage(new Image(getClass().getResource("images/"+ p1[0].getImageName()).toString()));
        imgPlayer1Card2.setImage(new Image(getClass().getResource("images/"+ p1[1].getImageName()).toString()));
        imgPlayer1Card3.setImage(new Image(getClass().getResource("images/"+ p1[2].getImageName()).toString()));
        imgPlayer2Card1.setImage(new Image(getClass().getResource("images/"+ p2[0].getImageName()).toString()));
        imgPlayer2Card2.setImage(new Image(getClass().getResource("images/"+ p2[1].getImageName()).toString()));
        imgPlayer2Card3.setImage(new Image(getClass().getResource("images/"+ p2[2].getImageName()).toString()));
        counter ++;
        
        //tfplayer1.setText(pName1);
        //tfplayer2.setText(pName2);

        }
        
        else{
              
            
            bcards.setDisable(true);
            bwinner.setDisable(true);
        }
       
        

    }
    
    //winner button handler
    @FXML
    private void handleWinnerAction(ActionEvent event)
    {
       determineWinner();
    }
    
    private void dealTheCards(){
        
        for(int i = 0; i < 3; ++i){
            p1[i] = cardDeck.getNextCard();
        }
        
        for(int j = 0; j < 3; ++j){
            p2[j] = cardDeck.getNextCard();
        }
        
    }
    
    private void determineWinner(){
        
        tCardBrag.setPlayerHads(p1, p2);
        
        tCardBrag.winner = tCardBrag.getWinningHand();
         switch(tCardBrag.winner){
            case 0:
                tfplayer1.clear();
                tfplayer2.clear();
                tfplayer1.setText((pName1+ " Draw"));
                tfplayer2.setText((pName2+ " Draw"));
                break;
            case 1:
                tfplayer1.clear();
                tfplayer2.clear();
                tfplayer2.setText(pName2);
                tfplayer1.setText((""+pName1+" Winner!"));
               
               break;
            case 2:
                tfplayer1.clear();
                tfplayer2.clear();
                tfplayer1.setText(pName1);
                tfplayer2.setText((""+pName2+" Winner!")); 
                break;
        
        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        // TODO C:\Users\james\Desktop\TrevithickMastersJarizmendyP7\
        
    }    
    
}
