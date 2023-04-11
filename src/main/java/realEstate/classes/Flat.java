package realEstate.classes;

import realEstate.Image;

public class Flat extends Property implements Image {
    Integer room;
    Integer bath;
    String amenities;
    Integer floor;
    String accessibility;
    String condition;
    Integer sl;
    Customer seller;
    String name;

    public Flat() {

    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Customer getSeller() {
        return seller;
    }

    public void setSeller(Customer seller) {
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Flat(String district, String location, String country, String type, String sellRent, Integer propertyID, String landArea, String status, Integer room, Integer bath, String amenities, Integer floor, String accessibility, String condition) {
        super(district, location, country, type, sellRent, propertyID, landArea, status);
        this.room = room;
        this.bath = bath;
        this.amenities = amenities;
        this.floor = floor;
        this.accessibility = accessibility;
        this.condition = condition;
    }
    public Flat(Integer serial,String name,String dis,String location,Integer price,String type){
        this.sl=serial;
        this.name=name;
        this.setDistrict(dis);
        this.setLocation(location);
        this.setPrice(price);
        this.setType(type);
    }


    public Flat(String district, String location, String country, String type, String sellRent, Integer propertyID, String landArea, String status) {
        super(district, location, country, type, sellRent, propertyID, landArea, status);
    }

    public void addImage() {

    }

    public void editImage() {

    }

    public void removeImage() {

    }
    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
