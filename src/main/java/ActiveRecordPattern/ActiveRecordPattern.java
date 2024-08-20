package ActiveRecordPattern;

import java.util.AbstractMap;
import java.util.ArrayList;

public interface ActiveRecordPattern {

    public boolean update(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria);

    public boolean save();

    public static <T> T findByID(int userID) {
        return null;
    }

    public static <T> ArrayList<T> find() {
        return null;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {

    }

    public boolean delete();


}

