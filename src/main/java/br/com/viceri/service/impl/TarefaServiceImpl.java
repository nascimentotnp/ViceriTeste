package br.com.viceri.service.impl;

import br.com.viceri.config.security.TokenService;
import br.com.viceri.dto.request.TarefaForm;
import br.com.viceri.dto.response.TarefaDto;
import br.com.viceri.entity.Tarefa;
import br.com.viceri.entity.Usuario;
import br.com.viceri.enums.PrioridadeEnum;
import br.com.viceri.repository.TarefaRepository;
import br.com.viceri.repository.UsuarioRepository;
import br.com.viceri.service.TarefaService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Override
    public Page<TarefaDto> listar(PrioridadeEnum prioridade, String bearerToken, Pageable paginacao){
        Usuario usuario = getUser(bearerToken);
        if (prioridade == null)
            return TarefaDto.converter(tarefaRepository.findByAutorEmail(usuario.getEmail(), paginacao));
        return TarefaDto.converter(tarefaRepository.findByAutorEmailAndPrioridade(usuario.getEmail(), prioridade, paginacao));
    }

    private Usuario getUser(String bearerToken){
        String email = tokenService.getUsernameFromToken(bearerToken.substring(7));
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário inexistente"));
    }
    @Override
    public TarefaDto cadastrar(TarefaForm form, String bearerToken){
        Usuario usuario = getUser(bearerToken);
        Tarefa tarefa = new Tarefa(form.getTitulo(), form.getMensagem(), usuario);
        return new TarefaDto(tarefaRepository.save(tarefa));
    }

    @Override
    public Optional<Tarefa> findById(Long id) {
        return tarefaRepository.findById(id);
    }

    @Override
    public TarefaDto update(Long id, TarefaForm form) throws NotFoundException {
        Optional<Tarefa> optTarefa = tarefaRepository.findById(id);

        Tarefa tarefa = optTarefa.orElseThrow(() -> new NotFoundException("Não encontrado tarefa id: "+ id ));

        if(form.getMensagem() != null) tarefa.setMensagem(form.getMensagem());
        if(form.getTitulo() != null) tarefa.setTitulo(form.getTitulo());
        if(form.getPrioridade() != null) tarefa.setPrioridade(form.getPrioridade());
        if(form.getStatus() != null) tarefa.setStatus(form.getStatus());

        return new TarefaDto(tarefaRepository.save(tarefa));
    }

    @Override
    public void deleteById(Long id) {
        tarefaRepository.deleteById(id);
    }


}
