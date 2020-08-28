package org.serratec.ContaBancaria.controller;

import java.util.List;

import org.serratec.ContaBancaria.dominio.Conta;
import org.serratec.ContaBancaria.dominio.Tipo;
import org.serratec.ContaBancaria.exceptions.ContaNotFoundException;
import org.serratec.ContaBancaria.exceptions.ValorInsuficienteException;
import org.serratec.ContaBancaria.service.ContaBancariaService;
import org.serratec.ContaBancaria.service.OperacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conta")
public class ContaBancariaController {
	
	@Autowired
	ContaBancariaService contaBancariaService;
	
	@Autowired
	OperacaoService operacaoService;
	
	@GetMapping
	public List<Conta> getAll(){
		return contaBancariaService.getAll();
	}
	
	@GetMapping("/{numero}")
	public Conta getConta(@PathVariable Integer numero) throws ContaNotFoundException {
		return contaBancariaService.findConta(numero);
	}
	
	@PostMapping
	public ResponseEntity<Conta> postConta(@RequestBody Conta conta) {
		return ResponseEntity.created(null).body(contaBancariaService.addConta(conta));
	}
	
	@PostMapping("/{numero}/{operacao}")
	public Conta postOperacao(@PathVariable Integer numero, @PathVariable String operacao, @RequestParam Integer valor) throws ContaNotFoundException, ValorInsuficienteException, IllegalArgumentException{
		Conta conta = contaBancariaService.findConta(numero);
		return operacaoService.getOperation(conta, valor, Tipo.valueOf(operacao.toUpperCase()));

	}
	
	@PutMapping("/{numero}")
	public Conta putConta(@PathVariable Integer numero, @RequestBody Conta conta) throws ContaNotFoundException {
		return contaBancariaService.updateConta(conta, numero);
	}
	
	@DeleteMapping("{id}")
	public void deleteConta(@PathVariable Integer id) throws ContaNotFoundException {
		contaBancariaService.deleteConta(id);
	}
}
