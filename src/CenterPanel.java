import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class CenterPanel extends JPanel implements MouseListener {

    private final TimelinePanel timeline;
    private final JButton extendButton;
    private final List<CardData> cardDataList = new ArrayList<>();

    private int panelWidth;
    private int timelineWidth;

    private final int TIMELINE_Y = 300;
    private final int TIMELINE_HEIGHT = 100;
    private final int BUTTON_CARD_MARGIN = 20;
    private final String CARD_FILE_PATH = "cards_data.txt";
    private final String PANEL_WIDTH_PATH = "timeline_data.txt";

    private boolean isPlacingCard = false;
    private CardData temporaryCardData;

    public CenterPanel(MainWindow mainWindow) {
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        addMouseListener(this);

        panelWidth = FileManager.getInstance().loadPanelWidth(PANEL_WIDTH_PATH);
        setPanelWidth(panelWidth);

        setPreferredSize(new Dimension(panelWidth, 1));
        timeline = createTimelinePanel();
        add(timeline);

        extendButton = createExtendButton();
        add(extendButton);

        loadCards();
    }

    private TimelinePanel createTimelinePanel() {
        TimelinePanel panel = new TimelinePanel();
        panel.setBounds(0, TIMELINE_Y, timelineWidth, TIMELINE_HEIGHT);
        return panel;
    }

    private JButton createExtendButton() {
        JButton button = new JButton("+");
        button.setBounds(timelineWidth + BUTTON_CARD_MARGIN, TIMELINE_Y, 100, 100);
        button.addActionListener(e -> extendPanel());
        button.setFocusable(false);
        return button;
    }

    public void setTemporaryCardData(CardData cardData) {
        temporaryCardData = cardData;
        isPlacingCard = true;
    }

    private void setPanelWidth(int width) {
        panelWidth = width;
        timelineWidth = panelWidth - 200;
        FileManager.getInstance().savePanelWidth(panelWidth, PANEL_WIDTH_PATH);
    }

    private void extendPanel() {
        setPanelWidth(panelWidth + 500);
        setPreferredSize(new Dimension(panelWidth, 1));
        timeline.setBounds(0, TIMELINE_Y, timelineWidth, TIMELINE_HEIGHT);
        extendButton.setBounds(timelineWidth + BUTTON_CARD_MARGIN, TIMELINE_Y, 100, 100);
        revalidate();
        repaint();
    }

    private void addCard(CardData cardData) {
        Card card = createCard(cardData);

        int cardX = cardData.getX() - 140;  // Centering card horizontally
        int cardY = (cardData.getY() > TIMELINE_Y) ? 410 : 11;

        card.setBounds(cardX, cardY, 280, 260);
        add(card);
        timeline.addMarker(cardData.getX());
        cardDataList.add(cardData);

        revalidate();
        repaint();
    }

    private Card createCard(CardData cardData) {
        if (cardData instanceof TextCardData) {
            return new TextCard((TextCardData) cardData, this);
        } else if (cardData instanceof ImageCardData) {
            return new ImageCard((ImageCardData) cardData, this);
        }
        return new TextCard(new TextCardData("Empty Card", 0, 0, "Empty", "1", Color.BLACK, false), this);
    }

    public void saveCards() {
        FileManager.getInstance().saveCardData(cardDataList, CARD_FILE_PATH);
    }

    private void loadCards() {
        removeAllCards();
        cardDataList.clear();
        List<CardData> loadedCards = FileManager.getInstance().loadCardData(CARD_FILE_PATH);

        for (CardData cardData : loadedCards) {
            addCard(cardData);
        }
    }

    private void removeAllCards() {
        for (Component component : getComponents()) {
            if (component instanceof Card) {
                remove(component);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isPlacingCard) {
            temporaryCardData.setX(e.getX());
            temporaryCardData.setY(e.getY());

            addCard(temporaryCardData);
            saveCards();

            isPlacingCard = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
