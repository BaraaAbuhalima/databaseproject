package ActiveRecordPattern;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.AbstractMap;
import java.util.ArrayList;


public abstract class ActiveRecordPatternClass {
    private String entityName;
    private int id;
    private String sqlStatement;
    private String primaryKey;

    public abstract void save();


    public ActiveRecordPatternClass(String entityName, int id, String primaryKey) {
        this.entityName = entityName;
        this.id = id;
        this.primaryKey = primaryKey;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public int getId() {
        return id;
    }

    public void setSqlStatement(String sqlStatement) {
        this.sqlStatement = sqlStatement;
    }

    public String getSqlStatement() {
        return sqlStatement;
    }


    public boolean update(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        sqlStatement = "UPDATE " + entityName + "\n" +
                "SET ";

        for (int i = 0; i < criteria.size(); i++) {
            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
            if (i < criteria.size() - 1) {
                sqlStatement += " ,";
            }

        }
        sqlStatement += "WHERE " + primaryKey + " =+" + this.id + ";";
        DatabaseOperations.makeQuery(sqlStatement);
        return true;
    }

    public void delete() {


        sqlStatement = "DELETE FROM " + entityName + " WHERE " + primaryKey + " ='" + this.id + "';";
        DatabaseOperations.makeQuery(sqlStatement);

    }


    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria, String entityName) {
        String sqlStatement;
        sqlStatement = "DELETE FROM " + entityName + " WHERE\n";

        for (int i = 0; i < criteria.size(); i++) {
            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
            if (i < criteria.size() - 1) {
                sqlStatement += " AND ";
            }

        }
        DatabaseOperations.makeQuery(sqlStatement);
    }


}
