package java8;

import modelo.Time;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {

        List<Time> times = Time.devolveTimes();
        /**Usando um method reference para o meu Comparador, algo do tipo "comparador, usa os nomes
         * do meu time ai"*/
        times.sort(Comparator.comparing(Time::getNomeClube));

        /**o for each é uma stream que permite fazer uma ação final sobre uma coleção*/
        times.forEach(time -> System.out.println(time.getNomeClube()));

        /**Olha como é fácil fazer uma filtragem em uma lista usando Streams, não preciso fazer um
         * código verboso e imperativo, posso usar meu fluxo(stream) para que ele faça isso para mim,
         * outra coisa é que a Stream não muda a lista original, ele apenas devolve fluxos a partir dela*/
        List<Time> timesDeFutebol = times.stream()
                /**usando uma lambda para a Stream*/
                .filter(time -> time.getModalidade().equals("Futebol"))
                .collect(Collectors.toList());

        System.out.println("========= Só time de futebol ======================");
        timesDeFutebol.forEach(time -> System.out.println(time.getNomeClube()));

        /**Eu também posso efetuar usar map para pegar atributos específicos da minha coleção e efetuar
         * uma operação sobre eles, como aqui omde eu mapeio meu atributo de números de jogadores e
         * faço uma soma no final com o sum()*/
        int totalJogadoresDeFutebolNaLista = timesDeFutebol.stream()
                .mapToInt(Time::getNumeroJogadores)
                .sum();
        System.out.println("Total de jogadores de futebol : " + totalJogadoresDeFutebolNaLista);

        /**Também podemos usar o Optional em conjunto com as streams e lambdas, o Optional é algo que
         * "envelopa" nosso objeto que pode ou NÃO ser nullo, nos dando opções para se trabalhar com
         * essa possibilidade.*/
        timesDeFutebol.stream()
                .filter(time -> time.getNomeClube().equals("Internacional"))
                .findAny()
                .ifPresent((time -> System.out.println(time.getNomeClube())));
    }
}
