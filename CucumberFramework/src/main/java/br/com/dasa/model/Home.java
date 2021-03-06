package br.com.dasa.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
	
	WebDriver driver;
	private String xMenu = "//div[contains(@class,\"eWFgbM\")]//a[@label=\"{0}\"]/div"; 
	private String xOption = "//a[@label=\"{0}\"]";
	
	
	public Home(WebDriver _driver) {
		driver = _driver;
	}
	
	public WebElement GetMenu(String menu) {
		System.out.println("1 - " + xMenu.replace("{0}", menu));
		return driver.findElement(By.xpath(xMenu.replace("{0}", menu)));
	}
	
	public WebElement GetOption(String option) {
		System.out.println("2 - " + xOption.replace("{0}", option));
		return driver.findElement(By.xpath(xOption.replace("{0}", option)));
	}
}
