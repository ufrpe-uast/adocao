package model;

import java.util.ArrayList;

public class BancoDados {

	private ArrayList<Animal> animais = new ArrayList<Animal>();
	private ArrayList<Candidato> candidatos = new ArrayList<Candidato>();

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public void setAnimais(ArrayList<Animal> animais) {
		this.animais = animais;
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(ArrayList<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
}
