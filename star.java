import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class star extends Actor
{
    GreenfootImage star = new GreenfootImage("images/star.png");
    /**
     * Act - do whatever the star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public star()
    {
        setImage(star);
        star.scale(55,50);
    }
    public void act()
    {
        if(getY() < 380)
        {
            setLocation(getX(), getY()+1);
        }
    }
}
