import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy3 extends Enemy
{
    int speed = 5;
    /**
     * Act - do whatever the Enemy3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //https://www.pinterest.ca/pin/724375921301934272/
        move(speed);
        if(isAtEdge()){
            speed = speed*-1;
            attack();
        }
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            enemyTakeDamage(20);
        }
    }

    public void attack(){
        MyWorld world = (MyWorld) getWorld();
        world.spawnFireBall(getX(), getY(), speed);
    }
}
