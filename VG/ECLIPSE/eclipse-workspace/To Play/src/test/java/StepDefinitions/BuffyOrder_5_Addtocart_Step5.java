package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class BuffyOrder_5_Addtocart_Step5 {
	
	WebDriver driver = null;
	
	@Given("user is on the selected Laptop page")
	public void user_is_on_the_selected_laptop_page() throws InterruptedException {
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
		
		Thread.sleep(2000);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"col-lg-9\"]/div/div[5]/div/div/h4/a"))).click();
	  
	}

	@When("user selects Add to cart on the page")
	public void user_selects_add_to_cart_on_the_page() throws InterruptedException {
		Thread.sleep(2000);
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"))).click();

		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	  
	}

	@Then("user is presented with product added on the page")
	public void user_is_presented_with_product_added_on_the_page() {
	    
		driver.getPageSource().contains("2017 Dell 15.6 Inch");
	
		driver.close();
		driver.quit();
	}
	
	
	}
	

