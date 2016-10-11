package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Administrador;
import model.Animal;
import model.BancoDados;
import model.Candidato;
import view.CadastroAdministrador;
import view.CadastroAnimal;
import view.CadastroCandidato;
import view.ListaAnimais;
import view.ListaCandidato;
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
			if (menu.getTelaCadAnimal() == null) {
				menu.setTelaCadAnimal(new CadastroAnimal());
				menu.getTelaCadAnimal().getAlterar().setEnabled(false);
				menu.getTelaCadAnimal().setContatorCadastro(1);
				menu.getTelaCadAnimal().getImputId()
						.setText(Integer.toString(menu.getTelaCadAnimal().getContatorCadastro()));
				menu.getTelaCadAnimal().setVisible(true);
				menu.getDesktop().add(menu.getTelaCadAnimal());
			} else {
				menu.getTelaCadAnimal().getImputId()
						.setText(Integer.toString(menu.getTelaCadAnimal().getContatorCadastro()));
				menu.getTelaCadAnimal().setVisible(true);
				menu.getDesktop().add(menu.getTelaCadAnimal());
			}

		} else if (e.getSource() == menu.getSair()) {
			int sair = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?");
			if (sair == 0) {
				// salvamento de dados
				salvarDados();
				System.exit(0);
			}

		} else if (e.getSource() == menu.getCadastrarCandidato()) {
			if (menu.getTelaCadCandidato() == null) {
				menu.setTelaCadCandidato(new CadastroCandidato());
				menu.getTelaCadCandidato().setVisible(true);
				menu.getDesktop().add(menu.getTelaCadCandidato());
			} else {
				menu.getTelaCadCandidato().setVisible(true);
				menu.getDesktop().add(menu.getTelaCadCandidato());
			}

		} else if (e.getSource() == menu.getCadastrarAdministrador()) {
			if (menu.getTelaCadAdm() == null) {
				menu.setTelaCadAdm(new CadastroAdministrador());
				menu.getTelaCadAdm().setVisible(true);
				menu.getDesktop().add(menu.getTelaCadAdm());
			} else {
				menu.getTelaCadAdm().setVisible(true);
				menu.getDesktop().add(menu.getTelaCadAdm());
			}

		} else if (e.getSource() == menu.getVisualizarAnimais()) {
			if (menu.getTelaListarAnimal() == null) {
				menu.setTelaListarAnimal(new ListaAnimais());
				menu.getTelaListarAnimal().setVisible(true);
				menu.getDesktop().add(menu.getTelaListarAnimal());
			} else {
				menu.getTelaListarAnimal().setVisible(true);
				menu.getDesktop().add(menu.getTelaListarAnimal());
			}

		} else if (e.getSource() == menu.getVisualizarCandidatos()) {
			if (menu.getTelaListarCandidato() == null) {
				menu.setTelaListarCandidato(new ListaCandidato());
				menu.getTelaListarCandidato().setVisible(true);
				menu.getDesktop().add(menu.getTelaListarCandidato());
			} else {
				menu.getTelaListarCandidato().setVisible(true);
				menu.getDesktop().add(menu.getTelaListarCandidato());
			}
		}

		else if (e.getSource() == menu.getEditarAnimal()) {
			String identifica;
			if (BancoDados.animais.size() == 0) {
				JOptionPane.showMessageDialog(null, "Nenhum Animal foi Cadastrado.");
				return;
			} else {

				identifica = JOptionPane.showInputDialog("Digite o ID do Animal:");
				int cont = 0;
				int id = Integer.parseInt(identifica);

				for (int i = 0; i < BancoDados.animais.size(); i++) {
					Animal anim = BancoDados.animais.get(i);
					if (anim.getId() == id) {
						// Mostrar os Dados que foram cadastrados
						menu.getTelaCadAnimal().getImputId().setText(identifica);
						menu.getTelaCadAnimal().getImputNome().setText(anim.getNome());
						menu.getTelaCadAnimal().getImputRaca().setText(anim.getRaca());
						menu.getTelaCadAnimal().getImputIdade().setText(String.valueOf(anim.getIdade()));
						menu.getTelaCadAnimal().getImputDescricao().setText(anim.getDescricao());
						menu.getTelaCadAnimal().getImputPeso().setText(String.valueOf(anim.getPeso()));

						if (anim.getSexo().equalsIgnoreCase("Macho")) {
							menu.getTelaCadAnimal().getSexoOption().setSelectedIndex(1);
						} else {
							menu.getTelaCadAnimal().getSexoOption().setSelectedIndex(0);
						}
						menu.getTelaCadAnimal().getCadastrar().setEnabled(false);
						menu.getTelaCadAnimal().getAlterar().setEnabled(true);
						menu.getTelaCadAnimal().setVisible(true);
						menu.getDesktop().add(menu.getTelaCadAnimal());
						cont++;
					}

				}
				if (cont == 0) {
					JOptionPane.showMessageDialog(null,
							"  Animal não Encontrado! \n Verifique se o Animal foi Cadastrado.");
				}
			}

		}
	}

	public void salvarDados() {
		BufferedWriter out = null;
		File adms = new File("administradores.txt");
		File anim = new File("animais.txt");
		File cand = new File("candidatos.txt");

		for (Administrador adm : BancoDados.adms) {
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

		for (Animal an : BancoDados.animais) {
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

		for (Candidato ca : BancoDados.candidatos) {
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
