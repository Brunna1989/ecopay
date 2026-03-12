package com.ecopay.ecopay.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagamentoResponseDTO {

    private Long id;
    private BigDecimal valor;
    private String moeda;
    private String pagadorId;
    private String metodoPagamento;
    private String status;
    private LocalDateTime dataCriacao;
}
