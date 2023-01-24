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
        if(color == "red"){
            image.setColor(Color.GREEN);
            image.fill();
            image.setColor(Color.BLACK);
            image.drawString("Easy", 60,40);
        }
        else if(color == "blue"){
            image.setColor(Color.RED);
            image.fill();
            image.setColor(Color.BLACK);
            image.drawString("Hard",60,40);
        }
        else{
            image.setColor(Color.ORANGE);
            image.fill();
            image.setColor(Color.BLACK);
            image.drawString("Medium",60,40);
        }
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
