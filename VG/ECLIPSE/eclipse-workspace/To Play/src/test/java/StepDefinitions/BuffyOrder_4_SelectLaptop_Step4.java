package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class BuffyOrder_4_SelectLaptop_Step4 {
	
	WebDriver driver = null;
	
	@Given("user is on demo blaze website Laptops only page")
	public void user_is_on_demo_blaze_website_laptops_only_page() throws InterruptedException {
	    
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path+"/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
		driver.navigate().to("https://www.demoblaze.com/index.html#");
		driver.manage().window().maximize();

		driver.findElement(By.id("login2")).click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("Test1");
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))).sendKeys("Test1");
		
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		
		Thread.sleep(2000);
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"list-group\"]/a[3]"))).click();
	}

	@When("user selects Laptop on the page")
	public void user_selects_laptop_on_the_page() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"col-lg-9\"]/div/div[5]/div/div/h4/a"))).click();
	    
	}

	@Then("user is navigated to the selected Laptop page")
	public void user_is_navigated_to_the_selected_laptop_page() {
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/h2"))).isDisplayed();
		
		driver.close();
		driver.quit();
	    
	}

	
	
	}
	

