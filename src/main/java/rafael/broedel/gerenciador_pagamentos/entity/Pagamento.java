package rafael.broedel.gerenciador_pagamentos.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {

	private Long id;
	private BigDecimal valor;
	private LocalDateTime dataSolicitacao;
	private LocalDateTime dataAprovacao;

	public Long getId() {
		return id;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor( BigDecimal valor ) {
		this.valor = valor;
	}

	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao( LocalDateTime dataSolicitacao ) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public LocalDateTime getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao( LocalDateTime dataAprovacao ) {
		this.dataAprovacao = dataAprovacao;
	}
}
