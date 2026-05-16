package com.lisboa.agendamento_notificacao_api.controller.dto.out;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lisboa.agendamento_notificacao_api.infrastructure.enums.StatusNotificacaoEnum;

public record AgendamentoRecordOut(Long id,
                                   String emailDestinatario,
                                   String telefoneDestinatario,
                                   String mensagem,
                                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                   LocalDateTime dataHoraEnvio,
                                   StatusNotificacaoEnum statusNotificacaoEnum) {
    
}