public class Hero extends Creature
{
    private int currentLife; //changes as game goes on. monster doesnt need to track this
    
    public Hero(int l, int a, int d, int s, int m)
    {
        super(l, a, d, s, m);
        currentLife = getLife(); //initializes currentlife to maxlife from creature constructor.
    }
    
    public int getCurrentLife()
    {
        return currentLife;
    }
    
    public void setCurrentLife(int inLife)
    {
        currentLife = inLife;
    }
    
    public void takeDamage(int damage) //changes current life
    {
        setCurrentLife(getCurrentLife() - damage);
        System.out.println("Ow. Life: "+getCurrentLife());
    }
    
    public void doAttack(Hero h, Monster m) 
    {
        if(attackHit(h,m)) //if hero attack is more than monster def...
        {
            System.out.println("Bam! You do "+h.getAttack()+ " damage.");
            m.takeDamage(h.getAttack()); //monster takes damage equal to hero attack.
        }
    }
    
    
}
