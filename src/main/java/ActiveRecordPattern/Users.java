package ActiveRecordPattern;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Users extends ActiveRecordPattern<Users> {
    private String name;
    private String role;
    private String password;
    private static String entityName = "Users";
    private static String primaryKey = "id";

    public Users(String name, String role, String password) {
        super(entityName, primaryKey);
        setObj(this);
        this.name = name;
        this.role = role;
        this.password = password;

    }

    public Users() {
        super(entityName, primaryKey);
        setObj(this);
        this.name = null;
        this.role = null;
        this.password = null;
    }

    public Users(int userId) {
        super(entityName, primaryKey);
        setObj(this);
        this.id = userId;
    }


    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }


    public String getName() {
        System.out.println(name);
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static int size() {
        return findCount(entityName);
    }

    public static Users findById(int id) {
        return ActiveRecordPattern.findByID(id, entityName, primaryKey);
    }

    public static ArrayList<Users> find(ArrayList<SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }


}
