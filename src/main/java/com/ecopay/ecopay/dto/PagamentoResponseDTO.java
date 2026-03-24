package com.ecopay.ecopay.dto;

import com.ecopay.ecopay.enums.MetodoPagamento;
import com.ecopay.ecopay.enums.StatusPagamento;
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
    private MetodoPagamento metodoPagamento;
    private StatusPagamento status;
    private LocalDateTime dataCriacao;
}
