public class Things
{
    public Things(){} 
    
    public int randInt() 
    {
        double tempDouble = (Math.random() * 20) +1;
        int tempInt = (int)tempDouble;
        return tempInt;
    }
    
    public void lifeIncrease(Hero h) 
    {
        h.setCurrentLife(h.getCurrentLife() + randInt());
        if(h.getCurrentLife() > h.getLife()) //if over max, sets back to max. 
        {
            h.setCurrentLife(h.getLife());
        }
    }
    
    public void lifeDecrease(Hero h)
    {
        h.setCurrentLife(h.getCurrentLife() - randInt());
    }
    
    public void attackIncrease(Hero h)
    {
        h.setAttack(h.getAttack() + (randInt()/2));
    }
    
    public void attackDecrease(Hero h)
    {
        h.setAttack(h.getAttack() - (randInt()/4));
    }
    
    public void defenseIncrease(Hero h)
    {
        h.setDefense(h.getDefense() + (randInt()/2));
    }
    
    public void defenseDecrease(Hero h)
    {
        h.setDefense(h.getAttack() - (randInt()/4));
    }
    
    public void speedIncrease(Hero h)
    {
        h.setSpeed(h.getSpeed() + randInt());
    }
    
    public void speedDecrease(Hero h)
    {
        h.setSpeed(h.getSpeed() - (randInt()/2));
    }
    
    public void moneyIncrease(Hero h)
    {
        h.setMoney(h.getMoney() + randInt());
    }
    
    public void moneyDecrease(Hero h)
    {
        h.setMoney(h.getMoney() - randInt());
    }
    
    public void itemMaker(Hero h)
    {
        int temp = randInt();
        if(temp <= 2)
        {
            trapMaker(h);
        }
  
        if (temp >= 17) {
            lifeIncrease(h);
            System.out.println("The bag is too faded to read the name, but they taste okay. Life is now "+h.getLife());
        } else if (temp >= 13) {
            attackIncrease(h);
            System.out.println("The new sword fits in your hand easily. Attack is now "+h.getAttack());
        } else if (temp >= 9) {
            defenseIncrease(h);
            System.out.println("Suspiciously abandoned armor is the best kind of armor. Defense is now "+ h.getAttack());
        } else if (temp >= 5) {
            speedIncrease(h);
            System.out.println("You take a sip of the mysterious floor potion, and... oh, it's just caffeine. Speed is now "+ h.getSpeed());
        } else {
            moneyIncrease(h);
            System.out.println("You can't tell what it is, exactly? looks expensive, though. Money is now "+ h.getMoney());
        }
    }
    
    public void trapMaker(Hero h)
    {
        int temp = randInt();
        if(temp >= 18)
        {
            itemMaker(h);
        }
        
        if (temp <= 4) {
            lifeDecrease(h);
            System.out.println("You dodge the first couple arrows easily. The couple after that, not so much. Life is now "+h.getLife());
        } else if (temp <= 8) {
            attackDecrease(h);
            System.out.println("In hindsight, maybe using your sword to cut through the rope net was a bad idea. Attack is now "+h.getAttack());
        } else if (temp <= 12) {
            defenseDecrease(h);
            System.out.println("Your armor does it's job a little too well, and you discard the pieces. Defense is now "+h.getDefense());
        } else if (temp <= 16) {
            speedDecrease(h);
            System.out.println("Whatever energy you had before got drained by the longest puzzle you've ever dealt with. Speed is now "+h.getSpeed());
        } else {
            moneyDecrease(h);
            System.out.println("Just your luck that you narrowly avoided the deadly spikes only for them to cut open your pockets. Money is now "+h.getMoney());
        }
    }
}
