package realEstate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import realEstate.Main_Classes.PropertyManager;

import java.util.List;

public class Property_Images extends Scene_Change  {
    @FXML
    private Button next;

    @FXML
    private Label price;
    @FXML
    private ImageView property_image;

    @FXML
    void next(ActionEvent event) {
        // Assuming you have a list of image paths or URLs
        List<String> imagePaths = PropertyManager.getImagePaths();

        // Get the current image index
        int currentIndex = imagePaths.indexOf(property_image.getImage().getUrl());

        // Increment the index
        int nextIndex = (currentIndex + 1) % imagePaths.size();

        // Load and set the next image
        String nextImagePath = imagePaths.get(nextIndex);
        Image nextImage = new Image(nextImagePath);
        property_image.setImage(nextImage);

        // Update any other related information, such as price
        price.setText(String.valueOf(334));
    }


}
