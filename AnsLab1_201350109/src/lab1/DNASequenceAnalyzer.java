package lab1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.knowm.xchart.*;
import static org.knowm.xchart.BitmapEncoder.getBufferedImage;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author localuser
 */
public final class DNASequenceAnalyzer {
    private Codon[][][] lookupTable;
    private Map<Character, Integer> codeMap;
    private File file;
    
    public DNASequenceAnalyzer() {
        this.codeMap = new HashMap<Character, Integer>();
        this.initialize();
    }
    
    public void setFile(File file) { this.file = file; }
    public File getFile() { return this.file; }
      
    public void initialize() {
        this.codeMap.put('t', 0);
        this.codeMap.put('c', 1);
        this.codeMap.put('a', 2);
        this.codeMap.put('g', 3);
        
        // '0' stands for stop
        
        this.lookupTable = new Codon[4][4][4];
        
        //================================T===============================
        this.lookupTable[0][0][0] = new Codon("ttt", 'F', "Phenylalanine");
        this.lookupTable[0][0][1] = new Codon("ttc", 'F', "Phenylalanine");
        this.lookupTable[0][0][2] = new Codon("tta", 'L', "Leucine");
        this.lookupTable[0][0][3] = new Codon("ttg", 'L', "Leucine");

        this.lookupTable[0][1][0] = new Codon("tct", 'S', "Serine");
        this.lookupTable[0][1][1] = new Codon("tcc", 'S', "Serine");
        this.lookupTable[0][1][2] = new Codon("tca", 'S', "Serine");
        this.lookupTable[0][1][3] = new Codon("tcg", 'S', "Serine");

        this.lookupTable[0][2][0] = new Codon("tat", 'Y', "Tyrosine");
        this.lookupTable[0][2][1] = new Codon("tac", 'Y', "Tyrosine");
        this.lookupTable[0][2][2] = new Codon("taa", '*', "Stop");
        this.lookupTable[0][2][3] = new Codon("tag", '*', "Stop");

        this.lookupTable[0][3][0] = new Codon("tgt", 'C', "Cysteine");
        this.lookupTable[0][3][1] = new Codon("tgc", 'C', "Cysteine");
        this.lookupTable[0][3][2] = new Codon("tga", '*', "Stop");
        this.lookupTable[0][3][3] = new Codon("tgg", 'W', "Typtophan");

        //================================C===============================
        this.lookupTable[1][0][0] = new Codon("ctt", 'L', "Leucine");
        this.lookupTable[1][0][1] = new Codon("ctc", 'L', "Leucine");
        this.lookupTable[1][0][2] = new Codon("cta", 'L', "Leucine");
        this.lookupTable[1][0][3] = new Codon("ctg", 'L', "Leucine");

        this.lookupTable[1][1][0] = new Codon("cct", 'P', "Phenylalanine");
        this.lookupTable[1][1][1] = new Codon("ccc", 'P', "Phenylalanine");
        this.lookupTable[1][1][2] = new Codon("cca", 'P', "Phenylalanine");
        this.lookupTable[1][1][3] = new Codon("ccg", 'P', "Phenylalanine");

        this.lookupTable[1][2][0] = new Codon("cat", 'H', "Hisitidine");
        this.lookupTable[1][2][1] = new Codon("cac", 'H', "Hisitidine");
        this.lookupTable[1][2][2] = new Codon("caa", 'Q', "Glutamine");
        this.lookupTable[1][2][3] = new Codon("cag", 'Q', "Glutamine");

        this.lookupTable[1][3][0] = new Codon("cgt", 'R', "Arginine");
        this.lookupTable[1][3][1] = new Codon("cgc", 'R', "Arginine");
        this.lookupTable[1][3][2] = new Codon("cga", 'R', "Arginine");
        this.lookupTable[1][3][3] = new Codon("cgg", 'R', "Arginine");

        //================================A===============================
        this.lookupTable[2][0][0] = new Codon("att", 'I', "Isoleucine");
        this.lookupTable[2][0][1] = new Codon("atc", 'I', "Isoleucine");
        this.lookupTable[2][0][2] = new Codon("ata", 'I', "Isoleucine");
        this.lookupTable[2][0][3] = new Codon("atg", 'M', "Start");

        this.lookupTable[2][1][0] = new Codon("act", 'T', "Threonine");
        this.lookupTable[2][1][1] = new Codon("acc", 'T', "Threonine");
        this.lookupTable[2][1][2] = new Codon("aca", 'T', "Threonine");
        this.lookupTable[2][1][3] = new Codon("acg", 'T', "Threonine");

        this.lookupTable[2][2][0] = new Codon("aat", 'N', "Asparagine");
        this.lookupTable[2][2][1] = new Codon("aac", 'N', "Asparagine");
        this.lookupTable[2][2][2] = new Codon("aaa", 'K', "Lysine");
        this.lookupTable[2][2][3] = new Codon("aag", 'K', "Lysine");

        this.lookupTable[2][3][0] = new Codon("agt", 'S', "Serine");
        this.lookupTable[2][3][1] = new Codon("agc", 'S', "Serine");
        this.lookupTable[2][3][2] = new Codon("aga", 'R', "Arginine");
        this.lookupTable[2][3][3] = new Codon("agg", 'R', "Arginine");

        //================================G===============================
        this.lookupTable[3][0][0] = new Codon("gtt", 'V', "Valine");
        this.lookupTable[3][0][1] = new Codon("gtc", 'V', "Valine");
        this.lookupTable[3][0][2] = new Codon("gta", 'V', "Valine");
        this.lookupTable[3][0][3] = new Codon("gtg", 'V', "Valine");

        this.lookupTable[3][1][0] = new Codon("gct", 'A', "Alanine");
        this.lookupTable[3][1][1] = new Codon("gcc", 'A', "Alanine");
        this.lookupTable[3][1][2] = new Codon("gca", 'A', "Alanine");
        this.lookupTable[3][1][3] = new Codon("gcg", 'A', "Alanine");

        this.lookupTable[3][2][0] = new Codon("gat", 'D', "Aspartic Acid");
        this.lookupTable[3][2][1] = new Codon("gac", 'D', "Aspartic Acid");
        this.lookupTable[3][2][2] = new Codon("gaa", 'E', "Glutamic Acid");
        this.lookupTable[3][2][3] = new Codon("gag", 'E', "Glutamic Acid");

        this.lookupTable[3][3][0] = new Codon("ggt", 'G', "Glycine");
        this.lookupTable[3][3][1] = new Codon("ggc", 'G', "Glycine");
        this.lookupTable[3][3][2] = new Codon("gga", 'G', "Glycine");
        this.lookupTable[3][3][3] = new Codon("ggg", 'G', "Glycine");
    }
    
