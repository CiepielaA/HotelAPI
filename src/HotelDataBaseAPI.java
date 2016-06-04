/**
 * Created by Adrian on 04.06.2016.
 */

import java.sql.*;

/**
 *  1. Create new HotelDataBaseAPI object.
 *  2. OPEN CONNECTION with database - openConnection() method.
 *  3. Use API.
 *  4. At the end CLOSE CONNECTION with database - closeConnection() method.
 */

public class HotelDataBaseAPI implements HotelAPI {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://192.168.15.51:3306/hotel";

    private Connection conn;
    private Statement stat;

    public void openConnection(){
        try {
            Class.forName(DRIVER).newInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC0");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("Brak sterownika JDBC1");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("Brak sterownika JDBC2");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL,"root", "");
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }
    }

    public boolean addCustomer(String name, String lastName, String address) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call addklient(?, ?)");
            prepStmt.setString(1, lastName + " " + name);
            prepStmt.setString(2, address);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Add client Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteCustomer(int customerID) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call deletecustomer(?)");
            prepStmt.setString(1, ""+ customerID);

            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Delete customer Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addRoom(int Capacity, int numberOfBeds, boolean isBalcony, String roomType, double price) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call addroom(?, ?, ?, ?, ?, ?)");
            prepStmt.setString(1, "0");
            prepStmt.setString(2, "" + Capacity);
            prepStmt.setString(3, "" + numberOfBeds);

            if(isBalcony) {
                prepStmt.setString(4, "1");
            }
            else{
                prepStmt.setString(4, "0");
            }
            prepStmt.setString(5, "" + roomType);
            prepStmt.setString(6, "" + price);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Add room Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteRoom(int roomID) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call deleteroom(?)");
            prepStmt.setString(1, ""+ roomID);

            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Delete room Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean reserve(int customerID, int roomID, String startDate, String endDate) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call reserve(?, ?, ?, ?)");
            prepStmt.setString(1, ""+ customerID);
            prepStmt.setString(2, "" + roomID);
            prepStmt.setString(3, startDate);
            prepStmt.setString(4, endDate);

            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Reserve Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean cancelReservation(int reservationID) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call cancelreservation(?)");
            prepStmt.setString(1, ""+ reservationID);

            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Reserve Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean hireStaff(String name, String lastName, String address, String position) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call hire(?, ?, ?, ?)");
            prepStmt.setString(1, "0");
            prepStmt.setString(2, lastName + " " + name);
            prepStmt.setString(3, address);
            prepStmt.setString(4, position);

            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("hire staff Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean fireStaff(int staffID) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call fire(?)");
            prepStmt.setString(1, "" + staffID);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("fire staff Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean isRoomFree(int roomID) {

        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call isfree(?)");
            prepStmt.setString(1, "" + roomID);
            ResultSet result = prepStmt.executeQuery();
            while(result.next()){
                return result.getBoolean("if");
            }
            return false;
        } catch (SQLException e) {
            System.err.println("is free room Error!");
            e.printStackTrace();
            return false;
        }
    }

    public double showBill(int reservationID) {

        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call showbill(?)");
            prepStmt.setString(1, "" + reservationID);
            ResultSet result = prepStmt.executeQuery();
            while(result.next()){
                return result.getDouble("bill");
            }
            return 0.0;
        } catch (SQLException e) {
            System.err.println("is free room Error!");
            e.printStackTrace();
            return 0.0;
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}