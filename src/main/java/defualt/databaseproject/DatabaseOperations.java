package defualt.databaseproject;

import java.sql.*;
import java.util.Locale;

public final class DatabaseOperations {

    private static final String IP = "194.164.76.4";
    private static final String PORT = "5432";
    private static final String USER = "baraamoh";
    private static final String PASSWORD = "baraamoh12345";
    private static final String DATABASE = "baraamoh";
    private static final String URL = "jdbc:postgresql://" + IP + ":" + PORT + "/" + DATABASE;
    private static Connection connection;
    private static Statement statement;
    private static final String DRIVERMANAGER = "org.postgresql.Driver";

    public DatabaseOperations() {

    }

    public static void initilizeConnection() {
        try {

            Class.forName(DRIVERMANAGER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            System.out.println("Connected to database successfully");

        } catch (ClassNotFoundException e) {

            System.out.println("Driver not found");

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }


    public static void closeConnection() {
        try {

            connection.close();

        } catch (SQLException e) {

            System.out.println("Error closing connection");

        }

    }

    public static ResultSet makeQuery(String query) {
        ResultSet resultSet = null;

        try {

            if (query.trim().toLowerCase().startsWith("select")) {
                resultSet = statement.executeQuery(query);


            } else {

                statement.executeUpdate(query);

            }

            System.out.println("query: " + query + "Executed Successfully");


        } catch (SQLException e) {

            System.err.println(e.getMessage());

        }
        return resultSet;

    }

}
