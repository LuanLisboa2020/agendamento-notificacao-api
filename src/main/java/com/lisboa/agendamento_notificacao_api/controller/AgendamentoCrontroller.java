package com.lisboa.agendamento_notificacao_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lisboa.agendamento_notificacao_api.business.AgendamentoService;
import com.lisboa.agendamento_notificacao_api.controller.dto.in.AgendamentoRecord;
import com.lisboa.agendamento_notificacao_api.controller.dto.out.AgendamentoRecordOut;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoCrontroller {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoRecordOut> gravarAgendamentos(@RequestBody AgendamentoRecord agendamento){
        return ResponseEntity.ok(agendamentoService.gravarAgendamento(agendamento));
    }
    
}