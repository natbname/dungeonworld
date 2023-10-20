import java.util.Scanner;
        
public class Shop 
{
    private Things shopItem = new Things();
    private int itemType = 0;
    private int[] types = {0,0,0};
    private String itemString = "";
    private int[] prices = {0,0,0};
    private int increase = 0;
    
    private boolean hasOne = true;
    private boolean hasTwo = true;
    private boolean hasThree = true;
    
    public Shop(){}
    
    public String itemDisplay()
    {
        if (shopItem.randInt() >= 16) {
            itemType = 1;
            return "will heal damage.";
        } else if (shopItem.randInt() >= 11) {
            itemType = 2;
            return "will make you stronger.";
        } else if (shopItem.randInt() >= 6) {
            itemType = 3;
            return "will protect you.";
        } else if (shopItem.randInt() >= 1) {
            itemType = 4;
            return "will make you faster.";
        }
        return "";
    }
    
    public int price()
    {
        return (15+shopItem.randInt());
    }
    
    public void itemEffect(Hero h)
    {
        if(itemType == 1)
        {
            int temp = h.getLife();
            shopItem.lifeIncrease(h);
            itemString = "Life";
            increase = h.getLife() - temp;
        }
        else if(itemType == 2)
        {
            int temp = h.getAttack();
            shopItem.attackIncrease(h);
            itemString = "Attack";
            increase = h.getAttack() - temp;
        }
        else if(itemType == 3)
        {
            int temp = h.getDefense();
            shopItem.defenseIncrease(h);
            itemString = "Defense";
            increase = h.getDefense() - temp;
        }
        else if(itemType == 4)
        {
            int temp = h.getSpeed();
            shopItem.speedIncrease(h);
            itemString = "Speed";
            increase = h.getSpeed() - temp;
        }
    }
    
    
    public void shopping(Hero h)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("The room has a small table crowded with three items against one wall.");
        for(int i = 0; i < 3; i++) //3 items per room
        {
            prices[i] = price();
            System.out.println((i+1) +". It looks like this "+itemDisplay()+" It's labeled with the number "+ prices[i]+ "");
            types[i] = itemType;
        }
        
        while(hasOne || hasTwo || hasThree)
        {
            System.out.println("You have "+ h.getMoney()+" coins. What are you taking? (type 1,2,3, or 0 to leave.)");
            int choice = s.nextInt();
        
            if (choice == 1)
            {
                if(h.getMoney() >= prices[0] && hasOne)
                {
                    itemType = types[0];
                    System.out.println("Your pockets feel lighter...");
                    h.setMoney(h.getMoney() - prices[0]);
                    itemEffect(h);
                    System.out.println("("+itemString+ " increases by "+increase+"!)");
                    hasOne = false;
                }
                else if(h.getMoney() < prices[0])
                {
                    System.out.println("It's stuck to the table.");
                }
                else if(!hasOne)
                {
                    System.out.println("You already bought that!");
                }
            }
            else if (choice == 2)
            {
                if (h.getMoney() >= prices[1]) {
                    itemType = types[1];
                    System.out.println("Your pockets feel lighter...");
                    h.setMoney(h.getMoney() - prices[1]);
                    itemEffect(h);
                    System.out.println("("+itemString+ " increases by "+increase+"!)");
                    hasTwo = false;
                } else if (h.getMoney() < prices[1]){
                    System.out.println("It's stuck to the table.");
                }
                else if(!hasTwo)
                {
                    System.out.println("You already bought that!");
                }
            }
            else if (choice == 3)
            {
                if (h.getMoney() >= prices[2]) {
                    itemType = types[2];
                    System.out.println("Your pockets feel lighter...");
                    h.setMoney(h.getMoney() - prices[2]);
                    itemEffect(h);
                    System.out.println("("+itemString+ " increases by "+increase+"!)");
                    hasThree = false;
                } else if (h.getMoney() < prices[3]){
                    System.out.println("It's stuck to the table.");
                }
                else if(!hasThree)
                {
                    System.out.println("You already bought that!");
                }
            }
            else if (choice == 0)
            {
                hasOne = false;
                hasTwo = false;
                hasThree = false;  
            }
        }
        System.out.println("Alright, time to go.");
        //move to next room
    }  
}
