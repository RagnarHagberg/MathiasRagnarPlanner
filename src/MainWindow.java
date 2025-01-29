import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;


public class MainWindow {

    private JFrame frame;
    public CenterPanel centerPanel;
    public NorthPanel northPanel;


    public MainWindow(){
        initialize();
    }

    private void initialize(){

        frame = new JFrame();
        frame.setTitle("Planner");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1500,800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout()); // set gaps here


        northPanel = new NorthPanel(this);
        centerPanel = new CenterPanel(this);
        JScrollPane scrollPane = new JScrollPane(centerPanel);

        // Set only horizontal scroll
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);


        //panel.setPreferredSize(new Dimension(100,250));

        frame.add(northPanel, BorderLayout.NORTH); //NOrth south west east
        frame.add(scrollPane, BorderLayout.CENTER);


    }

    public void show(){
        this.frame.setVisible(true);
    }

}
