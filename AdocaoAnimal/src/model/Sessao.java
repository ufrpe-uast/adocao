package model;

// sessao onde estarao as informacoes de login
// fazer login
public class Sessao {
	private String usuarioLogado = "teste";
	
	public Sessao(Administrador adm) {
		usuarioLogado = adm.getUsuario();
	}

	public String getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}
