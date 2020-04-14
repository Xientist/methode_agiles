package controller;

import java.awt.List;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Personne;
import model.Transaction;
import model.TransactionDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class TransactionsController implements Initializable{
	
	
	private TransactionDAO transationDao;
	private ObservableList<Transaction> transacts;
	
	/*@FXML private Button btnAjouter;
	@FXML private Button btnAnnuler;
	
	@FXML private TextField textFiledTransaction;
	@FXML private TextField textFiledCategorie;
	@FXML private TextField textFiledMontant;
	@FXML private TextField textFiledPersonne;
	@FXML private TextField textFiledDate;*/

	
	
	
	@FXML private Button acceuil,transactions,statistiques,predictions;
	@FXML private TableView<Transaction> tvData;
	@FXML public TableColumn<Transaction, Integer> id;
	@FXML public TableColumn<Transaction, Double> montant;
	@FXML public TableColumn<Transaction, String> categorie;
	@FXML public TableColumn<Transaction, Personne> personne;
	@FXML public TableColumn<Transaction, Date> date;
	
	
	
	
	@Override
	 public void initialize(URL location, ResourceBundle resources) {

		
		 id.setCellValueFactory(new PropertyValueFactory<>("ID"));
		 montant.setCellValueFactory(new PropertyValueFactory<>("montant"));
		 categorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
		 personne.setCellValueFactory(new PropertyValueFactory<>("personne"));
		 date.setCellValueFactory(new PropertyValueFactory<>("date_T"));
		 
		 ObservableList<Transaction> listTransaction = returnTransact();
		 tvData.setItems(listTransaction);
		 
		
		
	 }
	
	
	 public void goToAjoutTransaction(ActionEvent event) throws IOException {
			
			Parent parent= FXMLLoader.load(getClass().getResource("/view/ajouttransaction.fxml"));
	    	Scene scene=new Scene(parent);
	    	scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
	    	Stage window = (Stage) acceuil.getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    	
	    	
		}
	 
	 
	 public void goToAcceuil(ActionEvent event) throws IOException {
			
			Parent parent= FXMLLoader.load(getClass().getResource("/view/acceuil.fxml"));
	    	Scene scene=new Scene(parent);
	    	scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
	    	Stage window = (Stage) acceuil.getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    	
		}
	 public void goToTransaction(ActionEvent event) throws IOException {
			
			Parent parent= FXMLLoader.load(getClass().getResource("/view/transactions.fxml"));
	    	Scene scene=new Scene(parent);
	    	scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
	    	Stage window = (Stage) acceuil.getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    	
		} public void goToStatistiques(ActionEvent event) throws IOException {
			
			Parent parent= FXMLLoader.load(getClass().getResource("/view/statistiques.fxml"));
	    	Scene scene=new Scene(parent);
	    	scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
	    	Stage window = (Stage) acceuil.getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    	
		}
	 public void goToPrediction(ActionEvent event) throws IOException {
			
			Parent parent= FXMLLoader.load(getClass().getResource("/view/acceuil.fxml"));
	    	Scene scene=new Scene(parent);
	    	scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
	    	Stage window = (Stage) acceuil.getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    	
		}
	 
	 private ObservableList<Transaction> returnTransact() {
		 transationDao = new TransactionDAO();
		ArrayList<Transaction> lists = (ArrayList<Transaction>) transationDao.getListeTransaction();
		transacts = FXCollections.observableArrayList();
		
		for(Transaction t : lists) {
			  transacts.add(new Transaction(t.getID(), t.getMontant(), t.getCategorie(), t.getDate_T(), t.getPersonne()));
		}
		
		return transacts;
	}
	 
	
	 
	
	     
	
}
