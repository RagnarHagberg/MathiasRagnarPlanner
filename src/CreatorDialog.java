import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public abstract class CreatorDialog extends JDialog{

    JLabel titleLabel;
    JTextField title;

    JLabel descriptionLabel;
    JTextArea description;

    JLabel hoursToCompleteLabel;
    JTextField hoursToComplete;

    JButton createButton;
    JButton colorChooserButton;
    JLabel colorPreview;

    public CreatorDialog(){
        setLayout(new GridLayout(0, 1));
        setSize(300,300);
    }

    public abstract Card createCard();

    public void initialize(){
        resetFields();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void resetFields(){
        title.setText("");
        description.setText("");
        hoursToComplete.setText("");
    }

}

