package br.com.yurylink.pedidos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.yurylink.pedidos.domain.Categoria;
import br.com.yurylink.pedidos.domain.Produto;
import br.com.yurylink.pedidos.repositories.ProdutoRepository;
import br.com.yurylink.pedidos.repositories.services.CategoriaServices;

@SpringBootApplication
public class PedidosMcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaServices categoriaService;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
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
		
		Produto p1 = new Produto(null, "Notebook", 1200.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 25.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaService.saveAll(listaCategoria);
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}
	
}
