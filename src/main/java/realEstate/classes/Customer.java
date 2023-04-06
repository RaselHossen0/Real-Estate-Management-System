package realEstate.classes;

import java.util.HashMap;

public class Customer {
    String name;
    String location;
    String district;
    String mobile;
    String type;
    HashMap<Integer,Property> propertyMap=new HashMap<>();

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
    public void addProperty(Property prp,Integer id){
        propertyMap.put(id,prp);
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
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Customer(String name, String area, String district, String mobile) {
        this.name = name;
        this.location = area;
        this.district = district;
        this.mobile = mobile;
    }
}
