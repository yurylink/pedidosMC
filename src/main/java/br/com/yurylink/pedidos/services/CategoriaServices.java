package br.com.yurylink.pedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.yurylink.pedidos.domain.Categoria;
import br.com.yurylink.pedidos.repositories.CategoriaRepository;
import br.com.yurylink.pedidos.repositories.exception.ObjectNotFoundException;

@Service
public class CategoriaServices {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> cat = categoriaRepository.findById(id);
		return cat.orElseThrow(() -> new ObjectNotFoundException(
													"Nenhuma categoria encontrada para o id: " + id ));
	}
	
	public void saveAll(List<Categoria> listaCategoria) {
		categoriaRepository.saveAll(listaCategoria);
	}

	public Categoria save(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
}
