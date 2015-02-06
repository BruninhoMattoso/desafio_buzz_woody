package br.com.dextra.estagio2015.atv14;

import br.com.dextra.estagio2015.atv03.BlackJack;



/**
 * @author jefferson.venancio
 * 
 *         Olá desenvolvedores!
 * 
 *         Seguinte, agora no Brasil o jogo "Black Jack" não é mais permitido
 *         (Algum dia já foi permitido?)
 * 
 *         Enfim, o cara que fez esse software Colocou um "Black Jack" logo que começa o programa
 *         gostaria que fosse alterado de "Black Jack" Para "21"
 * 
 *		   Há um porém, gostaria que nunca mais um "sysout" apresente "Black Jack". Mesmo que seja incluido futuramente. 
 * 
 *         Vocês podem me ajudar?
 * 
 *         Qualquer coisa me chama no talk, jefferson.venancio
 * 
 */
public class BlackJackEh21Agora extends BlackJack{
	
	public BlackJackEh21Agora(){
		super();
		SpecialStream saida = new SpecialStream(System.out);
		saida.addReplaceIgnoreCase("BlackJack", "21");
		saida.addReplaceIgnoreCase("Black Jack", "21");
		System.setOut(saida);
	}
	
	public static void main(String[] args) {
		SpecialStream saida = new SpecialStream(System.out);
		saida.addReplaceIgnoreCase("cArA", "VEI");
		System.setOut(saida);
		System.out.println("EI CARA");
		
	}
}
