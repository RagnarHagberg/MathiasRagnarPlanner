import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;



public class MainWindow {

    private JFrame frame;

    public MainWindow(){
        initialize();
    }

    private void initialize(){
        FlatDarculaLaf.setup();
        frame = new JFrame();
        frame.setTitle("Planner");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1500,800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout()); // set gaps here

        NorthPanel northPanel = new NorthPanel();
        CenterPanel centerPanel = new CenterPanel();

        //panel.setPreferredSize(new Dimension(100,250));

        frame.add(northPanel, BorderLayout.NORTH); //NOrth south west east
        frame.add(centerPanel, BorderLayout.CENTER);
    }

    public void show(){
        this.frame.setVisible(true);
    }

}
