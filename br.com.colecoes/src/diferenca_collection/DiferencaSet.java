package diferenca_collection;

/**
 * Sets não respeitam a ordem de inserção, um set(conjunto) não necessariamente mantém a ordem
 * em que os elementos foram inseridos, é como se eles fossem uma sacola(cheia de objetos), tanto
 * que não existe o método get() através de um indíce já que não existe ordem.
 * A principal diferença do set é a garantia de que eu não tenho objetos repetidos dentro do
 * conjunto e isso me proporciona um grande ganho em quesito de PERFORMANCE ao buscar ou remover
 * objetos desse conjunto.
 *
 * -> LinkedHashSet()
 * É um set que respeita a ordem em que os elementos foram inseridos.
 *
 * -> TreeSet()
 * Uma Tree é uma estrutura de dados que também é muito performática em buscas, mas quando
 * usamos uma TreeSet ela apenas fuciona com objeto que implementam Comparable pois a estrutura
 * Tree usa ordem natural nos objetos na hora da inserção.
 *
 */
public class DiferencaSet {
}
