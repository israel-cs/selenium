package br.com.alura.leilao.leiloes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
	private LeiloesPage paginaLeiloes;		
	private CadastroLeilaoPage paginaCadastro;		
	
	
	@BeforeEach
	public void inicializa() {
		LoginPage paginaLogin = new LoginPage();
		paginaLogin.preecheCredencial("fulano", "pass");
		this.paginaLeiloes = paginaLogin.efetuaLogin();	
		this.paginaCadastro = paginaLeiloes.carregarFormulario();
	}
	
	/*@AfterEach
	public void finaliza() {
		this.paginaLeiloes.fechaBrowser();
	}
	*/
	
	@Test
	public void cadastrarNoLeilao() {			
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia " + hoje;
		String valor = "500.00";
		this.paginaLeiloes = paginaCadastro.cadastrarLeilao(nome, valor, hoje);
		Assert.assertTrue(paginaLeiloes.isLeilaoCadastrado(nome, valor, hoje));
	}
	
	@Test
	public void naoValidaCadastroLeilao() {
		this.paginaLeiloes = paginaCadastro.cadastrarLeilao("", "", "");
		Assert.assertFalse(this.paginaCadastro.isPaginaAtual());
		Assert.assertTrue(this.paginaLeiloes.isPaginaAtual());
		Assert.assertTrue(this.paginaCadastro.isMensagemValidaVisivel());
	}
	
}