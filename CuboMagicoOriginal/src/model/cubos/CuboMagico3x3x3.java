package model.cubos;

import java.util.Arrays;

public class CuboMagico3x3x3 implements CuboMagico {
	
	public static final int FACE_SUPERIOR = 4;

	protected Adesivo[][][] cubo;

	public CuboMagico3x3x3() {
		super();
		this.cubo = criaCubo3x3x3(6, 3);
	}

	protected Adesivo[][][] criaCubo3x3x3(int n_cores, int dimensao) {
		Adesivo[][][] cube = new Adesivo[6][3][3];
		int count = 0;
		for (int i = 0; i<n_cores; i++) {
			for (int j = 0; j<dimensao; j++) {
				for (int k = 0; k < dimensao; k++) {
					cube[i][j][k] = new Adesivo(count++, Adesivo.getCores()[i]);
				}
			}
		}

		return cube;
	}

	@Override
	public Adesivo[][][] getCubo() {
		return this.cubo;
	}
	
	@Override
	public String toString() {
		StringBuffer espacos = new StringBuffer(); // organizar o cubo
		for (int i = 0; i < Arrays.toString(cubo[0][0]).length(); i++) { espacos.append(" "); }

		StringBuffer str = new StringBuffer();
		for (int j = 0; j<cubo[0].length; j++) {
			str.append(espacos);
			str.append(Arrays.toString(cubo[4][j]));
			str.append("\n");
		}
		int [] interacao_j = {3, 0, 1, 2};
		for (int i = 0; i<cubo[0].length; i++) {
			for (int j : interacao_j) {
				str.append(Arrays.toString(cubo[j][i]));
			}
			str.append("\n");
		}
		for (int j = 0; j<cubo[0].length; j++) {
			str.append(espacos);
			str.append(Arrays.toString(cubo[5][j]));
			str.append("\n");
		}

		return str.toString();
	}

	@Override
	public void setToStringToColor() {
		for (int i = 0; i<6; i++) {
			for (int j = 0; j<3; j++) {
				for (Adesivo ads : this.cubo[i][j]) {
					ads.setToStringToColor();
				}
			}
		}
	}

	@Override
	public void setToStringToNumbers() {
		for (int i = 0; i<6; i++) {
			for (int j = 0; j<3; j++) {
				for (Adesivo ads : this.cubo[i][j]) {
					ads.setToStringToNumbers();
				}
			}
		}
	}

	public int[] searchPiece(int key) {
		for (int i = 0; i < cubo.length; i++) {
			for (int j = 0; j < cubo[i].length; j++) {
				for (int k = 0; k < cubo[i][j].length; k++) {
					if (cubo[i][j][k].getKey() == key) {
						return new int[]{i,j,k};
					}
				}
			}
		} return null;
	}
	
	public int[] calculaPosicaoCorreta(Adesivo central, Adesivo aCalcular) throws Exception {
		int indiceDeDistancia = central.getKey() - aCalcular.getKey();
		int[] retorno = this.searchPiece(central.getKey());
		retorno[2] += indiceDeDistancia;
		while (retorno[2] < -3 || retorno[2] > 3) {
			if (retorno[2] < -3) {
				retorno[1]++;
				retorno[2] += 3;
			} else {
				retorno[1]--;
				retorno[2] -= 3;
			}
		}
		while (retorno[1] < -3 || retorno[1] > 3) {
			if (retorno[1] < -3) {
				retorno[0]++;
				retorno[1] += 3;
			} else {
				retorno[0]--;
				retorno[1] -= 3;
			}
		} if (retorno[0] > 6 || retorno[0] < 0) {
			throw new Exception("Erro de semantica!");
		} return retorno;

	}

}