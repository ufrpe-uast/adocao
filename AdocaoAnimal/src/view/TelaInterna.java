package view;

import javax.swing.JInternalFrame;

public class TelaInterna extends JInternalFrame {

	public TelaInterna(String titulo, int largura, int altura) {
		super(titulo, true, // resizable
				true, // closable
				false, // maximizable
				true);// iconifiable

		setSize(largura, altura);
		setVisible(false);
	}

}
