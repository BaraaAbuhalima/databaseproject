package ActiveRecordPattern;

import java.util.AbstractMap.SimpleEntry;

import defualt.databaseproject.DatabaseOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users implements ActiveRecordPattern {
    private int userId;
    private String userName;
    private String userRole;
    private String userPassword;


    private static String sqlStatement;

    public Users(String userName, String userRole, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
        this.userPassword = userPassword;

    }

    public Users() {
        this.userId = -1;
        this.userName = null;
        this.userRole = null;
        this.userPassword = null;
    }

    public Users(int userId) {
        this.userId = userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }


    public String getUserName() {
        return this.userName;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public int getUserId() {
        return this.userId;
    }

    public static ArrayList<Users> find(ArrayList<SimpleEntry<String, String>> criteria) {

        ArrayList<Users> usersList = new ArrayList<Users>();

        sqlStatement = "select * from users where ";

        for (int i = 0; i < criteria.size(); i++) {
            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
            if (i < criteria.size() - 1) {
                sqlStatement += " AND";
            }

        }

        ResultSet resultSet = DatabaseOperations.makeQuery(sqlStatement);

        try {

            while (resultSet.next()) {
                Users newUser = new Users();
                newUser.setUserId(resultSet.getInt("user_id"));

                newUser.setUserName(resultSet.getString("user_name"));
                newUser.setUserRole(resultSet.getString("user_role"));
                newUser.setUserPassword(resultSet.getString("user_password"));
                usersList.add(newUser);
            }

        } catch (SQLException e) {
            System.out.println("Error while finding users");
        }
        return usersList;

    }

    public static Users findByID(int userID) {
        sqlStatement = "select * from users where " + "user_id ='" + userID + "'";
        ResultSet resultSet = DatabaseOperations.makeQuery(sqlStatement);
        Users newUser = null;
        try {
            while (resultSet.next()) {
                newUser = new Users();
                newUser.setUserId(resultSet.getInt("user_id"));
                newUser.setUserName(resultSet.getString("user_name"));
                newUser.setUserRole(resultSet.getString("user_role"));
                newUser.setUserPassword(resultSet.getString("user_password"));
            }
        } catch (SQLException e) {

            System.out.println("Error while finding users");
        }
        return newUser;

    }

    @Override
    public boolean update(ArrayList<SimpleEntry<String, String>> criteria) {
        if (Users.findByID(userId) == null) {
            return false;
        }
        sqlStatement = "UPDATE users\n" +
                "SET ";

        for (int i = 0; i < criteria.size(); i++) {
            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
            if (i < criteria.size() - 1) {
                sqlStatement += " ,";
            }

        }
        sqlStatement += "WHERE user_id=" + this.userId + ";";
        DatabaseOperations.makeQuery(sqlStatement);
        return true;
    }


    @Override
    public boolean save() {
        if (userPassword != null && userRole != null && userName != null) {
            String sqlStatment = "INSERT INTO users(\n" +
                    " user_name, user_role, user_password)" +
                    "VALUES ('" + this.userName + "','" + this.userRole + "','" + this.userPassword + "');";
            DatabaseOperations.makeQuery(sqlStatment);

            return true;
        }
        return false;
    }

    @Override
    public boolean delete() {

        if (Users.findByID(userId) != null) {

            sqlStatement = "DELETE FROM users WHERE user_id='" + userId + "';";
            DatabaseOperations.makeQuery(sqlStatement);

            return true;
        }
        return false;
    }


    public static void delete(ArrayList<SimpleEntry<String, String>> criteria) {

        sqlStatement = "DELETE FROM users WHERE\n";

        for (int i = 0; i < criteria.size(); i++) {
            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
            if (i < criteria.size() - 1) {
                sqlStatement += " AND ";
            }

        }
        System.out.println(sqlStatement);
        DatabaseOperations.makeQuery(sqlStatement);
    }


}
