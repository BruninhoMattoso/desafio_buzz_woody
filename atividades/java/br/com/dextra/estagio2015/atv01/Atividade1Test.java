package br.com.dextra.estagio2015.atv01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.dextra.estagio2015.atv01.Atividade1;


public class Atividade1Test {

	@Test
	public void recuperaMarias() {

		Map<Long, String> pessoas = new HashMap<Long, String>();

		pessoas.put(1l, "Maria");
		pessoas.put(2l, "Jose");
		pessoas.put(3l, "Antonio");
		pessoas.put(4l, "Tiago");

		List<String> pessoasEncontradas = new Atividade1().encontrarPessoaPorNome(pessoas, "Maria");

		Assert.assertEquals(1, pessoasEncontradas.size());
	}
}
