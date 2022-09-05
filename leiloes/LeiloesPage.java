package br.com.alura.leilao.leiloes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.alura.leilao.PageObject;

public class LeiloesPage extends PageObject{

	private static final String URL_CADASTRA_LEILAO = "http://localhost:8080/leiloes/new";
	private static final String URL_LEILOES = "http://localhost:8080/leiloes";
	
	public LeiloesPage(WebDriver browser) {
		super(browser);
	}
	//carrega formulário
	public CadastroLeilaoPage carregarFormulario() {
		this.browser.navigate().to(URL_CADASTRA_LEILAO);
		return new CadastroLeilaoPage(browser);
	}
	
	public boolean isLeilaoCadastrado(String nome, String valorInicial, String dataAbertura) {
		WebElement linhaTabela = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
		WebElement colunaNome = linhaTabela.findElement(By.cssSelector("td:nth-child(1)"));
		WebElement colunaDataAbertura = linhaTabela.findElement(By.cssSelector("td:nth-child(2)"));
		WebElement colunaValorInicial = linhaTabela.findElement(By.cssSelector("td:nth-child(3)"));
		
		return colunaNome.getText().equals(nome) 
			&& colunaValorInicial.getText().equals(valorInicial)
			&& colunaDataAbertura.getText().equals(dataAbertura);
	}

	public boolean isPaginaAtual() {
		// TODO Auto-generated method stub
		return browser.getCurrentUrl().contentEquals(URL_LEILOES);
	}

}