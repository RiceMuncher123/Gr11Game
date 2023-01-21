import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class bossAttack2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bossAttack2 extends EnemyProjectile
{
  
    private int damage = 25;
    private int speed = 3;
    private int acts = 0;
    private boolean setLocation = true;
    GreenfootImage bossAttack2 = new GreenfootImage("images/bossBeam2.png");
    public bossAttack2(){
        bossAttack2.scale(50,600);
        setImage(bossAttack2);
       
    }

    public void act()
    {
        if(getX() == 599)
            speed = speed *-1;
        if(isTouching(Player.class) && !isTouching(Shield.class))
        {
            MyWorld world = (MyWorld) getWorld();
            dealDamage(damage);
        }
        if((speed < 0 && getX() > 60) || (speed > 0 && getX() < 540 ))
            move(speed);
        acts++;

        if(acts >= 300){
            getWorld().removeObject(this);
        }
    }
}