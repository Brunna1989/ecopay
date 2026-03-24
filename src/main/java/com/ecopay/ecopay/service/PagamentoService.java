package com.ecopay.ecopay.service;

import com.ecopay.ecopay.dto.PagamentoRequestDTO;
import com.ecopay.ecopay.dto.PagamentoResponseDTO;
import com.ecopay.ecopay.entity.Pagamento;
import com.ecopay.ecopay.enums.StatusPagamento;
import com.ecopay.ecopay.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
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
                .status(StatusPagamento.CRIADO)
                .dataCriacao(LocalDateTime.now())
                .build();

        pagamento = pagamentoRepository.save(pagamento);

        pagamento = processarPagamento(pagamento);

        return converterParaDTO(pagamento);
    }

    private Pagamento processarPagamento(Pagamento pagamento){

        pagamento.setStatus(StatusPagamento.PROCESSANDO);

        switch (pagamento.getMetodoPagamento()) {

            case PIX -> pagamento.setStatus(StatusPagamento.APROVADO);

            case BOLETO -> pagamento.setStatus(StatusPagamento.PROCESSANDO);

            case CARTAO -> {
                boolean aprovado = new Random().nextBoolean();
                pagamento.setStatus(aprovado ? StatusPagamento.APROVADO : StatusPagamento.RECUSADO);
            }

            default -> throw new IllegalArgumentException("Método de pagamento inválido");
        }

        return pagamentoRepository.save(pagamento);
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

    public PagamentoResponseDTO atualizarStatus(Long id, String status){

        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        try {
            pagamento.setStatus(StatusPagamento.valueOf(status.toUpperCase()));
        } catch (Exception e){
            throw new IllegalArgumentException("Status inválido");
        }

        pagamento = pagamentoRepository.save(pagamento);

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