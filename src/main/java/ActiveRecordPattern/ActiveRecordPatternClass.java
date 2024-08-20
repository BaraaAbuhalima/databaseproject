package ActiveRecordPattern;

import defualt.databaseproject.DatabaseOperations;

import java.util.ArrayList;


public class ActiveRecordPatternClass {

    private ArrayList<Triplet> attributes;
    private String entityName;
    private String sqlStatement;

    public ActiveRecordPatternClass(ArrayList<Triplet> attributes, String entityName) {
        this.attributes = attributes;
        this.entityName = entityName;
    }


//    public static <T> ArrayList<T> findAll(ArrayList<Triplet> attributes, Class<T> clazz, ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
//
//        String sqlStatement;
//
//        ArrayList<T> arrayListList = new ArrayList<T>();
//
//        sqlStatement = "select * from " + entityName + " where ";
//        for (int i = 0; i < criteria.size(); i++) {
//            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
//            if (i < criteria.size() - 1) {
//                sqlStatement += " AND";
//            }
//
//        }
//
//        System.out.println(sqlStatement);
//        ResultSet resultSet = DatabaseOperations.makeQuery(sqlStatement);
//        ArrayList<T> rowsList = new ArrayList<T>();
//        try {
//
//            while (resultSet.next()) {
//                try {
//                    T tuple = clazz.getDeclaredConstructor().newInstance();
//                    attributes.forEach(attribute -> {
//                        try {
//                            if (attribute.getType().equals(Types.STRING)) {
//                                Method method = clazz.getMethod(attribute.getMethodeName(), String.class);
//                                String temp = resultSet.getString(attribute.getColumnName());
//                                method.invoke(tuple, temp);
//                            } else if (attribute.getType().equals(Types.INT)) {
//                                int temp = resultSet.getInt(attribute.getColumnName());
//                                Method method = clazz.getMethod(attribute.getMethodeName(), int.class);
//                                method.invoke(tuple, temp);
//                            }
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
////                            throw new RuntimeException(e);
//                        }
//                    });
//                    rowsList.add(tuple);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error while finding users");
//        }
//
//
//        return rowsList;
//
//    }

    public void save() {
        sqlStatement = "INSERT * from " + entityName + " (\n";
        for (int i = 0; i < attributes.size(); i++) {
            sqlStatement += attributes.get(i).getColumnName();
            if (i < attributes.size() - 1) {
                sqlStatement += " , ";
            } else {
                sqlStatement += ")";
            }

        }
        sqlStatement += "VALUES ( ";
        for (int i = 0; i < attributes.size(); i++) {
            sqlStatement += "'" + attributes.get(i).getValue() + "'";
            if (i < attributes.size() - 1) {
                sqlStatement += " , ";
            } else {
                sqlStatement += ")";
            }

        }
        DatabaseOperations.makeQuery(sqlStatement);
    }

}
