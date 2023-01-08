import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Warrior extends Player
{
    boolean direction = false;

    /**
     * Act - do whatever the Warrior wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Warrior(){
        super();
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();

        controls();
        if(attack.millisElapsed() > 1500)
        {
            if(mouse != null)
            {   
                if(mouse.getButton() == 1)
                {
                    attack.mark();
                    MyWorld world = (MyWorld) getWorld();
                    world.swing();
                }
            }
        }
    }
}
