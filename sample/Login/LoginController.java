package sample.Login;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.ManagerPackage.ManagerController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {


    @FXML
    private TextField userid;
    @FXML
    private PasswordField passwordtxt;
    @FXML
    private ComboBox<LoginEnum> typeCombo;
    @FXML
    private Button loginButton;
    @Override
    public void initialize(URL url, ResourceBundle rs) {
    this.typeCombo.setItems(FXCollections.observableArrayList(LoginEnum.values()));
    }

    @FXML
    public void login(ActionEvent event)
    {
    try {
        LoginModel loginModel = new LoginModel();
        if (loginModel.userLogin(userid.getText(), passwordtxt.getText(), ((LoginEnum) typeCombo.getValue()).toString())){
            Stage stage=(Stage)loginButton.getScene().getWindow();
            stage.close();

            switch (((LoginEnum)typeCombo.getValue()).toString())
            {
                case "Owner":

                    OwnerLogin();
                    break;
                case "Manager":

                   ManagerLogin();
                    break;
                case "Cashier":

                    CashierLogin();
                    break;
        }

    }}

    catch (Exception ex)

    {
        ex.printStackTrace();
    }}


    public void CashierLogin(){
        try{
        Stage userStage = new Stage();
        FXMLLoader loader=new FXMLLoader();
        Pane root=(Pane)loader.load(getClass().getResource("/sample/CashierPackage/CashierDashboard.fxml"));
            Scene scene = new Scene(root);
            userStage.setTitle("Cashier | Textile Shop");
            userStage.setScene(scene);
            userStage.show();

    }
        catch(NullPointerException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }}

    public void ManagerLogin(){
        try{
            Stage userStage = new Stage();
            Pane root = (Pane)FXMLLoader.load(getClass().getResource("/sample/ManagerPackage/ManagerDashboard.fxml"));


            Scene scene = new Scene(root);
            userStage.setTitle("Manager | Textile Shop");
            userStage.setScene(scene);
            userStage.show();

        }
        catch(NullPointerException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }}


    public void OwnerLogin() {
        try {
            Stage userStage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane) loader.load(getClass().getResource("/sample/OwnerPackage/OwnerDashboard.fxml"));
            Scene scene = new Scene(root);
            userStage.setTitle("Owner | Textile Shop");
            userStage.setScene(scene);
            userStage.show();

        }
        catch(NullPointerException ex)
        {
            ex.printStackTrace();
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }}

