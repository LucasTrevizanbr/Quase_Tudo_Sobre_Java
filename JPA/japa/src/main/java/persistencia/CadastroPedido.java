package persistencia;

import dao.CategoriaDao;
import dao.ClienteDao;
import dao.PedidoDao;
import dao.ProdutoDao;
import modelo.*;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroPedido {
    public static void main(String[] args) {
        criarBancoDeDados();

        EntityManager entityManager = JPAUtil.criarEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        PedidoDao pedidoDao = new PedidoDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        Cliente jarlos = clienteDao.buscarPorId(1l);
        Cliente lauro = clienteDao.buscarPorId(2l);
        Cliente myala = clienteDao.buscarPorId(3l);

        Produto celular = produtoDao.buscarPorId(1l);
        Produto geladeira = produtoDao.buscarPorId(2l);
        Produto mouse = produtoDao.buscarPorId(3l);

        Pedido pedidoJarlos = new Pedido(jarlos);
        Pedido pedidoLauro = new Pedido(lauro);
        Pedido pedidoMyala = new Pedido(myala);

        pedidoJarlos.adicionarItem(new ItemPedido(10, pedidoJarlos,celular));

        pedidoLauro.adicionarItem(new ItemPedido(3, pedidoLauro,geladeira));

        pedidoMyala.adicionarItem(new ItemPedido(7, pedidoMyala,mouse));
        pedidoMyala.adicionarItem(new ItemPedido(1, pedidoMyala,celular));

        entityManager.getTransaction().begin();

        pedidoDao.cadastrar(pedidoJarlos);
        pedidoDao.cadastrar(pedidoLauro);
        pedidoDao.cadastrar(pedidoMyala);

        pedidoDao.relatorioDeVendas().forEach(System.out::println);

        entityManager.getTransaction().commit();
    }

    private static void criarBancoDeDados() {
        Categoria celulares = new Categoria("Celulares");
        Categoria eletrodoMestico = new Categoria("Eletrodomésticos");
        Categoria perifericos = new Categoria("Periféricos");

        Produto celular = new Produto("Nokia", "Velho",new BigDecimal(10000), celulares);
        Produto geladeira = new Produto("Geladeira gamer","razer", new BigDecimal(20000), eletrodoMestico);
        Produto mouse = new Produto("Razor trix", "mouse gamer",new BigDecimal(3000), perifericos);

        Cliente cliente = new Cliente(new ClienteId("Jarlos", "898989"));
        Cliente cliente2 = new Cliente(new ClienteId("Lauro", "777777"));
        Cliente cliente3 = new Cliente(new ClienteId("Myala", "90000000"));


        EntityManager entityManager = JPAUtil.criarEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(entityManager);
        CategoriaDao categoriaDao = new CategoriaDao(entityManager);
        ClienteDao clienteDao = new ClienteDao(entityManager);

        entityManager.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(eletrodoMestico);
        categoriaDao.cadastrar(perifericos);

        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(geladeira);
        produtoDao.cadastrar(mouse);

        clienteDao.cadastrar(cliente);
        clienteDao.cadastrar(cliente2);
        clienteDao.cadastrar(cliente3);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
