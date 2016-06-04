/**
 * Created by Adrian on 04.06.2016.
 */
public class Test {

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.insertCustomer("Karol", "Maciaszek", "Debowa 890");
        hotel.insertCustomer("Piotr", "Wojtecki", "Dupa 123");
        hotel.insertCustomer("Abdul", "Dabdul", "Wal sie 9999");


        hotel.closeConnection();
    }
}
