package realEstate.classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Property {
    String district;
    String location;
    String country;
    String type;
    String availability;
    Integer propertyID;
    String landArea;
    String  size;
    String description;
    String  sellerName;
    String  contact;
    String imagePath;
    Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Property(String district, String location, String country, String type, String availability, Integer propertyID, String landArea, String status) {
        this.district = district;
        this.location = location;
        this.country = country;
        this.type = type;
        this.availability = availability;
        this.propertyID = propertyID;
        this.landArea = landArea;
        this.status = status;
    }
    public Property(){}


    String status;

    public String getAvailability() {
        return availability;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Integer getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(Integer propertyID) {
        this.propertyID = propertyID;
    }

    public String getLandArea() {
        return landArea;
    }

    public void setLandArea(String landArea) {
        this.landArea = landArea;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public  void writingFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("addProperty.txt", true));
        writer.write(country + "/" + district + "/" + location + "/" + landArea + "/" + type + "/" + availability + "\n");
        writer.close();
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }
}
