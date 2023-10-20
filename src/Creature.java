//contains attributes for heroes and monsters.
public class Creature 
{
    private int maxLife;
    private int attack; 
    private int defense;
    private int speed;
    private int money;
    
    public Creature(){}
    
    public Creature(int l, int a, int d, int s, int m)
    {
        maxLife = l;
        attack = a;
        defense = d;
        speed = s;
        money = m;
    }
    
    public int getLife()
    {
        return maxLife;
    }
    
    public void setLife(int inLife)
    {
        maxLife = inLife;
    }
    
    public int getAttack()
    {
        return attack;
    }
    
    public void setAttack(int inAttk)
    {
        attack = inAttk;
    }
    
    public int getDefense()
    {
        return defense;
    }
    
    public void setDefense(int inDef)
    {
        defense = inDef;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public void setSpeed(int inSpeed)
    {
        speed = inSpeed;
    }
    
    public int getMoney()
    {
        return money;
    }
    
    public void setMoney(int inMoney)
    {
        money = inMoney;
    }
    
    public int coinFlip()
    {
        double coinDouble = (Math.random() * 2); 
        int coin = (int)coinDouble; //0 or 1
        return coin;
    }
    
    public int compareSpeed(Hero h, Monster m)
    {
        if(h.getSpeed() > m.getSpeed())
        {
            System.out.println("You're faster! You go first.");
            return 1;
        }
        else if (h.getSpeed() < m.getSpeed())
        {
            System.out.println("The monster's faster! It goes first.");
            return 0;
        }
        else if(h.getSpeed() == m.getSpeed())
        {
            System.out.println("You're both equally fast...let's flip a coin.");
            if(coinFlip() == 0)
            {
                System.out.println("Unlucky. The monster's first.");
                return 0;
            }
            else
            {
                System.out.println("Lucky. You're first.");
                return 1;
            }
        }
        return -1;
    }
    
    public boolean attackHit(Creature c1, Creature c2) //c1 is the one attacking
    {
        if(c1.getAttack() >= c2.getDefense())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
   
    //attack sequnece + hero/monster objects functional when constructed in main
    public void attackSequence(Hero h, Monster m) 
    {
        System.out.println("You see something ahead. Wait... what IS that thing?!?\nIt doesn't matter. It's in your way.");
        
        int first = compareSpeed(h,m);
        if(first == 1) 
        {
            while(h.getCurrentLife() > 0 && m.getLife() > 0) //both creatures alive
            {
                h.doAttack(h,m);
                if(m.getLife() > 0)
                {
                    m.doAttack(h,m);
                }
            }      
        }
        else if(first == 0)
        {
            while(h.getCurrentLife() > 0 && m.getLife() > 0)
            {
                m.doAttack(h,m);
                if(h.getCurrentLife() > 0)
                {
                    h.doAttack(h,m);
                }  
            } 
        }
        
        if(m.getLife() <= 0)
        {
            System.out.println("You swing your weapon one last time, and the monster diappears.");
            System.out.println("In it's place, you find "+ m.getMoney()+ " coins scattered on the floor. Nice!");
            h.setMoney(h.getMoney() + m.getMoney());
        }
        if(h.getCurrentLife() <= 0)
        {
            System.out.println("Oh. Oh no. You're probably fine. Just stand up, and-");
        }  
    }
}