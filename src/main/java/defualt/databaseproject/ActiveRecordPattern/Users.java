package defualt.databaseproject.ActiveRecordPattern;

import defualt.databaseproject.DatabaseOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users implements ActiveRecordPattern<Users> {
    private int userId;
    private String userName;
    private String userRole;
    private String userPassword;

    public Users(String userName, String userRole, String userPassword) {

    }

    public Users() {
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

    public static ArrayList<Users> find(String column, String value) {

        ArrayList<Users> usersList = new ArrayList<Users>();

        String sqlStatement = "select * from users where " + column + " = '" + value + "'";

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

    @Override
    public void update() {

    }

    public void save() {

    }

    public void delete() {

    }


}
