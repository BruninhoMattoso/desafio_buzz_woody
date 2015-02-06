package br.com.dextra.estagio2015.atv07;

public class Comparator {

	public boolean comparaStrings (String...strings) {
		for (int i = 0; i < strings.length; i++ ){
			strings[i] = strings[i].toUpperCase();
		}
		for (String frase : strings) {
			for (int i = 0; i < strings.length; i++) {
				if (!frase.equals(strings[i])) {
					return false;
				}
			}
		}
		
		
		return true;
		
	}
	
}