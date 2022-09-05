package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage paginaLogin;	
	
	@BeforeEach
	public void inicializa() {
		this.paginaLogin = new LoginPage();		
	}
		
	@AfterEach
	public void finaliza() {
		this.paginaLogin.fechaBrowser();
	}
	
	@Test
	public void logarDados() {		
		paginaLogin.preecheCredencial("fulano", "pass");
		paginaLogin.efetuaLogin();				
		Assert.assertFalse(paginaLogin.isPaginaLogin());
		Assert.assertEquals("fulano", paginaLogin.getNomeUsuario());
	}
	
	@Test
	public void invalidarLogin() {
		paginaLogin.preecheCredencial("invalido", "123123");
		paginaLogin.efetuaLogin();	
		
		Assert.assertTrue(paginaLogin.paginaLoginInvalido());
		Assert.assertNull(paginaLogin.getNomeUsuario());
		Assert.assertTrue(paginaLogin.contemTexto("Usuário e senha inválidos."));
	}
	@Test
	public void naoDeveAcessarPaginaRestrita() {
		paginaLogin.paginaLeilao();
		Assert.assertTrue(paginaLogin.isPaginaLogin());		
		Assert.assertFalse(paginaLogin.contemTexto("Dados do Leilão"));
	}	
}