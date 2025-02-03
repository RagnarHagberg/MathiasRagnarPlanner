import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TextCard extends Card {
    /*
    Adds the different elements to a text card and incorporates the values from TextCreatorDialog
    */

    public TextCard(TextCardData cardData) {
        super(cardData);

        // Set the layout manager for the card to GridBagLayout
        setLayout(new GridBagLayout());

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

        // Description Area (Expand to fill available space)
        descriptionArea = new JTextArea(this.description);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setLineWrap(true);
        descriptionArea.setOpaque(false); // Transparent area
        descriptionArea.setEditable(false); // Prevent user from editing
        descriptionArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

        GridBagConstraints descConstraints = new GridBagConstraints();
        descConstraints.gridx = 0;
        descConstraints.gridy = 1;
        descConstraints.gridwidth = 3; // Span across 3 columns
        descConstraints.fill = GridBagConstraints.BOTH; // Fill both horizontally and vertically
        descConstraints.weightx = 1.0; // Stretch horizontally
        descConstraints.weighty = 1.0; // Stretch vertically
        descConstraints.insets = new Insets(5, 5, 5, 5);
        add(descriptionArea, descConstraints);

        // Finished Button (Checkbox)
        JCheckBox finishedButton = new JCheckBox("Klar");
        GridBagConstraints finishedConstraints = new GridBagConstraints();
        finishedConstraints.gridx = 0; // First column
        finishedConstraints.gridy = 2; // Row 3
        finishedConstraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        finishedConstraints.insets = new Insets(5, 5, 5, 5);
        finishedConstraints.anchor = GridBagConstraints.CENTER; // Center the button horizontally
        finishedConstraints.weightx = 1.0; // Make it stretch equally across the columns
        add(finishedButton, finishedConstraints);

        finishedButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                boolean finished = (e.getStateChange() == ItemEvent.SELECTED); // true if checked, false if unchecked
                System.out.println(finished);
                setFinished(finished);

                // add functionality to save new state.
            }
        });


        // Move Button (Toggle)
        JToggleButton moveButton = new JToggleButton("Flytta");
        GridBagConstraints moveConstraints = new GridBagConstraints();
        moveConstraints.gridx = 1; // Middle column
        moveConstraints.gridy = 2; // Row 3
        moveConstraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        moveConstraints.insets = new Insets(5, 5, 5, 5);
        moveConstraints.anchor = GridBagConstraints.CENTER; // Center the button horizontally
        moveConstraints.weightx = 1.0; // Stretch horizontally
        add(moveButton, moveConstraints);

        // Hours to Complete Label (Position in the first column, centered)
        hoursToCompleteLabel = new JLabel(this.hoursToComplete);
        Font hoursFont = new Font("Serif", Font.BOLD, 36);
        hoursToCompleteLabel.setFont(hoursFont);

        GridBagConstraints hoursConstraints = new GridBagConstraints();
        hoursConstraints.gridx = 2; // Last column
        hoursConstraints.gridy = 2; // Row 3
        hoursConstraints.fill = GridBagConstraints.HORIZONTAL; // Stretch horizontally
        hoursConstraints.insets = new Insets(5, 5, 5, 5);
        hoursConstraints.anchor = GridBagConstraints.CENTER; // Center the label horizontally
        hoursConstraints.weightx = 1.0; // Stretch horizontally
        add(hoursToCompleteLabel, hoursConstraints);
    }
}
