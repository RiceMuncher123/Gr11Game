import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FireBallPt2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireBallPt2 extends EnemyProjectile
{
    GreenfootImage part_two = new GreenfootImage("images/FireAttack.png");
    /**
     * Act - do whatever the FireBallPt2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean del = false;
    private int speed = 15;
    private int damage = 5;
    public FireBallPt2(){
        part_two.mirrorHorizontally();
        setImage(part_two);
        part_two.scale(100,75);
    }

    public void act()
    {
        turnTowards(getX(), 399);
        move(speed);
        if(isTouching(Shield.class)){
            hitShield();
        }
        if(isTouching(FireBallPt2.class)){
            setLocation(Greenfoot.getRandomNumber(600), 0);
        }
        if(isTouching(Player.class) && getNeighbours(600, true, Shield.class).size() < 1){
            dealDamage(damage);
            del = true;
        }
        if(getY() == 399 || del == true){
            getWorld().removeObject(this);
        }
        // Add your action code here.
    }
}
