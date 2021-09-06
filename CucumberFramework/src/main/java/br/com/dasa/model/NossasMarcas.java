package br.com.dasa.model;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NossasMarcas {
	
	WebDriver driver;
	private String xSelectRegiao = "//select[@name=\"locations\"]"; 
	private String xBrands = "//picture//ancestor::div[@tabindex=0]/a";
	private String xBrandByURL = "//picture//ancestor::div[@tabindex=0]/a[contains(@href,\'{0}\')]";

	public NossasMarcas(WebDriver _driver) {
		driver = _driver;
	}
	
	public WebElement GetElementRegiao() {
		return driver.findElement(By.xpath(xSelectRegiao));
	}
	public Select GetSelectRegiao() {
		Select region = new Select(this.GetElementRegiao());
		return region;
	}
	
	public void SelectOption(Select _select, String _option) {
		_select.selectByValue(_option);
	}
	
	public List<WebElement> GetBrands() {
		return driver.findElements(By.xpath(xBrands));
	}
	
	public void SelectBrandByURL(String url) {
		WebElement brand = driver.findElement(By.xpath(xBrandByURL.replace("{0}", url)));
		brand.click();
	}
	
	
	
}
