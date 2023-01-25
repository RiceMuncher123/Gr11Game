import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PauseWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PauseWorld extends World
{
    GreenfootImage paused = new GreenfootImage("images/Paused.png");

    private MyWorld myWorld;
    /**
     * Constructor for objects of class PauseWorld.
     * 
     */
    public PauseWorld(MyWorld myWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.myWorld = myWorld;
        setBackground(paused);

    }

    public void act () {
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(myWorld);
        }

    }
}
