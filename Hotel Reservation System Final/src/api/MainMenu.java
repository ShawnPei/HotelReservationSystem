package api;

import Testing.HotelReservationSystem;
import mode1.Customer;
import mode1.IRoom;
import mode1.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import static service.ReservationService.mapOfReservation;

public class MainMenu {


    public static void main_menu() throws ParseException {


        boolean keep_running = true;
        while (keep_running) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Main Menu");
            System.out.println("------------------------------");
            System.out.println("1.Find and reserve a room");
            System.out.println("2.See my reservations");
            System.out.println("3.Create an account");
            System.out.println("4.Admin");
            System.out.println("5.Exit");
            System.out.println("------------------------------");
            System.out.println("Please select a number for the menu option");
            int selection = 0;
            try {
                selection = Integer.parseInt(sc.nextLine());


            } catch (Exception e) {

                System.out.println("Please enter a number between 1 and 5 \n\n");
                MainMenu.main_menu();

            }
            switch (selection) {
                case 1:
                    findAndReserve();
                    break;
                case 2:
                    myReservation();
                    break;
                case 3:
                    createAccount();
                    break;
                case 4:
                    AdminMenu.adminmenu();
                    break;
                case 5:
                    System.exit(0);
                    break;


            }

        }
    }
                private static void findAndReserve() throws ParseException {
                    Scanner sc1 = new Scanner(System.in);
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Please type in check in date (yyyy-mm-dd):");
                    String check_in_date = sc1.nextLine();
                    System.out.println("Please type in check out date (yyyy-mm-dd):");
                    String check_out_date = sc2.nextLine();

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date checkIn = sdf.parse(check_in_date);
                    Date checkOut = sdf.parse(check_out_date);

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("do you want to book a room? YES/NO");
                    String wantToBook = scanner.nextLine();
                    if (Objects.equals(wantToBook, "YES")) {
                        System.out.println("Do you have an account? YES/NO?");
                        String haveAccount = scanner.nextLine();
                        if (Objects.equals(haveAccount, "YES")) {
                            System.out.println("please enter your email");
                            String email = scanner.nextLine();
                            System.out.println(HotelResource.findARoom(checkIn, checkOut));
                            if (HotelResource.findARoom(checkIn, checkOut).isEmpty()) {

                                Calendar now_checkIn = Calendar.getInstance();
                                Calendar now_checkOut = Calendar.getInstance();

                                now_checkIn.setTime(checkIn);
                                now_checkOut.setTime(checkOut);
                                now_checkIn.add(Calendar.DAY_OF_YEAR, 7);
                                now_checkOut.add(Calendar.DAY_OF_YEAR, 7);

                                Date CheckIn = now_checkIn.getTime();
                                Date CheckOut = now_checkOut.getTime();

                                System.out.println("In the previous date range, there is no room available \n" +
                                        "We automatically search for available rooms seven days after\n");

                                System.out.println(HotelResource.findARoom(CheckIn, CheckOut));
                                System.out.println("Please select a room:\r");
                                Scanner new_room_number = new Scanner(System.in);
                                String new_roomID = new_room_number.nextLine();


                                HotelResource.bookARoom(email, HotelResource.getRoom(new_roomID), CheckIn, CheckOut);
                            } else {
                                System.out.println("Pleas choose a room number:");
                                Scanner roomnumber = new Scanner(System.in);
                                String roomID = roomnumber.nextLine();
                                HotelResource.bookARoom(email, HotelResource.getRoom(roomID), checkIn, checkOut);
                            }
                        } else if (Objects.equals(haveAccount, "NO")) {
                            createAccount();
                        }
                    } else if (Objects.equals(wantToBook, "NO")) {
                        return;
                    }
                }
                private static void myReservation(){
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("please enter your email");
                    String email = scanner1.nextLine();
                    Collection<Reservation> reservations = HotelResource.getInstance().getCustomersReservation(email);
                    if (reservations == null) {
                        System.out.println("no reservation is found");
                        return;
                    }
                    for (Reservation reservation : reservations) {
                        System.out.println(reservation.toString());
                    }
                }

                private static void createAccount() throws ParseException {
                    System.out.println("Please enter your first name：");
                    Scanner sc7 = new Scanner(System.in);
                    String firstname = sc7.nextLine();

                    System.out.println("Please enter your last name：");
                    Scanner sc8 = new Scanner(System.in);
                    String lastname = sc8.nextLine();

                    System.out.println("Please enter your email(eg. name@domain.com)：");
                    Scanner sc9 = new Scanner(System.in);
                    String email = sc9.nextLine();

                    String emailRegex1= "^(.+)@(.+).(.+)$";
                    Pattern pattern1 = Pattern.compile(emailRegex1);

                    if(!pattern1.matcher(email).matches()){
                        System.out.println("The email address you typed in is invalid,pleas type in again.");
                        MainMenu.main_menu();
                    }

                }


}


