import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NorthPanel extends JPanel {

    private CreatorDialog strategy;

    public NorthPanel(MainWindow mainWindow){
        setLayout(new BorderLayout(50,50));
        //setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));
        setBackground(Color.LIGHT_GRAY);

        JLabel label = new JLabel("PROJECT GOAT");
        label.setFont(new Font("Sans-serif", Font.BOLD, 36));
        label.setForeground(Color.WHITE);

        JPopupMenu addCardMenu = new JPopupMenu("Add card");
        JMenuItem textCardButton = new JMenuItem("Text card");
        JMenuItem imageCardButton = new JMenuItem("Image card");

        // Strategy pattern
        // NorthPanel är context
        // Creatordialog is our abstract class working as interface


        // Set Strategy
        textCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Creatordialog is our equivalent
                setStrategy(new TextCreatorDialog());
                executeStrategy(mainWindow.getCenterPanel());            }
        });


        // Set Strategy
        imageCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setStrategy(new ImageCreatorDialog());
                executeStrategy(mainWindow.getCenterPanel());
            }
        });

        add(addCardMenu, BorderLayout.EAST);
        addCardMenu.add(textCardButton);
        addCardMenu.add(imageCardButton);

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

    private void setStrategy(CreatorDialog newDialog){
        strategy = newDialog;
    }

    private void executeStrategy(CenterPanel centerPanel){
        strategy.initialize(centerPanel);
    }
}
