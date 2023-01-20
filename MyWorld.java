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
    Enemy1 enemy1 = new Enemy1();
    Enemy2 enemy2 = new Enemy2();
    FakeEnemy2 fakeEnemy1 = new FakeEnemy2();
    FakeEnemy2 fakeEnemy2 = new FakeEnemy2();
    FakeEnemy2 fakeEnemy3 = new FakeEnemy2();
    Enemy3 enemy3 = new Enemy3();
    Enemy4 enemy4 = new Enemy4();
    Enemy5 enemy5 = new Enemy5();
    Portal portal = new Portal();
    int lvl = 4;
    int playerType;
    public MyWorld(String choice)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        if(choice.equals("left")){
            playerType = 0;
            addObject(m,50,380);            
        }
        else if(choice.equals("middle")){
            addObject(w,50,380);
            playerType = 1;
        }
        else{
            addObject(p,50,380);
            playerType = 2;
        }
        nextLevel();
        Greenfoot.setSpeed(50);
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

    public void spawnFireBall(int x, int y, int speed){
        FireBall fb = new FireBall(speed);
        addObject(fb,x,y);
    }

    public void spawnIcicle(int x, int y){
        Icicle icicle = new Icicle();
        addObject(icicle, x, y - (Greenfoot.getRandomNumber(60)+10));
    }

    public void spawnKunai(int x, int y, boolean isFake){
        Kunai kunai = new Kunai(isFake);
        addObject(kunai, x , y);
    }
    
    public void spawnBossAttack(int x, int y){
        bossAttack laser = new bossAttack();
        addObject(laser,x, y);
    }
    public void spawnWallLaser(){
        bossAttack2 wallLaser = new bossAttack2();
        addObject(wallLaser, 0, 200);
    }
    public int getPlayerX(){
        if(playerType == 0)
            return m.getX();
        else if(playerType == 1)
            return w.getX();
        else
            return p.getX();
    }

    public int getPlayerY(){
        if(playerType == 0)
            return m.getY();
        else if(playerType == 1)
            return w.getY();
        else
            return p.getY();
    }

    public void createPortal()
    {
        Portal portal = new Portal();
        addObject(portal,550,350);
    }

    public void nextLevel(){
        if(lvl == 0){
            addObject(enemy1,500,380);
        }
        if(lvl == 1){
            addObject(enemy2,500,380);
            addObject(fakeEnemy1,Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
            addObject(fakeEnemy2,Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));
            addObject(fakeEnemy3,Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(400));

        }
        if(lvl == 2){
            addObject(enemy3, 500, 380);
        }
        if(lvl == 3){
            addObject(enemy4, 500, 380);
        }
        if(lvl == 4){
            addObject(enemy5, 500, 380);
        }
        lvl++;
    }

}
