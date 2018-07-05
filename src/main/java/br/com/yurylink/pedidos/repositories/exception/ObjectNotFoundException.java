package br.com.yurylink.pedidos.repositories.exception;

public class ObjectNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}
	
	public ObjectNotFoundException(String mensagem, Throwable excecao) {
		super(mensagem,excecao);
	}
	
}
