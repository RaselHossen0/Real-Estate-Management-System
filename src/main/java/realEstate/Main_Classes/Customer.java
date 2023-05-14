package realEstate.Main_Classes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Customer {

    String name;
    String location;
    String district;
    Integer mobile;
    String type;
    Integer property_id;
    static List<Customer> customers=new ArrayList<>();

    public Integer getProperty_id() {
        return property_id;
    }

    public void setProperty_id(Integer property_id) {
        this.property_id = property_id;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        Customer.customers = customers;
    }



    public Customer(String name, String area, String district, Integer mobile) {
        this.name = name;
        this.location = area;
        this.district = district;
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Customer() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }
    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }
    static void get_all_customers() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/CUSTOMER";
        String user = "rasel";
        String password = "Rasel2003@";
        Customer customer=new Customer();

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();

        String query ="SELECT * FROM `customer data`";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            customer.setName(resultSet.getString("Name"));
            customer.setDistrict(resultSet.getString("District"));
            customer.setMobile(resultSet.getInt("Contact"));
            customer.setLocation(resultSet.getString("Location"));
            customer.setType(resultSet.getString("Customer_Type"));
        }
        customers.add(customer);

        resultSet.close();
        statement.close();
        connection.close();
    }

    static Customer customer_by_id(Integer id) throws SQLException {
        get_all_customers();
        Customer ansList = new Customer();
        for(Customer customer:customers){
            if(customer.getName().equals(id)){
                ansList=customer;
            }
        }
        return ansList;
    }

}
