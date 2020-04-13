package controller;

import java.io.IOException;
import java.sql.Date;

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
		 
		 	categorie.getItems().addAll("D�ｿｽpense","Gains");
	    }
		 
	 
	 
	 public void ajouterTreansaction(ActionEvent event) throws IOException {
		 
		 	transaction_c	=	transaction.getText();
		 	//categorie_c	=	categorie.getText();
		 	montant_c		=	montant.getText();
		 	personne_c		=	personne.getText();
		 	date_c			=	date.getText();
		 	
		 	Date date_T = new Date(new java.util.Date().getTime());
		 	int personne_i = -1;
		 	double montant_d;
		 	
		 	try {
		 		
		 		montant_d = Double.parseDouble(montant_c);
		 	
		 	} catch(NumberFormatException nfe) {
		 		
		 		montant_d = 0.0;
		 	}
		 	
		 	System.out.println(transaction_c);
		 	System.out.println( categorie_c);
		 	System.out.println( montant_d);
		 	System.out.println (personne_i);
		 	System.out.println(date_T);
		 	
		 	Transaction t = new Transaction(-1, montant_d, categorie_c, date_T, personne_i);
		 	
		 	Model.getInstance().insert(t);

			Parent parent= FXMLLoader.load(getClass().getResource("/view/acceuil.fxml"));
	    	Scene scene=new Scene(parent);
	    	scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
	    	Stage window = (Stage) ajouter.getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    	
		}
}
