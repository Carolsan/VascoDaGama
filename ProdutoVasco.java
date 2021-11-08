package exercicio7;

import java.util.LinkedList;
import java.util.List;

public class ProdutoVasco {
	
	private List<CategoriaProduto> categoria;
	private int qtdEmEstoque;
	private int precoVenda;
	private String descricao;
	
	public ProdutoVasco() {
		this(new LinkedList<>(), 0, 0, "");
	}
	
	public ProdutoVasco(List<CategoriaProduto> categoria, int qtdEstoque, int precoVenda, String descricao) {
		this.categoria = categoria;
		this.qtdEmEstoque =  qtdEstoque;
		this.precoVenda = precoVenda;
		this.descricao = descricao;
	}

	public List<CategoriaProduto> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<CategoriaProduto> categoria) {
		this.categoria = categoria;
	}

	public int getQtdEmEstoque() {
		return qtdEmEstoque;
	}

	public void setQtdEmEstoque(int qtdEmEstoque) {
		this.qtdEmEstoque = qtdEmEstoque;
	}

	public int getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(int precoVenda) {
		this.precoVenda = precoVenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Categoria de produto: " + categoria + " \nQuantidade em estoque: " + qtdEmEstoque + "\n Preço do produto: R$" + precoVenda
				+ "\n detalhes do produto: " + descricao;
	}
	
	
}

