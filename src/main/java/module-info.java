module com.example.lab5fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab5fx to javafx.fxml;
    exports com.example.lab5fx;
}