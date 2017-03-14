package model;

public class Candidato {
	private String nome;
	private String CPF;
	private String email;
	private Endereco endereco;
	private String telefone;

	public Candidato(String nome, String CPF, String email, String telefone, Endereco endereco) {
		super();
		this.nome = nome;
		this.CPF = CPF;
		this.email = email;
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

	public String toString() {
		return new String("<html>" + "<p> Nome: " + getNome() + "</p>" + "<p> CPF: " + getCPF() + "</p>" + "<p> Email: "
				+ getEmail() + "</p>" + "<p> Fone: " + getTelefone() + "</p>" + "<p> Endereço: "
				+ getEndereco().getRua() + "," + getEndereco().getNumero() + "-" + getEndereco().getComplemento()
				+ " </p>" + "<p>" + getEndereco().getBairro() + "/" + getEndereco().getCidade() + "-"
				+ getEndereco().getEstado() + "</p>" + "<p>" + getEndereco().getCep() + "</p>"
				+ "____________________________________________________________________________" + "</p>" + "</html>");
	}

}
