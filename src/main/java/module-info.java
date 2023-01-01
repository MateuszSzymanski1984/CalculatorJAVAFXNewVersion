module com.devwider.fx.calculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    exports com.devwider.fx.calculator.service;
    opens com.devwider.fx.calculator.service to javafx.fxml;
    exports com.devwider.fx.calculator.service.operation;
    opens com.devwider.fx.calculator.service.operation to javafx.fxml;
    exports com.devwider.fx.calculator.controller;
    opens com.devwider.fx.calculator.controller to javafx.fxml;
    exports com.devwider.fx.calculator;
    opens com.devwider.fx.calculator to javafx.fxml;
}