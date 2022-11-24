module com.example.tpcours {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tpcours to javafx.fxml;
    exports com.example.tpcours;
}