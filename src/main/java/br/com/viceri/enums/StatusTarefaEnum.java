package br.com.viceri.enums;

public enum StatusTarefaEnum {

	INICIADO("Iniciado"),
	EM_ANDAMENTO("Em Andamento"),
	PENDENTE("Pendente"),
	PAUSADO("Pausado"),
	EXCLUIDO("Excluído"),
	CANCELADO("Cancelado"),
	REJEITADO("Rejeitado"),
	CONCLUIDO("Concluído");

	private final String status;

	StatusTarefaEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}