package model.rotations;

import model.cubos.Adesivo;
import model.cubos.CuboMagico;
import model.cubos.CuboMagico3x3x3;
import model.matrizes.MatrizBidimensional;

public class RotationsImpl implements Rotations {
	
	@Override
	public void girarCimaSentidoHorario(CuboMagico cubo) {
		Adesivo[][][] cube = cubo.getCubo();

		Adesivo[] linha_0 = cube[0][0];
		Adesivo[] linha_1 = cube[1][0];
		Adesivo[] linha_2 = cube[2][0];
		Adesivo[] linha_3 = cube[3][0];

		cube[0][0] = linha_1;
		cube[1][0] = linha_2;
		cube[2][0] = linha_3;
		cube[3][0] = linha_0;

		MatrizBidimensional.transposta(cube[4]);
		MatrizBidimensional.espelharColunas(cube[4]);

	}

	@Override
	public void girarCimaSentidoAntiHorario(CuboMagico cubo) {
		girarCimaSentidoHorario(cubo);
		girarCimaSentidoHorario(cubo);
		girarCimaSentidoHorario(cubo);
	}

	@Override
	public void girarCima2Vezes(CuboMagico cubo) {
		girarCimaSentidoHorario(cubo);
		girarCimaSentidoHorario(cubo);
	}

	@Override
	public void girarBaseSentidoHorario(CuboMagico cubo) {
		Adesivo[][][] cube = cubo.getCubo();

		Adesivo[] linha_0 = cube[0][cube[0].length-1];
		Adesivo[] linha_1 = cube[1][cube[0].length-1];
		Adesivo[] linha_2 = cube[2][cube[0].length-1];
		Adesivo[] linha_3 = cube[3][cube[0].length-1];

		cube[0][cube[0].length-1] = linha_3;
		cube[1][cube[0].length-1] = linha_0;
		cube[2][cube[0].length-1] = linha_1;
		cube[3][cube[0].length-1] = linha_2;

		MatrizBidimensional.transposta(cube[5]);
		MatrizBidimensional.espelharColunas(cube[5]);
	}

	@Override
	public void girarBaseSentidoAntiHorario(CuboMagico cubo) {
		girarBaseSentidoHorario(cubo);
		girarBaseSentidoHorario(cubo);
		girarBaseSentidoHorario(cubo);
	}

	@Override
	public void girarBase2Vezes(CuboMagico cubo) {
		girarBaseSentidoHorario(cubo);
		girarBaseSentidoHorario(cubo);
	}

	@Override
	public void girarFrenteSentidoHorario(CuboMagico cubo) {
		Adesivo[][][] cube = cubo.getCubo();
		int dim = cube[0].length;
		int[] interacaoCoresColunas = {1, 3};
		Adesivo[][] colunas = new Adesivo[2][dim];
		Adesivo[][] linhas = new Adesivo[2][dim];
		for (int i = 0; i<interacaoCoresColunas.length; i++) {
			for (int j = 0; j<dim; j++) {
				colunas[i][j] = cube[interacaoCoresColunas[i]][j][(i==0? 0:2)];
			}
		}
		linhas[0] = cube[4][2];
		linhas[1] = cube[5][0];

		cube[1][0][0] = linhas[0][0];
		cube[1][1][0] = linhas[0][1];
		cube[1][2][0] = linhas[0][2];

		cube[3][0][2] = linhas[1][0];
		cube[3][1][2] = linhas[1][1];
		cube[3][2][2] = linhas[1][2];

		cube[CuboMagico3x3x3.FACE_SUPERIOR][2][0] = colunas[1][2];
		cube[CuboMagico3x3x3.FACE_SUPERIOR][2][1] = colunas[1][1];
		cube[CuboMagico3x3x3.FACE_SUPERIOR][2][2] = colunas[1][0];

		cube[5][0][0] = colunas[0][2];
		cube[5][0][1] = colunas[0][1];
		cube[5][0][2] = colunas[0][0];

		MatrizBidimensional.transposta(cube[0]);
		MatrizBidimensional.espelharColunas(cube[0]);
	}

	@Override
	public void girarFrenteSentidoAntiHorario(CuboMagico cubo) {
		girarFrenteSentidoHorario(cubo);
		girarFrenteSentidoHorario(cubo);
		girarFrenteSentidoHorario(cubo);
	}

