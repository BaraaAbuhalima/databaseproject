package TableView;

import ActiveRecordPattern.ActiveRecordPattern;
import ActiveRecordPattern.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.*;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.ArrayList;

public class TableViewEditor {
    public static <S> void configureIntegerColumn(
            TableColumn<S, Integer> column,
            PropertyGetter<S, IntegerProperty> propertyGetter,
            PropertySetter<S, Integer> propertySetter) {
        column.setCellValueFactory(cellData -> propertyGetter.getProperty(cellData.getValue()).asObject());
        column.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        column.setOnEditCommit(event -> propertySetter.setProperty(event.getRowValue(), event.getNewValue()));
    }

    // Utility function for setting up String columns
    public static <S> void configureStringColumn(TableColumn<S, String> column,
                                                 PropertyGetter<S, StringProperty> propertyGetter,
                                                 PropertySetter<S, String> propertySetter) {
        column.setCellValueFactory(cellData -> propertyGetter.getProperty(cellData.getValue()));
        column.setCellFactory(TextFieldTableCell.forTableColumn(new DefaultStringConverter()));
        column.setOnEditCommit(event -> propertySetter.setProperty(event.getRowValue(), event.getNewValue()));
    }


    // Functional interface for getting property
    @FunctionalInterface
    public interface PropertyGetter<S, P> {
        P getProperty(S item);
    }

    // Functional interface for setting property
    public @FunctionalInterface
    interface PropertySetter<S, V> {
        void setProperty(S item, V value);
    }

    private static void update(TableViewPattern object, Field field, String newVal) {
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
        criteria.add(new AbstractMap.SimpleEntry<String, String>(field.getName(), newVal));
        System.out.println(object.getClass().getName().toLowerCase());
        if (object.getClass().getName().toLowerCase().contains("component")) {
            Component component = new Component(object.getId());
            component.update(criteria);
        } else if (object.getClass().getName().toLowerCase().contains("employee")) {
            Employee employee = new Employee(object.getId());
            employee.update(criteria);
        } else if (object.getClass().getName().toLowerCase().contains("supplier")) {
            Supplier supplier = new Supplier(object.getId());
            supplier.update(criteria);
        } else if (object.getClass().getName().toLowerCase().contains("product")) {
            Product product = new Product(object.getId());
            product.update(criteria);
        }
    }

    public void addPropertyChangeListeners(TableViewPattern object) {
        // Iterate over all fields of the object's class
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object property = field.get(object);

                if (property instanceof IntegerProperty) {
                    ((IntegerProperty) property).addListener((obs, oldVal, newVal) -> {
                        update(object, field, "" + newVal);
                    });
                } else if (property instanceof StringProperty) {
                    ((StringProperty) property).addListener((obs, oldVal, newVal) -> {
                        update(object, field, newVal);
                    });
                } else if (property instanceof BooleanProperty) {
                    ((BooleanProperty) property).addListener((obs, oldVal, newVal) -> {
                    });
                } else if (property instanceof ObjectProperty) {
                    ((ObjectProperty<?>) property).addListener((obs, oldVal, newVal) -> {
                        update(object, field, newVal.toString());
                    });
                }
                // Add other property types as needed
            } catch (IllegalAccessException e) {
                e.printStackTrace(System.out);
            }
        }
    }
}
