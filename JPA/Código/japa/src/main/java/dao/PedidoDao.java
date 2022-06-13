package dao;

import modelo.Pedido;
import modelo.Produto;
import vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {

    private EntityManager entityManager;

    public PedidoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Pedido pedido){
        entityManager.persist(pedido);
    }

    public Pedido buscarPorId(Long id){
        return entityManager.find(Pedido.class, id);
    }

    public List<Pedido> buscarTodos(){
        String jpql = "from Pedido";
        return entityManager.createQuery(jpql, Pedido.class).getResultList();
    }

    public BigDecimal valorTotalDePedidos(){
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return entityManager.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<RelatorioDeVendasVo> relatorioDeVendas() {

        Class<RelatorioDeVendasVo> vo = RelatorioDeVendasVo.class;

        StringBuilder jpql = new StringBuilder(300);
        jpql.append("SELECT new ")
                .append(vo.getName() + "(")
                .append("produto.nome,")
                .append("SUM(item.quantidade), ")
                .append("MAX(pedido.dataPedido)) ")
                .append("FROM Pedido pedido ")
                .append("JOIN pedido.itens item ")
                .append("JOIN item.produto produto ")
                .append("GROUP BY produto.nome, item.quantidade ")
                .append("ORDER BY item.quantidade DESC");

        return entityManager.createQuery(jpql.toString(), RelatorioDeVendasVo.class).getResultList();

    }


    public Pedido buscarClienteDoPedido(long id) {
        String jpql = "SELECT p FROM Pedido p JOIN FETCH p.cliente WHERE p.id = :id";

        return entityManager.createQuery(jpql, Pedido.class).setParameter("id", id).getSingleResult();
    }
}
