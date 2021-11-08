package exercicio7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SisClubeVascoRemovecontroller implements ActionListener {

	private SistemaClubeVasco sistemaVasco;
	private JFrame janelaPrincipal;
	
	public SisClubeVascoRemovecontroller(SistemaClubeVasco sistemaVasco, JFrame janelaPrincipal) {
		this.sistemaVasco = sistemaVasco;
		this.janelaPrincipal = janelaPrincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nomePatroc = JOptionPane.showInputDialog(janelaPrincipal, "Digite o nome do Patrocinador para remove-lo");
		boolean removidoPatroc = sistemaVasco.removePatrocinador(nomePatroc);
		if(removidoPatroc) {
			JOptionPane.showMessageDialog(janelaPrincipal, "Patrocinador removido com sucesso!");
		} else {
			JOptionPane.showMessageDialog(janelaPrincipal, "Não foi possível remover patrocinador");
		}		
	}
}


