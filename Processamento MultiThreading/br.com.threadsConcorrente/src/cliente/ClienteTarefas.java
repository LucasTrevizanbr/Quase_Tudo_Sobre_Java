package cliente;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**Representa a conexão do cliente com o servidor*/
public class ClienteTarefas {

    private Socket clienteSocket;
    private ExecutorService poolThreadCliente;

    public void iniciarClienteTarefas() throws IOException {
        this.clienteSocket = new Socket("localhost",12345);
        System.out.println("Conexão estabelecida");
        this.poolThreadCliente = Executors.newFixedThreadPool(2);
        this.iniciarThreadEnvioComandoServidor();
        this.iniciarThreadRecebeRespostaServidor();
    }

    private void iniciarThreadEnvioComandoServidor() {
        this.poolThreadCliente.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Envie algum comando para o Servidor: ");
                    PrintStream saidaClienteParaServidor = new PrintStream(clienteSocket.getOutputStream());
                    Scanner tecladoCliente = new Scanner(System.in);

                    while (tecladoCliente.hasNextLine()) {
                        String entradaTextoCliente = tecladoCliente.nextLine();

                        if (entradaTextoCliente.trim().equals("")) {
                            break;
                        }

                        saidaClienteParaServidor.println(entradaTextoCliente);
                    }
                    tecladoCliente.close();
                    saidaClienteParaServidor.println();
                } catch (IOException exception) {
                    throw new RuntimeException(exception);
                }
            }
        });
    }

    private void iniciarThreadRecebeRespostaServidor() {
        this.poolThreadCliente.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    Scanner respostaServidor = new Scanner(clienteSocket.getInputStream());

                    while(respostaServidor.hasNextLine()){
                        String resposta = respostaServidor.nextLine();
                        System.out.println("Resposta do servidor: "+resposta);
                    }
                }catch (IOException exception){
                    throw new RuntimeException(exception);
                }
            }
        });
    }

}
