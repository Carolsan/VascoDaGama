package exercicio7;

public enum PosicaoEmCampo {
	ATACANTE("atacante"),
	GOLEIRO("goleiro"),
	MEIO_CAMPO("meio-campista"),
	VOLANTE("volante"),
	ZAGUEIRO("zagueiro"),
	LATERAL_DIREITO("lateral-direito"),
	LATERAL_ESQUERDO("lateral-esquerdo");
	
	private String posicaoEmCampo;
	PosicaoEmCampo(String posicaoEmCampo){
		this.posicaoEmCampo = posicaoEmCampo;
	}
	
	public String getPosicaoEmCampo() {
		return posicaoEmCampo;
	}
}
