/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author rj
 */
public class FrequencyTable extends javax.swing.JFrame {

    /**
     * Creates new form FrequencyTable
     * @param a
     * @param c
     * @param t
     * @param g
     */
    public FrequencyTable(int a, int c, int t, int g) {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fillTable(a,c,t,g);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        saveAsJPGButton = new javax.swing.JButton();
        backButton = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Nucleotide Count for the DNA Sequence");

        saveAsJPGButton.setText("Save AS JPG");
        saveAsJPGButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsJPGButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(saveAsJPGButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(backButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveAsJPGButton)
                    .addComponent(backButton))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveAsJPGButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsJPGButtonActionPerformed
                
        JFileChooser chooser = new JFileChooser();
        int retrival = chooser.showSaveDialog(this.jLabel1);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage bi = createImage(this.jTable1);
                File outputfile = new File(chooser.getSelectedFile() + ".png");
                ImageIO.write(bi, "png", outputfile);
            } catch (IOException e) {
            }
        }
    }//GEN-LAST:event_saveAsJPGButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    
    private void fillTable(int a, int c, int t, int g) {
        DefaultTableModel tm = new DefaultTableModel();
        double tot = a + c + t + g;
        
        tm.addColumn("Nucleotide");
        tm.addColumn("Frequency");
        tm.addColumn("Percentage");
        
        String[] adenine = {"Adenine", String.valueOf(a), 
            String.format("%.3f",(a/tot*100))};
        String[] cytosine = {"Cytosine", String.valueOf(c), 
            String.format("%.3f",(c/tot*100))};
        
        String[] thymine = {"Thymine", String.valueOf(t),
            String.format("%.3f",(t/tot*100))};

        String[] guanine = {"Guanine", String.valueOf(g), 
            String.format("%.3f",(g/tot*100))};
        
        String[] total = {"Total", String.valueOf(tot), "100.000"};
        
        
        tm.addRow(adenine);
        tm.addRow(cytosine);
        tm.addRow(thymine);
        tm.addRow(guanine);
        tm.addRow(total);
        
        this.jTable1.setModel(tm);
        
    }
    
    public static BufferedImage createImage(JTable table) {
        JTableHeader tableHeaderComp = table.getTableHeader();
        int totalWidth = 370;
        int totalHeight = 101;
        BufferedImage tableImage = new BufferedImage(totalWidth, totalHeight,
            BufferedImage.TYPE_INT_RGB);
        Graphics2D g2D = (Graphics2D) tableImage.getGraphics();
        tableHeaderComp.paint(g2D);
        g2D.translate(0, tableHeaderComp.getHeight());
        table.paint(g2D);
        return tableImage;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton saveAsJPGButton;
    // End of variables declaration//GEN-END:variables
}
