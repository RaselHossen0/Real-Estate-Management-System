module realestate.realestate {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens realEstate to javafx.fxml;
    exports realEstate;
    exports realEstate.Main_Classes;
    opens realEstate.Main_Classes to javafx.fxml;
    exports realEstate.AgentCreation;
    opens realEstate.AgentCreation to javafx.fxml;
    exports realEstate.Agent_Login;
    opens realEstate.Agent_Login to javafx.fxml;
    exports realEstate.Search_Options;
    opens realEstate.Search_Options to javafx.fxml;
    exports realEstate.Run_Project;
    opens realEstate.Run_Project to javafx.fxml;
}
