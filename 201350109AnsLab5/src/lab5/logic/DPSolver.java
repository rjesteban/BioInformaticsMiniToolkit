package lab5.logic;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2013-50109 Esteban, Arnold Joseph Caesar P.
 */
public class DPSolver {

    public static String[] solveGlobalAlignment(String s1, String s2,
            int match, int mismatch, int gap) {
        s1 = "-" + s1;
        s2 = "-" + s2;
        int[][] S = new int[s2.length()][s1.length()];
        int[][] tracer = new int[s2.length()][s1.length()];
        
        // initialization
        for (int i = 0; i < S.length; i++) S[i][0] = i*gap;
        for (int j = 0; j < S[0].length; j++) S[0][j] = j*gap;
        
        // fill
        for (int i = 1; i < S.length; i++)
            for (int j = 1; j < S[0].length; j++)
                S[i][j] = max(S, tracer, s1, s2, i, j, match, mismatch, gap);
        
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S[0].length; j++)
                System.out.print(S[i][j] + "\t");
            System.out.println();
        }
        
        // 0 is s1
        // 1 is matching
        // 2 is s2
        String[] result = new String[]{"","",""};
        // trace back
        for (int i = S.length - 1, j = S[0].length - 1; i > 0 && j > 0;) {
            // diagonal
            if (tracer[i][j] == 0) {
                result[0] = s1.charAt(j--) + result[0];
                result[1] = (s1.charAt(j + 1) == s2.charAt(i)? "|" : " ") + result[1];
                result[2] = s2.charAt(i--) + result[2];
            }
            // left
            else if (tracer[i][j] == 1) {
                result[0] = s1.charAt(j--) + result[0];
                result[1] = " " + result[1];
                result[2] = "-" + result[2];
            }
            // top
            else if (tracer[i][j] == 2) {
                result[0] = "-" + result[0];
                result[1] = " " + result[1];
                result[2] = s2.charAt(i--) + result[2];
            }
        }
        return result;
    }
    
    private static int max(int[][] S, int[][] tracer, 
            String s1, String s2, int i, int j, 
            int match, int mismatch, int w) {
        
        int[] score = new int[] {
            S[i - 1][j - 1] + (s2.charAt(i) == s1.charAt(j) ? match: mismatch),
            S[i][j - 1] + w,
            S[i - 1][j] + w
        };
        
        int maxIndex;
        if (score[0] < score[1]) maxIndex = 1; else maxIndex = 0;
        if (score[maxIndex] < score[2]) maxIndex = 2;
        tracer[i][j] = maxIndex;
        
        return score[maxIndex];
    }
    
    /*
    public static void main(String[] args) {
        
        String[] s = DPSolver.solveGlobalAlignment("GAATTCAGTTA", 
                "GGATCGA", 5, -3, -4);
        for (String s1:s)
            System.out.println(s1);
        
        
        String[] s2 = DPSolver.solveGlobalAlignment("VLSPADKFLTNV", 
                "VFTELSPAKTV", 5, -3, -4);
        for (String s1:s2)
            System.out.println(s1);
    }
    */
}
