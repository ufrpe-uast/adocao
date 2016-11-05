package model;

public class Administrador {

	private String nome;
	private String usuario;
	private String email;
	private String senha;
	
	public Administrador(String n, String usr, String e, String s){
		nome = n;
		usuario = usr;
		email = e;
		senha = s;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
