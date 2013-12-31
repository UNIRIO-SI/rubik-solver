package model.matrizes;

import java.util.Arrays;

public class MatrizBidimensional {

	private MatrizBidimensional() {} 

	public static void transposta(Object[][] matriz) {
		Object[][] copia = copiar(matriz);
		for (int i = 0; i<copia.length; i++) {
			for (int j = 0; j<copia[0].length; j++) {
				matriz[j][i] = copia[i][j];
			}
		}
	}

	public static Object[][] copiar(Object[][] matriz) {
		Object[][] copia = new Object[matriz.length][matriz[0].length];
		for (int i = 0; i<matriz.length; i++) {
			copia[i] = Arrays.copyOf(matriz[i], matriz.length);
		}
		return copia;
	}

	public static void espelharColunas(Object[][] matriz) {
		transposta(matriz);
		espelharLinhas(matriz);
		transposta(matriz);
	}

	public static void espelharLinhas(Object[][] matriz) {
		Object[][] copia = copiar(matriz);
		int linha_copia = 0;
		for (int i = matriz.length-1; i>=0; i--) {
			linha_copia = matriz.length-1 - i;
			for (int j = 0; j<matriz[0].length; j++) {
				matriz[i][j] = copia[linha_copia][j];
			}
		}
	}

}