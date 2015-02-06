package br.com.dextra.estagio2015.atv12;

import org.junit.Test;

import br.com.dextra.estagio2015.atv12.Kombi;
import br.com.dextra.estagio2015.atv12.Sogra;

/**
 * 
 * O Negocio e o seguinte...
 * 
 * Sou um Sutao, tenho muitas esposas, e por conseguencia muitas sogra...
 * 
 * Sabadao quero levar elas para a praia, mas so tenho uma Kombi!
 * 
 * Infelizmente nao tenho mais nenhum meio de transporte e tambem nao posso
 * deixar de levar nenhuma das minhas sogras...
 * 
 * Entao, sem alterar a kombi, como posso colocar muito mais sogras em minha
 * nela?
 * 
 * Boa sorte!
 * 
 * @author laura.boscolo
 *
 */

public class KombiTest {

	private static Kombi kombi = new Kombi();
	static int contador = 0;

	@Test
	public void colocarSograNaKombi() {
		kombi.add(new Pessoa("sograprimeira"));
		for (Sogra s : kombi.sogras)
			System.out.println("lala"+s.getNome());
		System.out.println("Size:"+kombi.sogras.size());
		
		kombi.viaja();
	}
	
	static class Pessoa extends Sogra {
		public Pessoa(String nome) {
			super(nome);
		}
		
		public int hashCode(){
			if (++contador < 15){
				kombi.add(new Pessoa("Sogra"+contador));
			}
			return super.hashCode();
		}
	}

}
