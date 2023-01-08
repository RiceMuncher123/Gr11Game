import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private GreenfootImage image;

    public Button(String color){
        image = new GreenfootImage(160,60);
        if(color == "red")
            image.setColor(Color.RED);
        else if(color == "blue")
            image.setColor(Color.BLUE);
        else
            image.setColor(Color.GREEN);
        image.fill();
        setImage (image);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            getWorld().removeObject(this);
        }
    }
}
