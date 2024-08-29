package ActiveRecordPattern;

import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;


import java.util.ArrayList;

public class Users extends ActiveRecordPattern<Users> {
    private String name;
    private String role;
    private int id;
    private String password;
    private final static String entityName = "Users";
    private final static String primaryKey = "id";

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
        super.setId(id);
    }


    public Users setRole(String role) {
        this.role = role;
        return this;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public int getId() {

        return id;
    }

    public Users setId(int id) {
        super.setId(id);
        this.id = id;
        return this;
    }

    public Users setName(String name) {
        this.name = name;
        return this;
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
        return ActiveRecordPattern.findById(id, entityName, primaryKey);
    }

    public static ArrayList<Users> find(ArrayList<SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }


}
