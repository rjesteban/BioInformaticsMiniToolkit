/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author rj
 */
public class AnsLabJPanel extends javax.swing.JPanel {
    private DNASequenceAnalyzer analyzer;
    static public final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    
    /**
     * Creates new form AnsLabJPanel
     */
    public AnsLabJPanel() {
        initComponents();
        this.analyzer = new DNASequenceAnalyzer();
        
        addKeyListenerToTextArea();
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
        inputFastaArea = new javax.swing.JTextArea();
        title = new javax.swing.JLabel();
        uploadFastaFileButton = new javax.swing.JButton();
        translateToProteinSequencesButton = new javax.swing.JButton();
        step1Label = new javax.swing.JLabel();
        frequencyPercentageTable = new javax.swing.JButton();
        trendNucleotideSequencesButton = new javax.swing.JButton();
        proceedToStep2Button = new javax.swing.JButton();
        resetInputButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();
        step2Label = new javax.swing.JLabel();
        resetAndGoBackToStep1Button = new javax.swing.JButton();
        goBackToStep1 = new javax.swing.JButton();

        inputFastaArea.setColumns(20);
        inputFastaArea.setRows(5);
        jScrollPane1.setViewportView(inputFastaArea);

        title.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        title.setText("DNA SEQUENCE PROCESSING AND ANALYSIS");

        uploadFastaFileButton.setText("Upload FASTA file");
        uploadFastaFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFastaFileButtonActionPerformed(evt);
            }
        });

        translateToProteinSequencesButton.setText("Translate to Protein Sequences");
        translateToProteinSequencesButton.setEnabled(false);
        translateToProteinSequencesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateToProteinSequencesButtonActionPerformed(evt);
            }
        });

        step1Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        step1Label.setText("Step 1:");

        frequencyPercentageTable.setText("Frequency and Percentage Table");
        frequencyPercentageTable.setEnabled(false);
        frequencyPercentageTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                frequencyPercentageTableActionPerformed(evt);
            }
        });

        trendNucleotideSequencesButton.setText("Trend of Nucleotide Sequences");
        trendNucleotideSequencesButton.setEnabled(false);
        trendNucleotideSequencesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trendNucleotideSequencesButtonActionPerformed(evt);
            }
        });

        proceedToStep2Button.setText("Proceed to step 2");
        proceedToStep2Button.setEnabled(false);
        proceedToStep2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proceedToStep2ButtonActionPerformed(evt);
            }
        });

        resetInputButton.setText("Reset Input");
        resetInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetInputButtonActionPerformed(evt);
            }
        });

        quitButton.setBackground(new java.awt.Color(255, 51, 51));
        quitButton.setText("QUIT");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        step2Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        step2Label.setText("Step 2:");

        resetAndGoBackToStep1Button.setText("Reset And Go Back to Step 1");
        resetAndGoBackToStep1Button.setEnabled(false);
        resetAndGoBackToStep1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetAndGoBackToStep1ButtonActionPerformed(evt);
            }
        });

        goBackToStep1.setText("Go Back to Step 1");
        goBackToStep1.setEnabled(false);
        goBackToStep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackToStep1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(goBackToStep1)
                .addGap(61, 61, 61)
                .addComponent(resetAndGoBackToStep1Button)
                .addGap(103, 103, 103))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(step1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uploadFastaFileButton)
                                .addGap(18, 18, 18)
                                .addComponent(proceedToStep2Button)
                                .addGap(18, 18, 18)
                                .addComponent(resetInputButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quitButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(translateToProteinSequencesButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(frequencyPercentageTable)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(trendNucleotideSequencesButton))
                                    .addComponent(step2Label))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(quitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addComponent(step1Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uploadFastaFileButton)
                    .addComponent(proceedToStep2Button)
                    .addComponent(resetInputButton))
                .addGap(51, 51, 51)
                .addComponent(step2Label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(translateToProteinSequencesButton)
                    .addComponent(frequencyPercentageTable)
                    .addComponent(trendNucleotideSequencesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetAndGoBackToStep1Button)
                    .addComponent(goBackToStep1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void translateToProteinSequencesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateToProteinSequencesButtonActionPerformed
        String[] textAreaValue = this.inputFastaArea.getText().split("\n");
        String output = "";
        String input = "";
        
        for (int i = 0, n = textAreaValue.length; i < n; i++) {
            if (textAreaValue[i].startsWith(">")) {
                if (!input.equals("")) {
                    output += this.analyzer.translateToProtein(input) + "\r\n";
                    input = "";
                }
                output += textAreaValue[i] + "_PROTEIN_EQUIVALENT\r\n";
            }  else {
                    input += textAreaValue[i];
            }
        }
        if (!input.equals("")) {
            output += this.analyzer.translateToProtein(input) + "\r\n";
            input = "";
        }
        
        new TranslatedProteinsOutputUI(this.analyzer.getFile().getName(), 
                output).setVisible(true);
    }//GEN-LAST:event_translateToProteinSequencesButtonActionPerformed

    private void uploadFastaFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFastaFileButtonActionPerformed
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(title);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.analyzer.setFile(fc.getSelectedFile());
            //This is where a real application would open the file.
            String input = "";
            try {
            Scanner sc = new Scanner(this.analyzer.getFile());
            while(sc.hasNextLine()) {
                input += sc.nextLine() + "\n";
            }
            this.inputFastaArea.setText(input);
            this.proceedToStep2Button.setEnabled(true);
            
            } catch(FileNotFoundException fne){}
        } else {
            System.out.println("operation cancelled");
        }
        
    }//GEN-LAST:event_uploadFastaFileButtonActionPerformed

   
     
    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void resetInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetInputButtonActionPerformed
        this.inputFastaArea.setText("");
        this.checkInput();
    }//GEN-LAST:event_resetInputButtonActionPerformed
   
    private void enableStep1Buttons() {
        this.inputFastaArea.setEnabled(true);
        this.uploadFastaFileButton.setEnabled(true);
        this.proceedToStep2Button.setEnabled(true);
        this.resetInputButton.setEnabled(true);
    }
    
    private void disableStep1Buttons() {
        this.inputFastaArea.setEnabled(false);
        this.uploadFastaFileButton.setEnabled(false);
        this.proceedToStep2Button.setEnabled(false);
        this.resetInputButton.setEnabled(false);
    }
    
    private void enableStep2Buttons() {
        this.translateToProteinSequencesButton.setEnabled(true);
        this.frequencyPercentageTable.setEnabled(true);
        this.trendNucleotideSequencesButton.setEnabled(true);
        this.resetAndGoBackToStep1Button.setEnabled(true);
        this.goBackToStep1.setEnabled(true);
    }
    
    private void disableStep2Buttons() {
        this.translateToProteinSequencesButton.setEnabled(false);
        this.frequencyPercentageTable.setEnabled(false);
        this.trendNucleotideSequencesButton.setEnabled(false);
        this.resetAndGoBackToStep1Button.setEnabled(false);
        this.goBackToStep1.setEnabled(false);
    }
    
    private void proceedToStep2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proceedToStep2ButtonActionPerformed
        this.disableStep1Buttons();
        this.enableStep2Buttons();
    }//GEN-LAST:event_proceedToStep2ButtonActionPerformed

    private void resetAndGoBackToStep1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetAndGoBackToStep1ButtonActionPerformed
        this.enableStep1Buttons();
        this.inputFastaArea.setText("");
        this.checkInput();
        this.disableStep2Buttons();
    }//GEN-LAST:event_resetAndGoBackToStep1ButtonActionPerformed

    private void goBackToStep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackToStep1ActionPerformed
        this.enableStep1Buttons();
        this.disableStep2Buttons();
    }//GEN-LAST:event_goBackToStep1ActionPerformed

    private void frequencyPercentageTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_frequencyPercentageTableActionPerformed
        String[] text = this.inputFastaArea.getText().split("\n");
        String dna = "";
        for (String t: text) {
            if (!t.startsWith(">"))
                dna += t;
        }
        
        this.analyzer.showFrequencyTable(dna);
        
    }//GEN-LAST:event_frequencyPercentageTableActionPerformed

    private void trendNucleotideSequencesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trendNucleotideSequencesButtonActionPerformed
        this.analyzer.showGraph(this.inputFastaArea.getText());
    }//GEN-LAST:event_trendNucleotideSequencesButtonActionPerformed

    
    private void addKeyListenerToTextArea(){
        inputFastaArea.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                checkInput();
            }
        });
    
    }
    
    private void checkInput(){
        if (this.inputFastaArea.getText().isEmpty())
            this.proceedToStep2Button.setEnabled(false);
        else
            this.proceedToStep2Button.setEnabled(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton frequencyPercentageTable;
    private javax.swing.JButton goBackToStep1;
    private javax.swing.JTextArea inputFastaArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton proceedToStep2Button;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton resetAndGoBackToStep1Button;
    private javax.swing.JButton resetInputButton;
    private javax.swing.JLabel step1Label;
    private javax.swing.JLabel step2Label;
    private javax.swing.JLabel title;
    private javax.swing.JButton translateToProteinSequencesButton;
    private javax.swing.JButton trendNucleotideSequencesButton;
    private javax.swing.JButton uploadFastaFileButton;
    // End of variables declaration//GEN-END:variables
}
