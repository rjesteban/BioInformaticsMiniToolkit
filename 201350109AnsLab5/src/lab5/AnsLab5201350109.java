package lab5;


import java.awt.Dimension;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rj
 */
public class AnsLab5201350109 {
    public static void main(String[] args) {
        AnsLab5Panel panel = new AnsLab5Panel();
        JFrame frame = new JFrame("Pairwise Sequence Alignment By 2013-50109");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(589, 530));
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
