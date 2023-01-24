import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WelcomeWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WelcomeWorld extends World
{

    /**
     * Constructor for objects of class WelcomeWorld.
     * 
     */
    public WelcomeWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600,400, 1); 
    }
    
    public void act () {
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new ClassChoice());
        }
        if (Greenfoot.isKeyDown("i") || Greenfoot.isKeyDown("I")){
             Greenfoot.setWorld(new InstructionWorld());
        }
            
    }
}
