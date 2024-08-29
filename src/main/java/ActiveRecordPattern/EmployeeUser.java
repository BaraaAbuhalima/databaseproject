package ActiveRecordPattern;

public class EmployeeUser extends ActiveRecordPattern<EmployeeUser> {
    private final static String entityName = "EmployeeUser";
    private final static String primaryKey = "id";

    public EmployeeUser() {
        super(entityName, primaryKey);
        setObj(this);
    }
}
