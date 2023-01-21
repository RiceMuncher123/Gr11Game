import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mage extends Player
{
    /**
     * Act - do whatever the Mage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Mage(){
        super();
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        controls();
        if(attack.millisElapsed() > 1000)
        {
            if(mouse != null)
            {            
                if(mouse.getButton() == 1)
                {
                    attack.mark();
                    MyWorld world = (MyWorld) getWorld();
                    world.spawnLaser(getX(), getY());
                }
            }
        }
        
    }

}
