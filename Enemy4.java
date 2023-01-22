import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//https://www.deviantart.com/zhalkon/art/Ice-Golem-Sprites-441510006
/**
 * Write a description of class Enemy4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy4 extends Enemy
{

    /**
     * Act - do whatever the Enemy4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int actsForWalk = 0;
    int acts = 0;
    int speed = 2;
    int direction = 1;
    int spawnIscicle = 0;
    private int damage = 10;
    GreenfootImage[] movingRight = new GreenfootImage[3];
    GreenfootImage[] movingLeft = new GreenfootImage[3];
    String facing = "right";
    public Enemy4(){
        for(int i = 0; i < movingRight.length; i++){
            movingRight[i] = new GreenfootImage("images/IceGolem/tile00" + i + ".png");
            movingRight[i].scale(movingRight[i].getWidth() - 25, movingRight[i].getHeight() - 25);
        }
        for(int i = 0; i < movingLeft.length; i++){
            movingLeft[i] = new GreenfootImage("images/IceGolem/tile00" + i + ".png");
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
        if(actsForWalk == 10){
            animateWalk();
            actsForWalk = 0;
        }
        actsForWalk++;
        if(isTouching(Player.class)){
            dealDamage(damage);
        }
        move(speed*direction);
        if(isAtEdge()){
            direction = direction*-1;
            if(direction > 0)
                facing = "left";
            else
                facing = "right";
        }
            if(acts == 300){
            for(int i = 0; i< 5; i++)
                shootIscicles();
            acts = 0;
        }
        acts++;
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            enemyTakeDamage(10);
        }
    }

    public void shootIscicles(){
        MyWorld world = (MyWorld) getWorld();
        world.spawnIcicle(getX(), getY());
        spawnIscicle++;
    }

    public void shootIceSpear(int x, int y){

    }

}
