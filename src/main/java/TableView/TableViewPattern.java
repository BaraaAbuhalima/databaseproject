package TableView;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class TableViewPattern {
    protected IntegerProperty id;
    private final BooleanProperty selected = new SimpleBooleanProperty(false);

    public int getId() {
        return id.get();
    }

    public BooleanProperty selectedProperty() {
        return selected;
    }

    public boolean isSelected() {
        return selected.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }


}