    public Codon getCodon(String seq) {
        int a = this.codeMap.get(seq.charAt(0));
        int b = this.codeMap.get(seq.charAt(1));
        int c = this.codeMap.get(seq.charAt(2));
        return lookupTable[a][b][c];
    }
    
    public String translateToProtein(String sequence) {
        sequence = sequence.toLowerCase();
        String proteinSequence = "";
        
        for (int i = 0, length = sequence.length(); i <= length - 3; i+=3) {
            Codon c = this.getCodon(sequence.substring(i, i + 3));
            proteinSequence += String.valueOf(c.getCode());
        }
        
        return proteinSequence;
    }
    
    public void showFrequencyTable(String dna) {
        int a = 0, c = 0, 
                t = 0, g = 0;

        dna = dna.toLowerCase();
        for (int i = 0, n = dna.length(); i < n; i++) {
            if (dna.charAt(i) == 'a')
                a++;
            else if (dna.charAt(i) == 'c')
                c++;
            else if (dna.charAt(i) == 'g')
                g++;
            else if (dna.charAt(i) == 't')
                t++;
        }
        
        new FrequencyTable(a, c, t, g).setVisible(true);
    }
    
    
    public void showGraph(String s){
        String[] textAreaValue = s.split("\n");
        String output = "";
        String input = "";
        ArrayList<String> dna =  new ArrayList<String>();
        
        for (int i = 0, n = textAreaValue.length; i < n; i++) {
            if (textAreaValue[i].startsWith(">")) {
                if (!input.equals("")) {
                    // output += this.analyzer.translateToProtein(input) + "\r\n";
                    dna.add(input);
                    input = "";
                }
                output += textAreaValue[i] + "_PROTEIN_EQUIVALENT\r\n";
            }  else {
                    input += textAreaValue[i];
            }
        }
        if (!input.equals("")) {
            // output += this.analyzer.translateToProtein(input) + "\r\n";
            dna.add(input);
            input = "";
        }
        
        
        
        XYChart chart = new XYChartBuilder().width(400).height(300).
                title("Nucleotide Trend").xAxisTitle("Position").
                yAxisTitle("Count").build();
        
        
        int max = this.max(dna);
        
        double[] a = new double[max];
        double[] c = new double[max];
        double[] t = new double[max];
        double[] g = new double[max];
        double[] position = new double[max];
        
        for (int i = 0; i < max; i++) {
            position[i] = i + 1;
        }
            
        for (int pos = 0; pos < max; pos++) {
            for (int seq = 0, n = dna.size(); seq < n; seq++) {
                if (pos < dna.get(seq).length()) {
                char cc = dna.get(seq).charAt(pos);
                    if (cc == 'a' || cc == 'A')
                        a[pos]++;
                    if (cc == 'c' || cc == 'C')
                        c[pos]++;
                    if (cc == 't' || cc == 'T')
                        t[pos]++;
                    if (cc == 'g' || cc == 'G')
                        g[pos]++;
                }
            }
        }
            
        chart.addSeries("Adenine", position, a);
        chart.addSeries("Cytosine", position, c);
        chart.addSeries("Thymine", position, t);
        chart.addSeries("Guanine", position, g);
        
        
        ChartFrame cf = new ChartFrame(chart);
        
    }    
    
    
    private int max(ArrayList<String> dna) {
        int max = 0;
        for (String d: dna) {
            int n = d.length();
            if (n > max)
                max = n;
        }
        return max;
    }
}

class Codon {
    String sequence;
    String name;
    char code;
    
    public Codon (String sequence, char code, String name){
        this.name = name;
        this.sequence = sequence;
        this.code = code;
    }
    
    public String getSequence() {
        return this.sequence;
    }
    
    public char getCode() { return this.code; }
}

class ChartFrame {
    private XYChart chart;
    private JFrame frame;
    private JPanel panel;
    private JButton saveAsPng;
    private JButton backButton;
    
    public ChartFrame(XYChart chart) {
        this.chart = chart;
        initComponents();
        frame.setVisible(true);
    }
    
    private void initComponents() {
        saveAsPng = new JButton();
        saveAsPng.setText("Save as JPEG/PNG");
        
        backButton = new JButton();
        backButton.setText("Back");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backButtonActionPerformed(e);
            }
        });
        
        saveAsPng.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    saveAsPngActionPerformed(e);
                } catch (IOException ex) {
                    Logger.getLogger(ChartFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        frame = new JFrame("Chart");
        frame.setSize(800, 600);
        
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panel = new JPanel();
        
        frame.add(panel);
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new XChartPanel(chart));
        panel.add(saveAsPng);
        panel.add(backButton);
    }

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        this.frame.dispose();
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
    
}