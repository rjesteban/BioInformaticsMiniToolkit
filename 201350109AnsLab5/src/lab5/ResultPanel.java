package lab5;

import java.awt.Font;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import lab5.logic.Result;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rj
 */
public class ResultPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResultPanel
     * @param l
     * @param s
     */
    public ResultPanel(List<Result> l, ArrayList<FastaSequence> s) {
        initComponents();
        fillTextArea(l, s);
        resultTextArea.setFont(new Font("Monospaced", Font.PLAIN, 13));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SaveOutputButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTextArea = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(750, 500));

        SaveOutputButton.setText("Save output");
        SaveOutputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveOutputButtonActionPerformed(evt);
            }
        });

        resultTextArea.setEditable(false);
        resultTextArea.setColumns(20);
        resultTextArea.setRows(5);
        resultTextArea.setPreferredSize(new java.awt.Dimension(745, 577));
        jScrollPane1.setViewportView(resultTextArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SaveOutputButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SaveOutputButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SaveOutputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveOutputButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int retrival = chooser.showSaveDialog(this);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt");
                fw.write(this.resultTextArea.getText());
                fw.close();
            } catch (Exception ex) {}
        }
    }//GEN-LAST:event_SaveOutputButtonActionPerformed

    
    private void fillTextArea(List<Result> rs, ArrayList<FastaSequence> sq) {
        String output = "";
        
        output += "Pairwise Sequence Alignment ver. 1.0 by Arnold Joseph Caesar P. Esteban (2013-50109)\n";
        output += "Run date:" + new SimpleDateFormat("dd-MM-yyyy hh:mm a").format(new Date()) + "\n\n";
        output += "Submitted sequences:\n";
        output += sq.get(0).comment + "\n";
        output += getSequenceFormatBy10(sq.get(0).sequence) + "\n\n";
        
        output += sq.get(1).comment + "\n";
        output += getSequenceFormatBy10(sq.get(1).sequence) + "\n\n";
        
        output += sq.get(0).comment + "\nlength: " + sq.get(0).sequence.length() + "\n";
        output += sq.get(1).comment + "\nlength: " + sq.get(1).sequence.length() + "\n";
        
        output += "Frequency Occurence:\n";
        output += getOccurences(sq.get(0).sequence, sq.get(1).sequence);
        
        output += "\nOptimal Alignment results\n";
        
        for (Result r:rs) {
            output += getSequenceFormatBy10(r.top) + "\n";
            output += getSequenceFormatBy10(r.mid) + "\n";
            output += getSequenceFormatBy10(r.low) + "\n\n";
        }
        
        output += "SCORE: " + ((!rs.isEmpty())? rs.get(0).score: "not applicable");
        output += "\n";
        
        this.resultTextArea.setRows(output.split("\n").length + 1);
        
        this.resultTextArea.setText(output);
    }
    
    public String getOccurences (String s1, String s2) {
        char[] arr = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L',
            'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','*'};
        String occurences = "SQ:\tS1\tS2\tTotal\n";
        
        for (char c: arr) {
            if (s1.contains(String.valueOf(c)) || s2.contains(String.valueOf(c))) {
                occurences += c + ":\t";
                
                int count1 = 0;
                for (int i = 0; i < s1.length(); i++) {
                    if (s1.charAt(i) == c) {
                        count1++;
                    }
                }
                
                occurences += count1 + "\t";
                
                int count2 = 0;
                for (int i = 0; i < s2.length(); i++) {
                    if (s2.charAt(i) == c) {
                        count2++;
                    }
                }
                
                occurences += count2 + "\t";
                occurences += (count1 + count2) + "\n";
            }
        }
        return occurences;
    }
    
    private String getSequenceFormatBy10(String sequence){
        String seq = "";
        for (int i = 0; i < sequence.length(); i++) {
            if (i % 10 == 0 && i != 0)
                seq += " ";
            seq += sequence.charAt(i);
        }
        return seq;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SaveOutputButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resultTextArea;
    // End of variables declaration//GEN-END:variables
}
