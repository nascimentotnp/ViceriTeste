package br.com.viceri.dto.request;

import br.com.viceri.enums.PrioridadeEnum;
import br.com.viceri.enums.StatusTarefaEnum;

public class TarefaForm {

	private String titulo;
	private String mensagem;
	private StatusTarefaEnum status;
	private PrioridadeEnum prioridade;

	public StatusTarefaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusTarefaEnum status) {
		this.status = status;
	}

	public PrioridadeEnum getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeEnum prioridade) {
		this.prioridade = prioridade;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
