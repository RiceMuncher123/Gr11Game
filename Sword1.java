import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Sword1 extends Weapons
{
    MouseInfo mouse = Greenfoot.getMouseInfo();
    GreenfootImage sword = new GreenfootImage("images/Sword1.png");
    GreenfootImage sword1 = new GreenfootImage("images/Sword1.png");
    boolean swingSword = false;
    public Sword1(Actor player){
        super(player);
        sword1.mirrorHorizontally();
        setImage(sword);
        sword.scale(50,50);
        sword1.scale(50,50);
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        controls();
        if(swingSword == true){
            numTurns++;
            turn(4);
        }
        if(numTurns == 45){
            swingSword = false;
            numTurns = 0;
            setRotation(10);
            getWorld().removeObject(this);
        }

    }
    public void swing(){
        swingSword = true;
    }

}
