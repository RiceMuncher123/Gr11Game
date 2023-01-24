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

    int lvl = 0;
    /*Levels:
     * 1- Ninjas (1 Real rest fakes, Fakes don't deal damage)
     * 2- Flying Dragon (Shoots fire barrage when touching right edge)
     * 3- Ice golem (Shoots homing icicles)
     * 4- Boss- (Has 3 move patterns)
     */
    //https://thewisehedgehog.itch.io/hs2020
    SimpleTimer takeDamageCoolDown = new SimpleTimer();
    Player p = new Player(100);
    Mage m = new Mage(200);
    Mage m2 = new Mage(100);
    Mage m3 = new Mage(1);
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
    private boolean finishedAttack = true;
    private boolean attackBoss = false;
    int playerType;
    private int seconds = 0;
    private int minutes = 0;
    private SuperDisplayLabel scoreBar;
    GreenfootImage backRoundOne = new GreenfootImage("images/Backround1.png");
    GreenfootImage backRoundTwo = new GreenfootImage("images/Backround2.jpg");
    GreenfootImage backRoundThree = new GreenfootImage("images/Backround3.jpg");
    GreenfootImage backRoundFour = new GreenfootImage("images/Backround4.jpg");
    private boolean gameEnd = false;
    public MyWorld(String choice)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        if(choice.equals("left")){
            playerType = 0;
            addObject(m,50,380);            
        }
        else if(choice.equals("middle")){
            addObject(m2,50,380);
            playerType = 1;
        }
        else{
            addObject(m3,50,380);
            playerType = 2;
        }
        takeDamageCoolDown.mark();
        nextLevel();
        scoreBar = new SuperDisplayLabel(Color.BLACK, Color.RED, new Font ("Comic Sans MS", true, false, 28), 600, "Good Luck! Don't Die!");
        addObject(scoreBar, 300, 28);
        scoreBar.setLabels(new String[] {"Minutes:", "Seconds:"});

        Greenfoot.setSpeed(50);
    }        

    public void updateLabel (int time){
        if(!gameEnd){
            seconds = (time/1000) % 60;
            minutes = (time/1000)/60;
            scoreBar.update (new int[]{minutes, seconds});
        }

    }

    public void spawnShield(int x, int y){
        Shield shield = new Shield();
        addObject(shield,x,y);
    }

    public void playerTakeDamage(int damage){
        if(playerType == 0)
            m.takeDamage(damage);
        else if(playerType == 1)
            m2.takeDamage(damage);
        else
            m3.takeDamage(damage);

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

    public void summonStar()
    {
        star w = new star();
        addObject(w,Greenfoot.getRandomNumber(600),0);
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
        finishedAttack = false;
        bossAttack laser = new bossAttack();
        addObject(laser,x, y);
    }

    public void spawnWallLaser(){
        finishedAttack = false;
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
        finishedAttack = false;
        bossAttack3 spin = new bossAttack3();
        addObject(spin, x, y);
    }

    public void finishedAttack(){
        finishedAttack = true;
    }

    public boolean getFinishedAttack(){
        return finishedAttack;
    }

    public void hitBoss()
    {
        attackBoss = true;
    }

    public boolean returnHitBoss()
    {
        return attackBoss;
    }

    public void deHitBoss()
    {
        attackBoss = false;
    }

    public int getPlayerX(){
        if(playerType == 0)
            return m.getX();
        else if(playerType == 1)
            return m2.getX();
        else
            return m3.getX();
    }

    public int getPlayerY(){
        if(playerType == 0)
            return m.getY();
        else if(playerType == 1)
            return m2.getY();
        else
            return m3.getY();
    }

    public void createPortal()
    {
        Portal portal = new Portal();
        addObject(portal,550,350);
    }

    public void gameOver() {
        Greenfoot.stop();
        scoreBar.update("Game Over! Your final time was " + minutes + ":" + seconds, true);
    }

    public void nextLevel(){
        createPortal();
        if(lvl == 0){
            setBackground(backRoundOne);
            addObject(enemy1,500,360);
        }
        if(lvl == 1){
            addObject(enemy2,500,380);
            addObject(fakeEnemy1,590, 380);
            addObject(fakeEnemy2,10, 380);
            addObject(fakeEnemy3,10, 380);
        }
        if(lvl == 2){
            setBackground(backRoundTwo);
            addObject(enemy3, 500, 350);
        }
        if(lvl == 3){
            setBackground(backRoundThree);

            addObject(enemy4, 500, 350);
        }
        if(lvl == 4){
            setBackground(backRoundFour);
            addObject(enemy5, 500, 20);
        }
        if(lvl == 5){
            scoreBar.update("You win! Your final time was " + minutes + ":" + seconds, true);
            gameEnd = true;
        }
        lvl++;
    }
}

