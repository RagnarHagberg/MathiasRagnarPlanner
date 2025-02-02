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

    protected GridBagConstraints gridBagConstraints;

    protected JLabel titleLabel;
    protected JTextArea descriptionArea;
    protected JLabel hoursToCompleteLabel;

    public Card(CardData cardData) {
        //Values to add to the cards to be displayed
        this.title = cardData.getTitle();
        this.description = cardData.getDescription();
        this.hoursToComplete = cardData.getHoursToComplete();
        this.cardColor = cardData.getBackgroundColor();

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

}

