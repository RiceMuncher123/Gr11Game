import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemy
{
  
    
    private boolean isFake = false;
    int randomNum = 0;
    public void act()
    {
        
        if(Greenfoot.getRandomNumber(90) == 0){
            teleportToWall();
            attack(isFake);
        }
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            enemyTakeDamage(25);
        }
    }

    public void attack(boolean isFake){
        MyWorld world = (MyWorld) getWorld();
        world.spawnKunai(getX(), getY(), isFake);
    
    }

    public void teleportToWall(){
        randomNum = Greenfoot.getRandomNumber(2);
        if(randomNum == 0)
            setLocation(5, Greenfoot.getRandomNumber(200)+10); 
        else
            setLocation(595,Greenfoot.getRandomNumber(200)+10);
    }
}
