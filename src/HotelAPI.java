/**
 * Created by Adrian on 04.06.2016.
 */
public interface HotelAPI {

    boolean addCustomer(String name, String lastName, String address);

    boolean deleteCustomer(int customerID);

    boolean addRoom(int Capacity, int numberOfBeds, boolean isBalcony, String roomType, double price);

    boolean deleteRoom(int roomID);

    boolean reserve(int customerID, int roomID, String startDate, String endDate);

    boolean cancelReservation(int reservationID);

    boolean hireStaff(String name, String lastName, String address, String position);

    boolean fireStaff(int staffID);

    boolean isRoomFree(int roomID);

    double showBill(int reservationID);

}
