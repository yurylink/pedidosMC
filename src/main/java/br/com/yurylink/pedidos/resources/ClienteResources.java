package br.com.yurylink.pedidos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.yurylink.pedidos.domain.Cliente;
import br.com.yurylink.pedidos.repositories.exception.ObjectNotFoundException;
import br.com.yurylink.pedidos.services.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResources {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscarById(@PathVariable Integer id) throws ObjectNotFoundException {
		Cliente cli = clienteService.buscar(id);
		return ResponseEntity.ok().body(cli);
	}
	
}
