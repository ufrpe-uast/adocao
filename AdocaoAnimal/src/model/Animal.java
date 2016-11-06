package model;

import javax.swing.ImageIcon;

public class Animal {
	private int id;
	private String nome;
	private String raca;
	private String sexo;
	private int idade;
	private float peso;
	private String descricao;
	private ImageIcon nomeImagem;

	public Animal(int id, String nome, String raca, String sexo, int idade, float peso, String descricao,
			ImageIcon nomeImagem) {
		if (nome.equalsIgnoreCase("")) {
			this.nome = "Sem nome";
		} else {
			this.nome = nome;
		}
		if (raca.equalsIgnoreCase("")) {
			this.raca = "Vira-Lata";
		} else {
			this.raca = raca;
		}

		if (descricao.equalsIgnoreCase("")) {
			this.descricao = "Sem descri��o";
		} else {
			this.descricao = descricao;
		}
		this.nomeImagem = nomeImagem;
		this.sexo = sexo;
		this.idade = idade;
		this.peso = peso;
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return new String("<html>" + "<p> ID: " + id + "</p>" + "<p> Nome: " + nome + "</p>" + "<p> Ra�a: " + raca
				+ "</p>" + "<p> Sexo: " + sexo + "</p>" + "<p> Idade: " + idade + " anos </p>" + "<p> Peso: " + peso
				+ " kg </p>" + "<p> Descri��o: " + descricao + "</p>" + "</html>");
	}

	public ImageIcon getNomeImagem() {
		return nomeImagem;
	}

	public void setNomeImagem(ImageIcon nomeImagem) {
		this.nomeImagem = nomeImagem;
	}
}
