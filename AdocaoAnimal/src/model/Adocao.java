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

	public String toString() {
		return new String("<html>" + "<p><h3> Informações do Animal" + "</h3></p>" +
						"<p>ID:" +animal.getId() +"</p>"+
				        "<p>Nome:" +animal.getNome() +"</p>"+
				        "<p>Sexo:" +animal.getSexo() +"</p>"+
				        "<p><h3> Informações do Candidato" + "</h3></p>"+
				        "<p>CPF:" +candidato.getCPF()+"</p>"+
				        "<p>Nome:" +candidato.getNome() +"</p>"+
				        "<p>Email:" +candidato.getEmail() +"</p>"+
				        "<p>Telefone:" +candidato.getTelefone() +"</p>"+
				        
				"</html>");
	}

}
