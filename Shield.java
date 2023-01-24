import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shield extends Actor
{

    private int x;
    private int y;
    SimpleTimer grace = new SimpleTimer();
    GreenfootImage summonShield = new GreenfootImage("images/shield.png");

    public Shield()
    {
        setImage(summonShield);
        summonShield.scale(150,150);
        grace.mark();
    }

    public void act()
    {
        if(getNeighbours(600, true, Player.class).size() > 0){
            getCoords();
            setLocation(x+5,y+5);
        }
        if(grace.millisElapsed() > 3000 || getNeighbours(600, true, Player.class).size() < 0)
        {
            MyWorld world = (MyWorld) getWorld();
            world.removeObject(this);
        }

    }

    public void getCoords(){
        MyWorld world = (MyWorld) getWorld();
        x = world.getPlayerX();
        y = world.getPlayerY();
    }
}
