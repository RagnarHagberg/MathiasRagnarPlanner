import java.awt.*;

abstract public class CardData {
    private String title;
    private int x, y;
    private String description;
    private String hoursToComplete;
    private Color backgroundColor;

    public CardData(String title, int x, int y, String description, String hoursToComplete, Color backgroundColor) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.description = description;
        this.hoursToComplete = hoursToComplete;
        this.backgroundColor = backgroundColor;
    }

    public String getTitle() {
        return title;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getDescription() {
        return description;
    }

    public String getHoursToComplete(){
        return hoursToComplete;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }
}