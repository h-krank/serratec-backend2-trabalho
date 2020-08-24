package org.serratec.ContaBancaria.controller;

import org.serratec.ContaBancaria.exceptions.ContaNotFoundException;
import org.serratec.ContaBancaria.exceptions.ValorInsuficienteException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ContaNotFoundException.class)
	public ResponseEntity<String> handleContaException(ContaNotFoundException e) {
		String msg = String.format("A conda com ID %d não foi encontrada", e.getId());
		return ResponseEntity.notFound()
				.header("ERROR-MSG", msg)
				.header("ERROR-CODE", "CONTA NOT FOUND")
				.header("ERROR-VALUE", e.getId().toString())
				.build();
	}
	@ExceptionHandler(ValorInsuficienteException.class)
	public ResponseEntity<String> handleSaldoException(ValorInsuficienteException e){
		return ResponseEntity.badRequest()
				.header("ERROR-MSG", e.getMsg())
				.header("ERROR-CODE", "VALOR INSUFICIENTE")
				.header("ERROR-VALUE", e.getId().toString())
				.body(e.getMsg());
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleOperacaoException(IllegalArgumentException e){
		return ResponseEntity.badRequest()
				.header("ERROR-MSG", "Operacao invalida")
				.header("ERROR-CODE", "SALDO INSUFICIENTE")
				.body("A operação requisitada não corresponde a DEBITO ou CREDITO");
	}
}
