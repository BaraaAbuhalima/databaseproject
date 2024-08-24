package ActiveRecordPattern;

import javax.print.attribute.standard.OrientationRequested;
import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class Orders extends ActiveRecordPattern<Orders> {
    private static String entityName = "Orders";
    private static String primaryKey = "id";
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

    public void setId(int id) {
        this.id = id;
        super.setId(id);
    }

    public int getId() {
        return id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrdersId() {
        return OrdersId;
    }

    public void setOrdersId(int OrdersId) {
        this.OrdersId = OrdersId;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static int size() {
        return findCount(entityName);
    }

    public static Orders findById(int id) {
        return ActiveRecordPattern.findByID(id, entityName, primaryKey);
    }

    public static ArrayList<Orders> find(ArrayList<SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }
}

