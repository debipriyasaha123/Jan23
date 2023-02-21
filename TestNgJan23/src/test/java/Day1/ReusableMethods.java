package Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ReusableMethods {

static WebDriver driver = null;
public static void GetDriverInstance (String browserName) {
		
		switch(browserName) {
		case "edge":       WebDriverManager.edgedriver().setup();
		                   driver = new EdgeDriver();
		                   driver.manage().window().maximize();
		                   break;
		                
		case "chrome":     WebDriverManager.chromedriver().setup();
                           driver = new ChromeDriver();
                           driver.manage().window().maximize();
                           break;  
                           
        default :          System.out.println("Proper browsername not entered");                   
		}
	}	
	
public static void GoToUrl(String url) {
	
	driver.get(url);
	
}
public static void enterText (WebElement element, String text, String name) {
	if (element.isDisplayed()) {
		element.clear();
		element.sendKeys(text);
	}
	else {
		System.out.println(name + "Webelement is not displayed");
}
    driver.getTitle();
}

}
	
