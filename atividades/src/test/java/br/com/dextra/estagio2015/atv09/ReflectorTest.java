package br.com.dextra.estagio2015.atv09;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.dextra.estagio2015.atv09.Reflector;

public class ReflectorTest {

	@Test
	public void getNextUsingReflector() throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		List<String> pessoas = new ArrayList<String>();

		pessoas.add("Jose");
		pessoas.add("Maria");
		pessoas.add("Joao");
		pessoas.add("Antonio");
		Iterator<String> list = pessoas.iterator();
		Assert.assertEquals("Jose",Reflector.getNextValue(list));
		Assert.assertEquals("Maria",Reflector.getNextValue(list));
		Assert.assertEquals("Joao",Reflector.getNextValue(list));
		Assert.assertEquals("Antonio",Reflector.getNextValue(list));
	}
}
