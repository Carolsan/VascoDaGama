package exercicio7;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Jogador {
	
	private String nomeJogador;
	private int idadeJogador;
	private List<PosicaoEmCampo> posicaoEmCampo;
	private int valContrato;
	private int qtdJogos;
	private int qtdGols;
	
	public Jogador() {
		this("", 0.0, new LinkedList<>(), 0.0, 0.0, 0.0);
	}
	
	public Jogador(String nomeJogador, int idadeJogador, List<PosicaoEmCampo> posicaoEmCampo, int valContrato, int qtdJogos, int qtdGols) {
		this.nomeJogador = nomeJogador;
		this.idadeJogador = idadeJogador;
		this.posicaoEmCampo = posicaoEmCampo;
		this.valContrato = valContrato;
		this.qtdJogos = qtdJogos;
		this.qtdGols = qtdGols;
	}

	public String getNomeJogador() {
		return nomeJogador;
	}

	public void setNomeJogador(String nomeJogador) {
		this.nomeJogador = nomeJogador;
	}

	public int getIdadeJogador() {
		return idadeJogador;
	}

	public void setIdadeJogador(int idadeJogador) {
		this.idadeJogador = idadeJogador;
	}

	public int getValContrato() {
		return valContrato;
	}

	public void setValContrato(int valContrato) {
		this.valContrato = valContrato;
	}

	public int getQtdJogos() {
		return qtdJogos;
	}

	public void setQtdJogos(int qtdJogos) {
		this.qtdJogos = qtdJogos;
	}

	public int getQtdGols() {
		return qtdGols;
	}

	public void setQtdGols(int qtdGols) {
		this.qtdGols = qtdGols;
	}

	@Override
	public String toString() {
		return "Jogador " + nomeJogador + ", idade:" + idadeJogador + ", posição em campo:"
				+ posicaoEmCampo + ", validade de contrato: " + valContrato + ", quatidade de jogos:" + qtdJogos + ", gols realizados:" + qtdGols;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idadeJogador, nomeJogador, posicaoEmCampo, qtdGols, qtdJogos, valContrato);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Jogador other = (Jogador) obj;
		return idadeJogador == other.idadeJogador && Objects.equals(nomeJogador, other.nomeJogador)
				&& Objects.equals(posicaoEmCampo, other.posicaoEmCampo) && qtdGols == other.qtdGols
				&& qtdJogos == other.qtdJogos && valContrato == other.valContrato;
	}
	
	
	
}
