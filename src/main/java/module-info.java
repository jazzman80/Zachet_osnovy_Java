module com.example.zachet_osnovy_java {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.zachet_osnovy_java to javafx.fxml;
    exports com.example.zachet_osnovy_java;
}