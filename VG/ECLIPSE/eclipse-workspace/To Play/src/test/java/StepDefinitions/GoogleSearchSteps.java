package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path+"/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
		
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
//System.out.println("test");
driver.navigate().to("https://google.com");
	}

	@When("user enters a text in search box page")
	public void user_enters_a_text_in_search_box_page() throws InterruptedException {
		//System.out.println("test");
		driver.findElement(By.name("q")).sendKeys("I am the best");
		Thread.sleep(2000);

		
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
		//System.out.println("test");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		//System.out.println("test");
		driver.getPageSource().contains("I Am the Best - Wikipedia");
		String str = driver.findElement(By.id("result-stats")).getText();
		System.out.println(str);
		driver.close();
		driver.quit();
	}

}
