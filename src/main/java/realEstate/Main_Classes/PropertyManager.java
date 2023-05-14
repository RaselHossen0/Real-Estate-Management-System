package realEstate.Main_Classes;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PropertyManager {
    private static List<Property> properties=new ArrayList<>();
    static List<Land> lands=new ArrayList<>();
    static List<Flat> flats=new ArrayList<>();
    static  List<Property> rents;
    static  List<Property> sales;
    static Integer totalProperties;


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

    public static Integer getTotalProperties() {
        return totalProperties;
    }

    public static void setTotalProperties(Integer totalProperties) {
        PropertyManager.totalProperties = totalProperties;
    }

    static public Property getByID(Integer id){
        Property ans=new Property();
        for (Property property : properties) {
            if (Objects.equals(property.getPropertyID(), id)) {
                ans=property;
            }
        }
        return ans;
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
    public static void deleteFromFile(Property property,String flag) {
        try {
            File inputFile = new File("addProperty.txt");
            File outputFile = new File("temp.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            String line;
            String propertyLine;
            Integer id=property.getPropertyID();

            while ((line = reader.readLine()) != null) {
                ArrayList<String> row = new ArrayList<String>(20);  //to store all info of a user
                row.add((Arrays.toString(line.split("/"))));
                String[] info = row.get(0).replaceAll("\\[", "").replaceAll("\\]", "").split(", ");
                if (!Objects.equals(id, Integer.valueOf(info[1]))) { //property id in info[1]
                    writer.write(line+"\n");
                }
                //01/1111/Dhaka/Gulshan/Flat/Sale/2.5/Balcony,Gym,Pool/John Doe/8801712345678/jdoe@email.com
                //18/8578/Dhaka/Dhanmondi/Land/Sale/2.3/Balcony,School/Kabir Sadik/957298357298/afdaf

                else if(flag.equals("Edit")){
                    writer.write(property.getPrice()+"/"+property.getPropertyID()+"/"+property.getDistrict()+"/"+property.getLocation()+"/"+property.getType()+"/"
                    +property.getAvailability()+"/"+property.getSize()+"/"+property.getDescription()+"/"+property.getSellerName()+"/"+property.getContact()+
                            "/"+property.getImagePath()+"\n");
                }

            }
            reader.close();
            writer.close();
            inputFile.delete();
            outputFile.renameTo(inputFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static List<Property> getType(String Type) {
        List<Property> ansList=new ArrayList<>();
        if(Type.equals("Land")) {
            for (Land property : lands) {
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
    public static void retrieve() throws IOException, SQLException {

        BufferedReader reader=new BufferedReader(new FileReader("addProperty.txt"));
        String whole;
        int cnt=0;
        while ((whole = reader.readLine()) != null) {
            ArrayList<String> row = new ArrayList<String>(20);  //to store all info of a user
            row.add((Arrays.toString(whole.split("#"))));
            try {
                //18/8578/Dhaka/Dhanmondi/Land/Sale/2.3/Balcony,School/Kabir Sadik/957298357298/afdaf
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
            String contact=info[9];
            String imagePath=info[10];
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
            cnt++;
        }
        totalProperties=cnt;
        customer_set();
        reader.close();
    }
    public static List<String> getImagePaths() {
        List<String> imagePaths = new ArrayList<>();
        for (Property property : properties) {
            imagePaths.add(property.getImagePath());
        }
        return imagePaths;
    }
    static void customer_set() throws SQLException {
        Customer.get_all_customers();
        int index=0;
        for(Property property:properties){
            Customer customer;
            customer=Customer.customer_by_id(property.getPropertyID());
            if(customer==null){
                customer.setDistrict("Not Exist");
                customer.setName("Not Exist");
                customer.setMobile(-1);
                customer.setType("Not Exist");
                customer.setLocation("not Exist");
            }
            properties.get(index).setCustomer(customer);
          //  System.out.println(property.getCustomer().getType());
            index++;
        }
    }
    public static int get_num_of_seller() {
        int cnt=0;

        for (Property property : properties) {
            if(property.getType().equals("Land"))
              cnt++;
        }
        return cnt;
    }
    public static int get_num_of_buyer() {
        int cnt=0;

        for (Property property : properties) {
            if(property.getType().equals("Flat"))
                cnt++;
        }
        return cnt;
    }
    public static double get_total_sell() {
        double cnt=0;

        for (Property property : properties) {

                cnt+=property.getPrice();
        }
        return cnt;
    }
}
