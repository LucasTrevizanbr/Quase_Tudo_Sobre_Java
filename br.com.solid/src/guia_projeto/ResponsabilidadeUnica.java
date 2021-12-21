package guia_projeto;

public class ResponsabilidadeUnica {
    /**
     *                             Conceito do Projeto
     *
     * Basicamente temos 2 modelos apenas no projeto, sendo que um deles é um ENUM. A ideia é que a
     * classe Tarefa represente alguma tarefa a ser concluída, cada tarefa concluída da uma quantidade
     * de pontos, esses pontos podem ser multiplicados de acordo com o ENUM que diz a dificuldade
     * da tarefa. A cada passagem de tempo rola um reajuste na quantidade de pontos que a tarefa da.
     *
     * =====================Tarefa/Coesão - Princípio da Responsabilidade Única===========================
     * Comentamos sobre o reajuste de pontos que ocorre de tempos em tempos por cumprir uma
     * tarefa. Inicialmente esse cálculo de reajuste estava dentro da classe de Tarefa, e isso
     * quebra a COESÃO do código, por mais que uma tarefa valha um número de pontos, ESSE CÁLCULO
     * DE REAJUSTE NÃO É FUNÇÃO DA CLASSE TAREFA , a Função dela é ter um X número de pontos que ela vale
     * e que ela pode ser reajustada.
     * Por isso, minha classe de "ReajusteService" vai ter esse método e vai ficar separadinha
     * no meu pacote de service.
     * Com isso acabamos de aplicar o "S" do SOLID, que é o Princípio da responsabilidade única
     * , o nome é bem descritivo mas se não ficou claro então grita ai :
     * "UMA CLASSE DEVE TER APENAS UM MOTIVO PARA MUDAR!!!" Isso significa que nossa Tarefa por exemplo
     * só deveria ser alterada caso houvesse alguma alteração naquilo que ela representa no sistema
     * (Uma tarefa durr), o cálculo do reajuste não tem nada a ver com ela, ela sabe que pode ter o valor
     * de pontos mudados mas não SABE QUAL A LÓGICA OU MOTIVO PRA ISSO.
     * Quem sabe as regras agora é a ReajusteService, se tiver alguma mudança nessa lógica então o service
     * de reajuste que vai precisar ser alterado.
     *
     * Para continuar avançando nos conceitos vá para essa Classe: AbertoFechado.
     *
     *
     */
}
