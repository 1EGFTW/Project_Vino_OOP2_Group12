package bg.tu_varna.sit.vino.project_vino_group12.application;

import bg.tu_varna.sit.vino.project_vino_group12.common.Constants;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.HelloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {

    private static final Logger log = Logger.getLogger(HelloApplication.class);

    @Override
    public void start(Stage stage) throws IOException {

        PropertyConfigurator.configure(HelloApplication.class.getResource(Constants.Configurations.LOG4J_PROPERTIES));
        URL path = getClass().getResource(Constants.View.HELLO_VIEW);

        if (path != null){
            FXMLLoader fxmlLoader=new FXMLLoader(path);
            fxmlLoader.setController(new HelloController(stage));
            Parent root =fxmlLoader.load();
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);
            stage.setTitle(Constants.Values.Title);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setMaxWidth(1920);
            stage.setMaxHeight(1080);
            stage.setWidth(1024);
            stage.setHeight(768);
            stage.show();

        } else {
            log.error("Sorry, the main fxml could not be loaded.");
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}