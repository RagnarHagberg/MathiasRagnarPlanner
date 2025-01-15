import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class CenterPanel extends JPanel implements MouseListener {

    private TimelinePanel timeline;
    private JButton extendButton;

    private int panelWidth = 3000;
    private int timelineX = 0;
    private int timelineY = 250;
    private int timelineWidth = 2800;
    private int timelineHeight = 100;

    private int buttonCardMargin = 20;

    private int cardCount = 1;

    private List<CardData> cardDataList = new ArrayList<CardData>();


    public CenterPanel(){
        setBackground(Color.PINK);
        setLayout(null);
        this.addMouseListener(this);

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

        loadCards("cards_data.txt");
    }


    private void extendPanel(){
        panelWidth += 500;
        timelineWidth = panelWidth - 200;
        setPreferredSize(new Dimension(panelWidth,1));
        timeline.setBounds(timelineX, timelineY, timelineWidth, timelineHeight);
        extendButton.setBounds(timelineWidth+buttonCardMargin, timelineY, 100, 100);
        revalidate();
        repaint();
    }

    private void addCard(String title, int x, int y){
        RoundedCard card = new RoundedCard(title);
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
        FileManager.saveCardData(cardDataList, filename);
    }

    private void loadCards(String filename){
        removeCards(cardDataList);

        cardDataList.clear();

        List<CardData> tempCardDataList = new ArrayList<CardData>();
        tempCardDataList = FileManager.loadCardData(filename);

        for (CardData cardData : tempCardDataList) {
            // if carddata is imagecarddata
            // new ImageCard
            // else textcard

            RoundedCard card = new RoundedCard(cardData.title);
            addCard(cardData.title, cardData.x, cardData.y);
        }
    }


    private void removeCards(List<CardData> cardDataList) {
        Component[] components = getComponents();
        for (Component component : components) {
            if (component instanceof RoundedCard) {
                remove(component);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        addCard(Integer.toString(cardCount), e.getX(), e.getY());
        saveCards("cards_data.txt");
        System.out.println(e.getX());
        System.out.println(e.getY());

;
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
