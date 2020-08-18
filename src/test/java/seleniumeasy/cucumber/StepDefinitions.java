package seleniumeasy.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
//import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {
	
	     WebDriver driver;

	@Given("^I am able to launch the site$")
	public void i_am_able_to_launch_the_site() {
		System.setProperty("webdriver.gecko.driver", "C://Users//palak//Downloads//geckodriver.exe");
		driver=new FirefoxDriver();
	    driver.get("https://www.seleniumeasy.com/test/");
	    driver.manage().window().maximize();
	    WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'at-cv-lightbox-button-holder\']/a[2]"))).click();
	  
	
	}
	@Given("^I verify others tab is present$")
	public void i_verify_others_tab_is_present() {
		 boolean status = driver.findElement(By.linkText("Others")).isDisplayed();
		 Assert.assertEquals(true, status);
	}


	@When("^I click on Others Tab$")
	public void i_click_on_others_tab() {
		driver.findElement(By.linkText("Others")).click();
	    
	}

	@Then("^I verify (.*) is getting displayed$")
	public void i_verify_values_are_getting_displayed(String str) {
		 boolean status = driver.findElement(By.linkText(str)).isDisplayed();
		 Assert.assertEquals(true, status);
	}
	@When("^I click on (.*) in the drop down menu$")
	public void i_click_on_an_item_in_the_drop_down_menu(String str) {
		driver.findElement(By.linkText(str)).click();
	    
	}
	@Then("^I verify that it takes me to (.*) page$")
	public void i_verify_that_it_takes_me_to_another_page(String str) {
		if(driver.getCurrentUrl().contains(str)) {
			System.out.println("Navigated");
		}
		else System.out.println("Not navigated");
		
	}
	@Then("^I verify Drag and Drop Demo for Automation is displayed$")
	public void i_verify_drag_and_drop_demo_for_automation_is_displayed() {
		 boolean status = driver.findElement(By.xpath("//div[@class=\"col-md-6 text-left\"]/child::h2")).isDisplayed();
		 Assert.assertEquals(true, status);
	}
	@Then("^I verify items to drag is displayed$")
	public void i_verify_items_to_drag_is_displayed() {
		 if(driver.findElement(By.xpath("//div[@class=\"panel-body\"]/child::div[@id=\"todrag\"]")).isDisplayed()) {
			 System.out.println("Pass");
		 }
		 else System.out.println("Fail");
	}

	@Then("^I verify that drop here is displayed$")
	public void i_verify_that_drop_here_is_displayed() {
		 if(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/h2")).isDisplayed()) {
			 System.out.println("Pass");
		 }
		 else System.out.println("Fail");
	}

	@Then("^I verify that dropped items list is visible$")
	public void i_verify_that_dropped_items_list_is_visible() {
		 if(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/h3")).isDisplayed()) {
			 System.out.println("Pass");
		 }
		 else System.out.println("Fail");
	}
	@When("^I drag and drop an item to the drop here box$")
	public void i_drag_and_drop_an_item_to_the_drop_here_box() {
		WebElement dragged = driver.findElement(By.xpath("//*[@id=\"todrag\"]/span[1]"));
    WebElement dropped = driver.findElement(By.xpath("//*[@id=\"mydropzone\"]"));
    Actions builder = new Actions(driver);
    builder.dragAndDrop(dragged, dropped).perform();
		
	}

	@Then("^I verify The draggable is displayed on the dropped items list$")
	public void i_verify_the_draggable_is_displayed_on_the_dropped_items_list() {
		if(driver.findElement(By.xpath("//div[@id=\"droppedlist\"]/child::span")).isDisplayed()) {
			 System.out.println("Pass");
		 }
		 else System.out.println("Fail");
	}

	@Then("^I verify the same draggable dsplayed which was dropped$")
	public void i_verify_the_same_draggable_dsplayed_which_was_dropped() {
	   List<WebElement> checker=driver.findElements(By.xpath("//div[@class=\"w25 moveleft\"]/child::span"));
	   System.out.println(checker.size());
	}
	@Given("^I verify that a button named get new user under the Loading the data dynamically is present$")
	public void i_verify_that_a_button_named_get_new_user_under_the_loading_the_data_dynamically_is_present() {
		if((driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/h3")).isDisplayed())&&(driver.findElement(By.xpath("//*[@id=\"save\"]")).isDisplayed())) {
			 System.out.println("Pass");
		 }
		 else System.out.println("Fail");
	}

@When("^I click the get new user button$")
public void i_click_the_get_new_user_button() {
    driver.findElement(By.xpath("//div[@class=\"panel-body\"]/child::button[@id=\"save\"]")).click();
}

@Then("^I verify getting a new User and name and photo$")
public void i_verify_getting_a_new_user_and_name_and_photo() {
	WebElement element=new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loading']/img")));
	if((element.isDisplayed())&&(driver.findElement(By.xpath("//*[@id=\"loading\"]/text()[1]")).isDisplayed())&&(driver.findElement(By.xpath("//*[@id=\"loading\"]/text()[2]")).isDisplayed())) {
		 System.out.println("Pass");
	 }
	 else System.out.println("Fail");
}

@Given("^I verify display of data transfer block on the page$")
public void i_verify_display_of_data_transfer_block_on_the_page() {
	WebElement element=new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pie-chart-widget\"]")));
	if(element.isDisplayed()) {
		 System.out.println("Pass");
	 }
	
	
	 else System.out.println("Fail");
}

@Given("^I verify display of monthly volume and yearly change block$")
public void i_verify_display_of_monthly_volume_and_yearly_change_block() {
	if((driver.findElement(By.xpath("//*[@id=\"line-chart-widget\"]/div[3]")).isDisplayed())) {
		 System.out.println("Pass");
	 }
	 else System.out.println("Fail");
}


	
}
