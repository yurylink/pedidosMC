package br.com.yurylink.pedidos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.yurylink.pedidos.enums.TipoPessoa;

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String documento;
	private Integer tipoCliente;
	
	@OneToMany(mappedBy="cliente")
	@JsonManagedReference
	private List<Endereco> enderecos = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="Telefone")
	private Set<String> listaTelefone = new HashSet<String>();

	public Cliente(Integer id, String nome, String documento, TipoPessoa tipoCliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.documento = documento;
		this.tipoCliente = tipoCliente.getCod();
	}

	public Cliente() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public TipoPessoa getTipoCliente() {
		return TipoPessoa.fromCodigo(tipoCliente);
	}

	public void setTipoCliente(TipoPessoa tipoCliente) {
		this.tipoCliente = tipoCliente.getCod();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEndereco(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getListaTelefone() {
		return listaTelefone;
	}

	public void setListaTelefone(Set<String> listaTelefone) {
		this.listaTelefone = listaTelefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
