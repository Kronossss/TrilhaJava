package com.leilao.leilao.controller.DTO;

import com.leilao.leilao.model.Concorrente;

public class ConcorrenteDTO {
	
	private String nome;
	

	public ConcorrenteDTO(Concorrente concorrente) {
		super();
		this.nome = concorrente.getNome();
	}
	
	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "[nome=" + nome + "]";
	}



	
	

}
