package rafael.broedel.gerenciador_pagamentos.enums;

import java.math.BigDecimal;

public enum TipoCargo {

	GERENTE_IMEDIATO( 1, "Gerente Imediato" ), GERENTE_GERAL( 2, "Gerente Geral" ), DIRETOR_FINANCEIRO( 3, "Diretor financeiro" ), DIRETOR_GERAL( 4, "Diretor Geral" );

	private int id;
	private String description;

	TipoCargo( int id, String descricao ) {};

	public int getCode() {
		return this.id;
	}

	public String getDescription() {
		return this.description;
	}

	public static BigDecimal maximumApprovalValue( int codCargo ) {
		switch ( codCargo ) {
			case 1:
				return BigDecimal.valueOf( 500L );
			case 2:
				return BigDecimal.valueOf( 1500L );
			case 3:
				return BigDecimal.valueOf( 5000L );
			case 4:
				return BigDecimal.valueOf( 15000L );
			default:
				return BigDecimal.valueOf( 0L );
		}
	}
}
