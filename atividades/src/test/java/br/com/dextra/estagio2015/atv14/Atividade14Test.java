package br.com.dextra.estagio2015.atv14;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class Atividade14Test {

	
	@Test
	public void testSpecialStream() {
		SpecialStream saida = new SpecialStream(System.out);
		saida.addReplaceIgnoreCase("falhou", "funcionou");
		Class[] params = {String.class};
		try {
			Method m = saida.getClass().getDeclaredMethod("processText",params);
			m.setAccessible(true);
			assertEquals("esse test funcionou",m.invoke(saida, "esse test falhou"));
			assertEquals("esse test funcionou",m.invoke(saida, "esse test fAlHou"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
