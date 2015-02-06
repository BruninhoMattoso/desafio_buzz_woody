package br.com.dextra.estagio2015.atv01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Atividade1 {

	public List<String> encontrarPessoaPorNome(Map<Long, String> pessoas, String nome) {
		List<String> pessoasEncontradas = new ArrayList<String>();
		
		for(Entry<Long, String> entry : pessoas.entrySet()) {
			if (entry.getValue().equals(nome))
				pessoasEncontradas.add(nome);
		}
		return pessoasEncontradas;
	}
}
