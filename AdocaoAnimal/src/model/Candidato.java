package model;

public class Candidato {
	private String nome;
	private String CPF;
	private String email;
	private String username;
	private String senha;
	private Endereco endereco;
	private String telefone;

	public Candidato(String nome, String CPF, String email, String telefone,
			Endereco endereco) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.email = email;
		this.username = username;
		this.senha = senha;
		this.telefone = telefone;
		this.endereco = endereco;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

}
