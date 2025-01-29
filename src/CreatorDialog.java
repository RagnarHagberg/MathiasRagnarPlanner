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

    CenterPanel centerPanel;

    public CreatorDialog(){
        setLayout(new GridLayout(0, 1));
        setSize(300,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public abstract void createCard();

    public void initialize(CenterPanel centerPanel){
        //resetFields();
        this.centerPanel = centerPanel;
        setModal(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void resetFields(){  //behövs troligtvis inte
        title.setText("");
        description.setText("");
        hoursToComplete.setText("");
    }

}

