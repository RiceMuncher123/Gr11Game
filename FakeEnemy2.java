import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FakeEnemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FakeEnemy2 extends Enemy2
{
    /**
     * Act - do whatever the FakeEnemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int damage = 0;
    private boolean isFake = true;
    public void act()
    {
        if(isTouching(Player.class)){
            dealDamage(damage);
        }
        if(Greenfoot.getRandomNumber(60) == 0){
            teleportToWall();
            attack(damage);
        }
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            enemyTakeDamage(100);
        }
    }
}