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
    private int speed = 15;
    private int damage = 15;
    private boolean delWorld = false;
    private int counter = 0;
    GreenfootImage fireBall = new GreenfootImage("images/FireAttack.png");   
    public FireBall(){
        fireBall.mirrorHorizontally();
        setImage(fireBall);
        fireBall.scale(200,100);

    }

    public void act()
    {
        turnTowards(300,1);
        if(isTouching(Shield.class)){
            hitShield();
        }
        move(speed);
        if(isTouching(Player.class) && !isTouching(Shield.class)){
            dealDamage(damage);
            getWorld().removeObject(this);
        }
        else if(isAtEdge()){
            MyWorld world = (MyWorld) getWorld();
            world.spawnFireBallPt2();
            getWorld().removeObject(this);
        }
    }
}
