import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Enemy5 extends Enemy
{
    SimpleTimer attack1Bursts = new SimpleTimer();
    boolean finishedAttack = true;
    private int typeOfAttack = 0;
    private int acts = 0;
    private int lastAttack;
    public void act()
    {
        if(acts >= 300 && finishedAttack){
            //finishedAttack = false;
            setLocation(Greenfoot.getRandomNumber(600), Greenfoot.getRandomNumber(350));
            typeOfAttack = Greenfoot.getRandomNumber(3);
            if(typeOfAttack == 2 && lastAttack == 2)
                typeOfAttack = 1;
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
            acts = 0;
        }
        if(attack1Bursts.millisElapsed() < 10){
            attack1();
        }
       
        if(isTouching(MageBeam.class))
           enemyTakeDamage(5);
        // Add your action code here.
        acts++;
    }
    public void attack1(){
        setLocation(Greenfoot.getRandomNumber(400)+50, 180);
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
