package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class BuffyOrder_6_Gotocart_Step6 {

	WebDriver driver = null;


	@Given("user is successfully able to add Laptop in the cart and is on the Laptop page")
	public void user_is_successfully_able_to_add_laptop_in_the_cart_and_is_on_the_laptop_page() throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path+"/src/main/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
		driver.navigate().to("https://www.demoblaze.com/index.html#");
		driver.manage().window().maximize();

		driver.findElement(By.id("login2")).click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys("Test7");

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginpassword"))).sendKeys("Test7");

		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

		Thread.sleep(2000);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"list-group\"]/a[3]"))).click();

		Thread.sleep(2000);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"col-lg-9\"]/div/div[5]/div/div/h4/a"))).click();

		Thread.sleep(2000);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"))).click();

		Thread.sleep(3000);
		driver.switchTo().alert().accept();

	}

	@When("user selects Cart button on the page")
	public void user_selects_cart_button_on_the_page() {

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartur"))).click();
	}

	@Then("user is presented with product they have selected")
	public void user_is_presented_with_product_they_have_selected() {


		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"))).isDisplayed();

		driver.close();
		driver.quit();

	}

}


