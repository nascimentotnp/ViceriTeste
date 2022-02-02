package br.com.viceri.service;

import br.com.viceri.dto.response.TarefaDto;
import br.com.viceri.dto.request.TarefaForm;
import br.com.viceri.enums.PrioridadeEnum;
import br.com.viceri.entity.Tarefa;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TarefaService {
    Page<TarefaDto> listar(PrioridadeEnum prioridade, String bearerToken, Pageable paginacao);

    TarefaDto cadastrar(TarefaForm form, String bearerToken);

    Optional<Tarefa> findById(Long id);

    TarefaDto update(Long id, TarefaForm form) throws NotFoundException;

    void deleteById(Long id);
}
