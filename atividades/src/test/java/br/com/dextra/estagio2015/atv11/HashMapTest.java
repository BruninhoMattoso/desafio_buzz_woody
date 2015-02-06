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

	public static class Person {
		private Long id;
		private String name;

		public Person() {

		}

		public Person(Long id, String name) {
			this.id = id;
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Pessoa [id=" + id + ", name=" + name + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

	}

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