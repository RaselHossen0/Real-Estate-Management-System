module realestate.realestate {
    requires javafx.controls;
    requires javafx.fxml;


    opens realEstate to javafx.fxml;
    exports realEstate;
    exports realEstate.classes;
    opens realEstate.classes to javafx.fxml;
}
