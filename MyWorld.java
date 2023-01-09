import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    //https://thewisehedgehog.itch.io/hs2020
    Player p = new Player();
    Mage m = new Mage();
    Warrior w = new Warrior();
    Sword1 s = new Sword1(w);
    Enemy1 e = new Enemy1();
    public MyWorld(String choice)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        if(choice.equals("left"))
            addObject(m,50,380);
        else if(choice.equals("middle")){
            addObject(w,50,380);
                        //Greenfoot.delay(60);
        }
        
        else
            addObject(p,50,380);

        Greenfoot.setSpeed(50);
        addObject(e,500,380);
    }        
    public void swing()
    {
        addObject(s,50,380);
        s.swing();
    }
    public void spawnLaser(int x,int y)
    {
        MageBeam mb = new MageBeam();
        addObject(mb,x,y);           
    }
}
