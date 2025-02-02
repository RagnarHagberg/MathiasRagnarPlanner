import javax.swing.*;
import java.awt.*;

public class TextCard extends Card{
/*
Adds the different elements to a text card and incorporates the values from TextCreatorDialog
 */

    public TextCard(TextCardData cardData){

        super(cardData);
        //Title is put into a label to be displayed
        titleLabel = new JLabel(this.title);
        //.setBorder creates a black border around the label
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        //description is put into a JTextArea to handle line wrapping
        descriptionArea = new JTextArea(this.description);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setOpaque(false); //makes area transparent
        descriptionArea.setEditable(false); //prevents user from editing
        descriptionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));

        //hoursToComplete is put into a label
        hoursToCompleteLabel = new JLabel(this.hoursToComplete);
        hoursToCompleteLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        //adds components with gridBag constraints to style cards with given constraints in Card class
        add(titleLabel, gridBagConstraints);
        add(descriptionArea, gridBagConstraints);
        add(hoursToCompleteLabel, gridBagConstraints);
    }

}
