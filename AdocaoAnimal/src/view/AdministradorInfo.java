package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Administrador;
import model.BancoDados;
import model.Sessao;

public class AdministradorInfo extends Tela {
	
	Administrador admLogado;
	
	private JLabel titulo;
	private JLabel nome;
	private JLabel usuario;
	private JLabel email;
	
	public AdministradorInfo(Sessao sess) {
		super("Minhas informações", 400, 300);
		
		admLogado = buscarAdm(sess.getUsuarioLogado());
		
		setLayout(new GridLayout(4, 1));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		titulo = new JLabel("Suas informações");
		titulo.setFont(new Font("", Font.BOLD, 20));
		
		if(admLogado != null) {
			System.out.println(admLogado.getNome());
			System.out.println(admLogado.getUsuario());
			
			nome = new JLabel("Nome: "+admLogado.getNome());
			usuario = new JLabel("Usuário: "+admLogado.getUsuario());
			email = new JLabel("Email: "+admLogado.getEmail());
			
			add(titulo);
			add(nome);
			add(usuario);
			add(email);
		}
		else {
			JOptionPane.showMessageDialog(null, "O usuário não está logado");
		}
	}
	
	public Administrador buscarAdm(String usr) {
		for(Administrador adm: BancoDados.adms) {
			if(adm.getUsuario().equalsIgnoreCase(usr)) {
				return adm;
			}
		}
		return null;
	}

}
