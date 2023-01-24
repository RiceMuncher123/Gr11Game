import greenfoot.*; 

/**
 * Write a description of class Mage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mage extends Player
{
    /**
     * Act - do whatever the Mage wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int acts = 0;
    GreenfootImage[] movingRight = new GreenfootImage[3];
    GreenfootImage[] movingLeft = new GreenfootImage[3];
    String facing = "right";
    public Mage(int health){
        super(health);
        for(int i = 0; i < movingRight.length; i++){
            movingRight[i] = new GreenfootImage("images/wizard_ice/run_" + i + ".png");
            movingRight[i].scale(movingRight[i].getWidth() - 350, movingRight[i].getHeight() - 350);
        }
        for(int i = 0; i < movingLeft.length; i++){
            movingLeft[i] = new GreenfootImage("images/wizard_ice/run_" + i + ".png");
            movingLeft[i].mirrorHorizontally();
            movingLeft[i].scale(movingLeft[i].getWidth() - 350, movingLeft[i].getHeight() - 350);
        }
    }
    private int imageIndex = 0;
    public void animateWalk(){
        if(facing.equals("right")){
            setImage(movingRight[imageIndex]);
            imageIndex = (imageIndex + 1) % movingLeft.length;
           
        }
        else
        {
            setImage(movingLeft[imageIndex]);
            imageIndex = (imageIndex +1) % movingLeft.length;
        }

    }

    public void act()
    {
        if(acts == 15){
            animateWalk();
            acts = 0;
        }
        acts++;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        controls();
        if(Greenfoot.isKeyDown("a"))
        {
            facing = "left";
        }
        if(Greenfoot.isKeyDown("d"))
        {
            facing = "right";
        }
        if(attack.millisElapsed() > 1000)
        {
            if(mouse != null)
            {            
                if(mouse.getButton() == 1)
                {
                    attack.mark();
                    MyWorld world = (MyWorld) getWorld();
                    world.spawnLaser(getX(), getY());
                }
            }
        }

    }

}
