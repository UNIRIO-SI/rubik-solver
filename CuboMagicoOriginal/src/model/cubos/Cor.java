package model.cubos;

public enum Cor {

	AZUL("0"),
	VERMELHO("1"),
	VERDE("2"),
	LARANJA("3"),
	AMARELO("4"),
	BRANCO("5");

	protected String mensagem;

	private Cor(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	@Override
	public String toString() {
		return this.mensagem;
	}

}