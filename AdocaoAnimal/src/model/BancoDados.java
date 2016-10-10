package model;

import java.util.ArrayList;

public class BancoDados {

	public static ArrayList<Animal> animais = new ArrayList<Animal>();
	public static ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
	public static ArrayList<Administrador> adms = new ArrayList<Administrador>();

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}
	
}