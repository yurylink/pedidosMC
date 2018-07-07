package br.com.yurylink.pedidos.domain;

import javax.persistence.Entity;

import br.com.yurylink.pedidos.enums.EstadoPagamentoEnum;

@Entity
public class PagamentoCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcelas;

	public PagamentoCartao() {
		super();
	}

	public PagamentoCartao(Integer id, EstadoPagamentoEnum estado, Pedido pedido, Integer numeroParcela) {
		super(id, estado, pedido);
		
		this.numeroParcelas = numeroParcela;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
}
