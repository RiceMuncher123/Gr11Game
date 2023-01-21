import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireBall extends EnemyProjectile
{
    /**
     * Act - do whatever the FireBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    private int damage = 15;
    private boolean delWorld = false;
    GreenfootImage fireBall = new GreenfootImage("images/FireAttack.png");    
    public FireBall(int direction){
        setImage(fireBall);
        fireBall.scale(200,100);
        if(direction < 0){
            speed = direction*2;
        }
        else{
            speed = direction *2;
            fireBall.mirrorHorizontally();
        }
    }

    public void act()
    {
        if(isTouching(Shield.class)){
             hitShield();
        }
        move(speed);
        if(isTouching(Player.class) && !isTouching(Shield.class)){
            dealDamage(damage);
            getWorld().removeObject(this);
        }
        else if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
