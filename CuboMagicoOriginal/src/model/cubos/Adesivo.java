package model.cubos;

public class Adesivo {

	private Integer key;
	
	private Cor cor;
	
	private int controlaToString = 0;

	private final static Cor[] cores = {Cor.AZUL, Cor.VERMELHO, Cor.VERDE, Cor.LARANJA, Cor.AMARELO, Cor.BRANCO};

	public Adesivo(Integer key, Cor cor) {
		super();
		
		this.key = key;
		this.cor = cor;
	}

	@Override
	public String toString() {
		String resp = null;
		switch (this.controlaToString) {
		case 0:
			resp = (key<10? " ": "") + key.toString();
			break;

		case 1:
			resp = cor.toString();
		default:
			break;
		}
		return resp;
	}

	public static Cor[] getCores() {
		return cores;
	}

	public void setToStringToColor() {
		this.controlaToString = 1;
	}

	public void setToStringToNumbers() {
		this.controlaToString = 0;
	}

	public int getKey() {
		return key;
	}

	public boolean isCor(Cor cor) {
		return this.cor == cor;
	}

	public Cor getCor() {
		return cor;
	}

}
