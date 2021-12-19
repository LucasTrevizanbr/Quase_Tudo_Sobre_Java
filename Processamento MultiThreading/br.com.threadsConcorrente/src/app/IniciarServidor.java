package app;

import servidor.ServidorTarefas;

import java.io.IOException;

public class IniciarServidor {
    public static void main(String[] args) throws IOException {
        ServidorTarefas servidor = new ServidorTarefas();
        System.out.println("===================== Servidor online =============================");
        try {
            servidor.iniciarServidor();
        } catch (IOException exception) {
            System.out.println("Erro ao iniciar o servidor: "+ exception.getMessage());
        }

    }
}
