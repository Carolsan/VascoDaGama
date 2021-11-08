package exercicio7;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SisClubeVascoSearchController implements ActionListener {

	private SistemaClubeVasco sistemaVasco;
	private JFrame janelaPrincipal;
	
	public SisClubeVascoSearchController(SistemaClubeVasco sistemaVasco, JFrame janelaPrincipal) {
		this.sistemaVasco = sistemaVasco;
		this.janelaPrincipal = janelaPrincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String acao = e.getActionCommand();
		
		switch(acao) {
		
			case "botaoPatrocPesq":
				String nomePatroc = JOptionPane.showInputDialog(janelaPrincipal, "qual é o nome do patrocinador à pesquisar?");
				Collection<Patrocinio> patrocinadores = sistemaVasco.pesquisaPatrocinador(nomePatroc);
				if(patrocinadores.size() != 0) {
					JOptionPane.showMessageDialog(janelaPrincipal, "Patrocinadores encontrados: ");
					for(Patrocinio p: patrocinadores) {
						JOptionPane.showMessageDialog(janelaPrincipal, p.toString());
					}
				} else {
					JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum patrocinador no sistema");
				}		
			
		
			case "botaoTituloPesq":	
				int decTitulos = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Pesquisa quais titulo ganhou por década?"));
				String titulo = sistemaVasco.PesquisaTitulosPorDec(decTitulos);
				if(titulo != null) {
					JOptionPane.showMessageDialog(janelaPrincipal, "Titulos encontrados na década pesquisada");
					JOptionPane.showMessageDialog(janelaPrincipal, sistemaVasco.PesquisaTitulosPorDec(decTitulos));
				} else {
					JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum título na década pesquisada");
				}
				
			case "botaoJogadorPesq":
				String nome = JOptionPane.showInputDialog(janelaPrincipal, "Digite o nome do jogador à pesquisar");
				Collection<Jogador> jogadores = sistemaVasco.pesquisaJogador(nome);
				if(jogadores.size() != 0) {
					JOptionPane.showMessageDialog(janelaPrincipal,"Jogador encontrado");
					for(Jogador j: jogadores) {
						JOptionPane.showMessageDialog(janelaPrincipal, j.toString());
					}
				} else {
					JOptionPane.showMessageDialog(janelaPrincipal, "Jogador não encontrado");
				}
		
			case "botaoJogadorGols":
				JOptionPane.showMessageDialog(janelaPrincipal, sistemaVasco.listaJogadoresEquantidadeGols() );
				
			case "botaoJogadorJogos":
				JOptionPane.showMessageDialog(janelaPrincipal, sistemaVasco.listaJogadoresEqtdJogos());
				
			case "botaoExistePatroc":
				String cpf = JOptionPane.showInputDialog(janelaPrincipal, "Digite o CPF para saber se existe patrocinador no sistema");
				boolean cpfPatroc = sistemaVasco.existePatrocinador(cpf);
				if(cpfPatroc) {
					JOptionPane.showMessageDialog(janelaPrincipal, "Patrocinador existe");
				} else {
					JOptionPane.showMessageDialog(janelaPrincipal, "Não existe patrocinador");
				}
		}	
	}
}
