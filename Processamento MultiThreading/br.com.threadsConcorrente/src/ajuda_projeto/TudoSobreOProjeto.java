package ajuda_projeto;

public class TudoSobreOProjeto {
    /**
     * Vamos fazer um projeto de servidor para práticar multiThreading em um case mais real e mais
     * desafiador.
     * Nosso servidor terá a comunicação TCP(apenas garante trafego de dados, mas não diz
     * o que eles de fato significam) e faremos nosso próprio "vocabulário" em cima dessa TCP.
     * Para usar o TCP vamos utilizar classes do Java que vão fazer a abstração da complexidade, essas
     * classes serão Sockets(um ponto final em cada ponta de execução), teremos um Socket no servidor
     * e um Socket para o Client(e por baixo dos panos eles se comunicaram por TCP).
     * Em um ponto do código melhoramos o design retirando os códigos do servidor que ficavam tudo no main
     * e separando em uma classe especifica para iniciar o servidor e etc.
     * Quando usamos o atributo booleano no objeto de servidor estamos falando pra alguma Thread alterar
     * seu valor, isso gera um problema de concorrência, pq uma Thread deixa em cache o atributo e a
     * Thread principal não sabe que aquele atributo foi alterado, o ponto principal é PODE DAR MUITO
     * ERRADO DEIXAR QUE UMA THREAD ALTERE O ESTADO DE UM OBJETO COMPARTILHADO ENTRE MULTIPLAS THREADS,
     * no nosso exemplo é que um cliente pode tentar encerrar o servidor alterando o atributo booleano,
     * mas a Thread muda o que esta em cache e não o que ta na memória principal.
     * Cada comando do cliente que recebermos sera tratado por uma classe(isso é um padrão de projeto e
     * se chama "command")
     * Quando lidamos com exceção em multiplas Threads temos que pensar que estamos lidando com pilhas
     * de execuções diferentes, então eu tenho uma exceção por pilha de execução. Então pensando no cenário
     * que queremos tratar uma exceção que pode ocorrer na Thread, podemos utilizar um método de
     * uncaughtExceptionHandler(Esse cara funciona na Thread, mas não na pool, para usarmos na pool
     * precisamos passar para o Executor um segundo parâmetro que é uma Factory).
     * Agora vamos imaginar que precisamos executar uma tarefa na thread que precisa devolver uma resposta,
     * como um serviço web ou uma consulta no banco de dados. Vamos usar o Comando2 como exemplo disso,
     * onde agora usamos a Interface Callable<T>. Que além de ter um retorno no método, ainda permite
     * que lancemos alguma Excecao. A ideia é que o comando C2 faça duas tarefas(uma chamada a um
     * webService e uma chamada ao Banco de dados) Então quando eu submeto um callable ele me retorna um
     * Future, eu posso pegar o valor desse Future com um get, porém esse método é bloqueante então
     * vamos joga-lo para outra Thread. Agora a ideia é que eu tenha um tempo limite para fazer minha ação
     * e o comando C2 precisa que as duas Tarefas(Banco de dados e WebService) terminem, então eu posso
     * passar um tempo limite no get do meu Future e posso usar um cancel que permite que eu pare
     * a Thread.
     * Pra finalizar legal o tema, agora vamos implementar um padrão de consumo no nosso servidor ao
     * maior estilo consumidor e Produtor(Em outras palavras MENSAGERIA).Existem implementações de
     * fila no java, mas precisamos de uma implementação de fila que seja Thread Safe, uma
     * BlockingQueue(essa classe tem métodos bloqueantes ao inserir na fila, retirar e etc...) é
     * uma classe ThreadSafe. A ideia é que o comando C3 seja processado em uma fila, onde nosso cliente
     * não quer saber a resposta dessa execução.
     *
     * ============================================================================================
     * -> Para que uma ÚNICA conexão de cliente não trave a Thread main, vamos separar cada conexão em
     * uma nova Thread, isso evita o problema.
     * -> Para reaproveitar as Threads, podemos usar uma Pool(nada mais é que uma "piscina" com uma
     * quantidade determinada de Thread que podem ser sempre reutilizadas uma vez que acabam seu
     * processamento) com a ajuda da classe Executors. Eu posso ter uma pool fixa, cacheada, agendada
     * etc..
     *->Para encerrar um pool de threads podemos usar o método shutdown, mas esse método espera a execução
     * de threads que estão ativas para fechar de fato, então se tu tiver uma thread processando pra sempre
     * ele nunca vai "desligar".
     * ->Se precisarmos que alguma Thread altere algum atributo(estado do objeto) internamente, podemos
     * usar a palavra "volatile" que diz que esse atributo vai ser o da memória principal e não da memória
     * de cache criada pela Thread.(Classes Atomic tem esse comportamento "volatile")
     * ->Se precisarmos que as Threads no pool tenham algum comportamento especifico, podemos definir
     * a maneira que o pool as inicia através de um segundo parâmetro que é uma Factory de Threads, nessa
     * factory podemos definir como a Thread será iniciada.
     * ->Alinhando com o conhecimento da factory, uma situação onde podemos definir seu comportamento é
     * quando formos instância a Thread setarmos o atributo UncaugthExceptionHandler com uma classe
     * para tratamento de erro(esse atributo do objeto Thread vai pegar uma excecao que foi lançada
     * sem tratamento pela Thread, assim podemos trata-la através de uma classe para esse propósito)
     * ->Se quisermos obter o resultado de uma Thread para uma operação posterior, podemos usar a interface
     * Callable<T> que além de devolver um Future<T> também permite que lancemos exceções. Para obter
     * o resultado desse Future<T> usamos o método get(que é bloqueante, ou seja, para o a thread
     * principal em que está rodando para esperar que as threads paralelas terminem antes de continuar).
     * ->Podemos definir um timeout para nosso Future pegar seu conteúdo, se esse timeout estrapolar então
     * podemos cancelar a thread com o método cancel(Interrompe a Thread).
     *-> Usamos uma implementação de fila com uma classe ThreadSafe, que possui métodos bloqueantes a
     * tornando ideal para se trabalhar de forma concorrente.
     */
}
