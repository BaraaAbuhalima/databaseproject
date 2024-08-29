package TableView;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductTableView extends TableViewPattern {
    private final StringProperty name;
    private final IntegerProperty price;
    private final StringProperty itemDetails;

    public ProductTableView(int id, String name, int price, String itemDetails) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
        this.itemDetails = new SimpleStringProperty(itemDetails);
        this.id = new SimpleIntegerProperty(id);

    }

    public StringProperty nameProperty() {
        return this.name;
    }

    public IntegerProperty priceProperty() {
        return this.price;
    }

    public StringProperty itemDetailsProperty() {
        return this.itemDetails;
    }

    public String getName() {
        return this.name.get();
    }

    public int getPrice() {
        return this.price.get();
    }

    public String getItemDetails() {
        return this.itemDetails.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails.set(itemDetails);
    }
}
