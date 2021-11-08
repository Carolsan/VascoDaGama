package exercicio7;

public enum CategoriaProduto {
	
	CAMISA("camisa"),
	CALCA("calça"),
	BERMUDA("bermuda"),
	CORDAO("cordão"),
	COLAR("colar"),
	MEIAS("meias"),
	CHAVEIRO("chaveiro"),
	BLUSAO("blusão"),
	BIKINI("bikini"),
	BANDANA("bandana");
	
	private String tipo;
	
	CategoriaProduto(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
}
