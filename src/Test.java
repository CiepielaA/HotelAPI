/**
 * Created by Adrian on 04.06.2016.
 */
public class Test {

    public static void main(String[] args) {

        HotelDataBaseAPI hotel = new HotelDataBaseAPI();
        hotel.openDataBaseConnection();

//        hotel.addCustomer("Karol", "Maciaszek", "Debowa 890");
//        hotel.addCustomer("Piotr", "Wojtecki", "Dupa 123");
//        hotel.addCustomer("Abdul", "Dabdul", "Wal sie 9999");

//       hotel.addRoom(5, 5, true, "royal", 50);
//       hotel.addRoom(1, 2, false, "normal", 30);
//       hotel.addRoom(3, 3, true, "apartment", 40);
//
//      hotel.reserve(0, 0, "2016-06-08", "2016-07-10");
//      hotel.reserve(0, 0, "2016-07-08", "2016-08-10");
//      hotel.reserve(0, 0, "2016-09-08", "2016-10-10");
//      hotel.reserve(0, 0, "2016-11-08", "2016-12-10");

//       hotel.cancelReservation(0);

//        hotel.deleteCustomer(0);

//        hotel.deleteRoom(0);

//        hotel.hireStaff("Jacek", "Dupa", "Dupa 123", "cook");
//        hotel.hireStaff("Mietek", "Kutas", "Kutas 123", "manager");

//        hotel.fireStaff(0);

//        System.out.println("Room 0 is free: " + hotel.isRoomFree(0));
//        System.out.println("Room 1 is free: " + hotel.isRoomFree(1));
//        System.out.println("Room 2 is free: " + hotel.isRoomFree(2));
//
//
//        System.out.println("reservation 0: " + hotel.showBill(0));
//        System.out.println("reservation 1: " + hotel.showBill(1));

        System.out.println("1: " + hotel.isRoomFree(0, "2016-06-01", "2016-06-07"));
        System.out.println("2: " + hotel.isRoomFree(0, "2016-07-09", "2016-08-11"));
        System.out.println("3: " + hotel.isRoomFree(0, "2016-11-09", "2016-12-09"));
        System.out.println("4: " + hotel.isRoomFree(0, "2016-05-09", "2016-05-21"));
        System.out.println("5: " + hotel.isRoomFree(0, "2016-06-05", "2016-12-21"));
        System.out.println("6: " + hotel.isRoomFree(0, "2017-06-05", "2017-12-21"));
        System.out.println("7: " + hotel.isRoomFree(0, "2016-10-11", "2016-11-07"));


        hotel.closeDataBaseConnection();
    }
}
