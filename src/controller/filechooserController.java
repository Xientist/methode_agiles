package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Model;

public class filechooserController implements Initializable {
  
@FXML TextField filesname,fileiname,filername;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void selectionnerFichier(ActionEvent event) throws IOException {
		FileChooser fc= new FileChooser();
		fc.getExtensionFilters().addAll(new ExtensionFilter("Excel files","*.xlsx"));   
		
		File selectedfile =fc.showOpenDialog(null);
<<<<<<< HEAD
		
		String fichier=selectedfile.getAbsolutePath();
=======
		String fichier=selectedfile.getName();
>>>>>>> e719a56d530b8d76555c37bdfc40fee0e1deb87b
		filesname.setText(fichier);
		System.out.println(fichier);
		
		Model.getTransactionInstance().importTransaction(fichier);		  
	}
}

