package com.ecopay.ecopay.service;

import com.ecopay.ecopay.dto.PagamentoRequestDTO;
import com.ecopay.ecopay.dto.PagamentoResponseDTO;
import com.ecopay.ecopay.entity.Pagamento;
import com.ecopay.ecopay.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoResponseDTO criarPagamento(PagamentoRequestDTO dto){

        if(dto.getValor() == null || dto.getValor().doubleValue() <= 0){
            throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero.");
        }

        Pagamento pagamento = Pagamento.builder()
                .valor(dto.getValor())
                .moeda(dto.getMoeda())
                .pagadorId(dto.getPagadorId())
                .metodoPagamento(dto.getMetodoPagamento())
                .status("CRIADO")
                .dataCriacao(LocalDateTime.now())
                .build();

        pagamento = pagamentoRepository.save(pagamento);

        return converterParaDTO(pagamento);
    }

    public List<PagamentoResponseDTO> listarPagamentos(){

        return pagamentoRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public PagamentoResponseDTO buscarPagamento(Long id){

        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        return converterParaDTO(pagamento);
    }

    private PagamentoResponseDTO converterParaDTO(Pagamento pagamento){

        return PagamentoResponseDTO.builder()
                .id(pagamento.getId())
                .valor(pagamento.getValor())
                .moeda(pagamento.getMoeda())
                .pagadorId(pagamento.getPagadorId())
                .metodoPagamento(pagamento.getMetodoPagamento())
                .status(pagamento.getStatus())
                .dataCriacao(pagamento.getDataCriacao())
                .build();
    }
}
