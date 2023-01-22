import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemy
{
    //https://www.deviantart.com/ferzin-the-hedgehog/art/Shinju-Sprite-Sheet-158413737
    private int damage = 3;
    private int acts = 0;
    private boolean isFake = false;
    int randomNum = 0;
    GreenfootImage[] movingRight = new GreenfootImage[5];
    GreenfootImage[] movingLeft = new GreenfootImage[5];
    String facing = "right";
    public Enemy2(){
        for(int i = 0; i < movingRight.length; i++){
            movingRight[i] = new GreenfootImage("images/Ninja/tile00" + i + ".png");
        }
        for(int i = 0; i < movingLeft.length; i++){
            movingLeft[i] = new GreenfootImage("images/Ninja/tile00" + i + ".png");
            movingLeft[i].mirrorHorizontally();
        }
    }
    private int imageIndex = 0;
    public void animateClimb(){
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
            animateClimb();
            acts = 0;
        }
        acts++;
        if(isTouching(Player.class)){
            dealDamage(damage);
        }
        if(Greenfoot.getRandomNumber(30) == 0){
            teleportToWall();
            animateClimb();
            attack(damage);
        }
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            enemyTakeDamage(25);
        }
    }

    public void attack(int damage){
        MyWorld world = (MyWorld) getWorld();
        world.spawnKunai(getX(), getY(), damage);
    }

    public void teleportToWall(){
        randomNum = Greenfoot.getRandomNumber(2);
        if(randomNum == 0){
            setLocation(10, Greenfoot.getRandomNumber(200)+10); 
            facing = "right";
        }
        else{
            setLocation(590,Greenfoot.getRandomNumber(200)+10);
            facing = "left";
        }
    }
}
