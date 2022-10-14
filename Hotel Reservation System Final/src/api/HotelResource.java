package api;

import mode1.Customer;
import mode1.IRoom;
import mode1.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static api.AdminResource.customerService;

public class HotelResource {
    private static HotelResource hotelResource =null;
    public static HotelResource getInstance(){
        if(hotelResource==null){
            hotelResource=new HotelResource();
        }
        return hotelResource;
    }


    public static Customer getCustomer(String email){

        return CustomerService.getInstance().getCustomer(email);
    }
    public static void createACustomer(String email,String firstName,String lastName){
        CustomerService.getInstance().addCustomer(email,firstName,lastName);
    }

    public static IRoom getRoom(String roomNumber){

        return ReservationService.getInstance().getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room , Date checkInDate,Date checkOutDate){
        return ReservationService.getInstance().reserveARoom(CustomerService.getInstance().mapOfCustomer.get(customerEmail),room,checkInDate,checkOutDate);
    }

    public  Collection<Reservation> getCustomersReservation(String customerEmail){
        return ReservationService.getInstance().getCustomersReservation(CustomerService.getInstance().getCustomer(customerEmail));
    }

    public  static Collection<IRoom> findARoom (Date checkIn,Date checkOut){
        return ReservationService.getInstance().findRooms(checkIn,checkOut);
    }


}
