 //package java_final_;
//import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.*;
//import java.awt.event.KeyEvent;



//import java.security.Key;





public class KeyInput extends KeyAdapter
{
    private Handler handler;

    public KeyInput(Handler handler)
    {
        this.handler = handler;
    }
    
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();


        for (int i=0;i<handler.object.size();i++)
        {
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.Player)
            { // key events for player 1
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP )
                    tempObject.setVelY(-2);
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
                    tempObject.setVelY(2);
                if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
                    tempObject.setVelX(2);
                if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
                    tempObject.setVelX(-2);
            }
        }
        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
        //System.out.println(key);
        if (HUD.HEALTH < 0 || HUD.HEALTH == 0)
        { 
            System.out.println("你輸了!  遊戲結束...");                
            System.exit(1);
        }
                

    }


    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        for (int i=0;i<handler.object.size();i++)
        {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player)
            { // key events for player 1
                if (key == KeyEvent.VK_W)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_S)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_D)
                    tempObject.setVelX(0);
                if (key == KeyEvent.VK_A)
                    tempObject.setVelY(0);
            }

        }

    }
}
