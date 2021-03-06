package br.com.dasa.steps;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import br.com.dasa.model.Home;
import br.com.dasa.model.NossasMarcas;
import br.com.dasa.util.Util;
import io.cucumber.java.en.*;

public class DasaSteps{
	
	private WebDriver driver;
	private Home home;
	private NossasMarcas nossasMarcas;
	
	public DasaSteps() {
		driver = Util.GetDriver();
		home = new Home(driver);
		nossasMarcas = new NossasMarcas(driver);
	}

	@Given("^I navigate to DASA website$")
	public void NavigateToDasa() {
		driver.navigate().to("http://www.dasa.com.br" );		
	}
	
	@Given("I navigate to menu {string} option {string}")
	public void i_navigate_to_menu_option(String _menu, String _option) {
		WebElement menu = home.GetMenu("Somos Dasa");
		WebElement option = home.GetOption("Nossas Marcas"); 
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(menu));
		
		
		Actions action = new Actions(driver);
		action.moveToElement(menu).moveToElement(option).click().perform();
	}
	
	@When("^I filter \"(.*)\" and select option \"(.*)\"$")	
	public void IfilterAndSelectOption(String _select, String _option) throws Exception {
		Select select;
		Thread.sleep(5000);//VERIFICAR CONDI??O DE WAIT
		
		switch (_select) {
		case "Regi?es":
			select = nossasMarcas.GetSelectRegiao();
			break;
		default:
			throw new Exception("Option not defined");
		}
		nossasMarcas.SelectOption(select, _option);
	}
	
	@Then("I print all results")
	public void IPrintAllResults() {
		System.out.println("===[ Lista de Marcas ]===");
		for (WebElement brand : nossasMarcas.GetBrands()) {
			System.out.println(brand.getAttribute("href"));
		}
	}
	
	@When("I select {string} brand")
	public void SelectBrandS(String brandURL) throws InterruptedException {
		nossasMarcas.SelectBrandByURL(brandURL);
	}
	
	@Then("I verify if I navigated to {string}")
	public void i_verify_if_i_navigate_to(String url) throws InterruptedException {
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		Thread.sleep(5000); //VERIFICAR CONDI??O DE WAIT
	    driver.switchTo().window(tabs2.get(1));
	    assert("https://delboniauriemo.com.br/".equals(driver.getCurrentUrl()));  
	}
}
