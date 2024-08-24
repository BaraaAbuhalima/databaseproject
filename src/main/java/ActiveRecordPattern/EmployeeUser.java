package ActiveRecordPattern;

public class EmployeeUser extends ActiveRecordPattern<EmployeeUser> {
    private static String entityName = "EmployeeUser";
    private static String primaryKey = "id";

    public EmployeeUser() {
        super(entityName, primaryKey);
        setObj(this);
    }
//    public
}
