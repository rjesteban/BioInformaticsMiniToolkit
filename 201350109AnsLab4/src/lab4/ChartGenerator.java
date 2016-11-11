/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
    private String output;
    
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
        frame.setSize(800, 800);
        
        JPanel panel = new JPanel();
        panel.setSize(frame.getSize());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JButton generateReportButton = new JButton("Generate Report");
        panel.add(generateReportButton);
        
        this.output = "ID\tCount\tStart-End\r\n";
        
        for (ChartPanel chart: charts) {
            panel.add(chart.getPanel());
            if (chart.exception == null || chart.exception.isEmpty()) {
                output += String.format("%s\t%d", chart.id, chart.starts.size());
                for (int i = 0; i < chart.starts.size(); i++)
                    output += String.format("\t%08d-%08d", chart.starts.get(i),
                            chart.ends.get(i));
                output+= "\r\n";
            } else {
                output += chart.exception + "\r\n";
            }
        }
        
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReportButtonPerformed(e);
            }
        });
        
        JScrollPane scrollpane = new JScrollPane(panel);
        frame.add(scrollpane);
        frame.pack();
    }
    
    private void generateReportButtonPerformed(ActionEvent e) {//    String sb = output;
        JFileChooser chooser = new JFileChooser();
        int retrival = chooser.showSaveDialog(this.frame);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
                fw.write(output);
                fw.close();
            } catch (Exception ex) {}
        }
    }
}
