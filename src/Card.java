import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

abstract class Card extends JPanel {
/*
Abstract class for the cards added to the timeline
 */

    protected String title;
    protected String description;
    protected String hoursToComplete;
    protected Color cardColor;
    private CardData cardData;
    private Color previousCardColor;

    protected GridBagConstraints gridBagConstraints;

    protected JLabel titleLabel;
    protected JTextArea descriptionArea;
    protected JLabel hoursToCompleteLabel;

    private CenterPanel centerPanel;

    public Card(CardData cardData, CenterPanel centerPanel) {
        //Values to add to the cards to be displayed
        this.title = cardData.getTitle();
        this.description = cardData.getDescription();
        this.hoursToComplete = cardData.getHoursToComplete();
        this.cardColor = cardData.getBackgroundColor();

        this.cardData = cardData;
        this.centerPanel = centerPanel;

        if (cardData.getFinished()){
            System.out.println("Hello");
            this.cardColor = Color.GREEN;
        }

        //Default look for the cards
        setBackground(this.cardColor);
        setLayout(new GridBagLayout());

        /*To make cards have one label per row and allows the labels to expand the full card width
        works with GridBagLayout that the Card class uses*/

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = GridBagConstraints.RELATIVE;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;

    }

    public boolean getFinished(){
        return this.cardData.getFinished();
    }


    public void setFinished(boolean new_value){
        if (new_value){
            this.previousCardColor = this.cardColor;
            this.cardColor = Color.GREEN;
        }
        else{
            this.cardColor = this.cardData.getBackgroundColor();
        }
        this.cardData.setFinished(new_value);
        setBackground(this.cardColor);
        centerPanel.saveCards(centerPanel.getCardFilePath());

    }

}

