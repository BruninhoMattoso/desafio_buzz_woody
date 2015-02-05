package br.com.dextra.estagio2015.atv07;

public class Atividade7 {

	public Boolean verificaData(Long dia, Long mes, Long ano) {
		if (mes < 1 || mes > 12 || dia > 31 || dia < 1) {
			return false;
		}

		// Até Julho
		if (mes <= 7) {
			
			if (mes % 2 == 1) {
				return true;
			} else  {
				//Fevereiro especial
				if (mes == 2 && dia > 29 && ano % 4 == 0) {
					return false;

					// Fevereiro sem especial
				} else if (mes == 2 && dia > 28 && ano % 4 != 0) 
					return false;
				 
				
				if (dia < 31)
					return true;
				
				return false;
			}
		}	
		/////////////////////////////////////////////////////	
			
			
		else {
			if (mes % 2 == 1 && dia > 30) 
				return false;
			
			return true;
		}
	}
	
}
