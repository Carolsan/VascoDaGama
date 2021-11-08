package exercicio7;

public class Patrocinio {

		private String nomePatroc;
		private String CPFPatroc;
		private int numCartao;
		private int CVV;
		
		public Patrocinio(String nome, String cpf, int numCartao, int cvv) {
			this.nomePatroc = nome;
			this.CPFPatroc = cpf;
			this.numCartao = numCartao;
			this.CVV = cvv;
		}
		
		public Patrocinio() {
			this(" ", " ", 0, 0);
		}

		public String getNomePatroc() {
			return nomePatroc;
		}

		public void setNomePatroc(String nomePatroc) {
			this.nomePatroc = nomePatroc;
		}

		public String getCPFPatroc() {
			return CPFPatroc;
		}

		public void setCPFPatroc(String cPFPatroc) {
			CPFPatroc = cPFPatroc;
		}

		public int getNumCartao() {
			return numCartao;
		}

		public void setNumCartao(int numCartao) {
			this.numCartao = numCartao;
		}

		public int getCVV() {
			return CVV;
		}

		public void setCVV(int cVV) {
			CVV = cVV;
		}

		@Override
		public String toString() {
			return "Patrocinador " + nomePatroc + ", de CPF n°: " + CPFPatroc;
		}
		
		
}
