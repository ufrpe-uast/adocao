package model;

public class Sessao {
	private Administrador usuarioLogado;

	public Sessao(Administrador usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Administrador getUsuarioLogado() {
		return usuarioLogado;
	}

}
