import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Enemy5 extends Enemy
{
    boolean finishedAttack = true;
    int typeOfAttack = 0;
    int acts = 0;
    public void act()
    {
        if(acts >= 300 && finishedAttack){
            //finishedAttack = false;
            typeOfAttack = Greenfoot.getRandomNumber(3);
            if(typeOfAttack == 0){
                attack1();
            }
            if(typeOfAttack == 1){
                attack2();
            }
            if(typeOfAttack == 2){
                attack3();
            }
            acts = 0;
            
        }
        // Add your action code here.
        acts++;
    }
    public void attack1(){
        //maybe can summon more enemies on a condition
    }
    public void attack2(){
        //an attack that cuts the map in half (MAYBE)
        spawnWallLaser();
    }
    public void attack3(){
        setLocation(Greenfoot.getRandomNumber(400)+50, 180);
        for(int i = 0; i < 10; i++){
            spawnLaser();
        }
        //enemy teleports into the air, spins and shoots many mini projectiles that do minor damage
        //add simple timer to delay for 5 seconds after the attack
    }
    public void spawnLaser(){
        MyWorld world = (MyWorld) getWorld();
        world.spawnBossAttack(getX(), getY());
    }
    public void spawnWallLaser(){
        MyWorld world = (MyWorld) getWorld();
        world.spawnWallLaser();
    }
}
