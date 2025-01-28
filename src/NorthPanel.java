import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NorthPanel extends JPanel {
    public NorthPanel(CenterPanel centerPanel){
        setLayout(new BorderLayout(50,50));
        //setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
        setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("PROJECT GOAT");
        label.setFont(new Font("Sans-serif", Font.BOLD, 36));
        label.setForeground(Color.WHITE);

        JPopupMenu addCardMenu = new JPopupMenu("Add card");
        JMenuItem textCardButton = new JMenuItem("Text card");
        JMenuItem imageCardButton = new JMenuItem("Image card");

        textCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreatorDialog textCardDialog = new TextCreatorDialog();
                textCardDialog.initialize(centerPanel);
            }
        });

        imageCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreatorDialog imageCardDialog = new ImageCreatorDialog();
                imageCardDialog.initialize(centerPanel);
            }
        });


        add(addCardMenu, BorderLayout.EAST);
        addCardMenu.add(textCardButton);
        addCardMenu.add(imageCardButton);



        CreatorDialog dialog = new ImageCreatorDialog();

        add(label, BorderLayout.WEST);

        JButton button = new JButton("Add card");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCardMenu.show(button, 0, button.getHeight());
                //dialog.initialize();
            }
        });
        button.setPreferredSize(new Dimension(200,25));
        add(button, BorderLayout.EAST);


    }
}
