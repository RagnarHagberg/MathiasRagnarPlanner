import javax.swing.*;

public abstract class CardCreator extends JPanel {

    private String title;
    private String hoursToComplete;
    private String color;
    private String description;
    private JColorChooser colorPicker;

    abstract Card createCard();
}
