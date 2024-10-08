package ActiveRecordPattern;

import javassist.*;
import javassist.Modifier;

import java.lang.reflect.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;

public abstract class ActiveRecordPattern<T> {
    private final String entityName;
    private final String primaryKey;
    private int id;
    private T obj;

    private ArrayList<Field> filteredFields;


    public ActiveRecordPattern(String entityName, String primaryKey) {

        this.entityName = entityName;
        this.primaryKey = primaryKey;
        setFilteredFields();
    }

    public int getId() {

        return id;
    }

    protected T setObj(T obj) {
        this.obj = obj;
        return obj;
    }

    public T setId(int id) {
        this.id = id;
        return obj;
    }

    private void setFilteredFields() {

        try {
            filteredFields = new ArrayList<>();

            Class<?> c = Class.forName("ActiveRecordPattern." + this.entityName);
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                if (!(field.getName().equals("entityName") || field.getName().equals("primaryKey") || field.getName()
                        .equals("createdAt") || field.getName().equals("subTotal"))) {
                    filteredFields.add(field);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }


    }


    public void save() {
        try {


            String sqlStatement = "INSERT INTO " + entityName + "(\n";

            for (int i = 0; i < filteredFields.size(); i++) {
                if (filteredFields.get(i).getName().equals("id")) {
                    continue;
                }
                Field field = filteredFields.get(i);

                field.setAccessible(true);
                sqlStatement += field.getName();
                if (i == filteredFields.size() - 1) {
                    sqlStatement += ")";
                } else {
                    sqlStatement += ",";
                }
            }
            if (sqlStatement.charAt(sqlStatement.length() - 1) == ',') {
                sqlStatement = sqlStatement.substring(0, sqlStatement.length() - 1) + ')';
            }
            sqlStatement += "VALUES ('";

            for (int i = 0; i < filteredFields.size(); i++) {
                if (filteredFields.get(i).getName().equals("id")) {
                    continue;
                }
                Field field = filteredFields.get(i);

                sqlStatement += field.get(obj);

                if (i == filteredFields.size() - 1) {
                    sqlStatement += "')";
                } else {
                    sqlStatement += "','";
                }
            }
            if (sqlStatement.charAt(sqlStatement.length() - 1) == ',') {
                sqlStatement = sqlStatement.substring(0, sqlStatement.length() - 1) + ')';
            }
            ResultSet resultSet = DatabaseOperations.makeQuery(sqlStatement);

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public void update(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        String sqlStatement = "UPDATE " + entityName + "\n" +
                "SET ";

        for (int i = 0; i < criteria.size(); i++) {
            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
            if (i < criteria.size() - 1) {
                sqlStatement += " ,";
            }

        }
        sqlStatement += "WHERE " + primaryKey + " =" + this.id + ";";
        DatabaseOperations.makeQuery(sqlStatement);
    }

    public void delete() {


        String sqlStatement = "DELETE FROM " + entityName + " WHERE " + primaryKey + " ='" + this.id + "';";
        DatabaseOperations.makeQuery(sqlStatement);

    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria, String entityName) {

//        System.out.println(entityName);
        String sqlStatement = "DELETE FROM " + entityName + " WHERE\n";
        for (int i = 0; i < criteria.size(); i++) {
            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
            if (i < criteria.size() - 1) {
                sqlStatement += " AND ";
            }
        }
        DatabaseOperations.makeQuery(sqlStatement);
    }


    public static int findCount(String entityName) {
        String sqlStatement = "SELECT COUNT(*) FROM " + entityName + ";";
        ResultSet resultSet = DatabaseOperations.makeQuery(sqlStatement);
        int count = 0;
        try {
            resultSet.next();
            count = resultSet.getInt("count");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static <T> T findById(int id, String entityName, String primaryKey) {
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<>();
        criteria.add(new AbstractMap.SimpleEntry<String, String>(primaryKey, id + ""));
        return find(criteria, entityName).size() != 0 ? (T) find(criteria, entityName).get(0) : null;

    }

    public static <T> ArrayList<T> find(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria, String entityName) {


        String sqlStatement;
        sqlStatement = "select * from " + entityName;
        if (criteria != null) {

            for (int i = 0; i < criteria.size(); i++) {
                if (i == 0) sqlStatement += " where ";
                sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
                if (i < criteria.size() - 1) {
                    sqlStatement += " AND ";
                }
            }
        }

        ResultSet resultSet = DatabaseOperations.makeQuery(sqlStatement);


        ArrayList<Field> filteredFields = new ArrayList<>();
        Class c = null;
        try {
            c = Class.forName("ActiveRecordPattern." + entityName);
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                if (!(field.getName().equals("entityName") || field.getName().equals("primaryKey"))) {
                    filteredFields.add(field);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<T> list = new ArrayList<>();
        try {
            Method[] methods = c.getDeclaredMethods();

            while (resultSet.next()) {
                T newRow = null;
                newRow = (T) c.getDeclaredConstructor().newInstance();

//                System.out.println(newRow);
                for (Field field : filteredFields) {

                    for (Method method : methods) {
                        if (method.toString().toLowerCase().contains("set" + field.getName().toLowerCase())) {

                            if (field.getType().getName().equals("int")) {
                                method.invoke(newRow, resultSet.getInt(field.getName()));

                            } else if (field.getType().getName().contains("String")) {
                                if (resultSet.getString(field.getName()) != null)
                                    method.invoke(newRow, resultSet.getString(field.getName()));
                            } else if (field.getType().getName().contains("LocalDate")) {
                                if (resultSet.getDate(field.getName()) != null)
                                    method.invoke(newRow, resultSet.getDate(field.getName()).toLocalDate());
                            }
                        }
                    }

                }

                list.add(newRow);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return list;

    }


}
