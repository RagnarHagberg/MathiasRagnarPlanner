import java.awt.*;

public class ImageCardData extends CardData{
    private String imagePath;
    public ImageCardData(String title, int x, int y, String description, String hoursToComplete, Color backgroundColor, boolean finished, String imagePath) {
        super(title, x, y, description, hoursToComplete, backgroundColor, finished);
        this.imagePath = imagePath;

    }

    public String getImagePath() {
        return imagePath;
    }
}
