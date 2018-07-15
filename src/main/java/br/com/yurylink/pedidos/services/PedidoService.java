package br.com.yurylink.pedidos.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yurylink.pedidos.domain.Pedido;
import br.com.yurylink.pedidos.repositories.PedidoRepository;
import br.com.yurylink.pedidos.repositories.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public Pedido buscar(Integer id) throws ObjectNotFoundException {
		Optional<Pedido> pedido =  pedidoRepository.findById(id);
		
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Nenhum pedido encontrado para o id " + id ));
	}
}
