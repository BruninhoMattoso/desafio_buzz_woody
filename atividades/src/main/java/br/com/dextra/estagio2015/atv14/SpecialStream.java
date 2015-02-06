package br.com.dextra.estagio2015.atv14;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SpecialStream extends PrintStream {

	private Map<String,String> replacedWords; 
	
	public SpecialStream(OutputStream out) {
		super(out);
		this.replacedWords = new HashMap<String, String>();
	}
	
	@Override
	public void print(String txt) {
		super.print(processText(txt));
	}
	
	@Override
	public void println(String txt) {
		super.println(processText(txt));
	}
	
	
	public void addReplace(String oldWord, String newWord) {
		replacedWords.put(oldWord, newWord);
	}
	
	public void addReplaceIgnoreCase(String oldWord, String newWord) {
		this.addReplace("(?i)"+oldWord,newWord);
	}
	
	private String processText(String txt) {
		for(Entry<String, String> entry : replacedWords.entrySet()) {
		    txt = txt.replaceAll(entry.getKey(),entry.getValue());
		    
		}
		return txt;
	}

	

}
