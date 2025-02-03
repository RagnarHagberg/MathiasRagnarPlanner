import java.awt.*;

abstract public class CardData {
    private String title;
    private int x, y;
    private String description;
    private String hoursToComplete;
    private Color backgroundColor;
    private boolean finished;

    public CardData(String title, int x, int y, String description, String hoursToComplete, Color backgroundColor, boolean finished) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.description = description;
        this.hoursToComplete = hoursToComplete;
        this.backgroundColor = backgroundColor;
        this.finished = finished;
    }

    public String getTitle() {
        return title;
    }

    public boolean getFinished(){
        return finished;
    }

    public void setFinished(boolean finished){
        this.finished = finished;
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