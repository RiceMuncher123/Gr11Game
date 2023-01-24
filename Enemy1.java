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
    private int damage = 5;
    private int actsPerSecondCount = 0;
    private int direction = 1;
    private int speed = 1;
    private int acts = 0;
    private int actsForWalk = 0;
    GreenfootImage[] movingRight = new GreenfootImage[10];
    GreenfootImage[] movingLeft = new GreenfootImage[10];
    String facing = "right";
    public Enemy1(){
        for(int i = 0; i < movingRight.length; i++){
            movingRight[i] = new GreenfootImage("images/Goblin/tile00" + i + ".png");
            movingRight[i].scale(movingRight[i].getWidth() + 25, movingRight[i].getHeight() + 25);
        }
        for(int i = 0; i < movingLeft.length; i++){
            movingLeft[i] = new GreenfootImage("images/Goblin/tile00" + i + ".png");
            movingLeft[i].mirrorHorizontally();
            movingLeft[i].scale(movingLeft[i].getWidth() + 25, movingLeft[i].getHeight() + 25);

        }
    }
    private int imageIndex = 0;
    public void animateWalk(){
        if(facing.equals("right")){
            setImage(movingRight[imageIndex]);
            imageIndex = (imageIndex +1) % movingRight.length;
        }
        else
        {
            setImage(movingLeft[imageIndex]);
            imageIndex = (imageIndex +1) % movingLeft.length;
        }

    }

    public void act()
    {
        if(actsForWalk == 6){
            animateWalk();
            actsForWalk = 0;
        }
        actsForWalk++;
        acts++;
        charge();
        if(getY() >= 380 && acts > 180){
            jump();
            acts = 0;
        }
        if(isTouching(Player.class)){
            dealDamage(damage);
        }
        if(getY() < 360){
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
            if(direction < 0)
                facing = "left";
            else
                facing = "right";
            speed = 1;
        }
    }

    public void jump(){
        if(Greenfoot.getRandomNumber(2) == 0)
            setLocation(getX(), getY() - 160);
    }

}
