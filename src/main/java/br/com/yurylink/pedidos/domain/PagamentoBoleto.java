package br.com.yurylink.pedidos.domain;

import java.util.Date;

import javax.persistence.Entity;

import br.com.yurylink.pedidos.enums.EstadoPagamentoEnum;

@Entity
public class PagamentoBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Date dataVencimento;
	private Date dataPagamento;
	
	public PagamentoBoleto() {
		super();
	}
	public PagamentoBoleto(Integer id, EstadoPagamentoEnum estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	

}
