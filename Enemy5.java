import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Enemy5 extends Enemy
{
    boolean finishedAttack = true;
    int typeOfAttack = 0;
    int acts = 0;
    public void act()
    {
        if(acts >= 300 && finishedAttack){
            finishedAttack = false;
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
            
        }
        // Add your action code here.
        acts++;
    }
    public void attack1(){
        //maybe can summon more enemies on a condition
    }
    public void attack2(){
        //an attack that cuts the map in half (MAYBE)
    }
    public void attack3(){
        setLocation(Greenfoot.getRandomNumber(400)+50, 180);
        //enemy teleports into the air, spins and shoots many mini projectiles that do minor damage
        
    }
}
