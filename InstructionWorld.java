import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InstructionWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InstructionWorld extends World
{
    GreenfootImage Instructions = new GreenfootImage("images/Instructions.png");

    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    public InstructionWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        setBackground(Instructions);

    }

    public void act () {
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new ClassChoice());
        }

    }
}
