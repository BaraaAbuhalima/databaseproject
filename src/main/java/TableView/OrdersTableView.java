package TableView;

import javafx.beans.property.*;

public class OrdersTableView extends TableViewPattern {
    private final StringProperty createdTime;
    private final IntegerProperty totalPrice;
    private final IntegerProperty discount;
    private final IntegerProperty customerId;
    private final IntegerProperty employeeId;
    private final IntegerProperty subTotal;

    // Constructor
    public OrdersTableView(int id, String createdTime, int totalPrice, int discount, int customerId,
                           int employeeId, int subTotal) {
        this.id = new SimpleIntegerProperty(id);
        this.createdTime = new SimpleStringProperty(createdTime);
        this.totalPrice = new SimpleIntegerProperty(totalPrice);
        this.discount = new SimpleIntegerProperty(discount);
        this.customerId = new SimpleIntegerProperty(customerId);
        this.employeeId = new SimpleIntegerProperty(employeeId);
        this.subTotal = new SimpleIntegerProperty(subTotal);
    }

    public String getCreatedTime() {
        return createdTime.get();
    }

    public StringProperty createdTimeProperty() {
        return createdTime;
    }

    public int getTotalPrice() {
        return totalPrice.get();
    }

    public IntegerProperty totalPriceProperty() {
        return totalPrice;
    }

    public int getDiscount() {
        return discount.get();
    }

    public IntegerProperty discountProperty() {
        return discount;
    }

    public int getCustomerId() {
        return customerId.get();
    }

    public IntegerProperty customerIdProperty() {
        return customerId;
    }

    public int getEmployeeId() {
        return employeeId.get();
    }

    public IntegerProperty employeeIdProperty() {
        return employeeId;
    }

    public int getSubTotal() {
        return subTotal.get();
    }

    public IntegerProperty subTotalProperty() {
        return subTotal;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime.set(createdTime);
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public void setDiscount(int discount) {
        this.discount.set(discount);
    }

    public void setCustomerId(int customerId) {
        this.customerId.set(customerId);
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId.set(employeeId);
    }

    public void setSubTotal(int subTotal) {
        this.subTotal.set(subTotal);
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getId() {
        return id.get();
    }
}
