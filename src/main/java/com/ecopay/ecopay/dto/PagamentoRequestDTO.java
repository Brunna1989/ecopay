package com.ecopay.ecopay.dto;

import com.ecopay.ecopay.enums.MetodoPagamento;
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
    private MetodoPagamento metodoPagamento;

}