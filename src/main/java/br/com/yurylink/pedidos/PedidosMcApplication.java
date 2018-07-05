package br.com.yurylink.pedidos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.yurylink.pedidos.domain.Categoria;
import br.com.yurylink.pedidos.repositories.services.CategoriaServices;

@SpringBootApplication
public class PedidosMcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaServices categoriaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PedidosMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(1, "Informatica");
		Categoria cat2 = new Categoria(2, "Escritorio");
		
		List<Categoria> listaCategoria = new ArrayList<Categoria>();
		listaCategoria.add(cat1);
		listaCategoria.add(cat2);
		
		categoriaService.saveAll(listaCategoria);
	}
}
