package exercicio7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SisClubeVascoAddController implements ActionListener {
	
	private SistemaClubeVasco sistemaVasco;
	private JFrame janelaPrincipal;
	
	public SisClubeVascoAddController(SistemaClubeVasco sistemaVasco, JFrame janelaPrincipal) {
		this.sistemaVasco = sistemaVasco;
		this.janelaPrincipal = janelaPrincipal;
	}	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String acao = e.getActionCommand();
		
		switch(acao) {
			case "botaoAddPatroc":
				String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual é o seu nome?");
				String cpf = JOptionPane.showInputDialog(janelaPrincipal, "Digite seu CPF");
				int numCartao = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Digite o número do seu cartão de crédito"));
				int cvv = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Digite o código de segurança do seu cartão de crédito"));
				boolean patrocAdd = sistemaVasco.cadastraPatrocinador(nome, cpf, numCartao, cvv);
				if(patrocAdd) {
					JOptionPane.showMessageDialog(janelaPrincipal, "Patrocinador adicionado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(janelaPrincipal, "Patrocinador não foi cadastrado");
				}

		}
		
	}

}
