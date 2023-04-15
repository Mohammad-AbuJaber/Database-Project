module group.finalproject {
        requires transitive javafx.controls;
        requires transitive javafx.fxml;
        requires transitive java.sql;
        requires javafx.base;
    requires java.desktop;


    exports group.finalproject;

    opens group.finalproject to javafx.graphics, javafx.fxml, javafx.base;
    opens Entities to javafx.graphics, javafx.fxml, javafx.base;
}