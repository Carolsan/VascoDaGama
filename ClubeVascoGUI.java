package exercicio7;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.io.IOException;
import java.util.Collection;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ClubeVascoGUI extends JFrame {
	
	private GravadorDeDados gravador;
	private SistemaClubeVasco sistema;
	
	JLabel lin1, lin2;
	ImageIcon VascoImg = new ImageIcon("./imgVasco/VascoImg.png");
	
	JMenuBar barraMenu = new JMenuBar();
	
	public ClubeVascoGUI() {
		gravador =  new GravadorDeDados();
		sistema = new VascoMap();
		
		try {
			Collection<Patrocinio> patrocRecuperados = gravador.recuperPatroc();
			sistema.setPatrocinio(patrocRecuperados);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível recuperar patrocinadores anterirores");;
		} finally {
		}
		
		setTitle("Clube Vasco Da Gama");
		setSize(500, 300);
		setLocation(100, 100);
		setResizable(true);
		setBackground(Color.black);
		lin1 = new JLabel("Bem-vindo ao Vasco Clube", JLabel.CENTER);
		lin1.setForeground(Color.RED);
		lin1.setFont(new Font("Serif", Font.BOLD, 24));
		lin2 = new JLabel(VascoImg, JLabel.CENTER);
		
		setLayout(new GridLayout(3,1));
		add(lin1);
		add(lin2);
		add(new JLabel());
		JMenu menuCadastrar = new JMenu("Cadastrar");
		JMenuItem menuCadastrarPatroc = new JMenuItem("Cadastrar Patrocinador");
		menuCadastrar.add(menuCadastrarPatroc);
		JMenu menuPesq = new JMenu("Pesquisar");
		JMenuItem menuPesqPatroc = new JMenuItem("Pesquisar Patrocinador");
		JMenuItem menuPesqTitulo = new JMenuItem("Pesquisar Título");
		JMenuItem menuPesqJogador = new JMenuItem("Pesquisar Jogador");
		JMenuItem menuPesqQtdGols = new JMenuItem("Pesquisar quantidade de gols por jogador");
		JMenuItem menuPesqQtdJogos = new JMenuItem("Pesquisar quantidade de jogos por jogador");
		JMenuItem menuPesqExistePatroc = new JMenuItem("Pesquisar se existe Patrocinador");
		menuPesq.add(menuPesqPatroc);
		menuPesq.add(menuPesqTitulo);
		menuPesq.add(menuPesqJogador);
		menuPesq.add(menuPesqQtdGols);
		menuPesq.add(menuPesqQtdJogos);
		menuPesq.add(menuPesqExistePatroc);
		JMenu menuRemover = new JMenu("Remover");
		JMenuItem menuRemovePatroc = new JMenuItem("Remover Patrocinador");
		menuRemover.add(menuRemovePatroc);
		
		menuCadastrarPatroc.addActionListener(new SisClubeVascoAddController(sistema, this));
		menuPesqPatroc.addActionListener(new SisClubeVascoSearchController(sistema, this));
		menuPesqTitulo.addActionListener(new SisClubeVascoSearchController(sistema, this));
		menuPesqJogador.addActionListener(new SisClubeVascoSearchController(sistema, this));
		menuPesqQtdGols.addActionListener(new SisClubeVascoSearchController(sistema, this));
		menuPesqQtdJogos.addActionListener(new SisClubeVascoSearchController(sistema, this));
		menuPesqExistePatroc.addActionListener(new SisClubeVascoSearchController(sistema, this));
		menuRemovePatroc.addActionListener(new SisClubeVascoRemovecontroller(sistema, this));
		
		JMenu menuSave = new JMenu("Salvar");
		JMenuItem menuSaveContatos = new JMenuItem("Salvar Contatos");
		menuSave.add(menuSaveContatos);
		
		menuSaveContatos.addActionListener(
				(ae) -> {
					try {
									gravador.gravarPatrocinadores(sistema.getPatrocinio());
									JOptionPane.showMessageDialog(this, "Contatos salvos com sucesso");
							} catch (IOException e) {
									JOptionPane.showMessageDialog(this, "Problema ao salvar dados");
									e.printStackTrace();
							}
				}
			);
		
		barraMenu.add(menuCadastrar);
		barraMenu.add(menuPesq);
		barraMenu.add(menuRemover);
		barraMenu.add(menuSave);
		setJMenuBar(barraMenu);
		
	}
	
	public static void main (String[] args) {
		
		JFrame janela = new ClubeVascoGUI();
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
