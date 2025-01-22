import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public class CreatorDialog extends JDialog{
    CardCreator creator;

    public CreatorDialog(){
        JLabel label = new JLabel("Hello");
        setLayout(new GridLayout(0, 1));
        setSize(500,500);

        JLabel titleLabel = new JLabel("Title:");
        JTextField title = new JTextField("skriv desc");

        JLabel descriptionLabel = new JLabel("Description:");
        JTextArea description = new JTextArea();

        JLabel hoursToCompleteLabel = new JLabel("Hours:");
        JTextField hoursToComplete = new JTextField();

        add(titleLabel);
        add(title);
        add(descriptionLabel);
        add(description);
        add(hoursToCompleteLabel);
        add(hoursToComplete);
        //JLabel

    }

    public void initialize(){
        // clear input fields
        setLocationRelativeTo(null);
        setVisible(true);
    }

}

