package ActiveRecordPattern;


public class Triplet<T> {
    private Types type;
    private String columnName;
    private String methodeName;
    private T value;

    public Types getType() {
        return type;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getMethodeName() {
        return methodeName;
    }

    public T getValue() {
        return value;
    }

    public Triplet(Types type, String columnName, String methodeName, T value) {
        this.type = type;
        this.columnName = columnName;
        this.methodeName = methodeName;
        this.value = value;
    }
}
