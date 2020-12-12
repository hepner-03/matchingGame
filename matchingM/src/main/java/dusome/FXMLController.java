package dusome;

/* Matching.java
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    private Label lblOut;

    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private ImageView img8;
    @FXML
    private ImageView img9;
    @FXML
    private ImageView img10;
    @FXML
    private ImageView img11;
    @FXML
    private ImageView img12;
    @FXML
    private ImageView img13;
    @FXML
    private ImageView img14;
    @FXML
    private ImageView img15;
    @FXML
    private ImageView img16;

    //Global Arrays we can use. One of numbers, the other of JLabel types
    ArrayList<Integer> imageList = new <Integer>ArrayList();
    ArrayList<ImageView> cards = new <ImageView>ArrayList();
    int firstCard = 20; //Variable to hold the first card, start it at a number you know it can't be
    int secondCard = 20; //Variable to hold the second card, start it at a number that you know it can't be
    int pairsLeft = 8; //How many pairs we still have to clear

   public void image1(MouseEvent event){
       putCard(0);
   }


    public void putCard(int cardNum) {
    //Check to see if the card has already been used or they clicked on the same one again. If so stop the code
        if (cards.get(cardNum).isDisable() || firstCard == cardNum) {
            return;
        }

        //Checks to see if two cards are showing, if they are flip them
        if (firstCard != 20 && secondCard != 20) {
        //clear the image
            cards.get(firstCard).setImage(null);
            cards.get(secondCard).setImage(null);
        //resets the cards
            firstCard = 20;
            secondCard = 20;
        }

        //Checks to see if this is the first card they pushed
        if (firstCard == 20 && secondCard == 20) {
            firstCard = cardNum;
        //Load the image
            cards.get(cardNum).setImage(new Image(getClass().getResource("/"+imageList.get(cardNum) +".jpg").toString()));
        }
        //Checks to see if this is the second card they pushed
        else if (firstCard != 20) {
            secondCard = cardNum;
            cards.get(cardNum).setImage(new Image(getClass().getResource("/"+imageList.get(cardNum) +".jpg").toString()));

        //Check to see if the cards match
            if (imageList.get(firstCard).equals(imageList.get(secondCard))) {
        //Turn the labels off
                cards.get(firstCard).setDisable(true);
                cards.get(secondCard).setDisable(true);
        //Reset the card hold variable
                firstCard = 20;
                secondCard = 20;
        //One less pair to find
                pairsLeft--;
            }
        }
        //Check to see if you won
        if (pairsLeft == 0) {
           // JOptionPane.showMessageDialog(rootPane, "You WON!");
        }

    }


    @FXML
    void btnResetAction(ActionEvent event) {
        Collections.shuffle(imageList);
        //Reset the cards
        for (int i = 0; i < 16; i++) {
            cards.get(i).setDisable(false);
            cards.get(i).setImage(null);
        }
        //we have to find all 8 sets again
        pairsLeft = 8;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Put the image panels into the array
        cards.add(img1);
        cards.add(img2);
        cards.add(img3);
        cards.add(img4);
        cards.add(img5);
        cards.add(img6);
        cards.add(img7);
        cards.add(img8);
        cards.add(img9);
        cards.add(img10);
        cards.add(img11);
        cards.add(img12);
        cards.add(img13);
        cards.add(img14);
        cards.add(img15);
        cards.add(img16);

        //Add two of each of the possible cards to an array
        for (int i = 0; i < 8; i++) {
            imageList.add(i);
            imageList.add(i);
        }
        //This randomly sorts the array to move the images around
        Collections.shuffle(imageList);

    }
}
