package com.lisboa.agendamento_notificacao_api.business;

import org.springframework.stereotype.Service;

import com.lisboa.agendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.lisboa.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;
import com.lisboa.agendamento_notificacao_api.infrastructure.repositories.AgendamentoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AgendamentoService {
    
    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecord agendamento){
        return agendamentoMapper.paraOut(
            repository.save(
                agendamentoMapper.paraEntity(agendamento)));
    }
}