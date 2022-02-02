package br.com.viceri.dto.response;

import br.com.viceri.entity.Tarefa;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public class TarefaDto {

	private Long id;
	private String titulo;
	private String mensagem;
	private String prioridade;
	private String status;
	private LocalDateTime dataCriacao;
	
	public TarefaDto(Tarefa tarefa) {
		this.id = tarefa.getId();
		this.titulo = tarefa.getTitulo();
		this.mensagem = tarefa.getMensagem();
		this.prioridade = tarefa.getPrioridade().getPrioridade();
		this.status = tarefa.getStatus().getStatus();
		this.dataCriacao = tarefa.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public static Page<TarefaDto> converter(Page<Tarefa> tarefas) {
		return tarefas.map(TarefaDto::new);
	}

}
