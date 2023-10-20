public class Room<E> //inner linked class.
{
    private E roomData;
    private Room left;
    private Room right;
    
    public Room(){}
    
    public Room(E inRoom)
    {
        roomData = inRoom;
        left = null;
        right = null;
    }
    
    public Room getLeft()
    {
        return left;
    }
    
    public Room getRight()
    {
        return right;
    }
    
    public void setLeft(Room newLeft)
    {
        left = newLeft;
    }
    
    public void setRight(Room newRight)
    {
        left = newRight;
    }
    
    public E getData()
    {
        return roomData;
    }
    
    public void setData(E putInRoom)
    {
        roomData = putInRoom;
    }
}
