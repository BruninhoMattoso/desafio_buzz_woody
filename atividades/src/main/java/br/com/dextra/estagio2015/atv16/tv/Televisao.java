package br.com.dextra.estagio2015.atv16.tv;

public class Televisao {

	private boolean ligada = false;
	
	private Canal canal = new Canal(0);
	
	private Volume volume = new Volume(5);

	public Televisao setVolume(int volume) {
		this.volume = new Volume(volume);
		return this;
	}
	
	public Televisao abaixarVolume() {
		this.volume.abaixar();
		return this;
	}

	public Televisao aumentarVolume() {
		this.volume.aumentar();
		return this;
	}

	public Televisao canalAnterior() {
		this.canal.anterior();
		return this;
	}

	public int getCanal() {
		return canal.getAtual();
	}
	
	public int getVolume() {
		return volume.getAtual();
	}
	
	public boolean isLigada() {
		return ligada;
	}
	
	public Televisao proximoCanal() {
		this.canal.proximo();
		return this;
	}

	public Televisao setCanal(int canal) {
		this.canal = new Canal(canal);
		return this;
	}

	public Televisao setLigada(boolean ligada) {
		this.ligada = ligada;
		return this;
	}
}
