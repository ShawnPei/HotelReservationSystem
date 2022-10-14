package api;

import mode1.Customer;
import mode1.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Arrays;

public class AdminResource {
    static CustomerService customerService = CustomerService.getInstance();
    static ReservationService reservationService = ReservationService.getInstance();

    public static Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public static void addRoom(IRoom rooms){
        reservationService.addRoom(rooms);
    }

    public static void getAllRooms() {
        System.out.println(reservationService.mapOfRoom.values());
    }
    public  static void getAllCustomer(){
        customerService.getAllCustomers();
    }
    public static void displayAllReservations(){
        reservationService.printAllReservation();
    }
}
