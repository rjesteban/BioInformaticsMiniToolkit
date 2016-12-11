package lab5.logic;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2013-50109 Esteban, Arnold Joseph Caesar P.
 */

//http://www.mbio.ncsu.edu/bioedit/tables/

public class ProteinSequenceLookups {
    private static final ProteinSequenceLookups INSTANCE = new ProteinSequenceLookups();
    private int[][] PAM120;
    private int[][] PAM250;
    private int[][] BLOSUM62;
    private int[][] BLOSUM45;
    
    private ProteinSequenceLookups() {
        PAM120 = new int[27][27];
        PAM250 = new int[27][27];
        BLOSUM62 = new int[27][27];
        BLOSUM45 = new int[27][27];
        System.out.println("INSTANCE = " + INSTANCE);
        try {
            initializeMatrices();
        } catch(FileNotFoundException fne) {
            
        }
    }

    public static ProteinSequenceLookups getInstance() {
        return INSTANCE;
    }
    
    
    private void initializeMatrices() throws FileNotFoundException {
        Scanner sc1 = new Scanner(new File("ProteinScoringMatrices/PAM120.csv"));
        Scanner sc2 = new Scanner(new File("ProteinScoringMatrices/PAM250.csv"));
        Scanner sc3 = new Scanner(new File("ProteinScoringMatrices/Blosum62.csv"));
        Scanner sc4 = new Scanner(new File("ProteinScoringMatrices/Blosum45.csv"));
        sc1.nextLine();
        sc2.nextLine();
        sc3.nextLine();
        sc4.nextLine();
        
        for (int r = 0; r < PAM120.length; r++) {
            String[] row1 = sc1.nextLine().split(",");
            String[] row2 = sc2.nextLine().split(",");
            String[] row3 = sc3.nextLine().split(",");
            String[] row4 = sc4.nextLine().split(",");
            for (int c = 0; c < PAM120[0].length; c++) {
                try {
                    PAM120[r][c] = Integer.valueOf(row1[c + 1]);
                    PAM250[r][c] = Integer.valueOf(row2[c + 1]);
                    BLOSUM62[r][c] = Integer.valueOf(row3[c + 1]);
                    BLOSUM45[r][c] = Integer.valueOf(row4[c + 1]);
                } catch (NumberFormatException e) {
                    BLOSUM62[r][c] = PAM250[r][c] = PAM120[r][c] = 
                            Integer.MIN_VALUE;
                }
            }
        }
    }
    
    public void print () {
        System.out.println("==========PAM120==========");
        for (int r = 0; r < PAM120.length; r++) {
            for (int c = 0; c < PAM120[0].length; c++) {
                System.out.print(PAM120[r][c] + "\t");
            }
            System.out.println();
        }
        System.out.println("==========PAM250==========");
        for (int r = 0; r < PAM120.length; r++) {
            for (int c = 0; c < PAM120[0].length; c++) {
                System.out.print(PAM250[r][c] + "\t");
            }
            System.out.println();
        }
        System.out.println("==========BLOSUM62==========");
        for (int r = 0; r < PAM120.length; r++) {
            for (int c = 0; c < PAM120[0].length; c++) {
                System.out.print(BLOSUM62[r][c] + "\t");
            }
            System.out.println();
        }
        System.out.println("==========BLOSUM45==========");
        for (int r = 0; r < PAM120.length; r++) {
            for (int c = 0; c < PAM120[0].length; c++) {
                System.out.print(BLOSUM45[r][c] + "\t");
            }
            System.out.println();
        }
    
    }
    
    public int[][] getLookUp(int name) {
        switch (name) {
            case 0:
                return PAM120;
            case 1:
                return PAM250;
            case 2:
                return BLOSUM62;
            case 3:
                return BLOSUM45;
        }
        return null;
    }
    
}
