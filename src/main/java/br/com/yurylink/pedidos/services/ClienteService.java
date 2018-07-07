package br.com.yurylink.pedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yurylink.pedidos.domain.Cliente;
import br.com.yurylink.pedidos.repositories.ClienteRepository;
import br.com.yurylink.pedidos.repositories.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Integer id) throws ObjectNotFoundException {
		Optional<Cliente> cat = clienteRepository.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
													"Nenhuma cliente encontrado para o id: " + id ));
	}
	
	public void saveAll(List<Cliente> listaCategoria) {
		clienteRepository.saveAll(listaCategoria);
	}
	
}
