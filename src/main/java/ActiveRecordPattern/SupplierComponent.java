package ActiveRecordPattern;

import java.util.AbstractMap;
import java.util.ArrayList;

public class SupplierComponent extends ActiveRecordPattern<SupplierComponent> {

    private final static String entityName = "SupplierComponent";
    private int componentId;
    private int supplierId;


    public SupplierComponent(int componentId, int supplierId) {


        super(entityName, "");
        setObj(this);
        this.componentId = componentId;
        this.supplierId = supplierId;

    }

    public SupplierComponent() {
        super(entityName, "");

        setObj(this);

    }

    public SupplierComponent setSupplierId(int supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public SupplierComponent setComponentId(int componentId) {
        this.componentId = componentId;
        return this;
    }

    public int getComponentId() {
        return componentId;
    }

    public int size() {
        return ActiveRecordPattern.findCount(entityName);
    }

    public static SupplierComponent findById(int id, String primaryKey) {
        return ActiveRecordPattern.findById(id, entityName, primaryKey);
    }

    public static void delete(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        ActiveRecordPattern.delete(criteria, entityName);
    }

    public static ArrayList<SupplierComponent> find(ArrayList<AbstractMap.SimpleEntry<String, String>> criteria) {
        return ActiveRecordPattern.find(criteria, entityName);
    }

    public void delete() {
        ArrayList<AbstractMap.SimpleEntry<String, String>> criteria = new ArrayList<AbstractMap.SimpleEntry<String, String>>();
        criteria.add(new AbstractMap.SimpleEntry<String, String>("componentId", "" + componentId));
        criteria.add(new AbstractMap.SimpleEntry<String, String>("supplierID", "" + supplierId));
        delete(criteria, entityName);


    }
}