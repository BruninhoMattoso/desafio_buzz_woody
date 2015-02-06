package br.com.dextra.estagio2015.atv09;
/*
 * [WOODY]
 * - setando accessible true no metodo next
 */
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class Reflector {
	public static Object getNextValue(Iterator<String> it)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException, SecurityException {
		Method m = it.getClass().getMethod("next");
		m.setAccessible(true);
		return m.invoke(it);
	}
}
