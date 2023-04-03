package realestate.realestate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PropertyManager {
    private static List<Property> properties=new ArrayList<>();
    static List<Land> lands=new ArrayList<>();
    static List<Flat> flats=new ArrayList<>();
    static  List<Property> rents;
    static  List<Property> sales;


    public PropertyManager() {
        properties = new ArrayList<>();
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public void removeProperty(Property property) {
        properties.remove(property);
    }

    public static List<Property> getProperties() {
        return properties;
    }

    public List<Property> getPropertiesByStatus(PropertyStatus status) {
        List<Property> propertiesByStatus = new ArrayList<>();
        for (Property property : properties) {
            if (property.getStatus().equals(status)) {
                propertiesByStatus.add(property);
            }
        }
        return propertiesByStatus;
    }

   static public List<Property> getPropertiesByType(String type) {
        List<Property> propertiesByType = new ArrayList<>();
        for (Property property : properties) {
            if (property.getType().equals(type)) {
                propertiesByType.add(property);
            }
        }
        return propertiesByType;
    }
    static public Integer getPriceOf(Integer id) {
        Integer price=0;
        for (Property property : properties) {
            if (property.getPropertyID().equals(id)) {
               price=property.getPrice();
            }
        }
        return price;
    }
    static public List<Property> getPropertiesType() {
        /*
        String district = splitString[0];
            String cost =splitString[1] ;
            String location =splitString[2];
         */

        List<Property> propertiesByType = new ArrayList<>();
//        if(Type.equals("Flat")) {
//            for (Property property : properties) {
//                if (property.getDistrict().equals(district) || property.getDistrict().equals(cost)) {
//                    propertiesByType.add(property);
//                }
//            }
//        }
        return propertiesByType;
    }
    public static List<Property> getType(String Type) {
        List<Property> ansList=new ArrayList<>();
        if(Type.equals("Land")) {
            for (Land property : lands) {
                //System.out.println(district+" "+location);
               // System.out.println(property.getDistrict()+" "+property.getLocation());

                if (property.getType().equals(Type) ) {
                    ansList.add(property);
                }
            }
        }
        else {
            for (Flat property : flats) {
                if (property.getType().equals(Type) ) {
                    ansList.add(property);
                }
            }
       }
        return ansList;
    }
    public static List<Property> getAvailAbility(String availability) {
            List<Property> ansList=new ArrayList<>();
            for (Property property : properties) {
                if (property.getAvailability().equals(availability)) {
                    ansList.add(property);
                }
            }
        return ansList;
    }
    public static List<Property> getArea(String district,String location) {
        List<Property> ansList=new ArrayList<>();
        for (Property property : properties) {
            if (property.getDistrict().equals(district)&&property.getLocation().equals(location)) {
                ansList.add(property);
            }
        }
        return ansList;
    }
    static void retrive() throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader("addProperty.txt"));
        String whole;
        while ((whole = reader.readLine()) != null) {
            ArrayList<String> row = new ArrayList<String>(20);  //to store all info of a user
            row.add((Arrays.toString(whole.split("/"))));
            try {
            String[] info = row.get(0).replaceAll("\\[", "").replaceAll("\\]", "").split(", ");
            Integer price= Integer.valueOf(info[0]);
            Integer propertyID= Integer.valueOf(info[1]);
            String district=info[2];
            String location=info[3];

            String type=info[4];

            String selRent =info[5];

            String size=info[6];
            String description=info[7];
            String sellerName=info[8];
            String contact=info[8];
            String imagePath=info[9];
            if(type.equals("Flat")){
                Flat newFlat= new Flat();
                newFlat.setPrice(price);
                newFlat.setPropertyID(propertyID);
                 newFlat.setDistrict(district);
                 newFlat.setLocation(location);
                 newFlat.setType(type);
                 newFlat.setAvailability(selRent);
                 newFlat.setSize(size);
                 newFlat.setDescription(description);
                newFlat.setSellerName(sellerName);
                newFlat.setContact(contact);
                 newFlat.setImagePath(imagePath);
                 properties.add(newFlat);
                 flats.add(newFlat);
            }
            else{
                Land newLand= new Land();
                newLand.setPrice(price);
                newLand.setPropertyID(propertyID);
                newLand.setDistrict(district);
                newLand.setLocation(location);
                newLand.setType(type);
                newLand.setAvailability(selRent);
                newLand.setSize(size);
                newLand.setDescription(description);
                newLand.setSellerName(sellerName);
                newLand.setContact(contact);
                newLand.setImagePath(imagePath);
                properties.add(newLand);
                lands.add(newLand);
            }
           // System.out.println(price+" "+propertyID+" "+district+" "+location+" "+type+" "+selRent+" "+size+" "+description+" "+sellerName+" "+contact+" "+imagePath+"\n");
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        reader.close();
    }
}
