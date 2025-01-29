import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

abstract class Card extends JPanel {
    protected String title;
    protected String description;
    protected String hoursToComplete;
    protected Color cardColor;


    public Card(CardData cardData) {
        this.title = cardData.getTitle();
        this.description = cardData.getDescription();
        this.hoursToComplete = cardData.getHoursToComplete();
        this.cardColor = cardData.getBackgroundColor();
        setBackground(this.cardColor);
        setLayout(new GridLayout(0,1,10,10));

    }

}

