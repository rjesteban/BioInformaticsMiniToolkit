/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author rjesteban
 */
public class ChartGenerator {
    private ArrayList<ChartPanel> charts;
    private JFrame frame;
    
    public ChartGenerator (ArrayList<ChartPanel> charts) {
        this.charts = charts;
        initComponents();
        this.frame.setVisible(true);
    }
    
    private void initComponents() {
        if (charts.size() == 1)
            frame = new JFrame("Hydrophobicity Plot");
        else
            frame = new JFrame("Hydrophobicity Plots");
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 700);
        
        JPanel panel = new JPanel();
        panel.setSize(frame.getSize());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (ChartPanel chart: charts) {
            panel.add(chart.getPanel());
        }
        JScrollPane scrollpane = new JScrollPane(panel);
        frame.add(scrollpane);
        frame.pack();
    }
    
    
}
