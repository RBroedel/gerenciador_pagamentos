package rafael.broedel.gerenciador_pagamentos.business;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import rafael.broedel.gerenciador_pagamentos.entity.Pagamento;
import rafael.broedel.gerenciador_pagamentos.enums.TipoCargo;

public class PagamentoBusiness {

	public boolean solicitarAprovacao( List<Pagamento> pagamentos, BigDecimal valor ) throws Exception {
		if( !( valor.compareTo( BigDecimal.ZERO ) == 1 && valor.compareTo( BigDecimal.valueOf( 15000L ) ) == -1 ) ) {
			throw new Error( "O valor do pagamento deve estar entre R$ 0,00 e R$ 15000,00!" );
		}

		var pagamento = new Pagamento();
		pagamento.setId( getLastId( pagamentos ) + 1L );
		pagamento.setValor( valor );
		pagamento.setDataSolicitacao( LocalDateTime.now() );
                
                pagamentos.add(pagamento);
                
		return true;
	}

	public boolean aprovarSolitacao( List<Pagamento> pagamentos, int codCargo ) throws Exception {
		if( codCargo < 1 || codCargo > 4 ) {
			throw new Error( "Tipo de funcionario informado não existe!" );
		}

		var valorMaximo = TipoCargo.maximumApprovalValue( codCargo );

		System.out.println( "As seguintes solicitações de pagamento foram aprovadas!" );
		pagamentos.forEach( pag -> {
			if( pag.getDataAprovacao() == null && pag.getValor().compareTo( valorMaximo ) != 1 ) {
				pag.setDataAprovacao( LocalDateTime.now() );
				System.out.println( pag.getId() + " - R$ " + pag.getValor() + " Data Solicitação: " +  pag.getDataSolicitacao()  + " Data Aprovação: " +  pag.getDataSolicitacao()  );
			}
		} );

		return true;
	}

	private Long getLastId( List<Pagamento> pagamentos ) {
		if( !pagamentos.isEmpty() )
			return pagamentos.get( pagamentos.size() - 1 ).getId();

		return 0L;
	}

}
