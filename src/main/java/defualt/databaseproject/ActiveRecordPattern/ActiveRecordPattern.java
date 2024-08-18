package defualt.databaseproject.ActiveRecordPattern;

import java.util.ArrayList;

public interface ActiveRecordPattern<T> {
    public void save();

    public ArrayList<T> find(String column, String value);

    public void update();

    public void delete();
}
