package exercicio7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VascoMap implements SistemaClubeVasco {
	private Map<String, Jogador> jogadores = new HashMap<String, Jogador>();
	private Map<String, ProdutoVasco> produtos = new HashMap<String, ProdutoVasco>();
	private Map<String, Patrocinio> patrocinios = new HashMap<String, Patrocinio>();
	
	public VascoMap() {
		this.jogadores = new HashMap<String, Jogador>();
		this.produtos = new HashMap<String, ProdutoVasco>();
		this.patrocinios = new HashMap<String, Patrocinio>();
	}
	
	@Override
	public boolean cadastraPatrocinador(String nome, String cpf, int numCartao, int cvv) {
		if(patrocinios.containsKey(nome)) {
			return false;
		} else {
			this.patrocinios.put(nome, new Patrocinio(nome, cpf, numCartao, cvv));
			return true;
		}
	}
	
	@Override
	public boolean removePatrocinador(String nome) {
		if (this.patrocinios.containsKey(nome)) {
			this.patrocinios.remove(nome);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean existePatrocinador( String cpf) {
		return this.patrocinios.containsKey(cpf);
	}
	
	@Override
	public Collection<Patrocinio> pesquisaPatrocinador(String nomePatroc) {
		Collection<Patrocinio> patrocinadorEncontrado = new ArrayList<>();
		for(Patrocinio p: this.patrocinios.values()) {
			if (p.getNomePatroc()== nomePatroc) {
				patrocinadorEncontrado.add(p);	
			}
		}
		return patrocinadorEncontrado;
	}
	
	@Override
	public String PesquisaTitulosPorDec(int decTitulos) {
	    String result = null;
		switch(decTitulos) {
			case(20):
				result = "Campeão Carioca da 1ª Divisão – Série B (LMTD)\n"
						+ "Campeão Carioca (LMDT)\nBicampeão Carioca (LMDT / Campeão Invicto de Terra e Mar)"
						+ "Campeão do Torneio Início\n Campeão Carioca (AMEA)\nCampeão do Torneio Início";
				break;
			case(30):
				result = "Bicampeão do Torneio Início\n Tricampeão do Torneio Início\n"
						+ "Tetracampeão do Torneio Início\nCampeão Carioca (LCF)\\nCampeão Carioca (FMD)";
			case(40):
				result = "Campeão do Torneio Dr. Luiz Aranha (Rio de Janeiro)\n"
						+ "Campeão do Torneio Início (FMF)\nCampeão do Torneio Início\n"
						+ "Campeão Invicto do Torneio Relâmpago\nCampeão do Torneio Municipal\n"
						+"Campeão Carioca (FMF – Campeão Invicto de Terra e Mar)\n"
						+ "Bicampeão do Torneio Início\nBicampeão Invicto do Torneio Municipal\n"
						+ "Campeão do Torneio Relâmpago\nTricampeão do Torneio Municipal\n"
						+ "Campeão Carioca (FMF – Campeão Invicto de Terra e Mar)\n"
						+ "Tetracampeão do Torneio Municipal\n"
						+ "Campeão Sul-Americano de Campeões (Invicto – Primeiro Campeão da América no ano do Cinquentenário do Clube – Reconhecido pela CONMEBOL)\n"
						+ "Campeão do Torneio Início\n"
						+ "Campeão Carioca (FMF – Campeão Invicto de Terra e Mar)";
			}
		return result;
		}

	@Override
	public Collection<Jogador> pesquisaJogador(String nome){
		Collection<Jogador> jogadorEncontrado = new ArrayList<>();
		for (Jogador j: this.jogadores.values()) {
			if(j.getNomeJogador().equals(nome)) {
				jogadorEncontrado.add(j);
			}
		}
		return jogadorEncontrado;
	}

	@Override
	public boolean cadastrarJogador(String nomeJogador, int idadeJogador, List<PosicaoEmCampo> posicaoEmCampo,
			int valContrato, int qtdJogos, int qtdGols) {
		if(!jogadores.containsKey(nomeJogador)) {
			this.jogadores.put(nomeJogador, new Jogador(nomeJogador, idadeJogador, posicaoEmCampo, valContrato, qtdJogos, qtdGols));
			return true;
		}
		return false;
	}
	
	@Override
	public boolean removeJogador(String nomeJogador) {
		if(this.jogadores.containsKey(nomeJogador)) {
			this.jogadores.remove(nomeJogador);
			return true;
		}
		return false;
	}
	
	
	public String jogadoresPosicaoEmCampo(List<PosicaoEmCampo> posicaoEmCampo){
		if(this.jogadores.containsKey(posicaoEmCampo)) {
			for (Jogador j: this.jogadores.values()) {
				return j.getNomeJogador();
			}
		}
		return null;
	}
	
	@Override
	public String listaJogadoresEquantidadeGols() {
		Collection <Jogador> qtdGols =  new ArrayList<>();
		if(this.jogadores.containsKey(qtdGols)) {
			for(Jogador j: this.jogadores.values()) {
				return "O jogador" +j.getNomeJogador()+" fez "+j.getQtdGols()+" gols";
			}
		}
		return null;		
	}
	
	@Override
	public String listaJogadoresEqtdJogos() {
		List<Jogador> qtdJogo = new ArrayList<>();
		if(this.jogadores.containsKey(qtdJogo)) {
			for (Jogador j: this.jogadores.values()) {
				return "Jogador "+j.getNomeJogador()+" jogou "+j.getQtdJogos()+" vezes.";
			}
		}
		return null;
	}
	
	
	public void cadastraProduto(ProdutoVasco produtos) throws ProdutoJaExisteException {
		if (this.produtos.containsKey(produtos.getDescricao())) {
			throw new ProdutoJaExisteException("Já existe produto cadastrado" + produtos.getDescricao());
		} else {
			this.produtos.put(produtos.getDescricao(), produtos);
		}
	}
	
	@Override
	public boolean removeProduto(String descricao) {
		if(this.produtos.containsKey(descricao)) {
			this.produtos.remove(descricao);
			return true;
		}
		return false;
	}
	
	
	public boolean existeProduto(String descricao, List<CategoriaProduto> categoria) {
		for(ProdutoVasco p: this.produtos.values()) {
			if(this.produtos.containsKey(categoria) && this.produtos.containsKey(descricao));
			return this.produtos.containsKey(descricao);
		}
		return false;
	}
	
	
	public List<ProdutoVasco> pesquisaProdutosDaCategoria(CategoriaProduto categoria){
		List<ProdutoVasco> prodCategoria = new ArrayList<>();
		for(ProdutoVasco p: this.produtos.values()) {
			if(p.getCategoria().contains(prodCategoria)) {
				prodCategoria.add(p);
			}
		}
		return prodCategoria;
	}

	@Override
	public void setPatrocinio(Collection<Patrocinio> patrocinios) {
		//
		
	}

	@Override
	public Collection<Patrocinio> getPatrocinio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removePatrocinador(String nome) {
		if (this.patrocinios.containsKey(nome)) {
			this.patrocinios.remove(nome);
			return true;
		}
		return false;
	}

	@Override
	public boolean existePatrocinador( String cpf) {
		return this.patrocinios.containsKey(cpf);
	}

	@Override
	public Collection<Patrocinio> pesquisaPatrocinador(String nomePatroc) {
		Collection<Patrocinio> patrocinadorEncontrado = new ArrayList<>();
		for(Patrocinio p: this.patrocinios.values()) {
			if (p.getNomePatroc()== nomePatroc) {
				patrocinadorEncontrado.add(p);	
			}
		}
		return patrocinadorEncontrado;
	}

	@Override
	public Collection<Patrocinio> pesquisaPatrocinador(String nomePatroc) {
		Collection<Patrocinio> patrocinadorEncontrado = new ArrayList<>();
		for(Patrocinio p: this.patrocinios.values()) {
			if (p.getNomePatroc()== nomePatroc) {
				patrocinadorEncontrado.add(p);	
			}
		}
		return patrocinadorEncontrado;
	}

	@Override
	public String PesquisaTitulosPorDec(int decTitulos) {
	    String result = null;
		switch(decTitulos) {
			case(20):
				result = "Campeão Carioca da 1ª Divisão – Série B (LMTD)\n"
						+ "Campeão Carioca (LMDT)\nBicampeão Carioca (LMDT / Campeão Invicto de Terra e Mar)"
						+ "Campeão do Torneio Início\n Campeão Carioca (AMEA)\nCampeão do Torneio Início";
				break;
			case(30):
				result = "Bicampeão do Torneio Início\n Tricampeão do Torneio Início\n"
						+ "Tetracampeão do Torneio Início\nCampeão Carioca (LCF)\\nCampeão Carioca (FMD)";
			case(40):
				result = "Campeão do Torneio Dr. Luiz Aranha (Rio de Janeiro)\n"
						+ "Campeão do Torneio Início (FMF)\nCampeão do Torneio Início\n"
						+ "Campeão Invicto do Torneio Relâmpago\nCampeão do Torneio Municipal\n"
						+"Campeão Carioca (FMF – Campeão Invicto de Terra e Mar)\n"
						+ "Bicampeão do Torneio Início\nBicampeão Invicto do Torneio Municipal\n"
						+ "Campeão do Torneio Relâmpago\nTricampeão do Torneio Municipal\n"
						+ "Campeão Carioca (FMF – Campeão Invicto de Terra e Mar)\n"
						+ "Tetracampeão do Torneio Municipal\n"
						+ "Campeão Sul-Americano de Campeões (Invicto – Primeiro Campeão da América no ano do Cinquentenário do Clube – Reconhecido pela CONMEBOL)\n"
						+ "Campeão do Torneio Início\n"
						+ "Campeão Carioca (FMF – Campeão Invicto de Terra e Mar)";
			}
		return result;
		}

	public String jogadoresPosicaoEmCampo(List<PosicaoEmCampo> posicaoEmCampo){
		if(this.jogadores.containsKey(posicaoEmCampo)) {
			for (Jogador j: this.jogadores.values()) {
				return j.getNomeJogador();
			}
		}
		return null;
	}

	public String jogadoresPosicaoEmCampo(List<PosicaoEmCampo> posicaoEmCampo){
		if(this.jogadores.containsKey(posicaoEmCampo)) {
			for (Jogador j: this.jogadores.values()) {
				return j.getNomeJogador();
			}
		}
		return null;
	}

	@Override
	public String listaJogadoresEquantidadeGols() {
		Collection <Jogador> qtdGols =  new ArrayList<>();
		if(this.jogadores.containsKey(qtdGols)) {
			for(Jogador j: this.jogadores.values()) {
				return "O jogador" +j.getNomeJogador()+" fez "+j.getQtdGols()+" gols";
			}
		}
		return null;		
	}

	@Override
	public String listaJogadoresEqtdJogos() {
		List<Jogador> qtdJogo = new ArrayList<>();
		if(this.jogadores.containsKey(qtdJogo)) {
			for (Jogador j: this.jogadores.values()) {
				return "Jogador "+j.getNomeJogador()+" jogou "+j.getQtdJogos()+" vezes.";
			}
		}
		return null;
	}
}
	


