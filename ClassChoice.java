import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClassChoice here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClassChoice extends World
{   
    public String choice;
    Button left = new Button("red");
    Button middle = new Button("green");
    Button right = new Button("blue");
    public ClassChoice()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(left, 100,200);
        addObject(middle, 300,200);
        addObject(right,500,200);

    }

    public void act(){
        if (left.getWorld() == null){
            choice = "left";
            nextWorld();
        }
        if(middle.getWorld() == null){
            choice = "middle";
            nextWorld();
        }
        if(right.getWorld() == null){
            choice = "right";
            nextWorld();
           
        }
        
    }

    public void nextWorld(){
        Greenfoot.setWorld(new MyWorld(choice));   
    }
}
