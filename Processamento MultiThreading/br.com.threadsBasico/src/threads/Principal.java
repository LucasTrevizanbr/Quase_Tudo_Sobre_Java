package threads;

public class Principal {
    /**
     * ->Threads são um jeito de se fazer processos paralelamente, cada Thread é um processo e
     * no java ela é representada por uma classe Thread.
     * ->Uma classe Thread precisa de uma tarefa para executar, essa tarefa é uma classe que assina o
     *  contrato de Runnable.
     * ->Cada Thread é uma linha de execução separada que tem sua própria pilha de métodos.
     * ->Threads não tem uma ordem de execução, elas ocorrem paralelamente, então é tudo dependente da
     * máquina, então quando trabalhamos com Thread sabemos que não temos uma ordem de execução garantida.
     * ->Quando usamos Threads precisamos estar cientes do problema de concorrência, quando mais de uma
     * Thread tenta acessar um único objeto(objeto compartilhado).
     * -> Uma maneira de fazer as Threads se comunicarem é com wait() e notify(). Isso permite que eu diga
     * pra uma Thread fazer sua função quando outra terminar sua tarefa. Esses métodos SOMENTE FUNCIONAM
     * dentro de blocos Synchronized.
     * -> DeadLock é quando uma Thread possui uma chave que Esta em outra Thread, e outra Thread precisa
     * da chave que esta nessa "uma Thread". Então eles vão se esperar mas nunca vão se devolver a thread,
     * é preciso prestar atenção nessa lógica quando temos muitos recursos compartilhados e sincronizados.
     *
     * ===============================================================================================
     * pacote calculo:
     * Nesse pacote é só um exemplo onde colocamos a operação da calculadora para rodar em uma Thread,
     * assim como o calculo está em uma Thread e a Jpanel da calculadora em outra ela não travaria enquanto
     * a Thread processava o calculo.
     * ================================================================================================
     * pacote leitura_arquivo_multi:
     * Nesse projeto usamos mais de uma Thread para efetuar uma pesquisa em arquivos de textos atrás
     * de um nome, aqui tem uma implementação legal sobre leitura de arquivo na Runnable.
     * ===============================================================================================
     * pacote concorrencia_lista:
     * Mais de uma Thread manipulando o mesmo objeto causa erros de concorrência, nesse pacote temos algumas
     * alternativas de objetos que são ThreadSafe e portanto podem ser utilizados entre multiplas Threads.
     * Vector ou SynchronizedList do Collection são opções mais defasadas, o importante aqui é saber que
     * compartilhar UM MESMO objeto entre listas da ruim, e se não tiver outra opção além de Synchronized
     * então pode recorrer a ele.
     * =================================================================================================
     * pacote lista_artesanal_esperar_notificar:
     * Nese cenário queremos que a Thread de impressão(só um sysout) faça sua tarefa somente quando
     * as Threads de inserção(add numa lista arcaica) terminarem suas tarefas.
     *==================================================================================================
     *
     *
     */
}
