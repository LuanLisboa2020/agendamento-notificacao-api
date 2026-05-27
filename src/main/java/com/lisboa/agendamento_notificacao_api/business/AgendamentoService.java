package com.lisboa.agendamento_notificacao_api.business;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.lisboa.agendamento_notificacao_api.business.mapper.IAgendamentoMapper;
import com.lisboa.agendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.lisboa.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.lisboa.agendamento_notificacao_api.infrastructure.entities.Agendamento;
import com.lisboa.agendamento_notificacao_api.infrastructure.enums.StatusNotificacaoEnum;
import com.lisboa.agendamento_notificacao_api.infrastructure.exeption.NotFoundExeption;
import com.lisboa.agendamento_notificacao_api.infrastructure.repositories.AgendamentoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AgendamentoService {
    
    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento){

        Agendamento entity = agendamentoMapper.paraEntity(agendamento);

        entity.setDataHoraEnvio(LocalDateTime.now());

        return agendamentoMapper.paraOut(
            repository.save(entity));
    }

    public AgendamentoRecordOut buscarAgendamentosPorId (Long id) {
        return agendamentoMapper.paraOut(repository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("Id não encontrado")));
    }

    @Transactional
    public void cancelarAgendamento(Long id){
        Agendamento agendamento = repository.findById(id)
                .orElseThrow(() -> new NotFoundExeption("Id não encontrado"));

        agendamento.setDataHoraModificacao(LocalDateTime.now());
        agendamento.setStatusNotificacaoEnum(StatusNotificacaoEnum.CANCELADO);

        repository.save(agendamento);
    }
}