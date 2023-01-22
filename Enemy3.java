import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// /https://www.nicepng.com/downpng/u2e6a9w7w7t4y3t4_click-for-full-sized-image-black-wizard-wyvern/
public class Enemy3 extends Enemy
{
    private int damage = 10;
    int direction = 1;
    int speed = 5;
    private int acts = 0;
    GreenfootImage[] movingRight = new GreenfootImage[6];
    GreenfootImage[] movingLeft = new GreenfootImage[6];
    String facing = "right";
    public Enemy3(){
        for(int i = 0; i < movingRight.length; i++){
            movingRight[i] = new GreenfootImage("images/Dragon/tile00" + i + ".png");
            movingRight[i].scale(movingRight[i].getWidth() - 25, movingRight[i].getHeight() - 25);
        }
        for(int i = 0; i < movingLeft.length; i++){
            movingLeft[i] = new GreenfootImage("images/Dragon/tile00" + i + ".png");
            movingLeft[i].mirrorHorizontally();
            movingLeft[i].scale(movingLeft[i].getWidth() - 25, movingLeft[i].getHeight() - 25);
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
        if(acts == 10){
            animateWalk();
            acts = 0;
        }
        acts++;
        // Add your action code here.
        move(speed);
        if(isTouching(Player.class)){
            dealDamage(damage);
        }
        if(getX() >= 599){
            attack();
        }
        if(isAtEdge()){
            speed = speed*-1;
            if(speed > 0)
                facing = "left";
            else
                facing = "right";

        }
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            enemyTakeDamage(20);
        }

    }

    public void attack(){
        MyWorld world = (MyWorld) getWorld();
        if(getX() > 300)
            world.spawnFireBall(getX() - 50, getY() + 20);
        else
            world.spawnFireBall(getX() + 50, getY() + 20);
    }
}
