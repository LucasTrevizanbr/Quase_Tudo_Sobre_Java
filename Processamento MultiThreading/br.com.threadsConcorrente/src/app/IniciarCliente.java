package app;

import cliente.ClienteTarefas;
import servidor.ServidorTarefas;

import java.io.IOException;

public class IniciarCliente {
    public static void main(String[] args) throws IOException {
        ClienteTarefas cliente = new ClienteTarefas();
        cliente.iniciarClienteTarefas();
    }

}
