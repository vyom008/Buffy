package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class BuffyOrder_8_Success_Step8 {

	WebDriver driver = null;

	@Given("user is on the place order page")
	public void user_is_on_the_place_order_page() throws InterruptedException {


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

		Thread.sleep(2000);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a"))).click();

		Thread.sleep(3000);
		driver.switchTo().alert().accept();

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartur"))).click();
		Thread.sleep(2000);

		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"))).click();
	}




	@And("user enters all the details such as Name, Country, City, Credit Card Number and expiry month\\/ year")
	public void user_enters_all_the_details_such_as_name_country_city_credit_card_number_and_expiry_month_year() throws InterruptedException {
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys("BAT MAN");


		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("country"))).sendKeys("New Zealand");


		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).sendKeys("Wellington");

		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("card"))).sendKeys("101101110110");

		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("month"))).sendKeys("March");

		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.id("year"))).sendKeys("2023");
		Thread.sleep(2000);

	}

	@When("user clicks on clicks Purchase on the page")
	public void user_clicks_on_clicks_purchase_on_the_page() throws InterruptedException {
		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"))).click();

		Thread.sleep(2000);

	}

	@Then("Purchase Success message will be displayed and details will be noted")
	public void purchase_success_message_will_be_displayed_and_details_will_be_noted() {

		WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(120, 1));
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[10]/h2"))).isDisplayed();

		String text= driver.findElement(By.xpath("/html/body/div[10]/p")).getText();

		//String text= driver.findElement(By.xpath("(/html/body/div[10]/p/text())[1]")).getText();
		System.out.println(text);
		driver.close();
		driver.quit();
	}
}


