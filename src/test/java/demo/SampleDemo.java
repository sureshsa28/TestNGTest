package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleDemo {

	WebDriver driver;

	@BeforeTest
	public void startUp() {

		WebDriverManager.chromedriver().setup();  // download web driver
		driver =new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		driver.manage().window().maximize();

	}

	@Test(priority=1)
	public void provideName()
	{
		WebElement firstname = driver.findElement(By.id("FirstName"));
		WebElement lastname = driver.findElement(By.id("LastName"));
		firstname.sendKeys("Jacky");
		lastname.sendKeys("jully");
	}

	@Test(priority=0)
	public void genderSelect() {

		WebElement male = driver.findElement(By.id("gender-male"));
		male.click();
		boolean displayed = male.isDisplayed();
		System.out.println(displayed);
	}

	@Test(priority=2)
	public void dropDown() {
		WebElement dateDropdown = driver.findElement(By.name("DateOfBirthDay"));
		WebElement monthDropdown = driver.findElement(By.name("DateOfBirthMonth"));
		WebElement yearDropdown = driver.findElement(By.name("DateOfBirthYear"));

		Select dateSelect = new Select(dateDropdown);
		Select monthSelect = new Select(monthDropdown);
		Select yearSelect = new Select(yearDropdown);

		dateSelect.selectByValue("18");
		monthSelect.selectByIndex(6);
		yearSelect.selectByVisibleText("2000");

	}


	@AfterTest
	public void methodTwo() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}


}