	@Override
	public void girarFrente2Vezes(CuboMagico cubo) {
		girarFrenteSentidoHorario(cubo);
		girarFrenteSentidoHorario(cubo);
	}

	@Override
	public void girarAtrasSentidoHorario(CuboMagico cubo) {
		Adesivo[][][] cube = cubo.getCubo();
		int dim = cube[0].length;
		int[] interacaoCoresColunas = {1, 3};
		Adesivo[][] colunas = new Adesivo[2][dim];
		Adesivo[][] linhas = new Adesivo[2][dim];
		for (int i = 0; i<interacaoCoresColunas.length; i++) {
			for (int j = 0; j<dim; j++) {
				colunas[i][j] = cube[interacaoCoresColunas[i]][j][(i==0? 2:0)];
			}
		}
		linhas[0] = cube[4][0];
		linhas[1] = cube[5][2];

		cube[1][0][2] = linhas[1][2];
		cube[1][1][2] = linhas[1][1];
		cube[1][2][2] = linhas[1][0];

		cube[3][0][0] = linhas[0][2];
		cube[3][1][0] = linhas[0][1];
		cube[3][2][0] = linhas[0][0];

		cube[4][0] = colunas[0];

		cube[5][2] = colunas[1];

		MatrizBidimensional.transposta(cube[2]);
		MatrizBidimensional.espelharColunas(cube[2]);
	}

	@Override
	public void girarAtrasSentidoAntiHorario(CuboMagico cubo) {
		girarAtrasSentidoHorario(cubo);
		girarAtrasSentidoHorario(cubo);
		girarAtrasSentidoHorario(cubo);
	}

	@Override
	public void girarAtras2Vezes(CuboMagico cubo) {
		girarAtrasSentidoHorario(cubo);
		girarAtrasSentidoHorario(cubo);
	}

	@Override
	public void girarDireitaSentidoHorario(CuboMagico cubo) {
		Adesivo[][][] cube = cubo.getCubo();
		int dim = cube[0].length;
		int[] interacaoCores = {0, /*2,*/ 4, 5};
		Adesivo[][] colunas = new Adesivo[4][dim];
		for (int i = 0; i<interacaoCores.length; i++) {
			for (int j = 0; j<dim; j++) {
				colunas[i][j] = cube[interacaoCores[i]][j][dim-1];
			}
		}
		for (int j = 0; j<dim; j++) {
			colunas[colunas.length-1][j] = cube[2][j][0];
		}

		cube[0][0][2] = colunas[2][0];
		cube[0][1][2] = colunas[2][1];
		cube[0][2][2] = colunas[2][2];

		cube[4][0][2] = colunas[0][0];
		cube[4][1][2] = colunas[0][1];
		cube[4][2][2] = colunas[0][2];

		cube[5][0][2] = colunas[3][2];
		cube[5][1][2] = colunas[3][1];
		cube[5][2][2] = colunas[3][0];

		cube[2][0][0] = colunas[1][2];
		cube[2][1][0] = colunas[1][1];
		cube[2][2][0] = colunas[1][0];

		MatrizBidimensional.transposta(cube[1]);
		MatrizBidimensional.espelharColunas(cube[1]);
	}

	@Override
	public void girarDireitaSentidoAntiHorario(CuboMagico cubo) {
		girarDireitaSentidoHorario(cubo);
		girarDireitaSentidoHorario(cubo);
		girarDireitaSentidoHorario(cubo);
	}

	@Override
	public void girarDireita2Vezes(CuboMagico cubo) {
		girarDireitaSentidoHorario(cubo);
		girarDireitaSentidoHorario(cubo);
	}

