module realestate.realestate {
    requires javafx.controls;
    requires javafx.fxml;


    opens realestate.realestate to javafx.fxml;
    exports realestate.realestate;
}
