package model;

import javax.swing.ImageIcon;

public class Animal {
	private String nome;
	private String raca;
	private String sexo;
	private int idade;
	private float peso;
	private String descricao;
	private ImageIcon imagemAnimal;
	
	public Animal(String nome, String raca, String sexo, int idade, float peso, String descricao) {
		if(nome.equalsIgnoreCase("")) {
			this.nome = "Sem nome";
		}
		else {
			this.nome = nome;
		}
		this.raca = raca;
		this.sexo = sexo;
		this.idade = idade;
		this.peso = peso;
		this.descricao = descricao;
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

	public ImageIcon getImagemAnimal() {
		return imagemAnimal;
	}

	public void setImagemAnimal(ImageIcon imagemAnimal) {
		this.imagemAnimal = imagemAnimal;
	}
}