	@Override
	public void girarEsquerdaSentidoHorario(CuboMagico cubo) {
		Adesivo[][][] cube = cubo.getCubo();
		int dim = cube[0].length;
		int[] interacaoCores = {0, 4, 5};
		Adesivo[][] colunas = new Adesivo[4][dim];
		for (int i = 0; i<interacaoCores.length; i++) {
			for (int j = 0; j<dim; j++) {
				colunas[i][j] = cube[interacaoCores[i]][j][0];
			}
		}
		for (int j = 0; j<dim; j++) {
			colunas[colunas.length-1][j] = cube[2][j][dim-1];
		}

		cube[0][0][0] = colunas[1][0];
		cube[0][1][0] = colunas[1][1];
		cube[0][2][0] = colunas[1][2];

		cube[5][0][0] = colunas[0][0];
		cube[5][1][0] = colunas[0][1];
		cube[5][2][0] = colunas[0][2];

		cube[4][0][0] = colunas[3][2];
		cube[4][1][0] = colunas[3][1];
		cube[4][2][0] = colunas[3][0];

		cube[2][0][2] = colunas[2][2];
		cube[2][1][2] = colunas[2][1];
		cube[2][2][2] = colunas[2][0];

		MatrizBidimensional.transposta(cube[3]);
		MatrizBidimensional.espelharColunas(cube[3]);
	}

	@Override
	public void girarEsquerdaSentidoAntiHorario(CuboMagico cubo) {
		girarEsquerdaSentidoHorario(cubo);
		girarEsquerdaSentidoHorario(cubo);
		girarEsquerdaSentidoHorario(cubo);
	}

	@Override
	public void girarEsquerda2Vezes(CuboMagico cubo) {
		girarEsquerdaSentidoHorario(cubo);
		girarEsquerdaSentidoHorario(cubo);
	}

	@Override
	public void executa(CuboMagico cubo, String[] operacoes) {
		
		for (String oper : operacoes) {
			
			if ("U".equals(oper)) {
				girarCimaSentidoHorario(cubo);
			} else if ("U_".equals(oper)) {
				girarCimaSentidoAntiHorario(cubo);
			} else if ("U2".equals(oper)) {
				girarCima2Vezes(cubo);
			} else if ("D".equals(oper)) {
				girarBaseSentidoHorario(cubo);
			} else if ("D_".equals(oper)) {
				girarBaseSentidoAntiHorario(cubo);
			} else if ("D2".equals(oper)) {
				girarBase2Vezes(cubo);
			} else if ("F".equals(oper)) {
				girarFrenteSentidoHorario(cubo);
			} else if ("F_".equals(oper)) {
				girarFrenteSentidoAntiHorario(cubo);
			} else if ("F2".equals(oper)) {
				girarFrente2Vezes(cubo);
			} else if ("B".equals(oper)) {
				girarAtrasSentidoHorario(cubo);
			} else if ("B_".equals(oper)) {
				girarAtrasSentidoAntiHorario(cubo);
			} else if ("B2".equals(oper)) {
				girarAtras2Vezes(cubo);
			} else if ("R".equals(oper)) {
				girarDireitaSentidoHorario(cubo);
			} else if ("R_".equals(oper)) {
				girarDireitaSentidoAntiHorario(cubo);
			} else if ("R2".equals(oper)) {
				girarDireita2Vezes(cubo);
			} else if ("L".equals(oper)) {
				girarEsquerdaSentidoHorario(cubo);
			} else if ("L_".equals(oper)) {
				girarEsquerdaSentidoAntiHorario(cubo);
			} else if ("L2".equals(oper)) {
				girarEsquerda2Vezes(cubo);
			} else if ("Z".equals(oper)) {
				girarEixoZSentidoHorario(cubo);
			} else if ("Z_".equals(oper)) {
				girarEixoZSentidoAntiHorario(cubo);
			} else if ("Z2".equals(oper)) {
				girarEixoZ2Vezes(cubo);
			}
		}
		
	}

	public void girarEixoZSentidoHorario(CuboMagico cubo) {
		Adesivo[][][] cube = cubo.getCubo();
		int dim = cube[0].length;
		int[] interacaoCores = {1, 3/*, 4, 5*/};
		Adesivo[][] colunas = new Adesivo[2][dim];
		Adesivo[][] linhas = new Adesivo[2][dim];
		for (int i = 0; i<interacaoCores.length; i++) {
			for (int j = 0; j<dim; j++) {
				colunas[i][j] = cube[interacaoCores[i]][j][1];
			}
		}

		linhas[0] = cube[4][1];
		linhas[1] = cube[5][1];

		cube[1][0][1] = linhas[1][2];
		cube[1][1][1] = linhas[1][1];
		cube[1][2][1] = linhas[1][0];

		cube[3][0][1] = linhas[0][2];
		cube[3][1][1] = linhas[0][1];
		cube[3][2][1] = linhas[0][0];

		cube[4][1] = colunas[0];

		cube[5][1] = colunas[1];

		girarFrenteSentidoAntiHorario(cubo);
		girarAtrasSentidoHorario(cubo);
	}

