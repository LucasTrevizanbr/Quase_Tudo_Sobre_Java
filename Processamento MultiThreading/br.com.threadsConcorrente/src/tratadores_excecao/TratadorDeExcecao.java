package tratadores_excecao;

public class TratadorDeExcecao implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread thread, Throwable excecao) {
        System.out.println("Erro na Thread "+thread.getName()
                +" exceção: "+excecao.getMessage());
    }
}
