import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossAttack2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bossAttack3 extends EnemyProjectile
{
    GreenfootImage attack = new GreenfootImage("images/bossBeam.png");
    SimpleTimer attackDelay = new SimpleTimer();
    int rotate = 0;
    int x = 1;
    int numTurns = 360;
    int xScale = 1200;
    int yScale = 40;
    private int damage = 50;
    private int shieldTouches = 4;
    /**
     * Act - do whatever the BossAttack2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public bossAttack3()
    {
        setImage(attack);
        attack.scale(xScale,yScale);
        attackDelay.mark();
    }

    public void act()
    {
        if(attackDelay.millisElapsed() > 200)
        {
            if(isTouching(Player.class))
            {
                MyWorld world = (MyWorld) getWorld();
                dealDamage(damage);
            }
            if(isTouching(Shield.class))
            {
                if(shieldTouches > 0){
                    xScale = xScale/2;
                    attack.scale(xScale,yScale);
                    x = x*-1;
                    numTurns = 180;
                    shieldTouches--;
                }

            }
            if(rotate >= numTurns || shieldTouches == 0)
            {
                MyWorld world = (MyWorld) getWorld();
                world.finishedAttack();
                getWorld().removeObject(this);
            }
            turn(x);
            rotate++;
        }
    }
}
