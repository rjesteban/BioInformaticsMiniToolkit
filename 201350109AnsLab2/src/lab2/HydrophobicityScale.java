/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

/**
 *
 * @author rj
 */
public class HydrophobicityScale {
    private Map<Character, double[]> scale;
    private String[] scaleName;
    private File file;
    
    public HydrophobicityScale() {
        this.initialize();
    }
    
    private void initialize() {
        scale = new HashMap<>();
        scale.put('A', new double[]{1.8, -0.5, 0.2, 0.62, 0.74, 0.3, 1.6});
        scale.put('C', new double[]{2.5, -1, 4.1, 0.29, 0.91, 0.9, 2});
        scale.put('D', new double[]{-3.5, 3, -3.1, -0.9, 0.62, -0.6, -9.2});
        scale.put('E', new double[]{-3.5, 3, -1.8, -0.74, 0.62, -0.7, -8.2});
        scale.put('F', new double[]{2.8, -2.5, 4.4, 1.19, 0.88, 0.5, 3.7});
        scale.put('G', new double[]{-0.4, 0, 0, 0.48, 0.72, 0.3, 1});
        scale.put('H', new double[]{-3.2, -0.5, 0.5, -0.4, 0.78, -0.1, -3});
        scale.put('I', new double[]{4.5, -1.8, 4.8, 1.38, 0.88, 0.7, 3.1});
        scale.put('K', new double[]{-3.9, 3, -3.1, -1.5, 0.52, -1.8, -8.8});
        scale.put('L', new double[]{3.8, -1.8, 5.7, 1.06, 0.85, 0.5, 2.8});
        scale.put('M', new double[]{1.9, -1.3, 4.2, 0.64, 0.85, 0.4, 3.4});
        scale.put('N', new double[]{-3.5, 0.2, -0.5, -0.78, 0.63, -0.5, -4.8});
        scale.put('P', new double[]{-1.6, 0, -2.2, 0.12, 0.64, -0.3, -0.2});
        scale.put('Q', new double[]{-3.5, 0.2, -2.8, -0.85, 0.62, -0.7, -4.1});
        scale.put('R', new double[]{-4.5, 3, 1.4, -2.53, 0.64, -1.4, -12.3});
        scale.put('S', new double[]{-0.8, 0.3, -0.5, -0.18, 0.66, -0.1, 0.6});
        scale.put('T', new double[]{-0.7, -0.4, -1.9, -0.05, 0.7, -0.2, 1.2});
        scale.put('V', new double[]{4.2, -1.5, 4.7, 1.08, 0.86, 0.6, 2.6});
        scale.put('W', new double[]{-0.9, -3.4, 1, 0.81, 0.85, 0.3, 1.9});
        scale.put('Y', new double[]{-1.3, -2.3, 3.2, 0.26, 0.76, -0.4, -0.7});
        setScaleName(new String[]{"Kyle-Doolitle", "Hopp-Woods", "Cornette", 
            "Eisenberg", "Rose", "Janin", "Engelman GES"});
    }
    
    public static void main(String[] args) {
        HydrophobicityScale hps = new HydrophobicityScale();
        double[] b = hps.getHydrophobicity(0, 3, "MEYAT");
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println("");
    }
    
    /**
     * @param sni index of scale to be used
     * @param sw sliding window length
     * @param sequence the sequence
     * @return hydrophobicity scale
     */
    public double[] getHydrophobicity(int sni, int sw, String sequence) {
        double[] hydrophobicity = new double[sequence.length()];
        //double.length - windowLength + 1
        for (int i = sw/2; i <= hydrophobicity.length - sw + 1; i++) {
            double u = 0.0;
            for (int j = i - sw/2, otherHalf = i + sw/2; j <= otherHalf; j++)
                u += this.scale.get(sequence.charAt(j))[sni];
            hydrophobicity[i] = u/sw;
        }
        return hydrophobicity;
    }

    public void generatePlot(int sni, int sw, double threshold, ArrayList<String> fastaInput) {
        if (fastaInput.size() == 1) {
            String sequence = fastaInput.get(0);
            XYChart chart = new XYChartBuilder().width(300).height(200).
                title("Hydrophobicity Plot").xAxisTitle("Index position").
                yAxisTitle("Average Hydrophobicity").build();
            
            
            double[] indexPosition = new double[sequence.length()];
            for (int i = 0; i < indexPosition.length; i++) {
                indexPosition[i] = i + 1;
            }
            
            double[] thresholdValue = new double[indexPosition.length];
            for (int i = 0; i < thresholdValue.length; i++) {
                thresholdValue[i] = threshold;
            }
            
            double[] avgHydrophobicity = this.getHydrophobicity(
                    sni, sw, sequence);
            
            chart.addSeries("Sequence", indexPosition, avgHydrophobicity);
            chart.addSeries("Threshold", indexPosition, thresholdValue);
            
            ChartPanel cp = new ChartPanel(chart);
            ArrayList<ChartPanel> cplist = new ArrayList<ChartPanel>();
            cplist.add(cp);
            ChartGenerator cg = new ChartGenerator(cplist);
        } else {
            ArrayList<ChartPanel> cplist = new ArrayList<ChartPanel>();
            
            for (int i = 1; i < fastaInput.size(); i+=2) {
                String sequence = fastaInput.get(i);
                
                XYChart chart = new XYChartBuilder().width(300).height(200).
                    title("Hydrophobicity plot for " + 
                            fastaInput.get(i - 1).substring(1)).
                        xAxisTitle("Index position").
                        yAxisTitle("Average Hydrophobicity").build();
                
                double[] indexPosition = new double[sequence.length()];
                for (int k = 0; k < indexPosition.length; k++) {
                    indexPosition[k] = k + 1;
                }
                
                double[] thresholdValue = new double[indexPosition.length];
                for (int j=  0; j < thresholdValue.length; j++) {
                    thresholdValue[j] = threshold;
                }
            
                double[] avgHydrophobicity = this.getHydrophobicity(
                        sni, sw, sequence);
                
                chart.addSeries(fastaInput.get(i - 1).substring(1) + "", 
                        indexPosition, avgHydrophobicity);
                chart.addSeries("Threshold", indexPosition, thresholdValue);
                cplist.add(new ChartPanel(chart));
            }
            ChartGenerator cg = new ChartGenerator(cplist);
        }
    }
    
    
  /*
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
    */

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the scaleName
     */
    public String[] getScaleName() {
        return scaleName;
    }

    /**
     * @param scaleName the scaleName to set
     */
    public void setScaleName(String[] scaleName) {
        this.scaleName = scaleName;
    }
}
