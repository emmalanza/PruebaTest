module PruebaTest {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports ejemplo;

    opens ejemplo to javafx.fxml;
}