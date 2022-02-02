package br.com.viceri.enums;

public enum PrioridadeEnum {

	ALTO("Alto"),
	MEDIO("Médio"),
	BAIXO("Baixo");

	private final String prioridade;

	PrioridadeEnum(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getPrioridade() {
		return prioridade;
	}
}