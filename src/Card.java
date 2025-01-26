import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

class Card extends JPanel {
    private final String title;
    private Color cardColor = new Color(200, 230, 255);

    public Card(String title) {
        this.title = title;
        setBackground(Color.darkGray);
        setLayout(new GridLayout(0,1,10,10));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        JButton button = new JButton("hello");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Card pressed");
                cardColor = Color.RED;
                repaint();
            }
        });

        add(button);
    }

    public String getTitle() {
        return title;
    }

}
