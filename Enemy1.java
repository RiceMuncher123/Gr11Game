import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemy
{
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int actsPerSecondCount = 0;
    int direction = 1;
    int speed = 1;
    public void act()
    {
        charge();
        randomJump();
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            getWorld().removeObject(this);
        }
        if(getY() < 380){
            setLocation(getX(), getY() +1);
            if(getY() % 2 == 0)
                turn(1);
        }
    }

    public void charge(){
        actsPerSecondCount++;
        if(actsPerSecondCount == 60){
            speed = speed*2;
            actsPerSecondCount = 0;
        }
        move(direction*speed);
        if(isAtEdge()){
            direction = direction*-1;
            speed = 1;
        }
    }
    public void randomJump(){
        int num = Greenfoot.getRandomNumber(10);
        if(num == 1){
            setLocation(getX(), getY() - 120);
        }
    }

}
