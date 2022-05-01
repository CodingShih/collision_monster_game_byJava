//package java_final_;

import java.util.*;
//import java.util.logging.Handler;

//import javax.swing.JFrame; //Swing 在 javax.swing 套件裡
//import javax.swing.plaf.DimensionUIResource;  //https://pydoing.blogspot.com/2011/05/java-basic-concept-of-gui.html
//import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import java.awt.Canvas; // AWT 在 java.awt 套件中
//import java.awt.Component;
import java.awt.Color;
import java.awt.Graphics;   
import java.awt.image.BufferStrategy;
//import javafx.geometry.Rectangle2D;


public class maingame extends Canvas implements Runnable
{
    public static final int WIDTH=640,HEIGHT=WIDTH / 12 *9; 

    private Thread thread;
    private boolean running = false;

    private Random r;

    //private HUD hud;
    HUD hud;
    //private Handler handler;
    Handler handler;
    
    
    public maingame()
    {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));


        new window(WIDTH,HEIGHT,"GAGA dodge!!",this);

        hud = new HUD();
       
        r = new Random();   

        
        handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32,ID.Player,handler));
        handler.addObject(new BasicEnemy(r.nextInt(WIDTH),r.nextInt(HEIGHT),ID.BasicEnemy,handler));
        //handler.addObject(new BasicEnemy(r.nextInt(WIDTH-50),r.nextInt(HEIGHT-15),ID.BasicEnemy,handler));
        //handler.addObject(new BasicEnemy(r.nextInt(WIDTH-100),r.nextInt(HEIGHT-10),ID.BasicEnemy,handler));
    }
    
    public synchronized void start() 
    {
        thread= new Thread(this);
        thread.start();
        running = true;

    }
    public synchronized void stop()
    {
        try
        {
            thread.join();
            running = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 100000000/amountOfTicks;
        double delta = 0 ;
        long timer = System.currentTimeMillis();
        //int frames = 0;
        
        while (running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1)
            {
                tick();
                delta--;
            }

            if (running)
                render();
           // frames++;

            if (System.currentTimeMillis() - timer > 1000)
            {
                timer +=1000;
                //System.out.println("FPS: "+frames);
                //frames=0;
            }



        }
        stop();
    }

    private void tick()
    {
        handler.tick();

        hud.tick();
    }
    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        
        hud.render(g);
        
        g.dispose();
        bs.show();
    }


    public static int clamp(int var,int min,int max)
    {
        if (var >= max)
        {
            return var = max;
        }
        else if (var <= min)
        {
            return var = min;
        }
        else 
            return var;

    }


    

    public static void main(String args[])
    {
        //String goodsong = "RedScarf.mp3";
        new maingame();
        


        
    }


}