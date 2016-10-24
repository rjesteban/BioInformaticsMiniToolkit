/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import static org.knowm.xchart.BitmapEncoder.getBufferedImage;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;

/**
 *
 * @author rjesteban
 */
public class ChartPanel {
    private XYChart chart;
    private JPanel panel;
    private JButton saveAsPng;
    // private JButton backButton;
    
    public ChartPanel(XYChart chart) {
        this.chart = chart;
        initComponents();
    }
    
    private void initComponents() {
        saveAsPng = new JButton();
        saveAsPng.setText("Save as JPEG/PNG");
        
        saveAsPng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveAsPngActionPerformed(e);
                } catch (IOException ex) {
                    Logger.getLogger(ChartPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        this.panel = new JPanel();
        this.panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        this.panel.add(new XChartPanel(chart));
        this.panel.add(saveAsPng);
    }
    
    private void saveAsPngActionPerformed(java.awt.event.ActionEvent evt) throws IOException {                                           
        JFileChooser chooser = new JFileChooser();
        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage bi = getBufferedImage(chart);
                File outputfile = new File(chooser.getSelectedFile() + ".png");
                ImageIO.write(bi, "png", outputfile);
            } catch (IOException e) {
            }
        }

    }       
    
    public JPanel getPanel() { return this.panel; }
    
}