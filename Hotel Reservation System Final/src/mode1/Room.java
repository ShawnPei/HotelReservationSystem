package mode1;

public class Room implements IRoom {
    private final String roomNumber;
    private final Double price;
    private final String enumeration;



    public Room(String roomNumber, Double price, String enumeration) {
        super();
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }



    @Override
    public String getRoomNumber(){
        return roomNumber;
    }
    @Override
    public Double getRoomPrice(){
        return price;
    }

    @Override
    public String getRoomType(){
        return enumeration;
    }

    @Override
    public boolean isFree(){
        return false;
    }
    @Override
    public String toString(){
        return "The room number is: "+roomNumber+" ,its price is: "+price+" ,room type is: "+enumeration+"\n";
    }




}
