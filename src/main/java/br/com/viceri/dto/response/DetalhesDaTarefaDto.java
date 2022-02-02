package br.com.viceri.dto.response;

import br.com.viceri.entity.Tarefa;
import br.com.viceri.enums.PrioridadeEnum;
import br.com.viceri.enums.StatusTarefaEnum;

import java.time.LocalDateTime;

public class DetalhesDaTarefaDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	private String nomeAutor;
	private StatusTarefaEnum status;
	private PrioridadeEnum prioridade;


	public DetalhesDaTarefaDto(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.titulo = tarefa.getTitulo();
		this.mensagem = tarefa.getMensagem();
		this.dataCriacao = tarefa.getDataCriacao();
		this.nomeAutor = tarefa.getAutor().getNome();
		this.status = tarefa.getStatus();
		this.prioridade = tarefa.getPrioridade();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public StatusTarefaEnum getStatus() {
		return status;
	}

	public PrioridadeEnum getPrioridade() {
		return prioridade;
	}

}
