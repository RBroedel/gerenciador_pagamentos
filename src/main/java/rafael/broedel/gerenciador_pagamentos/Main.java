package rafael.broedel.gerenciador_pagamentos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import rafael.broedel.gerenciador_pagamentos.business.PagamentoBusiness;
import rafael.broedel.gerenciador_pagamentos.entity.Pagamento;

public class Main {

	public static void main( String args[] ) {
		System.out.println( "Gerenciador de Pagamentos started...." );
		PagamentoBusiness pagamentoBusiness = new PagamentoBusiness();
		var pagamento = new Pagamento();
		List<Pagamento> pagamentos = new ArrayList<Pagamento>();

		System.out.println( "Adicionando solicitações de pagamentos...." );
		try {
			pagamentoBusiness.solicitarAprovacao( pagamentos, BigDecimal.valueOf( 450L ) );
		} catch ( Exception e ) {
			System.out.println( e.getLocalizedMessage() );
		}
		try {
			pagamentoBusiness.solicitarAprovacao( pagamentos, BigDecimal.valueOf( 1450L ) );
		} catch ( Exception e ) {
			System.out.println( e.getLocalizedMessage() );
		}
		try {
			pagamentoBusiness.solicitarAprovacao( pagamentos, BigDecimal.valueOf( 4500L ) );
		} catch ( Exception e ) {
			System.out.println( e.getLocalizedMessage() );
		}
		try {
			pagamentoBusiness.solicitarAprovacao( pagamentos, BigDecimal.valueOf( 14500L ) );
		} catch ( Exception e ) {
			System.out.println( e.getLocalizedMessage() );
		}

		System.out.println( "Aprovando solicitações como GERENTE_IMEDIATO...." );
		try {
			pagamentoBusiness.aprovarSolitacao( pagamentos, 1 );
		} catch ( Exception e ) {
			System.out.println( e.getLocalizedMessage() );
		}

		System.out.println( "Aprovando solicitações como GERENTE_GERAL...." );
		try {
			pagamentoBusiness.aprovarSolitacao( pagamentos, 2 );
		} catch ( Exception e ) {
			System.out.println( e.getLocalizedMessage() );
		}

		System.out.println( "Aprovando solicitações como DIRETOR_FINANCEIRO...." );
		try {
			pagamentoBusiness.aprovarSolitacao( pagamentos, 3 );
		} catch ( Exception e ) {
			System.out.println( e.getLocalizedMessage() );
		}

		System.out.println( "Aprovando solicitações como DIRETOR_GERAL...." );
		try {
			pagamentoBusiness.aprovarSolitacao( pagamentos, 4 );
		} catch ( Exception e ) {
			System.out.println( e.getLocalizedMessage() );
		}

	}
}
