package seleniumeasy.cucumber;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class listboxstepdefinition {
	WebDriver driver;
	WebDriverWait wait=null;
	@Given("^I login to the application$")
	public void i_login_to_the_application() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C://Users//palak//Downloads//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/");
		 wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'at-cv-lightbox-button-holder\']/a[2]")))
				.click();
	}

	@Given("^I click on list box tab$")
	public void i_click_on_list_box_tab() throws Throwable {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'List Box')]")).click();
	}

	
	@Then("^I verify three drop down values are getting displayed$")
	public void i_verify_three_drop_down_values_are_getting_displayed() throws Throwable {
		List<WebElement> elements = driver.findElements(
				By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu']//li"));
		System.out.println("count is" + elements.size());
		driver.quit();
	}

	@Given("^I click on bootstrap list box$")
	public void i_click_on_bootstrap_list_box() throws Throwable {
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Bootstrap List Box')]")).click();
	}

	@When("^I select (.*) from a list$")
	public void i_select_some_results_bootstrap_duallist(String str) throws Throwable {
		List<WebElement> liElements=driver.findElements(By.xpath("//div[@class='well text-right']//li[@class='list-group-item']"));
		for(int i=0;i<liElements.size();i++) {
			WebElement checking=liElements.get(i);
			if(str.equals(checking.getText())){
				checking.click();
			}
		}
	}

	
	
	
	@When("^I press the shift elements button$")
	public void i_press_the_shift_elements_button() throws Throwable {
		driver.findElement(By.xpath(
				"//div[@class='list-arrows col-md-1 text-center']/descendant::button[@class='btn btn-default btn-sm move-right']"))
				.click();
	}


	@Then("^I verify the (.*) are shifted$")
	public void i_verify_the_resultsbootstrap_duallist_are_shifted(String str) throws Throwable {
		WebElement first = driver.findElement(By.xpath(
				"//div[@class='well']/descendant::ul[@class='list-group']//li[contains(text(),str)]"));
		Assert.assertEquals(true, first.isDisplayed());
		driver.close();
	}

	

	@Given("^I click on data list filter tab$")
	public void i_click_on_data_list_filter_tab() throws Throwable {
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'Data List Filter')]")).click();
	}

	@Given("^I enter a value (.*) in box$")
	public void i_enter_a_value_Tyreese_Burn(String str) throws Throwable {
		Object search = driver.findElement(By.xpath("//div[@class='col-lg-12']//input[@id='input-search']"));
		((WebElement) search).sendKeys(str);
	}

	@Then("^I verify the results (.*) are shown$")
	public void i_verify_the_resultsTyreese_Burn_are_shown(String str) throws Throwable {

		List<WebElement> textDemo = driver.findElements(By.xpath("//*[contains(text(),'"+str+"')]"));
		System.out.println("Number of web elements: " + textDemo.size());
		if (textDemo.size() > 0) {
			System.out.println("element Tyreese Burn is present");
		} else {
			System.out.println("element Tyreese Burn is absent");
		}
//		driver.close();
	}
	@Given("^I click on JQuery$")
	public void i_click_on_JQuery() throws Throwable {
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[contains(text(),'JQuery List Box')]")).click();
	}

	@Given("^I select a result (.*) from list$")
	public void i_select_a_result_Alice(String str) throws Throwable {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'"+str+"')]"))).click();
	}

	@Given("^I click on Add button$")
	public void i_click_on_Add_button() throws Throwable {
		driver.findElement(By.xpath("//button[@class='pAdd btn btn-primary btn-sm']")).click();
	}

	@Then("^I verify result (.*) is added$")
	public void i_verify_result_Alice_is_added(String ste) throws Throwable {
		try {
			WebElement third = driver.findElement(By.xpath("//select[@class='form-control pickListSelect pickListResult']//option[contains(text(),'"+ste+"')]"));
			Assert.assertEquals(true, third.isDisplayed());
		} catch (AssertionError e) {
			System.out.println(ste+" is absent");
			throw e;
		}
		System.out.println(ste+" is present");

	}

	@When("^I select a result (.*) from second list$")
	public void i_select_a_resultAlice(String str) throws Throwable {
		driver.findElement(By.xpath("//select[@class='form-control pickListSelect pickListResult']//option[contains(text(),'"+str+"')]")).click();
	}

	@When("^I click on remove$")
	public void i_click_on_remove() throws Throwable {
		driver.findElement(By.xpath("//button[@class='pRemove btn btn-primary btn-sm']")).click();
	}

	@Then("^I verify the element (.*) is removed$")
	public void i_verify_the_element_Aliceis_removed(String ste) throws Throwable {
		List<WebElement> elements =driver.findElements(By.xpath("//select[@class='form-control pickListSelect pickListResult']//option[contains(text(),'"+ste+"')]"));
		if(elements.size()==0){
		    System.out.println("Element"+ste+" has been removed");

		 } else {
		    System.out.println(ste+" has not been removed");
		 }
		driver.close();
	}

	
	@When("^I click on addall button$")
	public void i_click_on_addall_button() throws Throwable {
	   driver.findElement(By.xpath("//button[@class='pAddAll btn btn-primary btn-sm']")).click();
	}

	

	@Then("^when I click on removeall button$")
	public void when_I_click_on_removeall_button() throws Throwable {
	driver.findElement(By.xpath("//button[@class='pRemoveAll btn btn-primary btn-sm']")).click();   
	}

	@Then("^I verify that all the results are added$")
	public void i_verify_that_all_the_results_are_added() throws Throwable {
		List<WebElement> elements = driver.findElements(By.xpath("//select[@class='form-control pickListSelect pickListResult']//option"));
		System.out.println("count of elements after the action Addall " + elements.size());
		if(elements.size()==15) {
			System.out.println("All elements ADDED");
		}
		else {
			System.out.println("All elements NOT Added");
		}
		
	}

	@Then("^I verify  all the results are removed$")
	public void i_verify_all_the_results_are_removed() throws Throwable {
		List<WebElement> links = driver.findElements(By.xpath("//select[@class='form-control pickListSelect pickListResult']//option"));
		System.out.println("count of elements after the action RemoveAll " + links.size());
		if(links.size()>0) {
			System.out.println("All elements NOT removed");
		}
		else {
			System.out.println("All elements have been removed");
		}
		
//		driver.close();
	}
}
