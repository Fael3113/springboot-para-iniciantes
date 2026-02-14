package dev.rafael.springboot_para_iniciantes.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class MensagemRepository {
	public String obterMensagem(){
		return "A criatividade do repositório";
	}
}
