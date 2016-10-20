/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.UIManager;

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
     * @param fastaInput FASTA input from text area
     * @return hydrophobicity scale
     */
    public double[] getHydrophobicity(int sni, int sw, String fastaInput) {
        String sequence = fastaInput;
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
