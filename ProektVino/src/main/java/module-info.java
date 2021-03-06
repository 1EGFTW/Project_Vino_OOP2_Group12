module bg.tu_varna.sit.vino.project_vino_group12 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires log4j;
    requires org.hibernate.orm.core;
    requires java.persistence;

    requires java.naming;
    requires java.sql;

    opens bg.tu_varna.sit.vino.project_vino_group12.data.entities to org.hibernate.orm.core;
    exports bg.tu_varna.sit.vino.project_vino_group12.data.entities;

    opens bg.tu_varna.sit.vino.project_vino_group12.data.access to org.hibernate.orm.core;
    exports bg.tu_varna.sit.vino.project_vino_group12.data.access;

    exports bg.tu_varna.sit.vino.project_vino_group12.application;
    opens bg.tu_varna.sit.vino.project_vino_group12.application to javafx.fxml;

    exports bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;
    opens bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers to javafx.fxml;

    exports bg.tu_varna.sit.vino.project_vino_group12.presentation.models;
    opens  bg.tu_varna.sit.vino.project_vino_group12.presentation.models to javafx.base;

    exports bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add;
    opens bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.add to javafx.fxml;

    exports bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.login;
    opens bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.login to javafx.fxml;

    exports bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create;
    opens bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.create to javafx.fxml;

    exports bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views;
    opens bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.views to javafx.fxml;

    exports bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check;
    opens bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.check to javafx.fxml;

    exports bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete;
    opens bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.delete to javafx.fxml;

    exports bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.update;
    opens bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.update to javafx.fxml;
}