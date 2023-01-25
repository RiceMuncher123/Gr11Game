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
    /*
     * Sound Sources:
     * https://www.chosic.com/download-audio/45440/ (By MaxKoMusic)
     * 
     * 
     * Code Sources:
     * https://www.greenfoot.org/topics/63631/0 (By RcCookie)
     * https://www.youtube.com/watch?v=VAHDrJ069sI (Channel Greenfoot)
     * https://www.youtube.com/watch?v=QJC1w5D6Ef8  (Channel(Greenfoot)
     * https://www.youtube.com/watch?v=TwID9i0Ey6o&t=1152s (Stewart Chan)
     * Image Sources:
     * https://craftpix.net/freebies/wizard-character-free-sprite/?utm_campaign=Website&utm_source=opengameart.org&utm_medium=public
     * https://opengameart.org/content/lpc-goblin
     * https://www.deviantart.com/ferzin-the-hedgehog/art/Shinju-Sprite-Sheet-158413737
     * https://www.nicepng.com/downpng/u2e6a9w7w7t4y3t4_click-for-full-sized-image-black-wizard-wyvern/
     * https://www.deviantart.com/zhalkon/art/Ice-Golem-Sprites-441510006
     * https://opengameart.org/content/angels
     * https://www.kindpng.com/imgv/hwxoJRT_kunai-png-transparent-png/
     * https://toppng.com/free-image/fireball-png-PNG-free-PNG-Images_120790
     * https://www.pngitem.com/middle/ioRhimx_transparent-ice-shards-hd-png-download/
     * https://www.pngmart.com/image/34097
     * https://similarpng.com/gold-black-shield-on-transparent-background-png/
     * https://toppng.com/free-image/3d-gold-star-png-PNG-free-PNG-Images_115471
     * http://pixelartmaker.com/art/d8947a58b4989bb
     * https://stock.adobe.com/search?k=forest+cartoon
     * https://www.shutterstock.com/image-vector/fairy-tale-castle-mountains-night-vector-1902864697
     * https://www.freepik.com/free-vector/winter-mountains-scenery-landscape-nature-view_24770143.htm#query=icy%20mountain&position=2&from_view=keyword
     * https://www.freepik.com/free-vector/evil-king-castle-throne-room-cartoon_4393637.htm
     * https://opengameart.org/content/phantasy-dungeon-entrance
     * https://shawnquinlivan.com/garden-labyrinth-entrance/
     * https://www.nicepng.com/ourpic/u2q8a9r5w7t4a9w7_laser-beam-eyes-png-red-laser-beam-png/
     * https://www.pinterest.ca/pin/37647346864611658/
     * https://www.pinterest.ca/pin/980095937634770923/
     * 
     * 
     * 
     */
    /*
     * Instructions
     * Your goal is to kill the enemies on each level and progress to the end
     * When clicking enter, you get to chose the difficulty to play. Each difficulty had the player start off with different health
     * Controls:
     * Move Left: A
     * Dash Left: Left Shift + A
     * Move Right: D
     * Dash Right: Left SHift + D
     * Attack: Mouse Left Click + Aiming
     * Jump: W
     * Pause: P
     * Shield: E (Can Block only most projectiles)
     * You can change the lvl variable to change the level you are on (Description of each level below:)
     */
    int lvl = 0;
    /*Levels:
     * 0 - Goblin
     * Attack: Goblin starts walking and jumping towards the edge
     * 1- Ninjas (1 Real rest fakes, Fakes don't deal damage)
     * Attack: Ninja teleports to a wall randomly and throws a kunai at the player
     * 2- Flying Dragon (Shoots fire barrage when touching right edge)
     * Attack: Shoots a fire ball in the air and releases a barrage of fire beams from the air
     * 3- Ice golem (Shoots homing icicles)
     * Attack: Spawns a barrage of homing icicles at the player
     * 4- Boss- (Has 3 move patterns and cna only by damaged by picking up a star)
     * Star: Stars spawn once every 3 moves by the boss and once picked up, the player has a grace period to damage the boss.
     * Attack: Boss shoots laser beam barrage , Wall laser (Shield does not work on purpose can only evade), Spinning Laser (Shield is needed to deflect)
     */
    /*
     * Known Bugs:
     * -Some Reason playLoop dosen't loop when the music ends
     * -Can't Shoot if cursor is outside of the world
     * -Sometimes player can damage boss more than once when touching the star
     */
    SimpleTimer takeDamageCoolDown = new SimpleTimer();
    SimpleTimer musicTime = new SimpleTimer();
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
    private GreenfootSound music;

    public MyWorld(String choice)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        //Gets the user input for the difficulty
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
        scoreBar = new SuperDisplayLabel(Color.BLACK, Color.RED, new Font ("Comic Sans MS", true, false, 20), 600, "Good Luck! Don't Die!");
        addObject(scoreBar, 300, 18);
        scoreBar.setLabels(new String[] {"Minutes:", "Seconds:"});

        Greenfoot.setSpeed(50);
        music = new GreenfootSound ("Powerful.mp3");
        started(); 
        musicTime.mark();
    }        
    //Plays the music when started
    public void started(){
        music.setVolume(10);
        music.playLoop();
    }
    //Method to stop the music
    public void stopped(){
        music.stop();
    }
    //Method that returns if the current song is playing
    public boolean isMusicPlaying(){
        return music.isPlaying();
    }
    //Method that updates the timer score bored
    public void updateLabel (int time){
        if(!gameEnd){
            seconds = (time/1000) % 60;
            minutes = (time/1000)/60;
            scoreBar.update (new int[]{minutes, seconds});
        }

    }
    //Method that summons the shield
    public void spawnShield(int x, int y){
        Shield shield = new Shield();
        addObject(shield,x,y);
    }
    //Method that decreases the player's health
    public void playerTakeDamage(int damage){
        if(playerType == 0)
            m.takeDamage(damage);
        else if(playerType == 1)
            m2.takeDamage(damage);
        else
            m3.takeDamage(damage);

    }
    //A method that spawns the player's projectile
    public void spawnLaser(int x,int y)
    {
        MageBeam mb = new MageBeam();
        addObject(mb,x,y);           
    }
    //A method that spawns the dragon's attack
    public void spawnFireBall(int x, int y){
        FireBall fb = new FireBall();
        addObject(fb,x,y);
    }
    //A method that spawns the dragon's attack
    public void spawnFireBallPt2(){
        for(int i = 0; i < 5; i++){
            FireBallPt2 fb2 = new FireBallPt2();
            addObject(fb2, Greenfoot.getRandomNumber(600), 0);
        }
    }
    //A method that spawns the star to deal damage to the boss
    public void summonStar()
    {
        star w = new star();
        addObject(w,Greenfoot.getRandomNumber(600),0);
    }
    //A method that spawns the ice golem's attack
    public void spawnIcicle(int x, int y){
        Icicle icicle = new Icicle();
        addObject(icicle, x, y - (Greenfoot.getRandomNumber(60)+10));
    }
    //A method that spawns the ninja's attack
    public void spawnKunai(int x, int y, int damage ){
        Kunai kunai = new Kunai(damage);
        addObject(kunai, x , y);
    }
    //A method that spawns the boss's laser barrage
    public void spawnBossAttack(int x, int y){
        finishedAttack = false;
        bossAttack laser = new bossAttack();
        addObject(laser,x, y);
    }
    //A method that spawns the boss's wall laser
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
    //A method that spawns the boss's spinning laser
    public void spawnSpinningLaser(int x, int y){
        finishedAttack = false;
        bossAttack3 spin = new bossAttack3();
        addObject(spin, x, y);
    }
    //A method that tells the world that the boss's attack is finished
    public void finishedAttack(){
        finishedAttack = true;
    }
    //A method that returns if the boss finished their attack
    public boolean getFinishedAttack(){
        return finishedAttack;
    }
    //A method that allows the player to hit the boss
    public void hitBoss()
    {
        attackBoss = true;
    }
    //A method that sets the boolean to where the player can deal damage to the boss to false
    public boolean returnHitBoss()
    {
        return attackBoss;
    }
    //A method that does not allow the player to damage to the boss
    public void deHitBoss()
    {
        attackBoss = false;
    }
    //A method that return's the player's x coordinate
    public int getPlayerX(){
        if(playerType == 0)
            return m.getX();
        else if(playerType == 1)
            return m2.getX();
        else
            return m3.getX();
    }
    //A method that return's the player's y coordinate
    public int getPlayerY(){
        if(playerType == 0)
            return m.getY();
        else if(playerType == 1)
            return m2.getY();
        else
            return m3.getY();
    }
    //A method that summons the teleport portal
    public void createPortal()
    {
        Portal portal = new Portal();
        addObject(portal,550,350);
    }
    //A method that ends the game
    public void gameOver() {
        Greenfoot.stop();
        scoreBar.update("Game Over! Your final time was " + minutes + " minutes and " + seconds + " seconds", true);
    }
    //A method that controls which enemies are spawning depending on which level they are on
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
            scoreBar.update("You win! Your final time was " + minutes + " minutes and " + seconds + " seconds", true);
            gameEnd = true;
        }
        lvl++;
    }
}

