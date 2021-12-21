package guia_projeto;

public class InversaoDependencia {
    /**
     *                                       Cenário
     *
     *   Quando implementamos o principio de OpenClosed fizemos com que nossa classe de validação
     *   service recebesse uma lista de Validacoes(Uma interface que representa o conceito de validacao).
     *   Classes concretas que sabem como fazer cada uma sua validação assinariam esse conceito e
     *   implementariam ele da maneira que elas sabem(cada uma com sua validação específica),
     *   nosso Service apenas então chamaria a lista com os Conceitos de validação permitindo que
     *   possamos alterar, adicionar ou remover validações sem causar impacto nele.
     *
     *=============================Princípio da Inversão de Dependência=========================
     *   Quando fizemos essa alteração aplicamos o princípio da inversão de dependência que diz
     *   que ABSTRAÇÕES NÃO DEVEM DEPENDER DE IMPLEMENTAÇÕES, E SIM IMPLEMENTAÇÕES QUE DEVEM DEPENDER
     *   DE ABSTRAÇÕES. Isso quer dizer o que no nosso contexto?
     *   Quer dizer que minha Service tem uma ABSTRAÇÃO(Interface) de Validação e depende dela, MINHAS
     *   VALIDAÇÕES CONCRETAS(Classes que implementam a validação de percentual e de periodicidade)
     *   DEPENDEM DO MÉTODO VALIDAR DA MINHA ABSTRAÇÃO(Pois elas implementam minha Interface).
     *   O que eu to fazendo é garantir que qualquer implementação de validação dependa do meu conceito
     *   de abstração(interface), dessa maneira como Service eu não to nem ai pras minhas implementações
     *   concretas POIS ELAS QUE DEPENDEM da minha Abstração, não o contrário, com isso eu posso adicionar
     *   ou remover ou alterar qualquer validação que seja.
     *
     *   Termina aqui: SegregacaoInterface.
     */
}
