package mode1;

public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, Double price, String enumeration) {
        super(roomNumber, price, enumeration);
        price=0.0;
    }
    @Override
    public String toString(){
        return "Free room is : "+getRoomNumber()+" ,price is : "+getRoomPrice()+" ,room type is : "+getRoomType();
    }


}
