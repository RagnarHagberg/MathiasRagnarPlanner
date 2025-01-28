import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import com.formdev.flatlaf.FlatDarculaLaf;


public class CenterPanel extends JPanel implements MouseListener {

    private TimelinePanel timeline;
    private JButton extendButton;

    private int panelWidth = 3000;
    private int timelineX = 0;
    private int timelineY = 250;
    private int timelineWidth = panelWidth-200;
    private int timelineHeight = 100;

    private int buttonCardMargin = 20;

    private int cardCount = 1;

    private List<CardData> cardDataList = new ArrayList<CardData>();

    private String cardFilePath = "cards_data.txt";
    private String panelWidthPath = "timeline_data.txt";

    public boolean isPlacingCard = false;

    public CenterPanel(){
        setBackground(Color.lightGray);
        setLayout(null);
        this.addMouseListener(this);

        panelWidth = FileManager.getInstance().loadPanelWidth(panelWidthPath);
        setPanelWidth(panelWidth);


        setPreferredSize(new Dimension(panelWidth,1)); // A large width to allow seemingly indefinite scroll
        // the timeline should span the entire scrollable width
        timeline = new TimelinePanel();
        timeline.setBounds(timelineX, timelineY, timelineWidth, timelineHeight);
        add(timeline);

        // Add button to extend the timeline and panel
        extendButton = new JButton();
        extendButton.setText("+");
        extendButton.setBounds(timelineWidth + buttonCardMargin, timelineY, 100, 100);
        extendButton.addActionListener(_ -> extendPanel());
        extendButton.setFocusable(false);
        add(extendButton);

        loadCards(cardFilePath);
    }

    public void setPlacingCard(boolean newValue){
        isPlacingCard = newValue;
    }

    private void setPanelWidth(int width){
        panelWidth = width;
        timelineWidth = panelWidth -200;
        FileManager.getInstance().savePanelWidth(panelWidth, panelWidthPath);
    }

    private void extendPanel(){
        setPanelWidth(panelWidth + 500);
        setPreferredSize(new Dimension(panelWidth,1));
        timeline.setBounds(timelineX, timelineY, timelineWidth, timelineHeight);
        extendButton.setBounds(timelineWidth+buttonCardMargin, timelineY, 100, 100);
        revalidate();
        repaint();
    }

    private void addCard(String title, int x, int y){
        Card card = new Card(title);
        cardCount++;

        int cardWidth = 200;
        int cardHeight = 120;

        // Set the center of the card to the position of the mouse
        int cardX = x - cardWidth / 2;
        int cardY = y - cardHeight / 2;
        card.setBounds(cardX, cardY, cardWidth, cardHeight);

        this.add(card);
        timeline.addMarker(x);
        cardDataList.add(new CardData(card.getTitle(), x, y));

        // Refresh the panel

        this.revalidate();
        this.repaint();
    }

    private void saveCards(String filename){
        FileManager.getInstance().saveCardData(cardDataList, filename);
    }

    private void loadCards(String filename){
        removeCards(cardDataList);

        cardDataList.clear();

        List<CardData> tempCardDataList = new ArrayList<CardData>();
        tempCardDataList = FileManager.getInstance().loadCardData(filename);

        for (CardData cardData : tempCardDataList) {
            // if carddata is imagecarddata
            // new ImageCard
            // else textcard

            Card card = new Card(cardData.title);
            addCard(cardData.title, cardData.x, cardData.y);
        }
    }


    private void removeCards(List<CardData> cardDataList) {
        Component[] components = getComponents();
        for (Component component : components) {
            if (component instanceof Card) {
                remove(component);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isPlacingCard) {
            Component deepestComponent = (SwingUtilities.getDeepestComponentAt(this, e.getX(), e.getY()));

            addCard(Integer.toString(cardCount), e.getX(), e.getY());
            saveCards(cardFilePath);
            isPlacingCard = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
