package br.com.dasa.steps;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.*;
import br.com.dasa.util.Util;
public class Hooks {
	
	private static WebDriver driver;
	
	public Hooks() {
		driver = Util.GetDriver();
	}
	
	@Before
	public void SetBrowser() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Util.SetDriver(driver);
	}
	
	@After
	public void CloseBrowser() {
		driver.quit();
	}

}
