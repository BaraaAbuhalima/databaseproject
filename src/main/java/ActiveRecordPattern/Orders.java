package ActiveRecordPattern;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class Orders extends ActiveRecordPatternClass {

    private static String entityName = "orders";
    private String baraa;
    private static ArrayList<Triplet> attributes;

    static {
        attributes = new ArrayList<Triplet>();
        attributes.add(new Triplet<Integer>(Types.INT, "order_id", "setOrder", -1));
        attributes.add(new Triplet<Integer>(Types.INT, "total_price", "setTotalPrice", 0));
        attributes.add(new Triplet<Integer>(Types.INT, "discount", "setDiscount", 0));
        attributes.add(new Triplet<Integer>(Types.INT, "customer_id", "setCustomerId", 0));
    }

    public Orders() {
        super(attributes, entityName);
    }
}
