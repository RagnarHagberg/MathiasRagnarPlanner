import javax.swing.*;
import java.awt.*;

public class ImageCard extends Card{

    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JLabel hoursToCompleteLabel;

    private ImageIcon imageIcon;
    private JLabel image;

    public ImageCard(ImageCardData cardData){
        super(cardData);
        titleLabel = new JLabel(this.title);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        descriptionLabel = new JLabel(this.description);
        descriptionLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        hoursToCompleteLabel = new JLabel(this.hoursToComplete);
        hoursToCompleteLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        imageIcon = new ImageIcon(cardData.getImagePath());
        image = new JLabel(imageIcon);

        add(titleLabel);
        add(descriptionLabel);
        add(hoursToCompleteLabel);
        add(image);
    }

}
