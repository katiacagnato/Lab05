package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.ParolaDAO;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtAnagCorretti;

    @FXML
    private TextArea txtAnagErrati;
        
    @FXML
    void handleCalcola(ActionEvent event) {
    	
    	String outputCorretto="";
    	String outputErrato="";
    	String parolaInput= txtInput.getText();
    	if(parolaInput.length()<2) {
    		txtAnagCorretti.setText("Inserire una parola con almeno due caratteri");
    		return;
    	}
    	if(parolaInput.length()>8){
    		txtAnagCorretti.setText("Inserire una parola con massimo otto caratteri");
    		return; //RETURN! Sennò si impalla perche prova lo stesso a risolverlo!!
    	}
    	Set<String> lista= this.model.anagrammi(parolaInput);
    	txtAnagCorretti.setText(lista.toString());
    	
    	for(String anagramma:lista) {
	
    		if(this.model.isCorrect(anagramma)) {
    			outputCorretto= outputCorretto+anagramma+'\n';
    		}
    		else {
    			outputErrato=outputErrato+anagramma+'\n';
    		}
    	}
    	txtAnagCorretti.setText(outputCorretto);
    	txtAnagErrati.setText(outputErrato);
    }

    @FXML
    void handleReset(ActionEvent event) {
    	txtAnagErrati.clear();
    	txtAnagCorretti.clear();
    	txtInput.clear();
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagCorretti != null : "fx:id=\"txtAnagCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtAnagErrati != null : "fx:id=\"txtAnagErrati\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model=model;
    }
}
