import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TextCreatorDialog extends CreatorDialog {

    public TextCreatorDialog(){
        super();
        setTitle("Text card creator");

        titleLabel = new JLabel("Title:");
        title = new JTextField();
        title.setBackground(Color.WHITE);

        descriptionLabel = new JLabel("Description:");
        description = new JTextArea();
        description.setLineWrap(true);
        description.setBackground(Color.WHITE);

        hoursToCompleteLabel = new JLabel("Hours:");
        hoursToCompleteValue = new SpinnerNumberModel(0,0,1000, 1);
        hoursToCompleteSpinner = new JSpinner(hoursToCompleteValue);
        hoursToCompleteSpinner.setSize(50,50);

        createButton = new JButton("Create Card");
        createButton.setBackground(Color.GREEN);
        colorChooserButton = new JButton("Select Color");
        colorChooserButton.setBackground(Color.YELLOW);

        colorPreview = new JLabel("Color Preview");
        colorPreview.setOpaque(true); // Make the label's background visible
        colorPreview.setBackground(Color.WHITE);

        colorChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = JColorChooser.showDialog(
                        TextCreatorDialog.this,
                        "Choose a Color",
                        colorPreview.getBackground()
                );

                if (selectedColor != null) {
                    colorPreview.setBackground(selectedColor);
                }
            }
        });


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCard();
            }
        });

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
        String titleText = title.getText();
        String descriptionText = description.getText();
        String hoursToCompleteText = hoursToCompleteValue.getValue().toString();
        Color cardColor = colorPreview.getBackground();

        TextCardData textCardData = new TextCardData(titleText, 0,0, descriptionText, hoursToCompleteText, cardColor);
        centerPanel.setTemporaryCardData(textCardData);

        dispose();
    }




}
