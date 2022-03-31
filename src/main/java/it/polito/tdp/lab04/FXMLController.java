package it.polito.tdp.lab04;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;


	@FXML
	private ComboBox<String> cmbox;

	@FXML
	private TextArea txtArea;

	@FXML
	private TextField txtCognome;

	@FXML
	private TextField txtMatricola;

	@FXML
	private TextField txtNome;

	@FXML
	void doCercaCorsi(ActionEvent event) {

	}

	@FXML
	void doCercaIscritti(ActionEvent event) {
		txtArea.clear();
		String s = cmbox.getValue();
		txtArea.appendText(s);
		List<Studente> r = model.studentiDiQuelCorso(s);
		for(Studente stud :r) {
			txtArea.appendText(stud.toString()+"\n");
		}
	}

	@FXML
	void doIscrivi(ActionEvent event) {

	}

	@FXML
	void doReset(ActionEvent event) {
		txtArea.clear();
		txtNome.clear();
		txtCognome.clear();
		txtMatricola.clear();
	}

	@FXML
	void doCompleta(ActionEvent event) {
		txtCognome.setText(model.completa(Integer.parseInt(txtMatricola.getText())).getCognome());
		txtNome.setText(model.completa(Integer.parseInt(txtMatricola.getText())).getNome());
	}

	public void setModel(Model model) {
		this.model = model;
		List<String> listaCorsi = this.model.getNomiCorsi();
		listaCorsi.add("Corso generale di test");
		cmbox.getItems().addAll(listaCorsi);
	}

	@FXML
	void initialize() {
		assert cmbox != null : "fx:id=\"cmbox\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
		assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";

	}

}
