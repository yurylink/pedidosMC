package br.com.yurylink.pedidos.enums;

public enum TipoPessoa {
	FISICA(1, "Pessoa Física"),
	JURIDICA(2, "Pessoa Jurídica");
	
	private Integer cod;
	private String descricao;
	
	private TipoPessoa(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoPessoa fromCodigo(Integer codigo) {
		for (TipoPessoa t : values()) {
			if(t.cod==codigo) {
				return t;
			}
		}
		throw new IllegalArgumentException("Nenhum tipo de pessoa econtrado para o codigod: " + codigo);
	}
}
