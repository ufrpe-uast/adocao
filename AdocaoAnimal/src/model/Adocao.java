package model;

public class Adocao {

	private Animal animal;
	private Candidato candidato;
	
	public Adocao(Animal a, Candidato c) {
		animal = a;
		candidato = c;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	
	
	
}
