package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Personne;
import model.Transaction;
import model.TransactionDAO;

public class Main extends Application {

    @Override
  public void start(Stage primaryStage) throws Exception
    {      
		 
		// t.setMontant(7445445);
		 //bd.update(t);
		  //bd.insert(salaire);
		 // bd.getListeTransaction();
		// bd.getTransaction(1);
    	         
    	 //  bd.importTransaction("U:/Agiles/data.xlsx");
    	
    	// requette pour setting le mot de passe 
        Parent root = FXMLLoader.load(getClass().getResource("/view/connexion.fxml"));
        Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
        primaryStage.setTitle("Gestionnaire financier");
        primaryStage.setScene(scene);
        primaryStage.show();
       
    }
  

    public static void main(String[] args) {
    	
//    	System.out.println("xouxou");
//    	Personne dounya = new Personne("ennech");
//    	Transaction salaire = new Transaction(0,1000, "income",Date.valueOf("2015-03-31"), );        
//    	TransactionDAO bd = new TransactionDAO();
//    	salaire.setMontant(954878987);
//    	System.out.println(bd.getTransaction(0).getCategorie());
//    	bd.getListeTransaction();
//    	for(Transaction t :bd.getListeTransaction()) {
//    		System.out.println(t.getCategorie());
//    	}
    	
       launch(args);
    }
}