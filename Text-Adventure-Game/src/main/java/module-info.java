module com.example.textadventuregame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.textadventuregame to javafx.fxml;
    exports com.example.textadventuregame;
}