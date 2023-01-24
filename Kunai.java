import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kunai here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kunai extends EnemyProjectile
{
    /**
     * Act - do whatever the Kunai wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage kunai = new GreenfootImage("images/kunai.png");
    private int speed = 4;
    private boolean turnedOnPlayer = true;
    private int damage;
    private boolean delWorld = false;
    public Kunai(int damage)
    {
        this.damage = damage;
        kunai.mirrorHorizontally();
        setImage(kunai);
        kunai.scale(100,25);

    }

    public void act()
    {
        if(isTouching(Shield.class)){
             hitShield();
        }
        if(turnedOnPlayer && getNeighbours(600, true, Player.class).size() > 0){
            MyWorld world = (MyWorld) getWorld();
            turnTowards(world.getPlayerX(), world.getPlayerY());
            turnedOnPlayer = false;
        }
        move(speed);
        if(isTouching(Player.class) && getNeighbours(600, true, Shield.class).size() < 1){
            dealDamage(damage);
            getWorld().removeObject(this);
        }
        else if(isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
