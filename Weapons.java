import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Weapons extends Actor
{  
    SimpleTimer swingCD = new SimpleTimer();
    SimpleTimer time = new SimpleTimer();
    SimpleTimer attack = new SimpleTimer();
    boolean swing = false;
    private Actor target;
    int numTurns = 0;
    boolean direction = false;
    public Weapons(Actor player)
    {
        target = player;
        time.mark();
        attack.mark();
        swingCD.mark();
        
    }

    /**
     * Act - do whatever the Sword1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {

    }

    public void controls(){
        if (target != null && getWorld() != null){
            if (target.getWorld() != null)
            {
                setLocation (target.getX(), target.getY());
            }
            else
            {
                getWorld().removeObject(this);
                return;
            }
        }    

    }

    public Actor getTarget(){
        return target;
    }

}
