import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    SuperStatBar enemyHealth = new SuperStatBar();
    private static int maxHealth = 100;
    private int health = maxHealth;
    public Enemy(){
        enemyHealth = new SuperStatBar (maxHealth, health, this, 32, 6, -32, Color.RED, Color.WHITE, false, Color.BLACK, 1);
    }
    public void addedToWorld (World w)
    {
        w.addObject (enemyHealth, getX(), getY());
        enemyHealth.update(100);
    }
    public void act()
    {
        // Add your action code here.
    }
    public void dealDamage(int damage){
        
    }
    
    public void enemyTakeDamage(int damageRecieved)
    {
        enemyHealth.update(health - damageRecieved);
    }
    public void enemyDie()
    {   
        getWorld().removeObject(this);
    }
    
}
