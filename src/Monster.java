public class Monster extends Creature
{
    private int monsterNumber = 0;
    
    public Monster(int l, int a, int d, int s, int m)
    {
        super(l, a, d, s, m);
    }
    
    public int randInt() 
    {
        double tempDouble = (Math.random() * 6); //0-5
        int tempInt = (int)tempDouble;
        return tempInt;
    }
    
    public void takeDamage(int damage) //changes max life.
    {
        setLife(getLife() - damage);
    }
    
    public void doAttack(Hero h, Monster m) 
    {
        if(attackHit(m,h)) //if monster attack is more than hero def...
        {
            h.takeDamage(m.getAttack()); //hero takes damage equal to monster attack.
        }
    }
    
    public void monsterFactory(Monster m) 
    {
        m.setLife(100 + (randInt()*4) + (monsterNumber*10)); 
        m.setAttack(5 + randInt() + (monsterNumber*2));
        m.setDefense(5 + randInt() + (monsterNumber*2));
        m.setSpeed(4 + randInt() + (monsterNumber*3));
        m.setMoney(10 + (randInt()*2) + (monsterNumber*10));
        monsterNumber++;
    }
}

