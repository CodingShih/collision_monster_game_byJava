 //package java_final_;

import java.awt.Color;
import java.awt.Graphics;
import javafx.geometry.Rectangle2D;
//import javafx.scene.shape.Rectangle;

public class BasicEnemy extends GameObject
{
    private Handler handler;
    
    public BasicEnemy(int x,int y,ID id,Handler handler)
    {
        super(x, y, id);

        this.handler = handler;

        velX = 1;
        velY = 1;

    }

    //Rectangle bounds = new Rectangle(0, 0, -1, -1);
    public Rectangle2D getBounds()
    {
        return new Rectangle2D(x,y,16,16);
    }
    
    public void tick()
    {
        x += velX;
        y += velY;

        if (y <= 0 || y >= maingame.HEIGHT -32)
            velY *= -1;
        if (x <= 0 || x >= maingame.WIDTH -16)
            velX *= -1;
        
        if (HUD.HEALTH < 0 || HUD.HEALTH == 0)
        {
            velX = 0;
            velY = 0;        
                
        }
        

        handler.addObject(new Trail(x, y,ID.Trail,Color.red, 16, 16, 0.007f, handler));
    }
    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
        g.setColor(Color.blue);
        g.fillRect(x, y, 16, 16);
        g.setColor(Color.green);
        g.fillRect(x, y, 16, 16);

    }

}
