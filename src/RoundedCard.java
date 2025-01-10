import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

class RoundedCard extends JPanel {
    private final String title;

    public RoundedCard(String title) {
        this.title = title;
        setOpaque(false); // Allow transparency for custom painting
    }


    public String getTitle() {
        return title;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw rounded rectangle
        int arc = 30;
        g2.setColor(new Color(200, 230, 255));
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));

        // Draw the border
        g2.setColor(Color.DARK_GRAY);
        g2.setStroke(new BasicStroke(2));
        g2.draw(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));

        // Draw the title
        g2.setColor(Color.DARK_GRAY);
        g2.setFont(new Font("SansSerif", Font.BOLD, 16));
        FontMetrics fm = g2.getFontMetrics();
        int titleX = (getWidth() - fm.stringWidth(title)) / 2;
        int titleY = (getHeight() + fm.getAscent()) / 2 - 10; // Center font vertically
        g2.drawString(title, titleX, titleY);
    }
}
