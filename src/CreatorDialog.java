import javax.swing.*;
import java.awt.*;

public abstract class CreatorDialog extends JDialog{
/*
Abstract class for the card creator dialog
Sets the layout for the dialogs and initializes the dialogs and displays them
 */
    protected JLabel titleLabel;
    protected JTextField title;

    protected JLabel descriptionLabel;
    protected JTextArea description;

    protected JLabel hoursToCompleteLabel;
    protected SpinnerModel hoursToCompleteValue;
    protected JSpinner hoursToCompleteSpinner;

    protected JButton createButton;
    protected JButton colorChooserButton;
    protected JLabel colorPreview;

    CenterPanel centerPanel;

    public CreatorDialog(){
        //Sets up the layout for ImageCreatorDialog and TextCreatorDialog
        setLayout(new GridLayout(0,1,10,0));
        setSize(300,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public abstract void createCard();

    public void initialize(CenterPanel centerPanel){
        //displays the dialog chosen
        this.centerPanel = centerPanel;
        setModal(true);
        setLocationRelativeTo(null);
        setVisible(true);
        resetFields();
    }

    public void resetFields(){
        //resets the values of the dialogs when making a new card
        title.setText("");
        description.setText("");
        hoursToCompleteValue.setValue(0);
    }
}

