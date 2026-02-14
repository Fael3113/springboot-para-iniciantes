package dev.rafael.springboot_para_iniciantes.Exceptions;


public class RecursoNaoEncontradoException extends RuntimeException{
	public RecursoNaoEncontradoException (String mensagem){
		super(mensagem);
	}
}
