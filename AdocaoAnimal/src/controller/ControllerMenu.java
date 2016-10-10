package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import model.Administrador;
import model.Animal;
import model.BancoDados;
import model.Candidato;
import view.AdministradorInfo;
import view.CadastroAdministrador;
import view.CadastroAnimal;
import view.CadastroCandidato;
import view.ListaAnimais;
import view.Menu;

public class ControllerMenu implements ActionListener {
	private Menu menu;

	public ControllerMenu(Menu menu) {
		super();
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu.getCadastrarAnimal()) {
			CadastroAnimal cadastrarAnimal = new CadastroAnimal();
			cadastrarAnimal.setVisible(true);
		}
		else if (e.getSource()==menu.getSair()) {
			int sair = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
			if(sair == 0) {
				// salvamento de dados
				salvarDados();
				System.exit(0);
			}
		}
		else if (e.getSource()==menu.getCadastrarCandidato()) {
			CadastroCandidato cadastrarCandidato = new CadastroCandidato();
			cadastrarCandidato.setVisible(true);
		}
		else if (e.getSource()==menu.getCadastrarAdministrador()) {
			CadastroAdministrador ca = new CadastroAdministrador();
			ca.setVisible(true);
		}
		else if(e.getSource() == menu.getVisualizarAnimais()) {
			ListaAnimais la = new ListaAnimais();
			la.setVisible(true);
		}
		else if(e.getSource() == menu.getConta()) {
			AdministradorInfo info = new AdministradorInfo();
			info.setVisible(true);
		}
	}
	
	public void salvarDados() {
		BufferedWriter out = null;
		File adms = new File("administradores.txt");
		File anim = new File("animais.txt");
		File cand = new File("candidatos.txt");
		
		for(Administrador adm: BancoDados.adms) {	
			try {
				out = new BufferedWriter(new FileWriter(adms));
				out.write(adm.getNome());
				out.newLine();
				out.write(adm.getUsuario());
				out.newLine();
				out.write(adm.getEmail());
				out.newLine();
				out.write(adm.getSenha());
				out.newLine();
				out.write("------");
				out.newLine();
				
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(Animal an: BancoDados.animais) {
			try {
				out = new BufferedWriter(new FileWriter(anim));
				out.write(an.getNome());
				out.newLine();
				out.write(an.getRaca());
				out.newLine();
				out.write((int) an.getPeso());
				out.newLine();
				out.write(an.getIdade());
				out.newLine();
				out.write(an.getSexo());
				out.newLine();
				out.write(an.getDescricao());
				out.write("------");
				out.newLine();
				
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(Candidato ca: BancoDados.candidatos) {
			try {
				out = new BufferedWriter(new FileWriter(cand));
				out.write(ca.getNome());
				out.newLine();
				out.write(ca.getUsername());
				out.newLine();
				out.write(ca.getEmail());
				out.newLine();
				out.write(ca.getSenha());
				out.newLine();
				out.write(ca.getTelefone());
				out.newLine();				
				out.write("------");
				out.newLine();
				
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
