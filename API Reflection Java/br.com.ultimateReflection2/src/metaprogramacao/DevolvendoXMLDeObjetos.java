package metaprogramacao;

public class DevolvendoXMLDeObjetos {
    /**
     * primeiro vamos aprender a usar a classe field
     * ===================UtilizandoFields===============
     * "reflection_classes.UtilizandoFields".
     * ====================================================
     * Agora nossa API vai devolver um XML invés de um retorno bruto. Enquanto quando cliente side
     * chamar a nossa aplicação, vamos usar uma classe conversora para devolver o XML. Para isso
     * vamos adicionar um novo pacote "conversor" que conterá nossos conversores.
     * =======================ConversorXML============================================================
     * "conversor.ConversorXML" é apenas uma classe que será responsável por converter o objeto
     * para XML, usaremos na hora de devolver pro cliente.
     * ===============================================================================================
     * Usando o getName da classe para converter a tag de nome pro XML obtemos o fully qualified name,
     * o que não era nosso objetivo, podemos resolver isso usando getSimpleName() ou usando anotações.
     * Como o objetivo é aprender mais, vamos pelo caminho de anotações.
     * =======================Usando Anotações==========================================================
     * Anotações são metadados, metadados são dados relativos a uma informação já existente(essa
     * informação é nosso código, então metadados em java são informações relativas a um código que
     * já escrevemos).
     * Mais informações aqui : "anotacoes.NomeTagXml". Quando criamos uma anotação, nosso programa
     * tem que saber como levar ela em consideração, toda classe que representa Uma Classe, Metodo,
     * Atributo(Como ja percebeu, estamos falando das classes de Reflection) possuem métodos que vão
     * verificar se a classe em questão tem alguma anotação e que valor essa anotação tem se estiver
     * sendo utilizada(aui mantemos o padrão de "getDeclaredAnnotation(s)","getAnnotation(s)").
     *
     * ================Entrando em um novo assunto====================================================
     * Vamos melhorar nossa estrutura de código do controller usando Inversão de controle
     * e injeção de dependência. Continua nessa classe : InjecaoDependenciaInversaoControle
     */
}
