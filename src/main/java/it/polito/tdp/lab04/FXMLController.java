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
		txtArea.clear();
		if (txtMatricola.getText().equals("")) {
			txtArea.setText("Inserisci un matricola");
			return;
		}
		int s = Integer.parseInt(txtMatricola.getText());
		List<String> r = model.getCorsiDiQuelloStudente(s);
		if(r.size() == 0) {
			txtArea.setText("Matricola non esistente");
			return;
		}
		for (String k : r) {
			txtArea.appendText(k + "\n");
		}
	}

	@FXML
	void doCercaIscritti(ActionEvent event) {
		txtArea.clear();
		String s = cmbox.getValue();
		// Fai if
		if (s != null) {
			txtArea.appendText(s);
			List<Studente> r = model.studentiDiQuelCorso(s);
			for (Studente stud : r) {
				txtArea.appendText(stud.toString() + "\n");
			}
		} else {
			txtArea.appendText("Seleziona un corso");
		}
	}

	@FXML
	void doIscrivi(ActionEvent event) {
		txtArea.clear();
		if (txtMatricola.getText().equals("")) {
			txtArea.setText("Inserisci un matricola");
			return;
		}
		if(model.isIscritto(cmbox.getValue(), Integer.parseInt(txtMatricola.getText())) == true) {
			txtArea.appendText("Studente gia iscritto");
		}
		else {
			txtArea.appendText("Ancora non iscritto");
		}
	}

	@FXML
	void doReset(ActionEvent event) {
		txtArea.clear();
		txtNome.clear();
		txtCognome.clear();
		txtMatricola.clear();
		cmbox.setValue(null);
	}

	@FXML
	void doCompleta(ActionEvent event) {
		txtArea.clear();
		if (txtMatricola.getText().equals("")) {
			txtArea.setText("Inserisci un matricola");
			return;
		}
		if (model.completa(Integer.parseInt(txtMatricola.getText())) == null) {
			txtArea.setText("Matricola non esistente");
			return;
		}
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
