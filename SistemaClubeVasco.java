package exercicio7;

import java.util.Collection;
import java.util.List;

public interface SistemaClubeVasco {
	
	public boolean cadastraPatrocinador(String nome, String cpf, int numCartao, int cvv);
	public boolean removePatrocinador(String nomePatroc);
	public boolean existePatrocinador( String cpf);
	public Collection<Patrocinio> pesquisaPatrocinador(String nomePatroc);
	public String PesquisaTitulosPorDec(int decTitulos);
	public Collection<Jogador> pesquisaJogador(String nome);
	public boolean cadastrarJogador(String nomeJogador, int idadeJogador, List<PosicaoEmCampo> posicaoEmCampo, int valContrato, int qtdJogos, int qtdGols);
	public boolean removeJogador(String nomeJogador);
	public String listaJogadoresEquantidadeGols();
	public String listaJogadoresEqtdJogos();
	public boolean removeProduto(String descricao);
	public void setPatrocinio(Collection<Patrocinio> patrocinios);
	public Collection<Patrocinio> getPatrocinio();
	
}
