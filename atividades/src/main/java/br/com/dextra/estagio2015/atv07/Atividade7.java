package br.com.dextra.estagio2015.atv07;

/*
 * [WOODY] 
 * Retirado variaveis privadas da classe Atividade7
 * Refatorado metodo verificaData
 * 
 */
public class Atividade7 {

	public Boolean verificaData(Long dia, Long mes, Long ano) {
		if (mes < 1 || mes > 12 || dia > 31 || dia < 1) {
			return false;
		}
		if (mes == 2) {
			if (dia > 29) {
				return false;
			}
			if (dia > 28 && ano % 4 != 0) {
				return false;
			}
			return true;
		}
		if (mes <= 7) {
			if (mes % 2 == 0 && dia > 30) {
				return false;
			}
			return true;
		} else {
			if (mes % 2 == 1 && dia > 30)
				return false;
			return true;
		}
	}

}
