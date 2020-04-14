package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class StatistiquesController {

	@FXML private Button acceuil,transactions,statistiques,predictions;
	//@FXML private Label budget,label;
	
  @FXML private ComboBox categorie;
  
  @FXML
  private BarChart<?, ?> depense;

  @FXML
  private CategoryAxis x;

  @FXML
  private NumberAxis y;
  @FXML
  private BarChart<?, ?> revenu;

  @FXML
  private CategoryAxis xr;

  @FXML
  private NumberAxis yr;


  @FXML
  private Label labeldepenses;

  @FXML
  private Label labelrevenu;
	
  	public void initialize() {
  		
  			categorie.getItems().addAll("Le mois dernier","Les 6 derniers mois" ,"L'année dernière", "Les deux dernières années");
  		
  			depense.setVisible(false);
  			revenu.setVisible(false);
  			labeldepenses.setVisible(false);
  			labelrevenu.setVisible(false);
	    }
    
    public void getCategorie(ActionEvent event) {
    		depense.setVisible(true);
			revenu.setVisible(true);
			labeldepenses.setVisible(true);
  			labelrevenu.setVisible(true);
        String c=categorie.getSelectionModel().getSelectedItem().toString();
        System.out.println(c);
        if(c=="Le mois dernier")
        {
        	XYChart.Series d= new  	XYChart.Series<>();
        	// une boucle pour ajouter plusieurs valuers
  			d.getData().add(new XYChart.Data<>("1",50));
  			d.getData().add(new XYChart.Data<>("2",50));
  			
  			depense.getData().addAll(d);
  			
  			XYChart.Series r= new  	XYChart.Series<>();
  			r.getData().add(new XYChart.Data<>("8",50));
  			r.getData().add(new XYChart.Data<>("100",50));
  			
  			revenu.getData().addAll(r);
        	
        }
        if(c=="Les 6 derniers mois")
        {
        	XYChart.Series d= new  	XYChart.Series<>();
        	// une boucle pour ajouter plusieurs valuers
  			d.getData().add(new XYChart.Data<>("1",50));
  			d.getData().add(new XYChart.Data<>("2",50));
  			
  			depense.getData().addAll(d);
  			
  			XYChart.Series r= new  	XYChart.Series<>();
  			r.getData().add(new XYChart.Data<>("1",50));
  			r.getData().add(new XYChart.Data<>("2",50));
  			
  			revenu.getData().addAll(r);
        }
        if(c=="L'année dernière")
        {
        	XYChart.Series d= new  	XYChart.Series<>();
        	// une boucle pour ajouter plusieurs valuers
  			d.getData().add(new XYChart.Data<>("1",50));
  			d.getData().add(new XYChart.Data<>("2",50));
  			
  			depense.getData().addAll(d);
  			
  			XYChart.Series r= new  	XYChart.Series<>();
  			r.getData().add(new XYChart.Data<>("1",50));
  			r.getData().add(new XYChart.Data<>("2",50));
  			
  			revenu.getData().addAll(r);
        }
        if(c=="Les deux dernières années")
        {
        	XYChart.Series d= new  	XYChart.Series<>();
        	// une boucle pour ajouter plusieurs valuers
  			d.getData().add(new XYChart.Data<>("1",50));
  			d.getData().add(new XYChart.Data<>("2",50));
  			
  			depense.getData().addAll(d);
  			
  			XYChart.Series r= new  	XYChart.Series<>();
  			r.getData().add(new XYChart.Data<>("1",50));
  			r.getData().add(new XYChart.Data<>("2",50));
  			
  			revenu.getData().addAll(r);
        	
        }
     
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
			
			Parent parent= FXMLLoader.load(getClass().getResource("/view/predictions.fxml"));
	    	Scene scene=new Scene(parent);
	    	scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
	    	Stage window = (Stage) acceuil.getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    	
		}
}
