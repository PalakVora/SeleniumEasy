package seleniumeasy.cucumber;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class inputtabstepdefinition {
	WebDriver driver;
	WebElement element;
	@Given("^I open the application$")
	public void I_open_the_application() throws Throwable{
		System.setProperty("webdriver.chrome.driver","C://Users//palak//Downloads//chromedriver.exe");
		driver = new ChromeDriver();
        driver.get("https://www.seleniumeasy.com/test/");
       // driver.findElement(By.xpath("//*[@id=\"block-block-57\"]/div/div/a")).click();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'at-cv-lightbox-button-holder\']/a[2]"))).click();
  }
	
	@And("^I click on Input Forms Tab$")
	public void I_click_on_Input_Forms_Tab() throws Throwable{
		driver.findElement(By.xpath("//*['@id=navbar-brand-centere']/ul[1]/li[1]/a")).click();
	}
	
	@Then("^I verify seven dropdown values are getting displayed$")
	public void I_verify_seven_dropdown_values_are_getting_displayed() throws Throwable{
		List<WebElement> seven = driver.findElements(By.xpath("//ul[contains(@class, 'dropdown-menu')]"));
		int s = seven.size();	
		int e = 7;
		Assert.assertEquals(e, s);
	}
	
	//ShowButton 
	@And("^I click on sub tab Simple form demo$")
	public void I_click_on_sub_tab_Simple_form_demo() throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[1]/a")).click();
	}
	
	@And("^I enter some message (.*) into enter message textbox$")
	public void I_enter_some_message_message_into_enter_message_textbox(String message) throws Throwable{
		element=new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"user-message\"]")));
		element.sendKeys(message);
		//driver.findElement(By.xpath("//*[@id=\"user-message\"]")).sendKeys(message);
	}
	
	@And("^I click on show button$")
	public void I_click_on_show_button() throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"get-input\"]/button")).click();
	}
	
	@Then("^I verify (.*) is getting displayed correctly$")
	public void I_verify_output_message_is_getting_displayed_as_the_message(String message) {
		element=new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"display\"]")));
		WebElement element1= element;
		String val=element1.getAttribute("innerText");
		Assert.assertEquals(message, val); 
	}
	
	//GetTotalButton
	@And("^I enter some number (\\d+) into the enter a textbox$")
	public void I_enter_some_number_no_into_the_enter_a_textbox(String no1) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"sum1\"]")).sendKeys(no1);
	}
	@And("^I enter some number (\\d+) into the enter b textbox$")
	public void I_enter_some_number_no_into_the_enter_b_textbox(String no2) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"sum2\"]")).sendKeys(no2);
	}
	
	@And("^I click on Sum button$")
	public void I_click_on_Sum_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
	}
	
	@Then("^I verify sum of (\\d+) and (\\d+) is the sum being displayed$")
	public void I_verify_output_sum_is_getting_displayed_as_their_sum(int no1, int no2) throws Throwable{
		int ExpectedRes = no1 + no2;
		element=new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"displayvalue\"]")));
		WebElement element1= element;
		String val=element1.getAttribute("innerText");
		int check1=Integer.parseInt(val);
		if(ExpectedRes==check1) {
			System.out.println("pass");
		}
		else System.out.println("Fail");
	}	
	
	//CheckSingleCheckBox
	@And("^I click on sub tab CheckBox Demo$")
	public void I_click_on_sub_tab_CheckBox_Demo() throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[2]/a")).click();
		
	}
		
	@And("^I check the given CheckBox$")
	public void I_check_the_given_CheckBox() throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/div[1]/label")).click();
		
	}
	
	@Then("^I verify output message is getting displayed as checked$")
	public void I_verify_output_message_is_getting_displayed_as_checked() throws Throwable{
		if( driver.findElement(By.xpath("//*[@id=\"txtAge\"]")).isDisplayed()){
			System.out.println("Element is Visible");
			}
	}
	
	//CheckMultipleCheckbox
	@And("^I click on Check All button$")
	public void I_click_on_Check_All_button() throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"check1\"]")).click();
	}
	
	@And("^I verify the button is Uncheck all$")
	public void I_verify_the_button_is_Uncheck_all() throws Throwable{
		String ExpectedRes = "Uncheck All";
		String Actual = driver.findElement(By.xpath("//*[@id=\"check1\"]")).getAttribute("value");
		Assert.assertEquals(ExpectedRes, Actual); 
	}
	
	@And("^I click the Uncheck All button$")
	public void I_click_the_Uncheck_All_button() throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"check1\"]")).click();
	}
	
	@Then("^I verify the button is check all$")
	public void I_verify_the_button_is_check_all() throws Throwable{
		String ExpectedRes = "Check All";
		String Actual = driver.findElement(By.xpath("//*[@id=\"check1\"]")).getAttribute("value");
		Assert.assertEquals(ExpectedRes, Actual); 
	}
	
	//RadioButton
	@And("^I click on sub tab RadioButton Demo$")
	public void I_click_on_sub_tab_RadioButton_Demo() throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[3]/a")).click();
	}
	
	@Then("^I check one of the radiobuttons and verify$")
	public void I_check_one_of_the_radiobuttons_and_verify() throws Throwable{
		List<WebElement> a = driver.findElements(By.xpath("//input[contains(@name,'optradio')]"));
		int b=a.size();
	        for(int i=0;i<b;i++)  
	        {  	WebElement T= driver.findElements(By.xpath("//input[contains(@name,'optradio')]")).get(i);
	        	String Expected = T.getText();
	            driver.findElements(By.xpath("//input[contains(@name,'optradio')]")).get(i).click();
	            driver.findElement(By.xpath("//*[@id=\"buttoncheck\"]")).click();
	            WebElement element= driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[3]"));  
	    		String val=element.getAttribute("innerText");
	    		Boolean bol=val.contains(Expected);
	    		Assert.assertEquals(bol, true); 
	        } 
	}
	
	//multipleradio
	@Then("^I check one of the mradiobuttons and verify$")
	public void I_check_one_of_the_mradiobuttons_and_verify() throws Throwable{
		List<WebElement> a = driver.findElements(By.xpath("//input[contains(@name,'gender')]"));
		int x=a.size();
		List<WebElement> b = driver.findElements(By.xpath("//input[contains(@name,'ageGroup')]"));
		int y=b.size();
		for(int i=0; i<x;i++) {
			WebElement gender= driver.findElements(By.xpath("//input[contains(@name,'optradio')]")).get(i);
        	String ExpectedG = gender.getText();
			driver.findElements(By.xpath("//input[contains(@name,'gender')]")).get(i).click();
			for(int j=0;j<y;j++) {
				WebElement age = driver.findElements(By.xpath("//input[contains(@name,'optradio')]")).get(i);
	        	String ExpectedA = age.getText();
				driver.findElements(By.xpath("//input[contains(@name,'ageGroup')]")).get(j).click();
				driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")).click();
	            WebElement element= driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]"));  
	    		String val=element.getAttribute("innerText");
	    		Boolean bol1=val.contains(ExpectedG);
	    		Assert.assertEquals(bol1, true); 
	    		Boolean bol2=val.contains(ExpectedA);
	    		Assert.assertEquals(bol2, true); 
			}
		}
	}
	
	//selectlist
	@And("^I click on Select Dropdown list$")
	public void I_click_on_Select_Dropdown_list() throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[4]/a")).click();
	}
	
	@Then("^I click on options of dropdown and verify$")
	public void I_click_on_options_of_dropdown_and_verify() throws Throwable{
		Select days = new Select(driver.findElement(By.id("select-demo")));
		List<WebElement> listOptionDropdown = days.getOptions();
		int dt = listOptionDropdown.size();
		for(int i = 0; i<dt ;i++) {
		Select day = new Select(driver.findElement(By.id("select-demo")));
		day.selectByIndex(i);
		String s = day.getFirstSelectedOption().getText();
        WebElement element1= driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/p[2]"));  
		String val1= element1.getAttribute("innerText"); 
		if(val1.contains(s) && s!="Please select")
		{
			System.out.println("matched");
		}
		
	}
}
	
	//Form
	@And("^I click on sub input form submit$")
	public void I_click_on_sub_input_form_submit() throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[1]/li[1]/ul/li[5]/a")).click();
	}
	
	@And("^I enter first name (.*) and (.*) into textbox1$")
	public void I_enter_first_name_and_into_textbox1(String fname, String lname) throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[1]/div/div/input")).sendKeys(fname);
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[2]/div/div/input")).sendKeys(lname);
	}
	
	@And("^I enter email (.*) and (\\d+) into textbox2$")
	public void I_enter_email_and_into_textbox2(String email, String Phno) throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[3]/div/div/input")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[4]/div/div/input")).sendKeys(Phno);
	}
	
	@And("^I enter address (.*) and (.*) into textbox3$")
	public void I_enter_address_and_into_textbox3(String add, String city) throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[5]/div/div/input")).sendKeys(add);
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[6]/div/div/input")).sendKeys(city);
	}
	
	@And("^I select state from the state drop-down list$")
	public void I_select_state_from_the_state_dropdown_list() throws Throwable{
		Select state = new Select(driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select")));
		List<WebElement> listOptionDropdown = state.getOptions();
		int dt = listOptionDropdown.size();
		for(int i = 0; i<dt ;i++) {
		Select day = new Select(driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[7]/div/div/select")));
		day.selectByIndex(i);
		String s = day.getFirstSelectedOption().getText();
		System.out.println(s);
		}
		state.selectByIndex(5);
		
	}
	
	@And("^I enter zip code (\\d+) and (.*) into textboxes$")
	public void I_enter_zip_code_and_into_textboxes(String zip, String web) throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[8]/div/div/input")).sendKeys(zip);
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[9]/div/div/input")).sendKeys(web);
	}
	
	@And("^I select one of the radiobuttons indicating hosting$")
	public void I_select_one_of_the_radiobuttons_indicating_hosting() throws Throwable{
		List<WebElement> a = driver.findElements(By.xpath("//input[contains(@name,'hosting')]"));
		int b=a.size();
	        for(int i=0;i<b;i++)  
	        {  	WebElement T= driver.findElements(By.xpath("//input[contains(@name,'hosting')]")).get(i);
	        	String Expected = T.getText();
	            driver.findElements(By.xpath("//input[contains(@name,'hosting')]")).get(i).click();
	            System.out.println(Expected);
	        } 
	}
	
	@Then("^I enter project description (.*) into project textbox and send$")
	public void I_enter_project_description_into_project_textbox_and_send(String proj) throws Throwable{
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[11]/div/div/textarea")).sendKeys(proj);
		driver.findElement(By.xpath("//*[@id=\"contact_form\"]/fieldset/div[13]/div/button")).click();
	}
}
