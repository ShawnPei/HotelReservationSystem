package api;

import mode1.Room;
import mode1.RoomType;

import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;

public class AdminMenu {
    public static void adminmenu() throws ParseException {
        boolean keeprunning = true;

        while (keeprunning) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Admin Menu");
            System.out.println("------------------------------");
            System.out.println("1.See all Customers");
            System.out.println("2.See all Rooms");
            System.out.println("3.See all Reservations");
            System.out.println("4.Add a Room");
            System.out.println("5.Back to the Main Menu");
            System.out.println("------------------------------");
            System.out.println("Please select a number for the menu option");

            try{
                int selection = Integer.parseInt(sc.nextLine());

                switch (selection) {
                    case 1:
                        AdminResource.getAllCustomer();
                        break;
                    case 2:
                        AdminResource.getAllRooms();
                        break;
                    case 3:
                        AdminResource.displayAllReservations();
                        break;
                    case 4:
                        System.out.println("Please add roomNumber:");
                        Scanner sc1 = new Scanner(System.in);
                        String roomnumber = sc1.nextLine();

                        System.out.println("Please add room price:");
                        Scanner sc2 = new Scanner(System.in);
                        Double roomprice = sc2.nextDouble();

                        System.out.println("Please add room type (Double/Single) :");
                        Scanner sc3 = new Scanner(System.in);
                        String roomtype = sc3.next();

                        boolean determination = ifRoomTypeIsRight(roomtype,roomnumber,roomprice);
                        while(determination){
                            Room room = new Room(roomnumber, roomprice, roomtype);
                            AdminResource.addRoom(room);
                            break;}
                        while(!determination){
                            System.out.println("Please enter valid room type (Double/Single):");
                            Scanner sc4 = new Scanner(System.in);

                            String type1 = sc4.nextLine();
                            boolean determination1=ifRoomTypeIsRight(type1,roomnumber,roomprice);
                            if(determination1){
                                Room room1 = new Room(roomnumber, roomprice, type1);
                                AdminResource.addRoom(room1);
                                break;
                            }
                        }
                        break;
                    case 5:
                        MainMenu.main_menu();
                        break;
                }
            }catch (NumberFormatException ex){
                System.out.println("The number you entered is wrong.Pleas enter a number between 1 and 5");
                AdminMenu.adminmenu();
            }

        }
    }
    public static boolean ifRoomTypeIsRight(String Roomtype,String roomnumber,Double roomprice) {

        if (Objects.equals(Roomtype, RoomType.Double.toString())) {

            boolean flag = true;
                return  flag;
        }else if(Objects.equals(Roomtype, RoomType.Single.toString())) {
            boolean flag1 = true;
            return flag1;
        }
        else {
            boolean flag2 = false;
            return flag2;
        }
    }
}
