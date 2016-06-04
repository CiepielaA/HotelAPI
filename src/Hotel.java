/**
 * Created by Adrian on 04.06.2016.
 */

import java.sql.*;


public class Hotel {

    public static final String DRIVER = "org.mysql.JDBC";
    public static final String DB_URL = "jdbc:mysql://192.168.15.85:3306/hotel";

    private Connection conn;
    private Statement stat;

    public Hotel() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://192.168.15.85:3306/hotel","root", "");
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

    }

    public boolean insertCustomer(String imie, String nazwisko, String adres) {
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "call addklient(?, ?)");
            prepStmt.setString(1, nazwisko + " " + imie);
            prepStmt.setString(2, adres);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu czytelnika");
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