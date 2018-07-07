package br.com.yurylink.pedidos.enums;

public enum EstadoPagamentoEnum {
	PENDENTE(1, "pendente"),
	PAGO(2, "pago"),
	CANCELADO(1, "cancelado");
	
	private Integer cod;
	private String descricao;
	
	private EstadoPagamentoEnum(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamentoEnum fromCodigo(Integer codigo) {
		for (EstadoPagamentoEnum t : values()) {
			if(t.cod==codigo) {
				return t;
			}
		}
		throw new IllegalArgumentException("Nenhum tipo de pagamento para o codigo:" + codigo);
	}
}
