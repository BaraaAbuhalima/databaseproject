module defualt.databaseproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.sql;
    requires jasperreports;
    requires java.desktop;
    requires org.postgresql.jdbc;
    requires org.objectweb.asm;
    requires org.javassist;

    opens defualt.databaseproject to javafx.fxml;
    exports defualt.databaseproject;
    exports ActiveRecordPattern;
    opens ActiveRecordPattern to javafx.fxml;
    exports TableView;
    opens TableView to javafx.fxml;
}