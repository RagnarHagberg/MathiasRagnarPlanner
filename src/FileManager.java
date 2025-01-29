import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileManager {

    private static FileManager singletonInstance = null;

    private FileManager(){}

    public static FileManager getInstance(){
        if (singletonInstance == null){
            singletonInstance = new FileManager();
        }
        return singletonInstance;

    }
    public void saveCardData(List<CardData> cardDataList, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (CardData cardData : cardDataList) {
                if (cardData instanceof TextCardData){
                    writer.write("TextCard," + cardData.getTitle() + "," + cardData.getX() + "," + cardData.getY()
                            + "," + cardData.getDescription() + "," + cardData.getHoursToComplete() + "," + cardData.getBackgroundColor().toString());
                    writer.newLine();
                } else if (cardData instanceof ImageCardData) {
                    writer.write("ImageCard," + cardData.getTitle() + "," + cardData.getX() + "," + cardData.getY()
                            + "," + cardData.getDescription() + "," + cardData.getHoursToComplete() + ","
                            + cardData.getBackgroundColor().toString() + "," + ((ImageCardData) cardData).getImagePath());
                    writer.newLine();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CardData> loadCardData(String filename) {
        List<CardData> cardDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (Objects.equals(parts[0], "TextCard")){
                    String title = parts[0];
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    String description = parts[4];
                    String hoursToComplete = parts[5];
                    Color backgroundColor = Color.getColor(parts[6]);
                    cardDataList.add(new TextCardData(title, x, y, description, hoursToComplete, backgroundColor));
                }
                if (Objects.equals(parts[0], "ImageCard")){
                    String title = parts[0];
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    String description = parts[4];
                    String hoursToComplete = parts[5];
                    Color backgroundColor = Color.getColor(parts[6]);
                    String imagePath = parts[7];
                    cardDataList.add(new ImageCardData(title, x, y, description, hoursToComplete, backgroundColor, imagePath));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cardDataList;

    }

    public void savePanelWidth(int width, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(Integer.toString(width));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int loadPanelWidth(String filename) {

        int width = 3000;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            line = reader.readLine();
            width = Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return width;
    }
}
