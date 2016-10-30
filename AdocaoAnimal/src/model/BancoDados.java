package model;

import java.util.ArrayList;

public class BancoDados {

	public static ArrayList<Animal> animais = new ArrayList<Animal>();
	public static ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
	public static ArrayList<Administrador> adms = new ArrayList<Administrador>();
	public static ArrayList<Adocao> adocoes = new ArrayList<Adocao>();

	public ArrayList<Animal> getAnimais() {
		return animais;
	}

	public ArrayList<Candidato> getCandidatos() {
		return candidatos;
	}
	
	public static void addAdm(Administrador adm) {
		adms.add(adm);
	}
	public static void addAnims(Animal anim) {
		animais.add(anim);
	}
	public static void addCand(Candidato cand) {
		candidatos.add(cand);
	}
	
	public static void addAdocao(Adocao adocao) {
		adocoes.add(adocao);
	}
	
}