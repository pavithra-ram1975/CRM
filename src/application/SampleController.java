package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SampleController {

    @FXML
    private Button signin;
    @FXML
    private Button admin;
    @FXML
    private Button Products;
    @FXML
    private Button rosegold;
    @FXML
    private Button vieworders;
    @FXML
    private Button serviceneeded;
    @FXML
    private TextField lpassword;

    @FXML
    private TextField lusername;

    @FXML
    private Button submit;

    @FXML
    private Button customer;
    @FXML
    private TextField cust;

    @FXML
    private TextField des;

    @FXML
    private TextField fb;

    @FXML
    private TextField p_id;

    @FXML
    private TextField p_name;
    @FXML
    void adminfxml(ActionEvent event)throws IOException {
    	Stage stage = (Stage) admin.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("admin.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Admin");
		stage.show();


    }

    @FXML
    void customerfxml(ActionEvent event)throws IOException {
    	Stage stage = (Stage) customer.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("customer.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Customer");
		stage.show();


    }
    @FXML
    void productsfxml(ActionEvent event)throws IOException {
    	Stage stage = (Stage) Products.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("Product.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Product");
		stage.show();
    }
    @FXML
    void rosegoldfxml(ActionEvent event)throws IOException {
    	Stage stage = (Stage) rosegold.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("Rosegold.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Rosegold");
		stage.show();
    }
    @FXML
    void viewordersfxml(ActionEvent event)throws IOException {
    	Stage stage = (Stage) vieworders.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("vieworders.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("vieworder");
		stage.show();
    }
    @FXML
    void serviceneededfxml(ActionEvent event)throws IOException {
    	Stage stage = (Stage) serviceneeded.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("serviceneeded.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Service");
		stage.show();
    }
    

    
   @FXML
    void submit(ActionEvent event)throws IOException {
    	Stage stage = (Stage) submit.getScene().getWindow();
		stage.close();
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Login");
		stage.show();


   }

    @FXML
    void signin(ActionEvent event) throws IOException {
        try {
            String username = lusername.getText();
            String userPassword = lpassword.getText();
            

            // Print values to console for debugging
            System.out.println("Username: " + username);
            System.out.println("Password: " + userPassword);

            // Call the method in your database class to insert data
            Database CRM = new Database(); // Fix: Use Database class, not CRM
            int rowsAffected = CRM.insert(username, userPassword); // Fix: Use insert method

            if (rowsAffected > 0) {
                System.out.println("Login successful!");

                Stage stage = (Stage) signin.getScene().getWindow();
                stage.close();
                Parent root = FXMLLoader.load(getClass().getResource("Admincustomer.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Admin customer");
                stage.show();
            } else {
                System.out.println("Login failed.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid login.");
        }
    }
    
    
    
    void submitbtn(ActionEvent event) throws IOException {
       try {
    	   
            String product_id = p_id.getText();
            String product_name = p_name.getText();
            String description = des.getText();
            String feedback = fb.getText();
            String customer_id = cust.getText();
            // Print values to console for debugging
            System.out.println("Product_id: " + product_id);
            System.out.println("Product_name: " + product_name);
            System.out.println("Product_description: " + description);
            System.out.println("Product_feedback " + feedback);
            System.out.println("customer_id " + customer_id);
            // Call the method in your database class to insert data
            Database CRM = new Database(); // Fix: Use Database class, not CRM
            int rowsAffected = CRM.insert1(product_id, product_name,description,feedback,customer_id); // Fix: Use insert method

            if (rowsAffected > 0) {
                System.out.println("Added successful!");

                
            } else {
                System.out.println("Add failed.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid.");
        }
    }

}
