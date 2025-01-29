import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageCreatorDialog extends CreatorDialog{

    private JButton fileChooserButton;
    private JFileChooser fileChooser;
    private JSpinner hoursToCompleteSpinner;

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
        SpinnerModel f = new SpinnerNumberModel(0,0,1000, 1);
        hoursToCompleteSpinner = new JSpinner(hoursToCompleteValue);
        hoursToCompleteSpinner.setSize(50,50);

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
        add(hoursToCompleteSpinner);
        add(fileChooserButton);
        add(colorChooserButton);
        add(createButton);

    }

    @Override
    public void createCard() {

        if (fileChooser.getSelectedFile() == null){
            return;
        }
        String titleText = title.getText();
        String descriptionText = description.getText();
        String hoursToCompleteText = hoursToCompleteToString(hoursToCompleteValue.getValue());
        Color cardColor = colorPreview.getBackground();
        String imageFilePath = fileChooser.getSelectedFile().getAbsolutePath();


        ImageCardData imageCardData = new ImageCardData(titleText, 0,0,descriptionText, hoursToCompleteText, cardColor, imageFilePath);
        centerPanel.setTemporaryCardData(imageCardData);
    }
    @Override
    public void resetFields(){
        super.resetFields();
        fileChooser.setSelectedFile(null);

    }

    private String hoursToCompleteToString(Object value){
        return value.toString();
    }
}
