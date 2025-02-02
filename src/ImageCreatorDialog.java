import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageCreatorDialog extends CreatorDialog{

    private JButton fileChooserButton;
    private JFileChooser fileChooser;


    public ImageCreatorDialog(){
        super();
        setTitle("Image card creator");

        //Creates the label and textfield where title input is put
        titleLabel = new JLabel("Title:");
        title = new JTextField();
        title.setBackground(Color.WHITE);

        //Creates the label and textarea where the description input is put
        descriptionLabel = new JLabel("Description:");
        description = new JTextArea();
        description.setLineWrap(true);
        description.setBackground(Color.WHITE);

        //Creates the label and spinner where hours to complete is chosen
        hoursToCompleteLabel = new JLabel("Hours:");
        //value of the hours to complete is stored in the SpinnerNumberModel
        hoursToCompleteValue = new SpinnerNumberModel(0,0,1000, 1);
        //the actual spinner is created
        hoursToCompleteSpinner = new JSpinner(hoursToCompleteValue);
        hoursToCompleteSpinner.setSize(50,50);

        //the create button runs createCard method in actionlistener
        createButton = new JButton("Create Card");
        createButton.setBackground(Color.GREEN);
        //button to choose color, opens a JColorChooser
        colorChooserButton = new JButton("Select Color");
        colorChooserButton.setBackground(Color.YELLOW);

        //colorPreview is used to store the color chosen from user, default = white
        colorPreview = new JLabel("Color Preview");
        colorPreview.setOpaque(true); // Make the label's background visible
        colorPreview.setBackground(Color.WHITE);

        //button to open the JFileChooser
        fileChooserButton = new JButton("Choose image");
        fileChooser = new JFileChooser();

        //opens fileChooser dialog to choose image file
        fileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.showSaveDialog(null);
            }
        });
        colorChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //opens JColorChooser and allows user to select color
                Color selectedColor = JColorChooser.showDialog(
                        ImageCreatorDialog.this,
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
        add(fileChooserButton);
        add(colorChooserButton);
        add(createButton);

    }

    @Override
    public void createCard() {
        /*createCard() extracts the values inputted from the user
        creates a TextCardData object to store values and closes dialog*/

        /*if-statement stops the user from opening the fileChooser and not choosing a file,
         which produces error message when using .getAbsolutePath() on a file with value null
         stops user from creating card without image selected
         */
        if (fileChooser.getSelectedFile() == null){
            return;
        }
        String titleText = title.getText();
        String descriptionText = description.getText();
        String hoursToCompleteText = hoursToCompleteValue.getValue().toString();
        Color cardColor = colorPreview.getBackground();
        //firstly gets file and then converts into file path
        String imageFilePath = fileChooser.getSelectedFile().getAbsolutePath();

        ImageCardData imageCardData = new ImageCardData(titleText, 0,0,descriptionText, hoursToCompleteText, cardColor, imageFilePath);
        centerPanel.setTemporaryCardData(imageCardData);

        dispose();
    }
    //adds resetting fileChooser value to resetFields
    @Override
    public void resetFields(){
        super.resetFields();
        fileChooser.setSelectedFile(null);

    }


}
