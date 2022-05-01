//package java_final_;
//import java.awt.Canvas; // AWT 在 java.awt 套件中
//import java.awt.Component;
//import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class Handler 
{   // handler 這個類別是用來 維護 或是更新、影響(render) 所有的 物件(objects)
    // 如此不用每個類別在debug的時候需要一個個去看，


    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick()
    {
        for (int i=0; i < object.size(); i++)
        {  // 在每個物件之間loop 並進行更新
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }

    public void render(Graphics g)
    {
        for (int i=0; i < object.size(); i++)
        {
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object)
    {
        this.object.add(object);
    }
    public void removeObject(GameObject object)
    {
        this.object.remove(object);
    }


}
