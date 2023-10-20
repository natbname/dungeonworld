import java.util.Scanner;
public class DungeonEngine 
{
    DungeonWorld mainDungeon = new DungeonWorld();
    Hero myHero = new Hero(200,10,7,7,25);
    Scanner gameScan = new Scanner(System.in);
    Shop s = new Shop();
    private int go = 0;
    private Room room; 
    
    DungeonEngine(){}
    
    public void run() 
    {
        System.out.println("You wake up in a dark room that you don't remember entering. There's a door to your left, and an identical one to your right.");
        while(myHero.getCurrentLife() != 0)
        {
            mainDungeon.createFloorMap(); //stops here 
            while(room != null)
            {
                System.out.println("What do you want to do? (enter 1 or 2)\n1. Go left \n2. Go right");
                go = gameScan.nextInt();
                if (go == 1) 
                {
                    System.out.println("You decide to go left.");
                    room = room.getLeft();
                } 
                else if (go == 2) 
                {
                    System.out.println("You decide to go right.");
                    room = room.getRight();
                }

                if (room.getData() instanceof Monster) 
                {
                    myHero.attackSequence(myHero, (Monster) room.getData());
                } 
                else if (room.getData() instanceof Things) 
                {
                    System.out.println("This room is more of a hallway than anything. Almost completely empty, except for whatever's on the floor over there...");
                    Things thing = (Things) room.getData();
                    int chance = myHero.coinFlip();
                    if (chance == 0) 
                    {
                        System.out.println("Oh god, a trap!");
                        thing.trapMaker(myHero);
                    } 
                    else if (chance == 1) 
                    {
                        System.out.println("Oh, sweet, an item!");
                        thing.itemMaker(myHero);
                    }
                } 
                else if (room.getData() instanceof Shop) 
                {
                    Shop newShop = (Shop) room.getData();
                    newShop.shopping(myHero);
                }
            }
            
        }
        gameOver(myHero);
    }
    
    public void gameOver(Hero h) 
    {
        System.out.println("GAME OVER.");
        System.out.println("Final attack: "+h.getAttack()+"\nFinal defense: "+h.getDefense()+"\nFinal speed: "+h.getSpeed()+"\nFinal money: "+h.getMoney());
        System.out.println("You made it to floor "+mainDungeon.getFloorNumber()+"!");
        System.out.println("Try again? (Y/N)");
        String again = gameScan.next();
        if(again.equals("Y")||again.equals("y"))
        {
            run();
        }
    }
}
