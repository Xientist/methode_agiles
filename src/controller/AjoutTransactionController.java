package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Model;
import model.Transaction;

public class AjoutTransactionController {
	 @FXML private TextField transaction,montant,personne,date;
	 @FXML private ComboBox categorie;
	 String transaction_c,categorie_c,montant_c,personne_c,date_c;
	 @FXML private Button ajouter,annuler;
	 public void initialize() {
		    categorie.getItems().addAll("D�pense","Gains");
		    }
		 
	 
	 
	 public void ajouterTreansaction(ActionEvent event) throws IOException {
		 

     	 transaction_c	=	transaction.getText();
		 categorie_c	=	categorie.getValue().toString();
		 montant_c		=	montant.getText();
		 personne_c		=	personne.getText();
		 date_c			=	date.getText();
	
		 System.out.println(transaction_c);
		 System.out.println( categorie_c);
		 System.out.println( montant_c);
		 System.out.println (personne_c);
		 System.out.println(date_c);

		

			Parent parent= FXMLLoader.load(getClass().getResource("/view/acceuil.fxml"));
	    	Scene scene=new Scene(parent);
	    	scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
	    	Stage window = (Stage) ajouter.getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    	
		}
}
