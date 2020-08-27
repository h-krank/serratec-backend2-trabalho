package org.serratec.ContaBancaria.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.ContaBancaria.dominio.Conta;
import org.serratec.ContaBancaria.exceptions.ContaNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ContaBancariaService {
	List<Conta> contas = new ArrayList<Conta>();
	
	{
		contas.add(new Conta("João", 3000.00));
		contas.add(new Conta("Maria", 100.00));
		contas.add(new Conta("José", 2000.00));
	}
	
	public List<Conta> getAll(){
		return contas;
	}
	
	public Conta findConta(Integer id) throws ContaNotFoundException {
		for (Conta conta : contas) {
			if (conta.getNumero().equals(id)) {
				return conta;
			}
		}
		
		throw new ContaNotFoundException(id);
	}
	
	public Conta addConta(Conta conta) {
		contas.add(conta);
		return conta;
	}
	
	//FIXME Não permitir alterar o número da conta para um número já existente na lista
	public Conta updateConta(Conta conta, Integer id) throws ContaNotFoundException {
		Conta c = findConta(id);
		
		c.setNumero(conta.getNumero());
		c.setTitular(conta.getTitular());
		
		return c;
	}
	
	public void deleteConta(Integer id) throws ContaNotFoundException {
		Conta c = findConta(id);
		contas.remove(c);
	}
}
