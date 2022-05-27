package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class BuffyOrder_1_OpenWebsite_Step1 {
	WebDriver driver = null;
	@Given("chrome browser is open")
	public void chrome_browser_is_open() {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path+"/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	



	}

	@Given("selects to open demo blaze website and is on the home page")
	public void selects_to_open_demo_blaze_website_and_is_on_the_home_page() {
		driver.navigate().to("https://www.demoblaze.com/index.html#");
		driver.manage().window().maximize();

	}

	@When("user clicks on Log in")
	public void user_clicks_on_log_in() throws InterruptedException {

		driver.findElement(By.id("login2")).click();
		Thread.sleep(2000);
	}

	@Then("user is navigated to Log in page")
	public void user_is_navigated_to_log_in_page() {
		//driver.getPageSource().contains("Log in");

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logInModalLabel\"]"))).isDisplayed();
		driver.close();
		driver.quit();
	}

}
