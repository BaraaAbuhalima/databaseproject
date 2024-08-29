package ActiveRecordPattern;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class Orders extends ActiveRecordPattern<Orders> {
    private final static String entityName = "Orders";
    private final static String primaryKey = "id";
    private LocalDate createdAt;
    private int id;
    private int totalPrice;
    private int discount;
    private int customerId;
    private int OrdersId;
    private int subTotal;

    public Orders() {
        super(entityName, primaryKey);
        setObj(this);
    }

    public Orders(LocalDate createdAt, int totalPrice, int discount, int customerId, int OrdersId, int subTotal) {
        super(entityName, primaryKey);
        setObj(this);
        this.createdAt = createdAt;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.customerId = customerId;
        this.OrdersId = OrdersId;
        this.subTotal = subTotal;

    }

    public Orders(int orderId) {

        super(entityName, primaryKey);
        setObj(this);
        this.id = orderId;
        super.setId(orderId);
    }

    public Orders setId(int id) {
        this.id = id;
        super.setId(id);
        return this;
    }

    public int getId() {
        return id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Orders setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Orders setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public int getDiscount() {
        return discount;
    }

    public Orders setDiscount(int discount) {
        this.discount = discount;
        return this;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Orders setCustomerId(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public int getOrdersId() {
        return OrdersId;
    }

    public Orders setOrdersId(int OrdersId) {
        this.OrdersId = OrdersId;
        return this;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public Orders setSubTotal(int subTotal) {
        this.subTotal = subTotal;
        return this;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static int size() {
        return findCount(entityName);
    }

    public static Orders findById(int id) {
        return ActiveRecordPattern.findById(id, entityName, primaryKey);
    }

    public static ArrayList<Orders> find(ArrayList<SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }
}

