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
    SimpleTimer takeDamageCoolDown = new SimpleTimer();
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
    private int direction;
    int lvl = 2;
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
        takeDamageCoolDown.mark();
        nextLevel();
        Greenfoot.setSpeed(50);
    }        

    public void spawnShield(int x, int y){
        Shield shield = new Shield();
        addObject(shield,x,y);
    }
    public void playerTakeDamage(int damage){
        
        m.takeDamage(damage);
        
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

    public void spawnFireBall(int x, int y){
        FireBall fb = new FireBall();
        addObject(fb,x,y);
    }
    public void spawnFireBallPt2(){
        for(int i = 0; i < 5; i++){
            FireBallPt2 fb2 = new FireBallPt2();
            addObject(fb2, Greenfoot.getRandomNumber(600), 0);
        }
    }

    public void spawnIcicle(int x, int y){
        Icicle icicle = new Icicle();
        addObject(icicle, x, y - (Greenfoot.getRandomNumber(60)+10));
    }

    public void spawnKunai(int x, int y, int damage ){
        Kunai kunai = new Kunai(damage);
        addObject(kunai, x , y);
    }

    public void spawnBossAttack(int x, int y){
        bossAttack laser = new bossAttack();
        addObject(laser,x, y);
    }
  
    public void spawnWallLaser(){
        bossAttack2 wallLaser = new bossAttack2();
        direction = Greenfoot.getRandomNumber(2);
        if(direction == 0){
            addObject(wallLaser, 0, 200);
        }
        if(direction == 1){
            addObject(wallLaser,599 , 200);
        }
        
    }
      public void spawnSpinningLaser(int x, int y){
        bossAttack3 spin = new bossAttack3();
        addObject(spin, x, y);
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
        createPortal();
        if(lvl == 0){
            addObject(enemy1,500,380);
        }
        if(lvl == 1){
            addObject(enemy2,500,380);
            addObject(fakeEnemy1,590, 380);
            addObject(fakeEnemy2,10, 380);
            addObject(fakeEnemy3,10, 380);
        }
        if(lvl == 2){
            addObject(enemy3, 500, 350);
        }
        if(lvl == 3){
            addObject(enemy4, 500, 350);
        }
        if(lvl == 4){
            addObject(enemy5, 500, 380);
        }
        lvl++;
    }
}

