import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyProjectile extends Actor
{
    /**
     * Act - do whatever the EnemyProjectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }

    public void dealDamage(int damage){
        MyWorld world = (MyWorld) getWorld();
        world.playerTakeDamage(damage);
    }

    public void hitShield(){
        setLocation(getX(), getY()-20);
        turn(70);
    }
}
