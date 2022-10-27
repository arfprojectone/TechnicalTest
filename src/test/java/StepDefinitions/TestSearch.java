package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSearch {

	WebDriver driver;

	@Before
	public void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@After
	public void tearDown() {

		driver.quit();
	}

	@Given("User go to https:\\/\\/demoqa.com\\/books")
	public void user_go_to_https_demoqa_com_books() {

		driver.get("https://demoqa.com/books");
	}

	@When("User in Book Store page")
	public void user_in_book_store_page() {

		String actualResult = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
		String expectedResult = "Book Store";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@When("User search book qa engineer")
	public void user_search_book_qa_engineer() {

		driver.findElement(By.id("searchBox")).sendKeys("qa engineer", Keys.ENTER);
	}

	@Then("User see No rows found")
	public void user_see_no_rows_found() {

		String actualResult = driver.findElement(By.xpath("//div[normalize-space()='No rows found']")).getText();
		String expectedResult = "No rows found";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@When("User search book Git Pocket Guide")
	public void user_search_book_git_pocket_guide() {

		driver.findElement(By.id("searchBox")).sendKeys("Git Pocket Guide", Keys.ENTER);
	}

	@When("User click book Git Pocket Guide")
	public void user_click_book_git_pocket_guide() {

		driver.findElement(By.xpath("//a[normalize-space()='Git Pocket Guide']")).click();
	}

	@Then("User see Git Pocket Guide")
	public void user_see_git_pocket_guide() {

		GetterSetterTestSearch GS = new GetterSetterTestSearch("Git Pocket Guide", "Richard E. Silverman", "O'Reilly Media");

		String actualTitle = driver.findElement(By.xpath("//div[@id='title-wrapper']//label[@id='userName-value']")).getText();
		String expectedTitle = GS.title;
		Assert.assertEquals(actualTitle, expectedTitle);

		String actualAuthor = driver.findElement(By.xpath("//div[@id='author-wrapper']//label[@id='userName-value']")).getText();
		String expectedAuthor = GS.author;
		Assert.assertEquals(actualAuthor, expectedAuthor);

		String actualPublisher = driver.findElement(By.xpath("//div[@id='publisher-wrapper']//label[@id='userName-value']")).getText();
		String expectedPublisher = GS.publisher;
		Assert.assertEquals(actualPublisher, expectedPublisher);
	}
}
