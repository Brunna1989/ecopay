package com.ecopay.ecopay.controller;

import com.ecopay.ecopay.dto.PagamentoRequestDTO;
import com.ecopay.ecopay.dto.PagamentoResponseDTO;
import com.ecopay.ecopay.service.PagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @PostMapping
    public PagamentoResponseDTO criarPagamento(@RequestBody PagamentoRequestDTO dto){
        return pagamentoService.criarPagamento(dto);
    }

    @GetMapping
    public List<PagamentoResponseDTO> listarPagamentos(){
        return pagamentoService.listarPagamentos();
    }

    @GetMapping("/{id}")
    public PagamentoResponseDTO buscarPagamento(@PathVariable Long id){
        return pagamentoService.buscarPagamento(id);
    }

    @PatchMapping("/{id}/status")
    public PagamentoResponseDTO atualizarStatus(
            @PathVariable Long id,
            @RequestParam String status){

        return pagamentoService.atualizarStatus(id, status);
    }
}