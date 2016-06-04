/**
 * Created by Adrian on 04.06.2016.
 */
public class Test {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
       // hotel.addCustomer("Karol", "Maciaszek", "Debowa 890");
//        hotel.addCustomer("Piotr", "Wojtecki", "Dupa 123");
//        hotel.addCustomer("Abdul", "Dabdul", "Wal sie 9999");

       //hotel.addRoom(5, 5, true, "royal", 50);
//
//      hotel.reserve(0, 0, "2016-06-06", "2016-06-10");

//       hotel.cancelReservation(0);

//        hotel.deleteCustomer(0);

//        hotel.deleteRoom(0);

//        hotel.hireStaff("Jacek", "Dupa", "Dupa 123", "cook");

//        hotel.fireStaff(0);

        System.out.println(hotel.isRoomFree(1));






        hotel.closeConnection();
    }
}
