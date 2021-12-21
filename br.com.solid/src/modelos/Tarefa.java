package modelos;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Tarefa {

	private DadosDaTarefa dadosDaTarefa;
	private LocalDate dataUltimoReajuste;

	public Tarefa(String nome, String donoDaTarefa, FatorPontoExtra fatorPontoExtra,
				  BigDecimal pontos) {
		this.dadosDaTarefa = new DadosDaTarefa(nome,donoDaTarefa,fatorPontoExtra,pontos);
	}

	/**Minha tarefa não sabe como ela foi reajustada, ela apenas sabe que deve reajustar seus pontos,
	 * mas esse cara aqui pode ser chamado pelo objeto sem passar pela minha classe de serviço,
	 * o encapsulamento aqui ta fudido*/
	public void atualizarPontosConclusao(BigDecimal pontosReajustados) {
		this.dadosDaTarefa.setPontosDeConclusao(pontosReajustados);
		this.dataUltimoReajuste = LocalDate.now();
	}

	public void adicionarPontoExtra(BigDecimal pontoExtra) {
		this.dadosDaTarefa.getPontosDeConclusao().add(pontoExtra);
	}

	public DadosDaTarefa getDadosDaTarefa() {
		return dadosDaTarefa;
	}

	public void setDadosDaTarefa(DadosDaTarefa dadosDaTarefa) {
		this.dadosDaTarefa = dadosDaTarefa;
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}


}
