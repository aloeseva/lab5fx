module com.vsu {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.vsu.labs;
    opens com.vsu.labs to javafx.fxml;
}