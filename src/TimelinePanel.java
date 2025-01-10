import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class TimelinePanel extends JPanel {
    private final List<Integer> markers = new ArrayList<>(); // X-coordinates of markers

    public TimelinePanel() {
        setBackground(Color.BLACK); // Timeline background
    }

    // Add a marker to the timeline
    public void addMarker(int x) {
        markers.add(x);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the markers
        g2.setColor(Color.WHITE); // Marker color

        for (int x : markers) {
            g2.fillRect(x - 2, 0, 4, getHeight()); // Draw a thin vertical line for the marker
        }
    }
}
