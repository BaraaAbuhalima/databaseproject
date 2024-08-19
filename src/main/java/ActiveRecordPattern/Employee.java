package ActiveRecordPattern;

import java.util.AbstractMap.SimpleEntry;

import defualt.databaseproject.DatabaseOperations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Employee implements ActiveRecordPattern {
    private int employeeId;
    private String firstName;
    private String secondName;
    private String lastNameS;
    private int salary;
    private String email;
    private String phone;
    private String city;
    private String street;
    private String zipCode;
    private String country;
    private static String entityName = "employee ";
    private String gender;
    private static String sqlStatement;

    public Employee(int employeeId, String firstName, String secondName, String lastNameS, int salary,
                    String email, String phone, String country, String city, String street, String zipCode, String gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastNameS = lastNameS;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.gender = gender;
        this.country = country;
    }

    public Employee(int employeeId) {
        this.employeeId = employeeId;
    }

    public Employee() {
        this.employeeId = -1;
        this.firstName = null;
        this.secondName = null;
        this.lastNameS = null;
        this.salary = 0;
        this.email = null;
        this.phone = null;
        this.city = null;
        this.street = null;
        this.zipCode = null;
        this.gender = null;
        this.country = null;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getCountry() {
        return country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastNameS() {
        return lastNameS;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getGender() {
        return gender;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setLastNameS(String lastNameS) {
        this.lastNameS = lastNameS;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static ArrayList<Employee> find(ArrayList<SimpleEntry<String, String>> criteria) {

        ArrayList<Employee> employeesList = new ArrayList<Employee>();

        sqlStatement = "select * from " + entityName + " where ";

        for (int i = 0; i < criteria.size(); i++) {
            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
            if (i < criteria.size() - 1) {
                sqlStatement += " AND";
            }

        }

        ResultSet resultSet = DatabaseOperations.makeQuery(sqlStatement);

        try {

            while (resultSet.next()) {
                Employee newEmployee = new Employee();
                newEmployee.setEmployeeId(resultSet.getInt("employee_id"));
                newEmployee.setFirstName(resultSet.getString("first_name"));
                newEmployee.setSecondName(resultSet.getString("second_name"));
                newEmployee.setLastNameS(resultSet.getString("last_name"));
                newEmployee.setSalary(resultSet.getInt("salary"));
                newEmployee.setEmail(resultSet.getString("email"));
                newEmployee.setPhone(resultSet.getString("phone"));
                newEmployee.setCity(resultSet.getString("city"));
                newEmployee.setCity(resultSet.getString("country"));
                newEmployee.setStreet(resultSet.getString("street"));
                newEmployee.setZipCode(resultSet.getString("zip_code"));
                newEmployee.setGender(resultSet.getString("gender"));
                employeesList.add(newEmployee);
            }

        } catch (SQLException e) {
            System.out.println("Error while finding employee");
        }
        return employeesList;

    }

    public static Employee findByID(int employeeID) {
        sqlStatement = "select * from " + entityName + " where employee_id='" + employeeID + "'";
        ResultSet resultSet = DatabaseOperations.makeQuery(sqlStatement);
        Employee newUser = null;
        try {
            while (resultSet.next()) {
                newUser = new Employee();
                Employee newEmployee = new Employee();
                newEmployee.setEmployeeId(resultSet.getInt("employee_id"));
                newEmployee.setFirstName(resultSet.getString("first_name"));
                newEmployee.setSecondName(resultSet.getString("second_name"));
                newEmployee.setLastNameS(resultSet.getString("last_name"));
                newEmployee.setSalary(resultSet.getInt("salary"));
                newEmployee.setEmail(resultSet.getString("email"));
                newEmployee.setPhone(resultSet.getString("phone"));
                newEmployee.setCity(resultSet.getString("city"));
                newEmployee.setCity(resultSet.getString("country"));
                newEmployee.setStreet(resultSet.getString("street"));
                newEmployee.setZipCode(resultSet.getString("zip_code"));
                newEmployee.setGender(resultSet.getString("gender"));
            }
        } catch (SQLException e) {
            System.out.println("Error while finding employees");
        }
        return newUser;
    }

    @Override
    public boolean update(ArrayList<SimpleEntry<String, String>> criteria) {
        if (Employee.findByID(employeeId) == null) {
            return false;
        }
        sqlStatement = "UPDATE " + entityName + "\n" +
                "SET ";

        for (int i = 0; i < criteria.size(); i++) {
            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
            if (i < criteria.size() - 1) {
                sqlStatement += " ,";
            }

        }
        sqlStatement += "WHERE employee_id=" + this.employeeId + ";";
        DatabaseOperations.makeQuery(sqlStatement);
        return true;
    }


    @Override
    public boolean save() {
        if (employeeId >= 0 && firstName != null && secondName != null && lastNameS != null && email != null) {
            String sqlStatment = "INSERT INTO " + entityName + "(\n" +
                    " user_name, user_role, user_password)" +
                    "VALUES ('" + this.employeeId + "','" + this.firstName + "','" + this.secondName + "','" + this.lastNameS + "','" +
                    this.salary + "','" + this.email + "','" + this.phone + "','" + this.city + "','" + this.street + "','" +
                    this.zipCode + "','" + this.gender + "','" + this.country + "');";
            DatabaseOperations.makeQuery(sqlStatment);

            return true;
        }
        return false;
    }

    @Override
    public boolean delete() {

        if (Employee.findByID(employeeId) != null) {

            sqlStatement = "DELETE FROM " + entityName + " WHERE user_id='" + employeeId + "';";
            DatabaseOperations.makeQuery(sqlStatement);

            return true;
        }
        return false;
    }


    public static void delete(ArrayList<SimpleEntry<String, String>> criteria) {

        sqlStatement = "DELETE FROM " + entityName + " WHERE\n";

        for (int i = 0; i < criteria.size(); i++) {
            sqlStatement += criteria.get(i).getKey() + " = '" + criteria.get(i).getValue() + "'";
            if (i < criteria.size() - 1) {
                sqlStatement += " AND ";
            }

        }
        System.out.println(sqlStatement);
        DatabaseOperations.makeQuery(sqlStatement);
    }


}
