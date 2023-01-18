import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kunai here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kunai extends Actor
{
    /**
     * Act - do whatever the Kunai wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage kunai = new GreenfootImage("images/kunai.png");
    private int speed = 4;
    private boolean turnedOnPlayer = true;
    boolean isFake;
    public Kunai(boolean isFake)
    {
        kunai.mirrorHorizontally();
        setImage(kunai);
        kunai.scale(100,25);
        this.isFake = isFake;
    }
    public void act()
    {
        if(turnedOnPlayer){
            MyWorld world = (MyWorld) getWorld();
            turnTowards(world.getPlayerX(), world.getPlayerY());
            turnedOnPlayer = false;
        }
        if(isAtEdge())
            getWorld().removeObject(this);
        move(speed);
    }
}
