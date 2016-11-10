/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.io.File;
import java.util.ArrayList;
import org.knowm.xchart.style.markers.None;
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
        
    /**
     * @param sni index of scale to be used
     * @param sw sliding window length
     * @param sequence the sequence
     * @return hydrophobicity scale
     */
    public double[] getHydrophobicity(int sni, int sw, String sequence) {
        int diff = (sw/2)*2;
        double[] hydrophobicity = new double[sequence.length() - diff];
        /*
        for (int i = sw/2; i <= hydrophobicity.length - sw + 1; i++) {
            double u = 0.0;
            for (int j = i - sw/2, otherHalf = i + sw/2; j <= otherHalf; j++)
                u += this.scale.get(sequence.charAt(j))[sni];
            hydrophobicity[i] = u/sw;
        }
        */
        for (int i = 0; i < hydrophobicity.length; i++) {
            double u = 0.0;
            for (int j = i, ctr = 0; ctr < sw; j++, ctr++) {
                u += this.scale.get(sequence.charAt(j))[sni];
            }
            hydrophobicity[i] = u/sw;
        }
        
        return hydrophobicity;
    }

    public void generatePlot(int sni, int sw, double threshold, 
            ArrayList<ProteinFastaSequence> fastaInput) {
        ArrayList<ChartPanel> cplist = new ArrayList<>();

        for (ProteinFastaSequence prot : fastaInput) {
            if (sw > prot.sequence.length()) {
                cplist.add(new ChartPanel(prot.comment + " output:"
                        + " Sequence length < Sliding Window Length"));
            } 
            else if (!prot.isProtein()) {
                cplist.add(new ChartPanel(prot.comment + " output:"
                        + "Input is not protein"));
            }
            else if (prot.comment == null) {
                cplist.add(new ChartPanel("output:"
                        + "Input is not in FASTA FORMAT"));
            }
            else {
                XYChart chart = new XYChartBuilder().width(700).height(700).
                        title("Hydrophobicity plot for " + prot.comment).
                        xAxisTitle("Index position").
                        yAxisTitle("Average Hydrophobicity").
                        build();
                double[] indexPosition = new double[prot.sequence.length()];
                for (int k = 0; k < indexPosition.length; k++) {
                    indexPosition[k] = k + 1;
                }
                double[] thresholdValue = new double[indexPosition.length];
                for (int j=  0; j < thresholdValue.length; j++) {
                    thresholdValue[j] = threshold;
                }
                double[] avgHydrophobicity = this.getHydrophobicity(
                        sni, sw, prot.sequence);
                double[] indices = new double[avgHydrophobicity.length];
                for (int k = 0, j = (sw / 2) + 1; k < indices.length; k++, j++) {
                    indices[k] = j;
                }
                if (indices.length > 1) {
                    chart.addSeries(prot.getID() + "", indices, avgHydrophobicity).setMarker(new None());
                } else {
                    chart.addSeries(prot.getID() + "", indices, avgHydrophobicity);
                }
                chart.addSeries("Threshold", indexPosition, thresholdValue).setMarker(new None());
                // add line
                double max = this.getMax(avgHydrophobicity);
                for (int j = 0, trendCount = 0; j < avgHydrophobicity.length - 3; j++) {
                    ArrayList<Double> trendX = new ArrayList<>();
                    for (int k = j, c = 0; k < avgHydrophobicity.length; k++, c++) {
                        j = k;
                        if (avgHydrophobicity[j] > threshold) {
                            trendX.add(indices[j]);
                        } else
                            break;
                    }
                    if (trendX.size() >= sw) {
                        ArrayList<Double> trendY = new ArrayList<>();
                        for (int k = 0; k < trendX.size(); k++) {
                            trendY.add(max + 0.5);
                        }
                        chart.addSeries("Trend #" + ++trendCount, 
                                trendX, trendY).setMarker(new None());
                    }
                }
                cplist.add(new ChartPanel(chart));
            }
        } // END FOR

        ChartGenerator cg = new ChartGenerator(cplist);
    }

    private double getMax(double[] array) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i])
                max = array[i];
        }
        return max;
    }
    
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String[] getScaleName() {
        return scaleName;
    }

    public void setScaleName(String[] scaleName) {
        this.scaleName = scaleName;
    }
}
