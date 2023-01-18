import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    SimpleTimer takeDamageCoolDown = new SimpleTimer();
    SuperStatBar enemyHealth = new SuperStatBar();
    private static int maxHealth = 100;
    private int health = maxHealth;
    public Enemy(){
        enemyHealth = new SuperStatBar (maxHealth, health, this, 32, 6, -32, Color.RED, Color.WHITE, false, Color.BLACK, 1);
    }

    public void addedToWorld (World w)
    {
        takeDamageCoolDown.mark();
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
        if(takeDamageCoolDown.millisElapsed() >= 500){
            health = health - damageRecieved;
            enemyHealth.update(health);
        }
        takeDamageCoolDown.mark();
        if(health <= 0){
            enemyDie();
        }
    }

    public void enemyDie()
    {   
        MyWorld world = (MyWorld) getWorld();
        world.createPortal();
        getWorld().removeObject(this);
    }

}
