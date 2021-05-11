package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeAll
	public static void antesDeTodos() {
		System.out.println("ANTES DE TODOS!");
	}
	
	@BeforeEach
	public void inicializar() {
		System.out.println("Inicializar...");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Henrique", LocalDate.now(), new BigDecimal("1000.00"));
		
	}
	
	@AfterEach
	public void finalizar() {
		System.out.println("Fim!");
	}
	
	@AfterAll
	public static void depoisDeTodos() {
		System.out.println("DEPOIS DE TODOS!");
	}

	@Test
	void reajusteDeveSerDeTresPorCentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveSerDeQuinzePorCentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	void reajusteDeveSerDeVintePorCentoQuandoDesempenhoForADesejar() {
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
