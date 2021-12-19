package bonus;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ControleDasThreads {

    public static void main(String[] args) {
       try{
           /**pool de Threads*/
           ExecutorService poolDeThreads = Executors.newCachedThreadPool();

           /**Pego no banco ou de alguma fonte de informação*/
           int qtdTotalDosRegistros = 10;//consulta no banco o total dos registros
           int idMinimoDosRegistros = 1;//Consulta no banco o menor id dos registros
           int idMaximoDosRegistros = 10;//Consulta no banco o maior id dos registros

           /**Range que minha Runnable irá atuar(busca registros entre os ids)*/
           int idInicialBlocoThread = 0;
           int idFinalBlocoThread = 0;

           /**Variáveis para controlar a execução das Threads*/
           int tamanhoMaximoBlocoThread = 500;//Quantidade máxima de registros que a Thread vai processar
           int qtdDeThreads;
           int qtdThreadsExecutadas = 1;
           int transbordoDeThreads = 0;

           /**Calculo para definir a quantidade de threads, pensando nos extremos*/
           if(qtdTotalDosRegistros % tamanhoMaximoBlocoThread != 0){
               qtdDeThreads = (int) Math.round((qtdTotalDosRegistros/tamanhoMaximoBlocoThread)+0.5);
           }else{
              qtdDeThreads = Math.round(qtdTotalDosRegistros/tamanhoMaximoBlocoThread);
              if(qtdDeThreads == 0){
                  qtdDeThreads = 1;
              }
           }

           /**Ajuda a controlar execução das Threads*/
           CountDownLatch contadorThread = new CountDownLatch(qtdDeThreads);//Contador
           Long auxiliarContadoThread = contadorThread.getCount();

           //Pega a quantidade de Threads disponiveis da máquina
           int qtdThreadsEmParalelo = Runtime.getRuntime().availableProcessors();
           int auxControleRegistros = 0;

           /**Executa as threads enquanto ainda houverem*/
           while(qtdThreadsExecutadas <= qtdDeThreads){

               /**Faz o controle para aguardar a liberação de uma thread da máquina caso todas estejam
                * ocupadas*/
               if(transbordoDeThreads >= qtdThreadsEmParalelo){
                   contadorThread.await(250l, TimeUnit.MILLISECONDS);

                   transbordoDeThreads = transbordoDeThreads - (int)
                           (auxiliarContadoThread - contadorThread.getCount());

                   auxiliarContadoThread = contadorThread.getCount();
                   continue;
               }

               /**Controla os Ids iniciais e finais que serão setados nas threads*/
               idInicialBlocoThread = idMinimoDosRegistros + (tamanhoMaximoBlocoThread * auxControleRegistros);
               idFinalBlocoThread = idInicialBlocoThread + tamanhoMaximoBlocoThread;

               if(idFinalBlocoThread > idMaximoDosRegistros){
                   idFinalBlocoThread = idMaximoDosRegistros;
               }

               if(idInicialBlocoThread != idMinimoDosRegistros){
                   idInicialBlocoThread = idInicialBlocoThread + 1;
               }

               /**Executa a Task da Thread*/
               poolDeThreads.submit(new TarefaProcessarBloco
                       (idInicialBlocoThread, idFinalBlocoThread, contadorThread));

               /**Incremento os auxiliares de controle do laço*/
               transbordoDeThreads ++;
               qtdThreadsExecutadas ++;
               auxControleRegistros ++;
           }



       }catch (InterruptedException e) {
            e.printStackTrace();
       }

    }
}
