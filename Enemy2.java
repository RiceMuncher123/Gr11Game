import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy2 extends Enemy
{
    /**
     * Act - do whatever the Enemy2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int acts = 0;
    int playerX = 0;
    int playerY = 0;
    int randomNum = 0;
    public void act()
    {
        acts++;
        if(acts == 120){
            MyWorld world = (MyWorld) getWorld();
            playerX = world.getPlayerX();
            playerY = world.getPlayerY();
            attack(playerX, playerY);
        }
        if(getY() < 380){
            //have clones also teleport to a wall
            teleportToWall();
        }
        if(isTouching(MageBeam.class) || isTouching(Weapons.class)){
            enemyTakeDamage(25);
        }
    }

    public void attack(int x, int y){
        setLocation(x, y - 40);
        //throw knife
        //have clones move as well
        acts = 0;
    }

    public void teleportToWall(){
        randomNum = Greenfoot.getRandomNumber(2);
        if(randomNum == 0)
            setLocation(0, 200); 
        else
            setLocation(600,200);
    }
}
