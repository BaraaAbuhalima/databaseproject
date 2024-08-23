package ActiveRecordPattern;

import java.util.AbstractMap.SimpleEntry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users extends ActiveRecordPatternClass {
    private int userId;
    private String userName;
    private String userRole;
    private String userPassword;
    private static String sqlStatement;
    private static String entityName = "users";

    public Users(String userName, String userRole, String userPassword) {
        super(entityName, -1, "user_id");
        this.userId = userId;
        this.userName = userName;
        this.userRole = userRole;
        this.userPassword = userPassword;

    }

    public Users() {

        super(entityName, -1, "user_id");
        this.userId = -1;
        this.userName = null;
        this.userRole = null;
        this.userPassword = null;
    }

    public Users(int userId) {
        super(entityName, userId, "user_id");
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
        sqlStatement = "select * from users where user_id='" + userID + "'";
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


    public void save() {

        String sqlStatment = "INSERT INTO users(\n" +
                " user_name, user_role, user_password)" +
                "VALUES ('" + this.userName + "','" + this.userRole + "','" + this.userPassword + "');";
        DatabaseOperations.makeQuery(sqlStatment);

    }

    public static int size() {
        return findCount(entityName);
    }

}
