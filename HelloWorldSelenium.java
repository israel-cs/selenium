package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {
	
	@Test
	public void hello() {
		WebDriver browser = new ChromeDriver();
		browser.navigate().to("http://localhost:8080/leiloes");
<<<<<<< HEAD
		System.out.println("Para Ana e sempre");
=======

		System.out.println("TST");

>>>>>>> 9e223e2bef2a75a3517f27fe712a799c13cc4369
		browser.quit();
	}
	
	
}
