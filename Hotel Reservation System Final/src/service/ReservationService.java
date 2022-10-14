package service;

import mode1.Customer;
import mode1.IRoom;
import mode1.Reservation;
import mode1.Room;

import java.util.*;

public class ReservationService {
    void ReservationService(){};
    static ReservationService obj = null;

    public static ReservationService getInstance(){
        if (obj == null){
            obj = new ReservationService();
        }
        return obj;
    }


    public static Map<String,IRoom> mapOfRoom = new HashMap<>();
    public static Map<Customer,Reservation> mapOfReservation = new HashMap<>();
    public static List<IRoom> listOfRoom = new ArrayList<IRoom>();

    public static Object getKey(Map map, Object value){
        List<Object> keyList = new ArrayList<>();
        for(Object key: map.keySet()){
            if(map.get(key).equals(value)){
                keyList.add(key);
            }
        }
        return keyList;
    }

    public static void addRoom(IRoom room){
        mapOfRoom.put(room.getRoomNumber(),room);
        listOfRoom.add(room);

    }

    public static IRoom getARoom(String roomId){

        return mapOfRoom.get(roomId);
    }

    static void extendReservations(Reservation reservation)
    {
        listOfRoom.add(reservation.getRoom());
    }
    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservation = new Reservation(customer,room,checkInDate,checkOutDate);
        mapOfReservation.put(customer,reservation);

        extendReservations(reservation);
        return reservation;
    }
    public  static Collection<IRoom> findRooms(Date checkIn_Date, Date checkOut_Date) {
        Map<String, IRoom> copyOfRoomMap = new HashMap<>();
        copyOfRoomMap.putAll(mapOfRoom);
        Collection<IRoom> rooms = new HashSet<>();
        for (Reservation reservation : ReservationService.mapOfReservation.values()) {
            if(reservation.getCheckInDate().equals(checkIn_Date)){
                copyOfRoomMap.remove(reservation.getRoom().getRoomNumber());
                rooms = copyOfRoomMap.values();
                return rooms;
            } else if(reservation.getCheckOutDate().equals(checkOut_Date)){
                copyOfRoomMap.remove(reservation.getRoom().getRoomNumber());
                rooms = copyOfRoomMap.values();
                return rooms;
            }else if((reservation.getCheckInDate().before(checkIn_Date))&&(reservation.getCheckOutDate().after(checkOut_Date))){
                copyOfRoomMap.remove(reservation.getRoom().getRoomNumber());
                rooms = copyOfRoomMap.values();
                return rooms;
            }

            else{
                rooms=mapOfRoom.values();
                return rooms;
            }
        }
        rooms=mapOfRoom.values();
        return rooms;
    }

    public static Collection<Reservation> getCustomersReservation (Customer customer){
        Set<Reservation> collection =  new HashSet<>();
        for (Reservation reservation : mapOfReservation.values()) {
            collection.add(reservation);
        }
        return collection;

    }
    public static void printAllReservation(){
        for (Reservation reservation : mapOfReservation.values()) {
            System.out.println(reservation+"\n");
        }

    }

}
