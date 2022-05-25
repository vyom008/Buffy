package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class BuffyOrder_2_Login2_Step2 {
	WebDriver driver = null;
	@Given("user is on the demo blaze website Log in page")
	public void user_is_on_the_demo_blaze_website_log_in_page() throws InterruptedException {
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
	}

	@When("user enters username and password")
	public void user_enters_username_and_password() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("Test1");
		
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))).sendKeys("Test1");
		
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
	}

	@Then("user is navigated to demo blaze Home page")
	public void user_is_navigated_to_demo_blaze_home_page() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]"))).isDisplayed();
		
		driver.close();
		driver.quit();
	}
}
