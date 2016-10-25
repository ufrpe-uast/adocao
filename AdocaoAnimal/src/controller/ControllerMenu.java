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
import view.AdministradorInfo;
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
				menu.getTelaCadAnimal().limparDados();
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
				menu.getTelaInicial().setVisible(true);
				menu.dispose();
				setMenu(null);
			}

		} else if (e.getSource() == menu.getConta()) {
			AdministradorInfo info = new AdministradorInfo(menu.getSessao());
			info.setVisible(true);

		} else if (e.getSource() == menu.getCadastrarCandidato()) {
			if (menu.getTelaCadCandidato() == null) {
				menu.setTelaCadCandidato(new CadastroCandidato());
				menu.getTelaCadCandidato().getAlterar().setEnabled(false);
				menu.getTelaCadCandidato().setVisible(true);
				menu.getDesktop().add(menu.getTelaCadCandidato());
			} else {
				menu.getTelaCadCandidato().limparDados();
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

			menu.setTelaListarAnimal(new ListaAnimais());
			menu.getTelaListarAnimal().setVisible(true);
			menu.getDesktop().add(menu.getTelaListarAnimal());

		} else if (e.getSource() == menu.getVisualizarCandidatos()) {
			menu.setTelaListarCandidato(new ListaCandidato());
			menu.getTelaListarCandidato().setVisible(true);
			menu.getDesktop().add(menu.getTelaListarCandidato());

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

		} else if (e.getSource() == menu.getEditarCandidato()) {
			String identifica;
			if (BancoDados.candidatos.size() == 0) {
				JOptionPane.showMessageDialog(null, "Nenhum Candidato foi Cadastrado.");
				return;
			} else {

				identifica = JOptionPane.showInputDialog("Digite o CPF do Candidato:");
				int cont = 0;

				for (int i = 0; i < BancoDados.candidatos.size(); i++) {
					Candidato cand = BancoDados.candidatos.get(i);
					String cpf = retiraCaracteres(cand.getCPF());
					if (cpf.equalsIgnoreCase(identifica)) {
						// Mostrar os Dados que foram cadastrados
						menu.getTelaCadCandidato().getImputNome().setText(cand.getNome());
						menu.getTelaCadCandidato().getImputCpf().setText(identifica);
						menu.getTelaCadCandidato().getImputEmail().setText(cand.getEmail());
						menu.getTelaCadCandidato().getImputFone().setText(cand.getTelefone());
						menu.getTelaCadCandidato().getImputUsername().setText(cand.getUsername());
						menu.getTelaCadCandidato().getImputSenha().setText(cand.getSenha());
						menu.getTelaCadCandidato().getEstados().setSelectedItem(cand.getEndereco().getEstado());
						menu.getTelaCadCandidato().getImputCidade().setText(cand.getEndereco().getCidade());
						menu.getTelaCadCandidato().getImputBairro().setText(cand.getEndereco().getBairro());
						menu.getTelaCadCandidato().getImputCep().setText(cand.getEndereco().getCep());
						menu.getTelaCadCandidato().getImputComplemento().setText(cand.getEndereco().getComplemento());
						menu.getTelaCadCandidato().getImputNumero()
								.setText(Integer.toString(cand.getEndereco().getNumero()));
						menu.getTelaCadCandidato().getImputRua().setText(cand.getEndereco().getRua());
						menu.getTelaCadCandidato().getAlterar().setEnabled(true);
						menu.getTelaCadCandidato().getEnviarForm().setEnabled(false);
						menu.getTelaCadCandidato().setVisible(true);
						menu.getDesktop().add(menu.getTelaCadCandidato());
						cont++;
					}

				}
				if (cont == 0) {
					JOptionPane.showMessageDialog(null,
							"  Candidato não Encontrado! \n Verifique se o Candidato foi Cadastrado.");
				}
			}
		}
	}

	public String retiraCaracteres(String str) {
		if (str != null) {

			return str.replaceAll("[^0123456789]", "");

		} else {

			return "";

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

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}
