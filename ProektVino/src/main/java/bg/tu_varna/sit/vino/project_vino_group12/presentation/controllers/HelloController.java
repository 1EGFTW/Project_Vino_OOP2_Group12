package bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers;

import bg.tu_varna.sit.vino.project_vino_group12.business.services.AdminService;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.login.AdminLoginController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.login.OperatorLoginController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.controllers.login.WarehouseHostLoginController;
import bg.tu_varna.sit.vino.project_vino_group12.presentation.models.AdminListViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import static bg.tu_varna.sit.vino.project_vino_group12.common.Constants.View.*;

public class HelloController{
    Stage s=new Stage();
    @FXML
    private Label HelloText;
    @FXML
    private Button adminButton;
    @FXML
    private Button operatorButton;
    @FXML
    private Button warehouseHostButton;
    @FXML
    private ImageView imageView;
    @FXML
    private ImageView buttonAdminIcon;


    public HelloController(Stage stage){
        s=stage;

        loadImage();
    }

    @FXML
    protected void loadImage(){
       /* ClassLoader classLoader = getClass().getClassLoader();
        String imageUrl = classLoader.getResource("src/main/resources/bg/tu_varna/sit/vino/project_vino_group12/images/Logo.png").toExternalForm();
        Image image = new Image(imageUrl);
        imageView.setImage(image);*/

        /*try {
            Image image = new Image(new FileInputStream("C:\\Users\\my\\Documents\\GitHub\\Project_Vino_OOP2_Group12\\ProektVino\\src\\main\\resources\\bg\\tu_varna\\sit\\vino\\project_vino_group12\\images\\Logo.png"));
            imageView.setImage(image);
        }catch(FileNotFoundException e){ e.printStackTrace();}*/

       /* Image image = new Image( new File("Users/my/Documents/GitHub/Project_Vino_OOP2_Group12/ProektVino/src/main/resources/bg/tu_varna/sit/vino/project_vino_group12/images/Logo.png").toURI().toString());
        imageView.setImage(image);*/

        /*Image icon = new Image( new File("src/main/resources/bg/tu_varna/sit/vino/project_vino_group12/images/user.png").toURI().toString());
        adminButton.setGraphic(new ImageView(icon));*/

    }

    @FXML
    protected void adminLog() {
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ADMIN_LOGIN));
            Stage stage = new Stage();
            fxmlLoader.setController(new AdminLoginController(stage));
            Parent root1 = (Parent) fxmlLoader.load();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void operatorLog(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(OPERATOR_LOGIN));
            Stage stage = new Stage();
            fxmlLoader.setController(new OperatorLoginController(stage));
            Parent root1 = (Parent) fxmlLoader.load();

            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    protected void warehouseHostLog(){
        try {
            s.close();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(WAREHOUSEHOST_LOGIN));
            Stage stage = new Stage();
            fxmlLoader.setController(new WarehouseHostLoginController(stage));
            Parent root1 = (Parent) fxmlLoader.load();

            stage.setScene(new Scene(root1));
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}