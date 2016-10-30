package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Adocao;
import model.Animal;
import model.BancoDados;
import model.Candidato;
import model.Endereco;
import view.CadastroCandidatoExterno;

public class ControllerForm implements ActionListener {

	private CadastroCandidatoExterno cce;
	private Animal animal;
	
	public ControllerForm(CadastroCandidatoExterno cce, Animal animal) {
		this.cce = cce;
		this.animal = animal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cce.getEnviarForm()) {
			BancoDados.addAdocao(new Adocao(animal, new Candidato(cce.getImputNome().getText(), 
					cce.getImputCpf().getText(), cce.getImputEmail().getText(), 
					cce.getImputUsername().getText(), cce.getImputSenha().getText(), 
					cce.getImputFone().getText(), 
					new Endereco(cce.getImputRua().getText(), cce.getImputComplemento().getText(), 
							cce.getImputBairro().getText(),	cce.getImputCidade().getText(), 
							cce.getImputCep().getText(), "PE", Integer.parseInt(cce.getImputNumero().getText())))));
			
			for(Adocao ad : BancoDados.adocoes)
				System.out.println(ad.getAnimal().getNome()+" "+ad.getCandidato().getNome());
		}
		if(e.getSource() == cce.getLimparDados()) {
			cce.limparDados();
		}
	}

}
