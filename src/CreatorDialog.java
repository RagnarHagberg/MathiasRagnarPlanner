import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public abstract class CreatorDialog extends JDialog{

    protected JLabel titleLabel;
    protected JTextField title;

    protected JLabel descriptionLabel;
    protected JTextArea description;

    protected JLabel hoursToCompleteLabel;
    protected SpinnerModel hoursToCompleteValue;

    protected JButton createButton;
    protected JButton colorChooserButton;
    protected JLabel colorPreview;

    CenterPanel centerPanel;

    public CreatorDialog(){
        setLayout(new GridLayout(0,1,10,10));
        setSize(300,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    public abstract Card createCard();

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

