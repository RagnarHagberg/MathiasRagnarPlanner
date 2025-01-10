import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    public static void saveCardData(List<CardData> cardDataList, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (CardData cardData : cardDataList) {
                writer.write(cardData.title + "," + cardData.x + "," + cardData.y);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<CardData> loadCardData(String filename) {
        List<CardData> cardDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String title = parts[0];
                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    cardDataList.add(new CardData(title, x, y));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cardDataList;
    }
}
