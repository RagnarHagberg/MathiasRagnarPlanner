import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class ImageCard extends Card{
/*
Adds the different elements to an image card and
incorporates the values from ImageCreatorDialog
and handles displaying the image chosen
 */
    private ImageIcon imageIcon;
    private JLabel image;

    public ImageCard(ImageCardData cardData, CenterPanel centerPanel){
        super(cardData, centerPanel);

        //title added to a JLabel to be displayed
        titleLabel = new JLabel(this.title);
        Font titleFont = new Font("Serif", Font.BOLD, 36);
        titleLabel.setFont(titleFont);
        //.setBorder creates a black border around the label

        int maxGridWidth = 3;
        GridBagConstraints titleConstraints = new GridBagConstraints();
        titleConstraints.gridx = 0;
        titleConstraints.gridy = 0;
        titleConstraints.gridwidth = maxGridWidth; // Span across two columns
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        titleConstraints.insets = new Insets(5, 5, 5, 5);
        titleConstraints.anchor = GridBagConstraints.CENTER;
        add(titleLabel, titleConstraints);


        //description is put into a JTextArea to handle more text and line wrapping
        descriptionArea = new JTextArea(this.description);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setOpaque(false); //makes area transparent
        descriptionArea.setEditable(false); //prevents user from editing
        //descriptionArea.setSize(new Dimension(50, 100));
        descriptionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

        GridBagConstraints descConstraints = new GridBagConstraints();
        descConstraints.gridx = 0;
        descConstraints.gridy = 1;
        descConstraints.gridwidth = maxGridWidth;
        descConstraints.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
        descConstraints.weightx = 1.0; // Stretch horizontally
        descConstraints.insets = new Insets(5, 5, 5, 5);
        add(descriptionArea, descConstraints);


        // Finished Button (Checkbox)
        JCheckBox finishedButton = new JCheckBox("Klar");
        GridBagConstraints finishedConstraints = new GridBagConstraints();
        finishedConstraints.gridx = 0; // First column
        finishedConstraints.gridy = 3; // Row 3
        finishedConstraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        finishedConstraints.insets = new Insets(5, 5, 5, 5);
        finishedConstraints.anchor = GridBagConstraints.CENTER; // Center the button horizontally
        finishedConstraints.weightx = 1.0; // Make it stretch equally across the columns
        finishedButton.setSelected(this.getFinished());

        add(finishedButton, finishedConstraints);

        finishedButton.addItemListener(e -> {
            boolean finished = (e.getStateChange() == ItemEvent.SELECTED); // true if checked, false if unchecked
            System.out.println(finished);
            setFinished(finished);

            // add functionality to save new state.
        });

        // Hours to Complete Label (Position in the first column, centered)
        hoursToCompleteLabel = new JLabel(this.hoursToComplete);
        Font hoursFont = new Font("Serif", Font.BOLD, 36);
        hoursToCompleteLabel.setFont(hoursFont);

        GridBagConstraints hoursConstraints = new GridBagConstraints();
        hoursConstraints.gridx = 1; // Last column
        hoursConstraints.gridy = 3; // Row 3
        hoursConstraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        hoursConstraints.insets = new Insets(5, 5, 5, 5);
        hoursConstraints.anchor = GridBagConstraints.CENTER; // Center the label horizontally
        hoursConstraints.weightx = 1.0; // Stretch horizontally
        add(hoursToCompleteLabel, hoursConstraints);


        //creates an imageIcon, scales it to 100x100 and creates a new scaled ImageIcon
        imageIcon = new ImageIcon(cardData.getImagePath());
        Image scaledImage = imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        //image icon is displayed in a JLabel and set to 100x100
        image = new JLabel(scaledIcon);
        image.setPreferredSize(new Dimension(100,100));

        GridBagConstraints imageConstraints = new GridBagConstraints();
        imageConstraints.gridx = 0;
        imageConstraints.gridy = 2;
        imageConstraints.gridwidth = maxGridWidth;
        imageConstraints.insets = new Insets(5, 5, 5, 5);
        imageConstraints.anchor = GridBagConstraints.CENTER;
        add(image, imageConstraints);
    }
}
