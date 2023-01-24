import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    SimpleTimer timeAlive = new SimpleTimer();
    SimpleTimer takeDamageCoolDown = new SimpleTimer();
    SimpleTimer time = new SimpleTimer();
    SimpleTimer attack = new SimpleTimer();
    SimpleTimer shieldCoolDown = new SimpleTimer();
    SimpleTimer gracePeriod = new SimpleTimer();
    SuperStatBar healthBar = new SuperStatBar();
    private static int maxHealth;
    private int health;
    private static int speed = 7;
    private int vSpeed = 0;
    private int acceleration = 10;
    private int jumpStrength = 60;
    private int vSpeedIncrement = 0;
    private int millisAlive = 0;
    //Makes sure onGround() == false if statement in controls activates once for checkFall();
    public boolean onGroundSwitch = true;
    public Player(int hp)
    {
        maxHealth = hp;
        health = hp;
        takeDamageCoolDown.mark();
        time.mark();
        attack.mark();
        shieldCoolDown.mark();
        healthBar = new SuperStatBar (maxHealth, health, this, 32, 6, -32, Color.RED, Color.WHITE, false, Color.BLACK, 1);
        timeAlive.mark();
    }

    public int updateTimer(){
        return millisAlive;
    }

    public void addedToWorld (World w)
    {
        w.addObject (healthBar, getX(), getY());
        healthBar.update(health);
    }

    public void act()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        controls();
    }

    public void fall(){
        vSpeedIncrement++;
        setLocation(getX(), getY() + vSpeed);
        if(vSpeedIncrement % 2 == 0 && vSpeed <= 100)
            vSpeed = vSpeed + acceleration;
    }

    public boolean onGround(){
        return getY() >= 363;
    }

    public void checkFall(){
        if(onGround()){
            vSpeed = 0;
            onGroundSwitch = true;
            setLocation(getX(), 363);
        }
        else{
            fall();
        }
    }

    public void jump(){
        vSpeed = -jumpStrength;
        fall();
    }

    public void controls(){
        String key = Greenfoot.getKey();
        if (key != null){
            if (key.equals("p") || key.equals("P")){
                MyWorld gw = (MyWorld)getWorld();
                Greenfoot.setWorld(new PauseWorld(gw));
            }
        }
        if(Greenfoot.isKeyDown("e") && shieldCoolDown.millisElapsed() > 3500)
        {
            MyWorld world = (MyWorld) getWorld();
            world.spawnShield(getX(),getY());
            shieldCoolDown.mark();
        }
        if(getX() > 599)
        {
            setLocation(599, getY());
        }
        if(getX() < 1)
        {
            setLocation(1, getY());
        }
        if(time.millisElapsed() > 1000 && Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("shift"))
        {
            setLocation(getX()+100,getY());
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
        if(onGround() && Greenfoot.isKeyDown("w"))
        {
            jump();

            //setLocation(getX(),getY()-380);
        }
        if(onGround() == false && onGroundSwitch == true)
        {
            fall();
            onGroundSwitch = false;
            //setLocation(getX(), getY()+speed);
        }
        checkFall();
        if(getNeighbours(600, true, Enemy.class).size() < 1)
        {
            if(isTouching(Portal.class))
            {
                setLocation(50, 380);
                MyWorld world = (MyWorld) getWorld();
                world.nextLevel();
            }

        }
        if(isTouching(star.class))
        {
            gracePeriod.mark();
            removeTouching(star.class);
            MyWorld world = (MyWorld) getWorld();
            world.hitBoss();
        }
        if(gracePeriod.millisElapsed() > 3000)
        {
            MyWorld world = (MyWorld) getWorld();
            world.deHitBoss();
        }
        millisAlive = timeAlive.millisElapsed();
        MyWorld world = (MyWorld) getWorld();
        world.updateLabel(millisAlive);
    }

    public void takeDamage(int damageRecieved)
    {

        if(takeDamageCoolDown.millisElapsed() > 200){
            health = health - damageRecieved;
            healthBar.update(health);
            takeDamageCoolDown.mark();
        }
        if(health <= 0){
            MyWorld world = (MyWorld) getWorld();
            world.gameOver(); 
            playerDie();
        }
    }

    public void playerDie(){
        getWorld().removeObject(this);
    }

}
