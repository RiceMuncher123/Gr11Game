import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Enemy5 extends Enemy
{
    boolean isMoving = true;
    boolean gotCoords = false;
    private int speedX = 1;
    private int speedY = 1;
    SimpleTimer attack1Bursts = new SimpleTimer();
    SimpleTimer attackCoolDown = new SimpleTimer();
    boolean finishedAttack = true;
    private int typeOfAttack = 0;
    private int acts = 0;
    private int lastAttack;
    GreenfootImage[] movingRight = new GreenfootImage[3];
    GreenfootImage[] movingLeft = new GreenfootImage[3];
    String facing = "right";
    private int newX = 0;
    private int newY = 0;
    private int actsForWalk = 0;
    private int attackCounter = 0;
    public Enemy5(){
        for(int i = 0; i < movingRight.length; i++){
            movingRight[i] = new GreenfootImage("images/Boss/tile00" + i + ".png");
        }
        for(int i = 0; i < movingLeft.length; i++){
            movingLeft[i] = new GreenfootImage("images/Boss/tile00" + i + ".png");
            movingLeft[i].mirrorHorizontally();
        }
        attackCoolDown.mark();
    }
    private int imageIndex = 0;
    public void animateWalk(){
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
        if(!gotCoords){
            newX = Greenfoot.getRandomNumber(600);
            newY = Greenfoot.getRandomNumber(170)+50;
            if(newX > getX()){
                facing = "right";
                speedX = 1;
            }
            else{
                facing = "left";
                speedX = -1;
            }
            if(newY > getY()){
                speedY = 1;
            }
            else{
                speedY = -1;
            }
            gotCoords = true;
        }
        if(actsForWalk == 10){
            animateWalk();
            actsForWalk = 0;
        }
        actsForWalk++;
        if(newX != getX() && newY != getY() && isMoving)
        {
            moveTowards(newX, newY);

        }
        else
            isMoving = false;
        MyWorld world = (MyWorld) getWorld();
        if(getNeighbours(600, true, EnemyProjectile.class).size() < 1){
            finishedAttack = true;
        }
        if(finishedAttack && !isMoving){

            finishedAttack = false;
            typeOfAttack = Greenfoot.getRandomNumber(3);
            if(typeOfAttack == 1 && lastAttack == 1)
                typeOfAttack = 0;
            if(typeOfAttack == 0){
                lastAttack = 0;
                attack1Bursts.mark();
                attack1();

            }
            if(typeOfAttack == 1){
                lastAttack = 1;
                attack2();
            }
            if(typeOfAttack == 2){
                lastAttack = 2;
                attack3();
            }
            attackCounter++;
            gotCoords = false;
            acts = 0;
            isMoving = true;
        }
        if(attack1Bursts.millisElapsed() < 10){
            attack1();
        }
        if(attackCounter == 3 && getNeighbours(600, true, star.class).size() < 1)
        { 
            world.summonStar();
            attackCounter = 0;
        }
        if(isTouching(MageBeam.class)){
            if(world.returnHitBoss() == true)
                enemyTakeDamage(20);
        }
        // Add your action code here.
        acts++;
    }

    public void moveTowards(int x, int y){
        if(getX() != newX){
            setLocation(getX() + speedX, getY());
        }
        if(getY() != newY){
            setLocation(getX(), getY() + speedY);
        }
    }

    public void attack1(){
        for(int i = 0; i < 10; i++){
            spawnLaser();
        }

    }

    public void attack2(){
        //an attack that cuts the map in half (MAYBE)
        spawnWallLaser();
    }

    public void attack3(){
        spawnSpinningLaser();
    }

    public void spawnLaser(){
        MyWorld world = (MyWorld) getWorld();
        world.spawnBossAttack(getX(), getY());
    }

    public void spawnWallLaser(){
        MyWorld world = (MyWorld) getWorld();
        world.spawnWallLaser();
    }

    public void spawnSpinningLaser(){
        MyWorld world = (MyWorld) getWorld();
        world.spawnSpinningLaser(getX(), getY());
    }
}
