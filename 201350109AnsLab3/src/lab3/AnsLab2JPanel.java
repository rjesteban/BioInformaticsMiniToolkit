/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author rj
 */
public class AnsLab2JPanel extends javax.swing.JPanel {
    private HydrophobicityScale scale;
    private ArrayList<String> sequences;
    
    
    /**
     * Creates new form AnsLab2JPanel
     */
    public AnsLab2JPanel() {
        scale = new HydrophobicityScale();
        initComponents();
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

        uploadFastaButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputFastaArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        resetInputButton = new javax.swing.JButton();
        generatePlotButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        windowLengthComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        scaleComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        thresholdSlider = new javax.swing.JSlider();
        defaultSettingsButton = new javax.swing.JButton();
        quitButton = new javax.swing.JButton();

        uploadFastaButton.setText("Upload Fasta");
        uploadFastaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFastaButtonActionPerformed(evt);
            }
        });

        inputFastaArea.setColumns(20);
        inputFastaArea.setRows(5);
        jScrollPane1.setViewportView(inputFastaArea);

        jLabel1.setText("Paste Sequence Here:");

        resetInputButton.setText("Reset Input");
        resetInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetInputButtonActionPerformed(evt);
            }
        });

        generatePlotButton.setText("Generate Plot");
        generatePlotButton.setEnabled(false);
        generatePlotButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generatePlotButtonActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        jLabel2.setText("Sliding Window Length:");

        String[] length = new String[25];

        for (int i = 0, c = 3; c <= 51; i++, c+=2){
            length[i] = String.valueOf(c);
        }
        windowLengthComboBox.setModel(new javax.swing.DefaultComboBoxModel(length));
        windowLengthComboBox.setSelectedItem("19");

        jLabel3.setText("Hydrophobicity Scale:");

        scaleComboBox.setModel(new javax.swing.DefaultComboBoxModel(this.scale.getScaleName()));

        jLabel4.setText("Average Hydrophobicity Threshold");

        defaultSettingsButton.setText("Default Settings");
        defaultSettingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultSettingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thresholdSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defaultSettingsButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(25, 25, 25)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scaleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(windowLengthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(windowLengthComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(scaleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(thresholdSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(defaultSettingsButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Dictionary labelTable = new Dict();
        thresholdSlider.setMinimum(5);
        thresholdSlider.setMaximum(25);
        thresholdSlider.setMajorTickSpacing(5);
        thresholdSlider.setMinorTickSpacing(1);
        labelTable.put(5, new JLabel("0.5"));
        labelTable.put(10, new JLabel("1.0"));
        labelTable.put(15, new JLabel("1.5"));
        labelTable.put(20, new JLabel("2.0"));
        labelTable.put(25, new JLabel("2.5"));
        thresholdSlider.setLabelTable(labelTable);
        thresholdSlider.setPaintTicks(true);
        thresholdSlider.setPaintLabels(true);
        thresholdSlider.setSnapToTicks(true);
        thresholdSlider.setValue(10);

        quitButton.setBackground(new java.awt.Color(255, 0, 51));
        quitButton.setText("QUIT");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(generatePlotButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(uploadFastaButton)
                                        .addGap(63, 63, 63)
                                        .addComponent(resetInputButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quitButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(quitButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uploadFastaButton)
                            .addComponent(resetInputButton)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(generatePlotButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void uploadFastaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFastaButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            this.scale.setFile(fc.getSelectedFile());
            //This is where a real application would open the file.
            String input = "";
            try {
            Scanner sc = new Scanner(this.scale.getFile());
            while(sc.hasNextLine()) {
                input += sc.nextLine() + "\n";
            }
            this.inputFastaArea.setText(input);
//            this.proceedToStep2Button.setEnabled(true);
            
            } catch(FileNotFoundException fne){}
        } else {
            System.out.println("operation cancelled");
        }

    }//GEN-LAST:event_uploadFastaButtonActionPerformed

    private void resetInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetInputButtonActionPerformed
        this.inputFastaArea.setText("");
        this.checkInput();
    }//GEN-LAST:event_resetInputButtonActionPerformed

    private void defaultSettingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultSettingsButtonActionPerformed
        windowLengthComboBox.setSelectedItem("19");
        thresholdSlider.setValue(10);
        scaleComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_defaultSettingsButtonActionPerformed

    private void generatePlotButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generatePlotButtonActionPerformed
        //sni, sw, arraylist
        int sni = this.scaleComboBox.getSelectedIndex();
        int sw = Integer.valueOf(String.valueOf(this.windowLengthComboBox.getSelectedItem()));
        double threshold = this.thresholdSlider.getValue()/10.0;
        this.scale.generatePlot(sni, sw, threshold, sequences);
    }//GEN-LAST:event_generatePlotButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    
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
        
        inputFastaArea.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                checkInput();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                checkInput();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                checkInput();
            }
        });
    }
    
    private void checkInput() {
        if (this.inputFastaArea.getText().isEmpty() || !this.loadFastaInput()) {
            this.generatePlotButton.setEnabled(false);
        }
        else {
            this.generatePlotButton.setEnabled(true);
        }
    
    }
    
   
    private boolean loadFastaInput () {
        String[] text = this.inputFastaArea.getText().toUpperCase().split("\n");
        ArrayList<String> fastaSequences = new ArrayList<String>();
        
        if (text[0].startsWith(">"))
            fastaSequences.add(text[0]);
        else if (text[0].startsWith("M"))
            fastaSequences.add(text[0]);
        else
            return false;        
        
        for (int i = 1; i < text.length; i++) {
            if (fastaSequences.get(fastaSequences.size() - 1).startsWith(">")) {
                if (!text[i].startsWith("M") || text[i].startsWith(">"))
                    return false;
                else
                    fastaSequences.add(text[i]);
            } else {
                int n = fastaSequences.size() - 1;
                if (!text[i].startsWith(">"))
                    fastaSequences.set(n, fastaSequences.get(n) + text[i]);
                else
                    fastaSequences.add(text[i]);
            }
        }
        
        if (fastaSequences.get(fastaSequences.size() - 1).startsWith(">")) {
            return false;
        }
        this.sequences = fastaSequences;
        return true;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton defaultSettingsButton;
    private javax.swing.JButton generatePlotButton;
    private javax.swing.JTextArea inputFastaArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton resetInputButton;
    private javax.swing.JComboBox scaleComboBox;
    private javax.swing.JSlider thresholdSlider;
    private javax.swing.JButton uploadFastaButton;
    private javax.swing.JComboBox windowLengthComboBox;
    // End of variables declaration//GEN-END:variables
}

class Dict extends Dictionary {
    private Map<Object, Object> dict;
    
    public Dict() {
        dict = new HashMap<>();
    }

    @Override
    public int size() {
        return dict.size();
    }

    @Override
    public boolean isEmpty() {
        return dict.isEmpty();
    }

    @Override
    public Enumeration keys() {
        return Collections.enumeration(dict.keySet());
    }

    @Override
    public Enumeration elements() {
        return Collections.enumeration(dict.values());
    }

    @Override
    public Object get(Object key) {
        return dict.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return dict.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return dict.remove(key);
    }
}
