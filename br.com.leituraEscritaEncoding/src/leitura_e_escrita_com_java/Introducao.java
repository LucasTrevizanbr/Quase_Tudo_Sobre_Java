package leitura_e_escrita_com_java;

public class Introducao {
    /**
     * Diversas vezes temos que trabalhar tratando dados que vem diretamente de algum tipo
     * de arquivo. Por experiência própria eu digo que é muito comum termos que importar dados de
     * um arquivo que parece estranho onde temos números e informações que
     * são separadas por "," , cabeçalhos/Headers , Detail/Detalhe/Informação de corpo , Trailer/Rodapé.
     * Essas informações costumam ser mapeadas em objetos que representem melhor ela no código, geralmente
     * frameworks próprios ou abertos fazem esse trabalho, mas o que nunca muda é QUE ELES USAM CLASSES
     * DO JAVA que lidam com leitura e escrita de arquivos.
     * Aqui vamos conhecer algumas dessas classes e principalmente entender o funcionamento "macro"
     * de uma leitura e escrita de arquivo, essa é de fato a base para um compreendimento maior.
     *
     * =======LerArquivoUm===============
     * Começa por essa classe. "leitura_e_escrita_com_java.LerArquivoUm", aqui tem conhecimentos
     * primordiais para prosseguir para um nível mais alto, aproveita que ta enxuto e diz quase tudo
     * que você precisa minimamente saber.
     *
     * ======LerArquivoDois================
     * Agora sim a gente pode subir um pouco o nível, usando uma classe ais abstrata e lendo um tipo
     * de arquivo mais "complexo" onde vamos transformar essas informações em uma lista de Objetos.
     *
     * ====EscreverArquivoUm==============
     * Agora que sabemos um pouco sobre o funcionamento de leitura, podemos ir para a escrita.
     * É EXTREMAMENTE IMPORTANTE saber os conceitos das etapas anteriores.
     *
     * ===EscreverArquivoDois================
     * Nessas duas classes vemos outras maneiras de se escrever arquivos, uma utilização de um nível
     * maior e ja fazendo um exemplo prático.
     *
     * ===CopiarArquivo=============
     * Apenas um exemplo para copiar o arquivo de um lugar para o outro.
     *
     * ===UnicodeEncoding=======
     * E pra finalizar o básico do tópico de escrita e leitura vamos falar sobre Encoding. Vamos
     * começar entendendo melhor o que é enconding e codePoints e os problemas de carcteres estranhos
     * em arquivos.
     *
     * ===ManipularEncoding======
     * Pra finalizar, vamos ver como podemos manipular o encoding de um arquivo que queremos ler, e podemos
     * fazer o mesmo em sua escrita e isso é muito simples.
     */
}
