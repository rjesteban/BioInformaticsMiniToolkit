package lab5.logic;


import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author 2013-50109 Esteban, Arnold Joseph Caesar P.
 */

public class DNASequenceAlignmentSolver {
    
    public static List<Result> solveGlobalAlignment(String s1, String s2,
            int match, int mismatch, int gap) {
        
        s1 = "-" + s1;
        s2 = "-" + s2;
        Cell[][] S = new Cell[s2.length()][s1.length()];
        for (int i = 0; i < S.length; i++) {
            for (int j = 0; j < S[0].length; j++) {
                S[i][j] = new Cell(0, false, false, false);
            }
        }
        
        // initialization
        for (int i = 1; i < S.length; i++) {
            S[i][0].score = i*gap;
            S[i][0].top = true;
        }
        for (int j = 1; j < S[0].length; j++){
            S[0][j].score = j*gap;
            S[0][j].left = true;
        }
        
        // fill
        for (int i = 1; i < S.length; i++)
            for (int j = 1; j < S[0].length; j++)
                S[i][j].score = max(S, s1, s2, i, j, match, mismatch, gap);
        
        
        // =============== print cell scores ================
        System.out.print("\t");
        for (int i = 0; i < s1.length(); i++)
            System.out.print(s1.charAt(i) + "\t");
        System.out.println();
        
        for (int i = 0; i < S.length; i++) {
            System.out.print(s2.charAt(i) + "\t");
            
            for (int j = 0; j < S[0].length; j++) {
                System.out.print(S[i][j] + "\t");
            }
            System.out.println();
        }
        // ============= end print cell scores ==============
        List<Result> results = new ArrayList<Result>();
        traceback("", "", "", S.length - 1, S[0].length - 1, S, s1, s2, results);
        
        for (Result r:results)
            r.score = S[S.length - 1][S[0].length - 1].score;
        return results;
    }
    
    public static List<Result> solveLocalAlignment(String s1, String s2,
            int match, int mismatch, int gap) {
        
        s1 = "-" + s1;
        s2 = "-" + s2;
        Cell[][] S = new Cell[s2.length()][s1.length()];
        for (Cell[] S1 : S) {
            for (int j = 0; j < S[0].length; j++) {
                S1[j] = new Cell(0, false, false, false);
            }
        }
        
        int max = 0;
        // fill
        for (int i = 1; i < S.length; i++) {
            for (int j = 1; j < S[0].length; j++) {
                S[i][j].score = max(S, s1, s2, i, j, match, mismatch, gap);
                if (i == 1 && j == 1)
                    max = S[1][1].score;
                else {
                    if (S[i][j].score < 0) {
                        S[i][j].score = 0;
                        S[i][j].diag = false;
                        S[i][j].top = false;
                        S[i][j].left = false;
                    }
                    if (max < S[i][j].score)
                        max = S[i][j].score;
                }
            }
        }
        
        ArrayList<Integer> maxI = new ArrayList<Integer>();
        ArrayList<Integer> maxJ = new ArrayList<Integer>();
        
        for (int i = 1; i < S.length; i++) {
            for (int j = 1; j < S[0].length; j++) {
                if (max == S[i][j].score) {
                    maxI.add(i);
                    maxJ.add(j);
                }
            }
        }
        
        
        // =============== print cell scores ================
        System.out.print("\t");
        for (int i = 0; i < s1.length(); i++)
            System.out.print(s1.charAt(i) + "\t");
        System.out.println();
        
        for (int i = 0; i < S.length; i++) {
            System.out.print(s2.charAt(i) + "\t");
            
            for (int j = 0; j < S[0].length; j++) {
                System.out.print(S[i][j] + "\t");
            }
            System.out.println();
        }
        // ============= end print cell scores ==============
        List<Result> results = new ArrayList<Result>();
        
        for (int i = 0; i < maxI.size(); i++)
            traceback("", "", "", maxI.get(i), maxJ.get(i), S, s1, s2, results);
        
        for (Result r:results)
            r.score = max;
        return results;        
    }
    
    
    private static int max(Cell[][] S, String s1, String s2, int i, int j, 
            int match, int mismatch, int w) {

        int[] score = new int[] {
            S[i][j - 1].score + w,
            S[i - 1][j - 1].score 
                + (s2.charAt(i) == s1.charAt(j) ? match: mismatch),         
            S[i - 1][j].score + w
        };
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        if (score[0] == max)
            S[i][j].left = true;
        if (score[1] == max)
            S[i][j].diag = true;
        if (score[2] == max)
            S[i][j].top = true;
        
        return max;
    }
    
    private static void traceback(String top, String mid, String low,
            int i, int j, Cell[][] S, String s1, String s2, List<Result> l) {
        
        if (i == 0 && j == 0 && S[i][j].left == false &
                S[i][j].top == false && S[i][j].diag == false) {
            System.out.println(top);
            System.out.println(mid);
            System.out.println(low);
            System.out.println();
            System.out.println();
            l.add(new Result(top, mid, low));
            return;
        }
        
        if (S[i][j].left == false && S[i][j].top == false && 
                S[i][j].diag == false) {
            System.out.println(top);
            System.out.println(mid);
            System.out.println(low);
            System.out.println();
            System.out.println();
            l.add(new Result(top, mid, low));
            return;
        }
        
        if (S[i][j].left == true) {
            traceback(s1.charAt(j) + top, " " + mid, "-" + low, i, j - 1, S, s1, s2, l);
        }
        
        if (S[i][j].diag == true) {
            traceback(s1.charAt(j) + top, (s1.charAt(j) == s2.charAt(i)? "*": ".") + mid, 
                    s2.charAt(i) + low, i - 1, j - 1, S, s1, s2, l);
        }
        
        if (S[i][j].top == true) {
            traceback("-" + top, " " + mid, s2.charAt(i) + low, i - 1, j, 
                    S, s1, s2, l);
        }
    }
    
    
    /*
    public static void main(String[] args) {
//        DNASequenceAlignmentSolver.solveGlobalAlignment("GAATTCAGTTA", 
//                "GGATCGA", 5, -3, -4);
//        System.out.println();
////        SequenceAlignmentSolver.solveGlobalAlignment("TGCGCCTACA", 
////                "TGTACCACAA",  1, 0, -1);
//
//        DNASequenceAlignmentSolver.solveGlobalAlignment("GCATGCU", "GATTACA", 1, -1, -1);

        System.out.println("---------------------------- LOCAL ----------------------");
        
        DNASequenceAlignmentSolver.solveLocalAlignment("GAATTCAGTTA", 
                "GGATCGA", 5, -3, -4);
    }
    */
    
}