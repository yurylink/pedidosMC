package br.com.yurylink.pedidos.repositories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yurylink.pedidos.domain.Categoria;
import br.com.yurylink.pedidos.repositories.CategoriaRepository;

@Service
public class CategoriaServices {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> cat = categoriaRepository.findById(id);
		return cat.orElse(null);
	}
	
	public void saveAll(List<Categoria> listaCategoria) {
		categoriaRepository.saveAll(listaCategoria);
	}
	
}
