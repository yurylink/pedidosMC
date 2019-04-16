package br.com.yurylink.pedidos.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.yurylink.pedidos.domain.Categoria;
import br.com.yurylink.pedidos.repositories.exception.ObjectNotFoundException;
import br.com.yurylink.pedidos.services.CategoriaServices;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {
	
	@Autowired
	private CategoriaServices categoriaService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> buscarById(@PathVariable Integer id) throws ObjectNotFoundException {
		Categoria cat = categoriaService.buscar(id);
		
		return ResponseEntity.ok().body(cat);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = categoriaService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}/").buildAndExpand(obj.getId()).toUri(); 

		return ResponseEntity.created(uri).build();
	}
	
}
