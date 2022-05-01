//package java_final_;

import java.awt.Canvas;
//import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.plaf.DimensionUIResource;


//import java.awt.Color;
//import java.awt.Graphics;
//import java.awt.image.BufferStrategy;

public class window extends Canvas  // 寫一視窗frame
{
    
    public window(int width,int height,String title,maingame game)
    {
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new DimensionUIResource(width, height));
        frame.setMaximumSize(new DimensionUIResource(width, height));
        frame.setMinimumSize(new DimensionUIResource(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();



    }
}

