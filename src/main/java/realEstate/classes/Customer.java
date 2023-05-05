package realEstate.classes;

import java.sql.*;
import java.util.HashMap;

public class Customer {

    String name;
    String location;
    String district;
    Integer mobile;
    String type;
    HashMap<Integer,Property> propertyMap=new HashMap<>();
    public Customer(String name, String area, String district, Integer mobile) {
        this.name = name;
        this.location = area;
        this.district = district;
        this.mobile = mobile;
    }

    public void addProperty(Property prp,Integer id){
        propertyMap.put(id,prp);
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<Integer, Property> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(HashMap<Integer, Property> propertyMap) {
        this.propertyMap = propertyMap;
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
    public Customer view_Customer(Integer id) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/CUSTOMER";
        String user = "rasel";
        String password = "Rasel2003@";
        Customer res=new Customer();

        Connection connection = DriverManager.getConnection(url, user, password);
        int primaryKeyValue = id;
        Statement statement = connection.createStatement();

        String query = "SELECT * FROM CUSTOMER.`customer data` WHERE Property_ID = " + primaryKeyValue;
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            res.setName(resultSet.getString("Name"));
            res.setDistrict(resultSet.getString("District"));
            res.setMobile(resultSet.getInt("Contact"));
            res.setLocation(resultSet.getString("Location"));
           res.setType(resultSet.getString("Customer_Type"));
        }

        resultSet.close();
        statement.close();
        connection.close();
        return res;
    }

}
