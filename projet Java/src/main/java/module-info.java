module com.example.projetjavaavance {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.projetjavaavance to javafx.fxml;
    exports com.example.projetjavaavance;
}