import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy1 extends Enemy
{
    /**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //https://opengameart.org/content/lpc-goblin
    private int damage = 5;
    private int actsPerSecondCount = 0;
    private int direction = 1;
    private int speed = 1;
    private int acts = 0;
    GreenfootImage[] moving = new GreenfootImage[10];
    public Enemy1(){
        for(int i = 0; i < moving.length; i++){
            moving[i] = new GreenfootImage("images/Goblin/tile
        }
    }
    public void act()
    {
        acts++;
        charge();
        if(getY() >= 380 && acts > 180){
            jump();
            acts = 0;
        }
        if(isTouching(Player.class)){
            dealDamage(damage);
        }
        if(getY() < 380){
            setLocation(getX(), getY() +1);    
        }
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            enemyTakeDamage(50);
        }

    }

    public void charge(){
        actsPerSecondCount++;
        if(actsPerSecondCount == 60){
            speed = speed*2;
            actsPerSecondCount = 0;
        }
        move(direction*speed);
        if(isAtEdge()){
            direction = direction*-1;
            speed = 1;
        }
    }

    public void jump(){
        if(Greenfoot.getRandomNumber(2) == 0)
            setLocation(getX(), getY() - 160);
    }

}
