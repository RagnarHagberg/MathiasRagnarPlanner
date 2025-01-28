import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImageCreatorDialog extends CreatorDialog{

    private JButton fileChooserButton;
    private JFileChooser fileChooser;

    public ImageCreatorDialog(){
        super();
        setTitle("Image card creator");

        titleLabel = new JLabel("Title:");
        title = new JTextField();
        title.setBackground(Color.WHITE);

        descriptionLabel = new JLabel("Description:");
        description = new JTextArea();
        description.setLineWrap(true);
        description.setBackground(Color.WHITE);

        hoursToCompleteLabel = new JLabel("Hours:");
        hoursToComplete = new JTextField();
        hoursToComplete.setBackground(Color.WHITE);

        createButton = new JButton("Create Card");
        createButton.setBackground(Color.GREEN);
        colorChooserButton = new JButton("Select Color");
        colorChooserButton.setBackground(Color.YELLOW);

        colorPreview = new JLabel("Color Preview");
        colorPreview.setOpaque(true); // Make the label's background visible
        colorPreview.setBackground(Color.WHITE);

        fileChooserButton = new JButton("Choose image");
        fileChooser = new JFileChooser();

        fileChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.showSaveDialog(null);
            }
        });
        colorChooserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color selectedColor = JColorChooser.showDialog(
                        ImageCreatorDialog.this,
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
        add(hoursToComplete);
        add(fileChooserButton);
        add(colorChooserButton);
        add(createButton);

    }

    @Override
    public Card createCard() {
        String titleText = title.getText();
        String descriptionText = description.getText();
        String hoursToCompleteText = hoursToComplete.getText();
        Color cardColor = colorPreview.getBackground();
        if(fileChooser.getSelectedFile() != null) {
            String imageFile = fileChooser.getSelectedFile().getAbsolutePath();
        }
        centerPanel.setPlacingCard(true);
        return null;
    }
    @Override
    public void resetFields(){
        super.resetFields();
        fileChooser.setSelectedFile(null);

    }

}
