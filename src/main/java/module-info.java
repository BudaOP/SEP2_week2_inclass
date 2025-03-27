module org.example.sep2_week2_inclass {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.sep2_week2_inclass to javafx.fxml;
    exports org.example.sep2_week2_inclass;
}