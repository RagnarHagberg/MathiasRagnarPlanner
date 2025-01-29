import javax.swing.*;
import java.awt.*;

public class ImageCard extends Card{

    private JLabel titleLabel;
    private JLabel descriptionLabel;
    private JLabel hoursToCompleteLabel;

    private ImageIcon imageIcon;
    private JLabel image;

    public ImageCard(String title, String description, String hoursToComplete, Color cardColor,String imagePath){
        super(title, description, hoursToComplete,  cardColor);
        titleLabel = new JLabel(this.title);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        descriptionLabel = new JLabel(this.description);
        descriptionLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        hoursToCompleteLabel = new JLabel(this.hoursToComplete);
        hoursToCompleteLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5,true));

        imageIcon = new ImageIcon(imagePath);
        image = new JLabel(imageIcon);

        add(titleLabel);
        add(descriptionLabel);
        add(hoursToCompleteLabel);
        add(image);
    }

}
