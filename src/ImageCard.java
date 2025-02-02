import javax.swing.*;
import java.awt.*;

public class ImageCard extends Card{
/*
Adds the different elements to an image card and
incorporates the values from ImageCreatorDialog
and handles displaying the image chosen
 */
    private ImageIcon imageIcon;
    private JLabel image;

    public ImageCard(ImageCardData cardData){
        super(cardData);

        //title added to a JLabel to be displayed
        titleLabel = new JLabel(this.title);
        //.setBorder creates a black border around the label
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        //description is put into a JTextArea to handle more text and line wrapping
        descriptionArea = new JTextArea(this.description);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setOpaque(false); //makes area transparent
        descriptionArea.setEditable(false); //prevents user from editing
        descriptionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));

        //hoursToComplete put into JLabel to be displayed
        hoursToCompleteLabel = new JLabel(this.hoursToComplete);
        hoursToCompleteLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        //creates an imageIcon, scales it to 100x100 and creates a new scaled ImageIcon
        imageIcon = new ImageIcon(cardData.getImagePath());
        Image scaledImage = imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        //image icon is displayed in a JLabel and set to 100x100
        image = new JLabel(scaledIcon);
        image.setPreferredSize(new Dimension(100,100));

        //adds components with gridBag constraints to style cards with given constraints in Card class
        add(titleLabel, gridBagConstraints);
        add(descriptionArea, gridBagConstraints);
        add(hoursToCompleteLabel, gridBagConstraints);
        add(image, gridBagConstraints);
    }

}
