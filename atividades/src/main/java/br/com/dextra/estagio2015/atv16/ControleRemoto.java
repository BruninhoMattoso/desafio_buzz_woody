package br.com.dextra.estagio2015.atv16;

import br.com.dextra.estagio2015.atv16.tv.Televisao;

public class ControleRemoto {

	private Televisao tv;
	private String display = "";

	public ControleRemoto(Televisao tv) {
		this.tv = tv;
	}

	public ControleRemoto setDisplay(String display) {
		this.display = display;
		return this;
	}

	public String getDisplay() {
		return display;
	}

	public void clickon(String botao) {
		String displayAtualizado = "";
		Integer canal = this.tv.getCanal();
		if (NumberUtils.isNumber(botao)) {
			String displayBotao = "0";
			Integer botaoAsInteger = NumberUtils.asInt(botao);
			if (botaoAsInteger < 5) {
				if (botao.equals("00")) {
					canal = 0;
					displayBotao += "0";
				} else if (botao.equals("01")) {
					canal = 1;
					displayBotao += "1";
				} else if (botao.equals("02")) {
					canal = 2;
					displayBotao += "2";
				} else if (botao.equals("03")) {
					canal = 3;
					displayBotao += "3";
				} else if (botao.equals("04")) {
					canal = 4;
					displayBotao += "4";
				}
			} else {
				if (botao.equals("05")) {
					canal = 5;
					displayBotao += "5";
				} else if (botao.equals("06")) {
					canal = 6;
					displayBotao += "6";
				} else if (botao.equals("07")) {
					canal = 7;
					displayBotao += "7";
				} else if (botao.equals("08")) {
					canal = 8;
					displayBotao += "8";
				} else if (botao.equals("09")) {
					canal = 9;
					displayBotao += "9";
				}
			}
			displayAtualizado = displayBotao;
		} else {
			if (botao.contains("volume")) {
				String displayVolume = "";
				int volumeAnterior = tv.getVolume() -1;
				int proximoVolume = tv.getVolume() +1;
				if (botao.equals("abaixar volume")) {
					tv.abaixarVolume();
					displayVolume = String.valueOf(volumeAnterior);
				} else if (botao.equals("aumentar volume")) {
					tv.aumentarVolume();
					displayVolume = String.valueOf(proximoVolume);
				}
				displayAtualizado = displayVolume;
			} else if (botao.contains("canal")) {
				String displayCanal = "";
				int canalAnterior = tv.getCanal() -1;
				int proximoCanal = tv.getCanal() + 1;
				if (botao.equals("canal anterior")) {
					canal = canalAnterior;
					displayCanal = String.valueOf(canalAnterior);
				} else if (botao.equals("canal proximo")) {
					canal = proximoCanal;
					displayCanal = String.valueOf(proximoCanal);
				}
				displayAtualizado =  displayCanal;
			} else if (botao.equals("liga")) 
				tv.setLigada(true);
		}
		this.display = displayAtualizado;
		if (this.tv.getCanal() != canal) {
			this.tv.setCanal(canal);
		}
	}

}
