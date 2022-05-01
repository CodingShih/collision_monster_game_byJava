//package java_final_;
//import java.awt.Color;
import java.awt.Graphics;

import javafx.geometry.Rectangle2D;
//import javafx.scene.shape.Rectangle;

public abstract class GameObject 
{
    protected int x,y;
    protected ID id;
    protected double velX,velY; // 控制 x y 方向的移動速度

    public GameObject(int x,int y,ID id)
    {
        this.x = x;
        this.y = y;
        this.id = id;

    }

    public abstract void tick(); 
    //抽象類別   //https://jjnnykimo.pixnet.net/blog/post/21585257
    public abstract void render(Graphics g);

    public Rectangle2D getBounds()
    {
        return new Rectangle2D(x,y,32,32);
    }


    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setId(ID id)
    {
        this.id = id;
    }
    public ID getId()
    {
        return id;
    }
    public void setVelX(int velX)
    {
        this.velX = velX;
    }
    public void setVelY(int velY)
    {
        this.velY = velY;
    }
    public double getVelX()
    {
        return velX;
    }
    public double getVelY()
    {
        return velY;
    }
    
}
