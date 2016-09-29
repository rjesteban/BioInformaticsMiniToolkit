/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author rj
 */
public class TranslatedProteinsOutputUI extends javax.swing.JFrame {

    /**
     * Creates new form TranslatedProteins
     */
    public TranslatedProteinsOutputUI(String fileName, String fastaContent) {
        initComponents();
        initializeContents(fileName, fastaContent);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        fastaContentTextArea = new javax.swing.JTextArea();
        proteinEquivalentLabel = new javax.swing.JLabel();
        exportAsFASTAFileButton = new javax.swing.JButton();
        goBackToStep2Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fastaContentTextArea.setEditable(false);
        fastaContentTextArea.setColumns(20);
        fastaContentTextArea.setRows(5);
        jScrollPane1.setViewportView(fastaContentTextArea);

        proteinEquivalentLabel.setText("Protein Equivalent for:");

        exportAsFASTAFileButton.setText("Export as FASTA File");
        exportAsFASTAFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAsFASTAFileButtonActionPerformed(evt);
            }
        });

        goBackToStep2Button.setText("Go back");
        goBackToStep2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackToStep2ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proteinEquivalentLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exportAsFASTAFileButton)
                        .addGap(18, 18, 18)
                        .addComponent(goBackToStep2Button)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(proteinEquivalentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportAsFASTAFileButton)
                    .addComponent(goBackToStep2Button))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportAsFASTAFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAsFASTAFileButtonActionPerformed
        String sb = this.fastaContentTextArea.getText();
        JFileChooser chooser = new JFileChooser();
        int retrival = chooser.showSaveDialog(this.fastaContentTextArea);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try {
                FileWriter fw = new FileWriter(chooser.getSelectedFile()+".FASTA");
                fw.write(sb.toString());
                fw.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_exportAsFASTAFileButtonActionPerformed

    private void goBackToStep2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackToStep2ButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_goBackToStep2ButtonActionPerformed

    private void initializeContents(String fileName, String fastaContent) {
        this.proteinEquivalentLabel.setText(
                this.proteinEquivalentLabel.getText() + " " + fileName);
        this.fastaContentTextArea.setText(fastaContent);
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportAsFASTAFileButton;
    private javax.swing.JTextArea fastaContentTextArea;
    private javax.swing.JButton goBackToStep2Button;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel proteinEquivalentLabel;
    // End of variables declaration//GEN-END:variables
}