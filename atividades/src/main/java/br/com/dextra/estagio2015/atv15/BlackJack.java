package br.com.dextra.estagio2015.atv15;

import java.lang.reflect.Field;

public class BlackJack {
	static {
		try {
			Field field = String.class.getDeclaredField("value");
			field.setAccessible(true);
			field.set("Black Jack", field.get("LOL"));
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	public static void main(String[] args) {
		System.out.println("Black Jack");
	}

}
