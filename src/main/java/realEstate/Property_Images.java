package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import realEstate.Main_Classes.Customer;
import realEstate.Main_Classes.Property;
import realEstate.Main_Classes.PropertyManager;

import java.util.List;

public class Property_Images extends Scene_Change  {
   static int index=0;
//    @FXML
//    private Button next;
//
    @FXML
    private Label price;
    @FXML
    private Label avaiability;
//
    @FXML
    private Label contact;
//
    @FXML
    private Label description;
//
    @FXML
    private Label district;

    @FXML
    private Label name;

    @FXML
    private ImageView property_image;

    @FXML
    void next(ActionEvent event) {
        List<Property> propertyList= PropertyManager.getProperties();
       int total=propertyList.size();



//        Image nextImage = new Image(nextImagePath);
     //   property_image.setImage(nextImage);
        Property currentProperty = propertyList.get(index);
        Customer customer=currentProperty.getCustomer();
        System.out.println(currentProperty.getPropertyID());

//        if(currentProperty!=null) {
           price.setText("Price: " + currentProperty.getPrice()+" Lakh ");
           name.setText("Customer Name: " + currentProperty.getSellerName());
            district.setText("District: " + currentProperty.getDistrict());
            description.setText("Description: " + currentProperty.getDescription());
           contact.setText("Contact: " + currentProperty.getContact());
           avaiability.setText("Availability: " + currentProperty.getAvailability());
//        }


//        String pric= String.valueOf(propertyList.get(index).getPrice());
//        price.setText("Price : "+String.valueOf(pric));
       // name.setText("Customer Name : "+propertyList.get(index).getSellerName());
//        district.setText(propertyList.get(index).getDistrict());
//        //location.setText(propertyList.get(index).getLocation());
//        description.setText(propertyList.get(index).getDescription());
//        contact.setText(propertyList.get(index).getContact());
//        avaiability.setText(propertyList.get(index).getAvailability());

        index+=1;
        index%=total;

    }


}
