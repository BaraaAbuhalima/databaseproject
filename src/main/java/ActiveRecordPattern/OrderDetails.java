package ActiveRecordPattern;

import java.util.AbstractMap;
import java.util.ArrayList;

public class OrderDetails extends ActiveRecordPattern<OrderDetails> {
    private final static String entityName = "OrderDetails";
    private final static String primaryKey = "id";
    private int id;
    private int quantity;
    private int totalPrice;
    private int productId;
    private int orderId;

    public OrderDetails() {
        super(entityName, primaryKey);
        setObj(this);

    }

    public OrderDetails(int quantity, int totalPrice, int productId, int orderId) {
        super(entityName, primaryKey);
        setObj(this);
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.productId = productId;
        this.orderId = orderId;
    }

    public OrderDetails(int orderId) {
        super(entityName, primaryKey);
        setObj(this);
        this.id = orderId;
        super.setId(id);

    }

    public OrderDetails setId(int id) {
        this.id = id;
        super.setId(id);
        return this;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;

    }

    public OrderDetails setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public OrderDetails setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public int getProductId() {
        return productId;
    }

    public OrderDetails setProductId(int productId) {
        this.productId = productId;
        return this;
    }

    public int getOrderId() {
        return orderId;
    }

    public OrderDetails setOrderId(int orderId) {
        this.orderId = orderId;
        return this;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static int size() {
        return findCount(entityName);
    }

    public static OrderDetails findById(int id) {
        return ActiveRecordPattern.findById(id, entityName, primaryKey);
    }

    public static ArrayList<OrderDetails> find(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }

}
