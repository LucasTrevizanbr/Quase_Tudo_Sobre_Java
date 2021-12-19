
package calculo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**Classe com a ação que faz o calculo*/
public class AcaoBotao implements ActionListener {

	private JTextField primeiro;
	private JTextField segundo;
	private JLabel resultado;

	public AcaoBotao(JTextField primeiro, JTextField segundo, JLabel resultado) {
		this.primeiro = primeiro;
		this.segundo = segundo;
		this.resultado = resultado;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		/**Criamos um objeto que representa uma Thread, uma thread precisa saber qual tarefa
		 * executar, esse algo é o Runnable, esse Runable é a classe TarefaMultiplicacao*/
		Thread threadCalculo = new Thread(new TarefaMultiplicacao(primeiro,segundo,resultado)
				,"Thread Calculo");

		/**Com minha Thread associada a minha Tarefa, eu digo agora pra minha JVM que a partir
		 * de agora ela vai rodar essa thread paralelamente através do método
		 */
		threadCalculo.start();
	}

}