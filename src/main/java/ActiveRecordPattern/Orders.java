package ActiveRecordPattern;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class Orders implements ActiveRecordPattern {

    @Override
    public boolean update(ArrayList<SimpleEntry<String, String>> criteria) {
        return false;
    }

    @Override
    public boolean save() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }
}
