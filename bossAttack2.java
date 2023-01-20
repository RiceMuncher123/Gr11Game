import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bossAttack2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bossAttack2 extends Actor
{
    private int speed = 3;
    private int acts = 0;
    private boolean setLocation = true;
    GreenfootImage bossAttack2 = new GreenfootImage("images/bossBeam2.png");
    public bossAttack2(){
        bossAttack2.scale(50,600);
        setImage(bossAttack2);
    }
    public void act()
    {
        if(setLocation){
            if(Greenfoot.getRandomNumber(2) == 0){
            setLocation(0,200);
            }
            else{
                setLocation(599,200);
                speed = speed *-1;
            }
            setLocation = false;
        }
        if((speed < 0 && getX() > 50) || (speed > 0 && getX() < 550 ))
            move(speed);
        acts++;
        if(acts >= 350){
            getWorld().removeObject(this);
        }
    }
}
