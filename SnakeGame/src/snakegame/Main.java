/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author sriva
 */
public class Main {
    public static void main(String args[])
    {
        JFrame f=new JFrame();
        f.setTitle("Snake Game");
        f.setBounds(10,10,905,700);
        f.setResizable(false);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBackground(Color.DARK_GRAY);
        f.setLocationRelativeTo(null);
        
        Gameplay gameplay=new Gameplay();
        f.add(gameplay);
    }
}
