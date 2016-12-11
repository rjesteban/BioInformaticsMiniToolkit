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
public class Cell {
    protected boolean top;
    protected boolean left;
    protected boolean diag;
    protected int score;
    
    public Cell (int score, boolean top, boolean left, boolean diag) {
        this.score = score;
        this.top = top;
        this.left = left;
        this.diag = diag;
    }
    
    @Override
    public String toString() {
        String l = "<";
        String u = "^";
        String d = "\\";
        
        String s = String.format("%03d[", this.score);
        if (this.left)
            s += l;
        else
            s += "_";
        if (this.diag)
            s += d;
        else
            s += "_";
        if (this.top)
            s += u;
        else
            s += "_";
        return s + "]";
    }
}