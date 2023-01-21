import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemy
{
    private int damage = 3;
    
    private boolean isFake = false;
    int randomNum = 0;
    public void act()
    {
        if(isTouching(Player.class)){
            dealDamage(damage);
        }
        if(Greenfoot.getRandomNumber(30) == 0){
            teleportToWall();
            attack(damage);
        }
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            enemyTakeDamage(25);
        }
    }

    public void attack(int damage){
        MyWorld world = (MyWorld) getWorld();
        world.spawnKunai(getX(), getY(), damage);
    }

    public void teleportToWall(){
        randomNum = Greenfoot.getRandomNumber(2);
        if(randomNum == 0)
            setLocation(10, Greenfoot.getRandomNumber(200)+10); 
        else
            setLocation(590,Greenfoot.getRandomNumber(200)+10);
    }
}
