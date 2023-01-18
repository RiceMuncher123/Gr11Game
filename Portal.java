import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Portal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portal extends Actor
{
    GreenfootImage teleport = new GreenfootImage("images/Portal-PNG-Photos.png");
    /**
     * Act - do whatever the Portal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Portal()
    {
        setImage(teleport);
        teleport.scale(100,100);
    }

    public void act()
    {
        if(getNeighbours(600, true, Enemy.class).size() < 1)
        {
            if(isTouching(Player.class))
            {
                getWorld().removeObject(this);
            }
        }

    }
}
