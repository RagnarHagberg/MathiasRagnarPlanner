import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public class MainWindow {

    private final JFrame frame;
    private final CenterPanel centerPanel;
    private final NorthPanel northPanel;

    public MainWindow() {
        frame = createMainFrame();
        northPanel = new NorthPanel(this);
        centerPanel = new CenterPanel(this);
        initializeUI();
    }

    private JFrame createMainFrame() {
        JFrame frame = new JFrame("Planner");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1500, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        return frame;
    }

    private void initializeUI() {
        JScrollPane scrollPane = createScrollPane(centerPanel);

        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    private JScrollPane createScrollPane(JComponent component) {
        JScrollPane scrollPane = new JScrollPane(component);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        return scrollPane;
    }

    public void show() {
        frame.setVisible(true);
    }

    public CenterPanel getCenterPanel() {
        return centerPanel;
    }
}
