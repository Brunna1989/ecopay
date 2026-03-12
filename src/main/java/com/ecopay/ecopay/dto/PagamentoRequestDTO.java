package com.ecopay.ecopay.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagamentoRequestDTO {

    private BigDecimal valor;
    private String moeda;
    private String pagadorId;
    private String metodoPagamento;

}