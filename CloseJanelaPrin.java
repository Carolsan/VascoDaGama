package exercicio7;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CloseJanelaPrin extends WindowAdapter{
	
	private JFrame janelaPrincipal;
	
	public CloseJanelaPrin(JFrame janela) {
		this.janelaPrincipal = janela;
	}
	
	public void windowClosing(WindowEvent e) {
		JOptionPane.showMessageDialog(janelaPrincipal, "Vou fechar o programa");
		System.exit(0);
	}
}
