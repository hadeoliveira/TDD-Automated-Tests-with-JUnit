package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveRetornarZeroParaSalarioMaiorQue10000() {
		BonusService service = new BonusService();
		assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Henrique", LocalDate.now(), new BigDecimal("20000.00"))));
	
		/* Uma outra abordagem e' da forma abaixo
		try {
			service.calcularBonus(new Funcionario("Henrique", LocalDate.now(), new BigDecimal("20000.00")));
			fail("Deveria ter dado uma Exception. O teste falhou!");
		} catch (Exception e) {
			assertEquals("Funcionario com salario maior que 10.000 reais nao pode receber bonus.", e.getMessage());
		}
		*/
	}

	@Test
	void bonusDeveRetornar10PorCentoDoSalarioMenorQue10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus
				(new Funcionario("Henrique", LocalDate.now(), new BigDecimal("2000.00")));
		
		assertEquals(new BigDecimal("200.00"), bonus);
	}
	
	@Test
	void bonusDeveRetornar10PorCentoParaSalarioExatamenteDe10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus
				(new Funcionario("Henrique", LocalDate.now(), new BigDecimal("10000.00")));
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}
