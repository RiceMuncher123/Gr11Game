import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FakeEnemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FakeEnemy2 extends Enemy2
{
    /**
     * Act - do whatever the FakeEnemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int acts = 0;
    private int damage = 0;
    private boolean isFake = true;
    GreenfootImage[] movingRight = new GreenfootImage[5];
    GreenfootImage[] movingLeft = new GreenfootImage[5];
    String facing = "right";
    public FakeEnemy2(){
        for(int i = 0; i < movingRight.length; i++){
            movingRight[i] = new GreenfootImage("images/Ninja/tile00" + i + ".png");
        }
        for(int i = 0; i < movingLeft.length; i++){
            movingLeft[i] = new GreenfootImage("images/Ninja/tile00" + i + ".png");
            movingLeft[i].mirrorHorizontally();
        }
        animateClimb();
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
        if(Greenfoot.getRandomNumber(60) == 0){
            teleportToWall();
            attack(damage);
            animateClimb();
            attack(damage);
        }
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            enemyTakeDamage(100);
        }
    }
}
