import java.awt.*;

public class ImageCardData extends CardData{
    private String imagePath;
    public ImageCardData(String title, int x, int y, String description, String hoursToComplete, Color backgroundColor, String imagePath) {
        super(title, x, y, description, hoursToComplete, backgroundColor);
        this.imagePath = imagePath;

    }

    public String getImagePath() {
        return imagePath;
    }
}
