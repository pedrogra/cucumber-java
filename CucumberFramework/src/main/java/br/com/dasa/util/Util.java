package br.com.dasa.util;

import org.openqa.selenium.WebDriver;

public class Util {
	public static WebDriver driver;
	
	public static WebDriver GetDriver() {
		return driver;
	}
	
	public static void SetDriver(WebDriver _drv) {
		driver = _drv;
	}
}
