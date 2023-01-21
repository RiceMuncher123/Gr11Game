import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    int acts = 0;
    int speed = 2;
    int direction = 1;
    int spawnIscicle = 0;
    private int damage = 10;
    public void act()
    {
        if(isTouching(Player.class)){
            dealDamage(damage);
        }
        move(speed*direction);
        if(isAtEdge())
            direction = direction*-1;
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
