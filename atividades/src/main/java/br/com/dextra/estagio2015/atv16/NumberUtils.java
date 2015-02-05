package br.com.dextra.estagio2015.atv16;

public class NumberUtils {

	public static boolean isNumber(String str) {
		try {
			Long.parseLong(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static Integer asInt(String str) {
		return Integer.parseInt(str);
	}
	
}
