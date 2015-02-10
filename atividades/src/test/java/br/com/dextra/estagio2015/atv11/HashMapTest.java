package br.com.dextra.estagio2015.atv11;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Fizemos todas as alterações na variavel "pessoa" antes de colocar no mapa.
 * Também deletamos o método process, porque todas as informações  foram adicionadas no construtor.
 * @author laura.boscolo
 *
 */

public class HashMapTest {

	@Test
	public void testMap() {
		Map<Person, String> map = new HashMap<Person, String>();
		
		Person pessoa = new Person(1l, "PessoaTeste1");

		map.put(pessoa, "A primeira pessoa do teste");
		
		assertTrue(map.containsKey(pessoa));
		Person key = map.keySet().iterator().next();
		assertTrue(map.containsKey(key));
	}

}