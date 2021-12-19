package app;

import banco_dados_fake.GerarObjetos;
import banco_dados_fake.GerarObjetosMock;
import modelos.Cidade;

import java.util.Scanner;

/**
 * Nessa classe vamos apenas simular um request, onde podemos passar via console uma url no padrão
 * básico de rest.
 */
public class EmuladorRequestClient {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            /**Url capturada via console*/
            String urlRequisicao = scanner.nextLine();

            /**Classe que vai fazer o processo de reflexao do request, por padrão vamos receber o
             * pacote base no construtor do controlador, para podermos usa-lo na hora da relfexão*/
            ControladorDeRota controlador = new ControladorDeRota("controladores.");

            controlador.registra(GerarObjetos.class, GerarObjetosMock.class);

            while(!urlRequisicao.equals("exit")){
                Object resposta = controlador.excuta(urlRequisicao);
                System.out.println("Resposta : " + resposta);

                urlRequisicao = scanner.nextLine();
            }
        }
    }

}
