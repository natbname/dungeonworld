public class DungeonWorld<E> //outter linked class
{
    private Room start; 
    private Room exit;
    private boolean shopTracker = false; //tracks if floor has a shop
    private int floorNumber = 0; //tracks player progress
    
    public DungeonWorld(){}
    
    public void addRoomLeft(E data)
    {
        Room r = new Room();
        r.setData(data);
        Room otherRoom = r;
        while(otherRoom.getLeft() != null)
        {
            otherRoom = r.getLeft();
        }
        otherRoom.setLeft(r);
    }
    
    public void addRoomRight(E data)
    {
        Room r = new Room();
        r.setData(data);
        Room otherRoom = r;
        while(otherRoom.getRight() != null)
        {
            otherRoom = r.getRight();
        }
        otherRoom.setRight(r);
    }
        
    public int roomType()
    {
        double tempDouble = (Math.random() * 4) + 1; //1-4
        int tempInt = (int) tempDouble;
        return tempInt;
    }
            
    public E addData() //does not correctly send set room data
    {
        boolean added = false;
        while(!added)
        {
            int room = roomType();
            if (room == 1) 
            {
                Monster scaryMonster = new Monster(0, 0, 0, 0, 0);
                scaryMonster.monsterFactory(scaryMonster);
                added = true;
                return (E) scaryMonster;
            } 
            else if (room == 2 || room == 3) //items and traps in same class
            {
                Things newThing = new Things();
                added = true;
                return (E) newThing;
            } 
            else if (room == 4 && !shopTracker) 
            {
                Shop newShop = new Shop();
                shopTracker = true;
                added = true;
                return (E) newShop;
            }
        }
        return null;
    }
            
    public void createFloorMap()
    {
        addRoomLeft(addData());
        for(int i = 0; i < 6; i++)
        {
            addRoomRight(addData());
        }
        floorNumber++;
    }
    
    public int getFloorNumber()
    {
        return floorNumber;
    }
    
    public void setFloorNumber(int f)
    {
        floorNumber = f;
    }
}
