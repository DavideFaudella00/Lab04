package it.polito.tdp.lab04.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	CorsoDAO c = new CorsoDAO();
	StudenteDAO s = new StudenteDAO();
	List<Studente> listaStudenti = s.getTuttiStudenti();

	public List<Corso> getTuttiICorsi() {
		return c.getTuttiICorsi();
	}

	public List<String> getNomiCorsi() {
		List<String> l = new ArrayList<String>();
		for (Corso d : c.getTuttiICorsi()) {
			l.add(d.getNome());
		}
		return l;
	}

	public List<Studente> getTuttiStudenti() {
		return listaStudenti;
	}

	public Studente completa(int matricola) {
		for (Studente s : getTuttiStudenti()) {
			if (s.getMatricola() == matricola) {
				return s;
			}
		}
		return null;
	}

	public List<Studente> studentiDiQuelCorso(String corso) {
		List<Studente> l = new ArrayList<>();
		l = c.getStudentiIscrittiAlCorso(c.getCorso(corso));
		return l;
	}
}
