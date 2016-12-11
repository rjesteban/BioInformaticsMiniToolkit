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
public class Result {
    public String top;
    public String mid;
    public String low;
    public int score;
    
    public Result (String t, String m, String l) {
        this.top = t;
        this.mid = m;
        this.low = l;
    }
    
    @Override
    public String toString() {
        return this.top + "\n" + this.mid + "\n" + this.low + "\n\n";
    }

}