package controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class filechooserController implements Initializable {
  
@FXML TextField filesname,fileiname,filername;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void selectionnerFichier(ActionEvent event) {
		FileChooser fc= new FileChooser();
		  fc.getExtensionFilters().addAll(new ExtensionFilter("csv files","*.csv"));   
		  File selectedfile =fc.showOpenDialog(null);
		  filesname.setText(selectedfile.getName());
		  String fichier=selectedfile.getName();
		  System.out.println(fichier);
		  /// requete pour manipuler les le ficher 
	}
	}

