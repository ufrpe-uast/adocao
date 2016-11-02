package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ControllerInfoAdocao;
import model.Adocao;
import model.BancoDados;

public class TelaAdocoes extends TelaInterna {
	
	private ControllerInfoAdocao cia;

	public TelaAdocoes(String titulo, int largura, int altura) {
		super(titulo, largura, altura);
		
		setLayout(new FlowLayout());
		setLocation(250, 50);
		for(Adocao a : BancoDados.adocoes) {			
			JPanel painel = new JPanel();
			painel.setLayout(new BorderLayout());
			painel.setBackground(Color.WHITE);
			painel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
			painel.add(BorderLayout.CENTER, new JLabel("<html>"+
					"<h3>Animal: "+a.getAnimal().getNome()+"</h3>"+
					"<h3>Candidato: "+a.getCandidato().getNome()+"</h3>"
					+ "</html>"));
			JButton mais = new JButton("Ver Mais");
			
			cia = new ControllerInfoAdocao(a, mais);
			mais.addActionListener(cia);
			painel.add(BorderLayout.SOUTH, mais);
			
			add(painel);
		}
	}
}
