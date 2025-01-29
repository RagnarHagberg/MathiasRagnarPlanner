import javax.swing.*;
import java.awt.*;

public class TextCard extends Card{

    JLabel titleLabel;
    JLabel descriptionLabel;
    JLabel hoursToCompleteLabel;

    public TextCard(TextCardData cardData){

        super(cardData);
        titleLabel = new JLabel(this.title);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        descriptionLabel = new JLabel(this.description);
        descriptionLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        hoursToCompleteLabel = new JLabel(this.hoursToComplete);
        hoursToCompleteLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        add(titleLabel);
        add(descriptionLabel);
        add(hoursToCompleteLabel);
    }

}
