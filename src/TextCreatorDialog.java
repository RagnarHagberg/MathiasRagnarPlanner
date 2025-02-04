import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TextCreatorDialog extends CreatorDialog {

    public TextCreatorDialog(){
        super();
        setTitle("Text card creator");

        //Creates the label and textfield where user input title text
        titleLabel = new JLabel("Title:");
        title = new JTextField();
        title.setBackground(Color.WHITE);

        //Creates the label and textarea where the description input is put
        descriptionLabel = new JLabel("Description:");
        description = new JTextArea();
        description.setLineWrap(true);
        description.setBackground(Color.WHITE);
        description.setSize(new Dimension(240,120));

        //Creates the label and spinner where hours to complete is chosen
        hoursToCompleteLabel = new JLabel("Hours:");
        //value of the hours to complete is stored in the SpinnerNumberModel
        hoursToCompleteValue = new SpinnerNumberModel(0,0,1000, 1);
        //the actual spinner is created
        hoursToCompleteSpinner = new JSpinner(hoursToCompleteValue);
        hoursToCompleteSpinner.setBackground(Color.WHITE);
        hoursToCompleteSpinner.setSize(50,50);

        //the create button runs createCard method in actionlistener
        createButton = new JButton("Create Card");
        createButton.setBackground(Color.GREEN);
        //button to choose color, opens a JColorChooser
        colorChooserButton = new JButton("Select Color");
        colorChooserButton.setBackground(Color.YELLOW);

        //colorPreview is used to store the color chosen from user, default = white
        colorPreview = new JLabel("Color Preview");
        colorPreview.setOpaque(true);
        colorPreview.setBackground(Color.WHITE);

        colorChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //opens JColorChooser and allows user to select color
                Color selectedColor = JColorChooser.showDialog(
                        TextCreatorDialog.this,
                        "Choose a Color",
                        colorPreview.getBackground()
                );
                //ensures that if user closes the dialog without selecting color, default color is selected
                //if the user selected a color, colorPreview stores the color in its background
                if (selectedColor != null) {
                    colorPreview.setBackground(selectedColor);
                }
            }
        });

        //createButton runs createCard method
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCard();
            }
        });

        //adds the components to the dialog
        add(titleLabel);
        add(title);
        add(descriptionLabel);
        add(description);
        add(hoursToCompleteLabel);
        add(hoursToCompleteSpinner);
        add(colorChooserButton);
        add(createButton);
    }


    @Override
    public void createCard() {
        /*createCard() extracts the values inputted from the user
        creates a TextCardData object to store values and closes dialog
         */
        String titleText = title.getText();
        String descriptionText = description.getText();
        String hoursToCompleteText = hoursToCompleteValue.getValue().toString();
        Color cardColor = colorPreview.getBackground();

        TextCardData textCardData = new TextCardData(titleText, 0,0, descriptionText, hoursToCompleteText, cardColor, false);
        centerPanel.setTemporaryCardData(textCardData);

        dispose();
    }
}
