import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bossAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bossAttack extends Actor
{
    GreenfootImage bossAttack = new GreenfootImage("images/bossBeam.png");
    private int speed = 4;
    /**
     * Act - do whatever the bossAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public bossAttack(){
        setImage(bossAttack);
        bossAttack.scale(100,25);
        turnTowards(Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
    }

    public void act()
    {
        move(speed);
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }

}
