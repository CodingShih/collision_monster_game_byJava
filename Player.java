 //package java_final_;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javafx.geometry.Rectangle2D;

//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.effect.ColorAdjust;
//import javafx.scene.shape.Rectangle;

public class Player extends GameObject
{
    Random r = new Random(); 
    Handler handler;


    public Player(int x,int y,ID id,Handler handler)
    {
        super(x,y,id);
        this.handler = handler;
        //velX = r.nextInt(5) + 1;
        //velY = r.nextInt(5);
    }

    public Rectangle2D getBounds()
    {
        return new Rectangle2D(x,y,32,32);
    }

    public void tick()
    {
        x += velX;
        y += velY;

        x = maingame.clamp(x,0,maingame.WIDTH - 52);
        y = maingame.clamp(y,0,maingame.HEIGHT - 80);
        
        handler.addObject(new Trail(x, y,ID.Trail,Color.white, 32, 32, 0.02f, handler));
        collision();
    }

   
    
    private void collision()
    {
        for (int i=0; i< handler.object.size();i++)
        {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.BasicEnemy)
            {
                if (getBounds().intersects(tempObject.getBounds()))
                {  // collision code
                    HUD.HEALTH -= 2;
                }
            }
            
        }
    }

    public void render(Graphics g)
    {   
        g.setColor(Color.white);
        g.fillRect(x, y,32,32);
    }

}

