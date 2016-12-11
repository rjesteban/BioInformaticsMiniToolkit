package lab5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rj
 */
public class Test {
    public static void main(String[] args) {
        String s1 = "ACTGGTCATAGCAAW*.";
        System.out.println(s1.matches("[ACTG]+"));
        System.out.println(s1.matches("[ARNDCQEGHILKMFPSTWYVBZX\\*]+"));
    }
   
}
