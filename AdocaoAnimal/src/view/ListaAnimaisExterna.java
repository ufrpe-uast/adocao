package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControllerAdocao;
import model.Animal;
import model.BancoDados;

public class ListaAnimaisExterna extends Tela {

private ControllerAdocao ca;
	
	public ListaAnimaisExterna() {
		super("Animais", 900, 500);
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		for(Animal anim: BancoDados.animais) {
			JPanel pan = new JPanel();
			pan.setSize(100, 100);
			pan.setBackground(Color.WHITE);
			pan.setBorder(BorderFactory.createLineBorder(Color.GREEN));
			JButton adotar = new JButton("Adotar");
			
			ca = new ControllerAdocao(anim, adotar);
			
			adotar.addActionListener(ca);

			pan.add(new JLabel("<html>"
					+ "<p> ID: "+anim.getId()+"</p>"
					+ "<p> Nome: "+anim.getNome()+"</p>"
					+ "<p> Raça: "+anim.getRaca()+"</p>"
					+ "<p> Sexo: "+anim.getSexo()+"</p>"
					+ "<p> Idade: "+anim.getIdade()+" anos </p>"
					+ "<p> Peso: "+anim.getPeso()+" kg </p>"
					+ "<p> Descrição: "+anim.getDescricao()+"</p>"
					+ "</html>"));
			pan.add(adotar);
						
			this.add(pan);
		}
	}
	
}
