package br.com.viceri.entity;

import br.com.viceri.enums.PrioridadeEnum;
import br.com.viceri.enums.StatusTarefaEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Tarefa {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String titulo;

	private String mensagem;

	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusTarefaEnum status = StatusTarefaEnum.PENDENTE;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private PrioridadeEnum prioridade = PrioridadeEnum.BAIXO;

	@ManyToOne
	private Usuario autor;

	public Tarefa() {
	}
	
	public Tarefa(String titulo, String mensagem, Usuario autor) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public StatusTarefaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusTarefaEnum status) {
		this.status = status;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public PrioridadeEnum getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(PrioridadeEnum prioridade) {
		this.prioridade = prioridade;
	}

}
