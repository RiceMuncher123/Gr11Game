import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bossAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bossAttack extends EnemyProjectile
{
    SimpleTimer turn = new SimpleTimer();

    GreenfootImage bossAttack = new GreenfootImage("images/bossBeam.png");
    private int speed = 4;
    private int damage = 5;
    /**
     * Act - do whatever the bossAttack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public bossAttack(){
        setImage(bossAttack);
        bossAttack.scale(100,25);
        turnTowards(Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
        turn.mark();
    }

    public void act()
    {
        move(speed);
        if(isTouching(Shield.class)){
             hitShield();
        }
        if(isTouching(bossAttack.class)  && turn.millisElapsed() > 1000)
        {
            turnTowards(Greenfoot.getRandomNumber(600),400);
            turn.mark();
        }
       if(isTouching(Player.class) && !isTouching(Shield.class)){
            dealDamage(damage);
            getWorld().removeObject(this);
        }
        else if(isAtEdge()){
            getWorld().removeObject(this);
        }

    }
}
