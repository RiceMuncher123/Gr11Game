import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Icicle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Icicle extends Actor
{
    public int speed = 40;
    /**
     * Act - do whatever the Icicle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage icicle = new GreenfootImage("images/Icicle.png");    
    boolean homingStage1Done = true;
    private int acts = 0;
    public Icicle(){
        setImage(icicle);
        icicle.scale(100,50);
    }

    public void act()
    {
        acts++;
        if(homingStage1Done){
            homingStage1();
            homingStage1Done = false;
        }     
        if(acts == 90){
            homingStage2();
            acts = 0;
        }
        if (getY() <= 200){
            move(speed/10);
        }
        if(isAtEdge())
            getWorld().removeObject(this);
    }

    public void homingStage1(){
        turnTowards(Greenfoot.getRandomNumber(600),200);
        move(speed*5);
    }

    public void homingStage2(){
        MyWorld world = (MyWorld) getWorld();
        turnTowards(world.getPlayerX(), world.getPlayerY());
    }

}
