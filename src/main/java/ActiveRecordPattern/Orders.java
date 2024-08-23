package ActiveRecordPattern;

import javax.print.attribute.standard.OrientationRequested;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class Orders extends ActiveRecordPattern<Orders> {


    public Orders(String entityName, String primaryKey) {
        super(entityName, primaryKey);
    }
}
