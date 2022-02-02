package br.com.viceri.repository;

import br.com.viceri.entity.Tarefa;
import br.com.viceri.enums.PrioridadeEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    Page<Tarefa> findByAutorEmail(String email, Pageable paginacao);
    Page<Tarefa> findByAutorEmailAndPrioridade(String email, PrioridadeEnum prioridade, Pageable paginacao);
}