	public void girarEixoZSentidoAntiHorario(CuboMagico cubo) {
		girarEixoZSentidoHorario(cubo);
		girarEixoZSentidoHorario(cubo);
		girarEixoZSentidoHorario(cubo);
	}

	public void girarEixoZ2Vezes(CuboMagico cubo) {
		girarEixoZSentidoHorario(cubo);
		girarEixoZSentidoHorario(cubo);
	}

	public void girarEixoXSentidoHorario(CuboMagico cubo) {
		
		Adesivo[][][] cube = cubo.getCubo();
		int dim = cube[0].length;
		int[] interacaoCores = {0, 2, 4, 5};
		Adesivo[][] colunas = new Adesivo[4][dim];
		for (int i = 0; i<interacaoCores.length; i++) {
			for (int j = 0; j<dim; j++) {
				colunas[i][j] = cube[interacaoCores[i]][j][1];
			}
		}

		cube[0][0][1] = colunas[3][0];
		cube[0][1][1] = colunas[3][1];
		cube[0][2][1] = colunas[3][2];

		cube[2][0][1] = colunas[2][2];
		cube[2][1][1] = colunas[2][1];
		cube[2][2][1] = colunas[2][0];

		cube[4][0][1] = colunas[0][0];
		cube[4][1][1] = colunas[0][1];
		cube[4][2][1] = colunas[0][2];

		cube[5][0][1] = colunas[1][2];
		cube[5][1][1] = colunas[1][1];
		cube[5][2][1] = colunas[1][0];

		girarEsquerdaSentidoAntiHorario(cubo);
		girarDireitaSentidoHorario(cubo);
	}

	public void girarEixoXSentidoAntiHorario(CuboMagico cubo) {
		girarEixoXSentidoHorario(cubo);
		girarEixoXSentidoHorario(cubo);
		girarEixoXSentidoHorario(cubo);
	}

	public void girarEixoX2Vezes(CuboMagico cubo) {
		girarEixoXSentidoHorario(cubo);
		girarEixoXSentidoHorario(cubo);
	}

	public void girarEixoYSentidoHorario(CuboMagico cubo) {
		girarCamadaMeioHorizontalSentidoAntiHorario(cubo);
		girarBaseSentidoAntiHorario(cubo);
		girarCimaSentidoHorario(cubo);
	}

	public void girarCamadaMeioHorizontalSentidoAntiHorario(CuboMagico cubo) {
		Adesivo[][][] cube = cubo.getCubo();
		int dim = cube[0].length;
		Adesivo[][] linhas = new Adesivo[4][dim];
		for (int i = 0; i<4; i++) {
			linhas[i] = cube[i][1];
		}

		cube[0][1] = linhas[1];
		cube[1][1] = linhas[2];
		cube[2][1] = linhas[3];
		cube[3][1] = linhas[0];
	}

	public void girarCamadaMeioHorizontalSentidoHorario(CuboMagico cubo) {
		girarCamadaMeioHorizontalSentidoAntiHorario(cubo);
		girarCamadaMeioHorizontalSentidoAntiHorario(cubo);
		girarCamadaMeioHorizontalSentidoAntiHorario(cubo);
	}

	public void girarCamadaMeioHorizontal2Vezes(CuboMagico cubo) {
		girarCamadaMeioHorizontalSentidoAntiHorario(cubo);
		girarCamadaMeioHorizontalSentidoAntiHorario(cubo);
	}

	public void girarEixoYSentidoAntiHorario(CuboMagico cubo) {
		girarEixoYSentidoHorario(cubo);
		girarEixoYSentidoHorario(cubo);
		girarEixoYSentidoHorario(cubo);
	}

	public void girarEixoY2Vezes(CuboMagico cubo) {
		girarEixoYSentidoHorario(cubo);
		girarEixoYSentidoHorario(cubo);
	}

}