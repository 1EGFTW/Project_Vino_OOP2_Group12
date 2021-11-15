package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;

public class AdminViewController{
    URL path = getClass().getResource(Constants.View.ADMIN_VIEW);
    Parent root;

    {
        try {
            root = FXMLLoader.load(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Scene adminView=new Scene(root);

}
