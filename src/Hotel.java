/**
 * Created by Adrian on 04.06.2016.
 */

import java.sql.*;


public class Hotel {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://192.168.15.85:3306/hotel";

    private Connection conn;
    private Statement stat;

    public Hotel() {
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

    public boolean addCustomer(String imie, String nazwisko, String adres) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call addklient(?, ?)");
            prepStmt.setString(1, nazwisko + " " + imie);
            prepStmt.setString(2, adres);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Add client Error!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addRoom(int Capacity, int numberOFBeds, boolean isBalcony, String roomType, double price) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call addroom(?, ?, ?, ?, ?, ?)");
            prepStmt.setString(1, "0");
            prepStmt.setString(2, "" + Capacity);
            prepStmt.setString(3, "" + numberOFBeds);

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


    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}