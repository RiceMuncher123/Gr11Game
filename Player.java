import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    SimpleTimer time = new SimpleTimer();
    SimpleTimer jump = new SimpleTimer();
    SimpleTimer shoot = new SimpleTimer();
    SimpleTimer gracePeriod = new SimpleTimer();
    SimpleTimer shieldCoolDown = new SimpleTimer();
    SuperStatBar healthBar = new SuperStatBar();
    private static int maxHealth = 100;
    private int health = maxHealth;
    public static int speed = 7;
    public Player()
    {
        time.mark();
        jump.mark();
        shoot.mark();
        shieldCoolDown.mark();
        healthBar = new SuperStatBar (maxHealth, health, this, 32, 6, -32, Color.RED, Color.WHITE, false, Color.BLACK, 1);
    }

    public void addedToWorld (World w)
    {
        w.addObject (healthBar, getX(), getY());
        healthBar.update(health);
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(getX() > 599)
        {
            setLocation(598, getY());
        }
        if(getX() < 1)
        {
            setLocation(2, getY());
        }
        if(time.millisElapsed() > 1000 && Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("shift"))
        {
            setLocation(getX()+80,getY());
            time.mark();
        }
        if(time.millisElapsed() > 1000 && Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("shift"))
        {
            setLocation(getX()-100, getY());
            time.mark();
        }
        //Moving Normally
        if(Greenfoot.isKeyDown("a"))
        {
            move(-speed);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            move(speed);
        }
        if(jump.millisElapsed() > 3000 && Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(),getY()-380);
            jump.mark();
        }
        if(getY() < 380)
        {
            setLocation(getX(), getY()+speed);
        }
    }
    public void controls(){
        //take keyboard info as a parameter
    }
    public void takeDamage(int damageRecieved)
    {
        healthBar.update(health - damageRecieved);
        if(health <= 0)
            playerDie();
    }
    public void playerDie(){
        //Make a lose s
    }

}
