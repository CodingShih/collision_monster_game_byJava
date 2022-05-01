//package java_final_;

import java.awt.Graphics;
import java.awt.Color;

//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;


public class HUD 
{

    public static int HEALTH = 100;


    public void tick()
    {


        HEALTH = maingame.clamp(HEALTH,0,100);
    }   
    public void render(Graphics g)
    {
        g.setColor(Color.GRAY);
        g.fillRect(15,15,200,32);

        g.setColor(Color.GREEN);
        g.fillRect(15,15,HEALTH*2,32);
       
        g.setColor(Color.white);
        g.drawRect(15,15,200,32);


    }
}
