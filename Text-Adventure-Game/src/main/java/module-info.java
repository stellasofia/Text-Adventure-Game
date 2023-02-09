module com.example.textadventuregame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.textadventuregame to javafx.fxml;
    exports com.example.textadventuregame;
    exports com.example.textadventuregame.weapon;
    opens com.example.textadventuregame.weapon to javafx.fxml;
    exports com.example.textadventuregame.enemy;
    opens com.example.textadventuregame.enemy to javafx.fxml;
}