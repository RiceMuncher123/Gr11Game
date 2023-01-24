import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Icicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Icicle extends EnemyProjectile
{
    public int speed = 4;
    /**
     * Act - do whatever the Icicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage icicle = new GreenfootImage("images/Icicle.png");    
    private boolean homingStage1Done = true;
    private int acts = 0;
    private boolean moveUntilDespawn = false;
    private int damage = 5;
    public Icicle(){
        setImage(icicle);
        icicle.scale(100,25);
    }

    public void act()
    {
        acts++;
        if(isTouching(Shield.class)){
            hitShield();
        }
        if(homingStage1Done){
            homingStage1();
            if(acts < 90)
                homingStage1Done = false;
        }     
        if(acts == 90){
            homingStage2();
            acts = 0;
            moveUntilDespawn = true;
        }
        if (getY() >= 50){
            move(speed);
        }

        if(moveUntilDespawn){
            move(speed/2);
        }
        if(isTouching(Player.class)&& getNeighbours(600, true, Shield.class).size() < 1){
            dealDamage(damage);
            getWorld().removeObject(this);
        }
        else if(isAtEdge() || getNeighbours(600, true, Player.class).size() < 0){
            getWorld().removeObject(this);
        }
    }

    public void homingStage1(){
        turnTowards(Greenfoot.getRandomNumber(600),200);
    }

    public void homingStage2(){
        if(getNeighbours(600, true, Player.class).size() > 0){
            MyWorld world = (MyWorld) getWorld();
            turnTowards(world.getPlayerX(), world.getPlayerY());
        }

    }

}
