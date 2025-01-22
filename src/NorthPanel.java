import javax.swing.*;
import java.awt.*;

public class NorthPanel extends JPanel {
    public NorthPanel(){
        setLayout(new BorderLayout(50,50));
        //setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
        setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("PROJECT GOAT");
        label.setFont(new Font("Sans-serif", Font.BOLD, 36));
        label.setForeground(Color.WHITE);

        add(label, BorderLayout.WEST);

        JButton button = new JButton("Add card");
        button.setPreferredSize(new Dimension(200,50));
        add(button, BorderLayout.EAST);


    }
}
