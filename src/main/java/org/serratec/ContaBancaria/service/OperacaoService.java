package org.serratec.ContaBancaria.service;

import org.serratec.ContaBancaria.dominio.Conta;
import org.serratec.ContaBancaria.dominio.Tipo;
import org.serratec.ContaBancaria.exceptions.ValorInsuficienteException;
import org.springframework.stereotype.Service;

@Service
public class OperacaoService {
	
	public Conta getOperation(Conta conta, Integer valor, Tipo operacao) throws ValorInsuficienteException {
		if (operacao.equals(Tipo.CREDITO))
			return credito(conta, valor);
		
		return debito(conta, valor);
	}

	public Conta credito (Conta conta, Integer valor) throws ValorInsuficienteException {
		//TODO configurar limite mínimo da operação no application.properties
		if (valor < 50) {
			//TODO Deveria haver 2 exceptinos: ValorInsuficiente (debito) e ValorMinimoCredito (credito)
			throw new ValorInsuficienteException(conta.getNumero(), "Valor de depósito muito baixo");
		}
		
		conta.setSaldo(conta.getSaldo() + valor);
		
		return conta;
	}
	
	public Conta debito (Conta conta, Integer valor) throws ValorInsuficienteException {
		if (valor > conta.getSaldo()) {
			throw new ValorInsuficienteException(conta.getNumero(), "Saldo insuficiente");
		}
		conta.setSaldo(conta.getSaldo() - valor);
		
		return conta;
	}
}
