package br.com.yurylink.pedidos;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.yurylink.pedidos.domain.Categoria;
import br.com.yurylink.pedidos.domain.Cidade;
import br.com.yurylink.pedidos.domain.Cliente;
import br.com.yurylink.pedidos.domain.Endereco;
import br.com.yurylink.pedidos.domain.Estado;
import br.com.yurylink.pedidos.domain.Pagamento;
import br.com.yurylink.pedidos.domain.PagamentoBoleto;
import br.com.yurylink.pedidos.domain.PagamentoCartao;
import br.com.yurylink.pedidos.domain.Pedido;
import br.com.yurylink.pedidos.domain.Produto;
import br.com.yurylink.pedidos.enums.EstadoPagamentoEnum;
import br.com.yurylink.pedidos.enums.TipoPessoa;
import br.com.yurylink.pedidos.repositories.CidadeRepository;
import br.com.yurylink.pedidos.repositories.ClienteRepository;
import br.com.yurylink.pedidos.repositories.EnderecoRepository;
import br.com.yurylink.pedidos.repositories.EstadoRepository;
import br.com.yurylink.pedidos.repositories.PagamentoRepository;
import br.com.yurylink.pedidos.repositories.PedidoRepository;
import br.com.yurylink.pedidos.repositories.ProdutoRepository;
import br.com.yurylink.pedidos.services.CategoriaServices;

@SpringBootApplication
public class PedidosMcApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaServices categoriaService;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
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
		
		Estado eDf = new Estado(null, "Distrito Federal");
		Estado eGoias = new Estado(null, "Goiás");
		
		Cidade cidCeilandia = new Cidade(null, "Ceilandia");
		Cidade cidAsaSul = new Cidade(null, "Asa Sul");
		Cidade cidGoiania = new Cidade(null, "Goiania");
		
		eDf.getCidades().addAll(Arrays.asList(cidCeilandia, cidAsaSul));
		eGoias.getCidades().addAll(Arrays.asList(cidGoiania));
		
		cidAsaSul.setEstado(eDf);
		cidCeilandia.setEstado(eDf);
		cidGoiania.setEstado(eGoias);
		
		estadoRepository.saveAll(Arrays.asList(eDf, eGoias));
		cidadeRepository.saveAll(Arrays.asList(cidAsaSul, cidCeilandia, cidGoiania));
		categoriaService.saveAll(listaCategoria);
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Cliente c1 = new Cliente(null, "Adilson", "02340080030", TipoPessoa.FISICA);
		c1.getListaTelefone().addAll(Arrays.asList("999998877","9988771123"));
		Cliente c2 = new Cliente(null, "Beto", "12345678910", TipoPessoa.FISICA);
		c2.getListaTelefone().addAll(Arrays.asList("999998877","9988771123"));
		Cliente c3 = new Cliente(null, "Clara Ltda", "1234567891045", TipoPessoa.JURIDICA);
		c3.getListaTelefone().addAll(Arrays.asList("999998877","9988771123"));
		
		Endereco e1 = new Endereco(null, "QNM", "", "Ceilandia", "72210241", c1, cidCeilandia);
		Endereco e2 = new Endereco(null, "SCS", "", "Brasilia", "74236514", c1, cidAsaSul);
		Endereco e3 = new Endereco(null, "CasadaPrima", "", "Goias", "74236514", c3, cidGoiania);
		
		c1.setEndereco(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3));
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null,new Date(), c1, e1);
		Pedido ped2 = new Pedido(null,new Date(), c1, e2);
		Pedido ped3 = new Pedido(null,new Date(), c2, e3);
		
		Pagamento pagamentoCartao = new PagamentoCartao(null, EstadoPagamentoEnum.PAGO, ped1, 5);
		ped1.setPagameto(pagamentoCartao);
		
		Pagamento pagamentoCartao2 = new PagamentoCartao(null, EstadoPagamentoEnum.PAGO, ped2, 5);
		ped2.setPagameto(pagamentoCartao2);
		
		Pagamento pagamentoBoleto = new PagamentoBoleto(null, EstadoPagamentoEnum.PENDENTE, ped3, sdf.parse("10/10/2018 22:00"), sdf.parse("12/10/2018 12:05"));
		ped3.setPagameto(pagamentoBoleto);
		
		c1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		c2.getPedidos().addAll(Arrays.asList(ped3));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2,ped3));
		pagamentoRepository.saveAll(Arrays.asList(pagamentoBoleto, pagamentoCartao, pagamentoCartao2));
	}
	
}
