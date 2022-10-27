package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSelectMenu {
	
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
	
	@Given("User go to https:\\/\\/demoqa.com\\/select-menu")
	public void user_go_to_https_demoqa_com_select_menu() {
		
		driver.get("https://demoqa.com/select-menu");
	}

	@When("User in select menu page")
	public void user_in_select_menu_page() {
	    
		String actualResult = driver.findElement(By.xpath("//div[@class='main-header']")).getText();
		String expectedResult = "Select Menu";
		Assert.assertEquals(actualResult, expectedResult);
	}

	@When("User choose select value Another root option")
	public void user_choose_select_value_another_root_option() {
	    
		driver.findElement(By.xpath("//input[@id='react-select-2-input']")).
		sendKeys("Another root option", Keys.ENTER);
	}

	@When("User choose select one Other")
	public void user_choose_select_one_other() {
	   
		driver.findElement(By.xpath("//input[@id='react-select-3-input']")).
		sendKeys("Other", Keys.ENTER);
	}

	@When("User choose old style select menu Aqua")
	public void user_choose_old_style_select_menu_aqua() {
	    
		Select values = new Select(driver.findElement(By.id("oldSelectMenu")));
		values.selectByVisibleText("Aqua");
	}

	@When("User choose multi select drop down all color")
	public void user_choose_multi_select_drop_down_all_color() {
	    
		WebElement multiSelectDropdown = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
		multiSelectDropdown.sendKeys("Green", Keys.ENTER);
		multiSelectDropdown.sendKeys("Blue", Keys.ENTER);
		multiSelectDropdown.sendKeys("Black", Keys.ENTER);
		multiSelectDropdown.sendKeys("Red", Keys.ENTER);
	}

	@Then("User success input all select menu")
	public void user_success_input_all_select_menu() {
	   
		String actualResult = driver.findElement(By.xpath("//*[contains(text(),'No options')]")).getText();
		String expectedResult = "No options";
		Assert.assertEquals(actualResult, expectedResult);
	}

}
