package khan_StepDef;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;






public class KhanStepdef_Test {

	
	public WebDriver driver;
	public TakesScreenshot pic;
	
	
	@Given("user is on Homepage of Khan Academy")
	public void user_is_on_homepage_of_khan_academy() {
	    
	 driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.khanacademy.org/");
		driver.manage().window().maximize();	
		pic = (TakesScreenshot)driver;
		
		
	}

	@When("user scroll down the home page")
	public void user_scroll_down_the_home_page() throws IOException {
	    
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement ele = driver.findElement(By.xpath("(//h2[@class='_ji9nyhl'])[1]"));
		js.executeScript("arguments[0].scrollIntoView()",ele);
		
	File sc=pic.getScreenshotAs(OutputType.FILE);
		File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
		FileHandler.copy(sc, dpic);
	}

	@Then("user should verify the right position")
	public void user_should_verify_the_right_position() {
	   
		WebElement ele0 = driver.findElement(By.xpath("(//h2[@class='_ji9nyhl'])[1]"));
		Assert.assertTrue(ele0.getText().endsWith(" can learn anything."),"page is not scroll");
		System.out.println("page is scroll successfuly");
		driver.quit();
	}
////////////////////////////////////////////////////////////////////////////
	@When("user scroll up the Homepage")
	public void user_scroll_up_the_homepage() throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement ele = driver.findElement(By.xpath("(//h2[@class='_ji9nyhl'])[1]"));
		js.executeScript("arguments[0].scrollIntoView()",ele);
		Thread.sleep(5000);
		js.executeScript("window.scrollTo(0,0)");
		File sc=pic.getScreenshotAs(OutputType.FILE);
		File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
		FileHandler.copy(sc, dpic);
	}

	@Then("user should verify title of Homepage")
	public void user_should_verify_title_of_homepage() {
	   String title =  driver.getTitle();
		Assert.assertTrue(title.equalsIgnoreCase("Khan Academy | Free Online Courses, Lessons & Practice"),"title mismatch");
		System.out.println("title of the page is match");
		driver.quit();
	}
////////////////////////////////////////////////////////////////////////////////////////
	@When("user click on signup button")
	public void user_click_on_signup_button() {
	    
		driver.findElement(By.linkText("Sign up")).click();
		
	}

	@When("user should select date of birth")
	public void user_should_select_date_of_birth() {
driver.findElement(By.xpath("(//span[@class='_yxstdzi'])[1]")).click();
		
		driver.findElement(By.xpath("//button [@type='button'][3]")).click();
		
		driver.findElement(By.xpath("(//span[@class='_yxstdzi'])[2]")).click();
			
		driver.findElement(By.xpath("(//span[@class='_1x4jm3wp'])[25]")).click();
		
		driver.findElement(By.xpath("(//span[@class='_yxstdzi'])[3]")).click();
		
		driver.findElement(By.xpath("(//span[@class='_1x4jm3wp'])[24]")).click();
		
	}

	@When("click on signup with Email button")
	public void click_on_signup_with_email_button() {
		driver.findElement(By.xpath("(//button[@type='button'])[12]")).click();
	}

	@When("user should fill Email {string}")
	public void user_should_fill_email(String email) {
		driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys(email);
	}

	@When("user fill first name {string}")
	public void user_fill_first_name(String fname) {
	    
		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys(fname);
	}

	@When("user fill last name {string}")
	public void user_fill_last_name(String sname) {
	    
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(sname);
	}

	@When("user fill password {string}")
	public void user_fill_password(String psw) throws IOException {
	    
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(psw);
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		File sc=pic.getScreenshotAs(OutputType.FILE);
		File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
		FileHandler.copy(sc, dpic);
	}

	@Then("user should navigate to the login page")
	public void user_should_navigate_to_the_login_page() {
	   Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Sign up | Khan Academy"),"registration fail");
		System.out.println("registration successful");
		driver.quit();
	}
//////////////////////////////////////////////////////////////////////////2
	@When("user click on login button")
	public void user_click_on_login_button() {
	    
		driver.findElement(By.linkText("Log in")).click();
		
	}

	@When("user pass Email {string}")
	public void user_pass_email(String email) throws InterruptedException {
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//input [@name='username']")).sendKeys(email);
	}

	@When("user pass password {string}")
	public void user_pass_password(String psw) {
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(psw);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	@Then("user should not able to login")
	public void user_should_not_able_to_login() throws InterruptedException, IOException {
		 
		Thread.sleep(10000);
		Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Dashboard | Khan Academy"), "login success");
		System.out.println("login unsuccessful");
		File sc=pic.getScreenshotAs(OutputType.FILE);
		File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
		FileHandler.copy(sc, dpic);
			
		driver.quit();
	}

	@Then("user should navigate to the student dashbord page")
	public void user_should_navigate_to_the_student_dashbord_page() throws InterruptedException, IOException {
	    Thread.sleep(20000);
	    Assert.assertTrue(driver.getTitle().equalsIgnoreCase("Dashboard | Khan Academy"), "login unsuccessful");
		System.out.println("login sucessful");
		File sc=pic.getScreenshotAs(OutputType.FILE);
		File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
		FileHandler.copy(sc, dpic);
		driver.quit();
	}
//////////////////////////////////////////////////////////////////////////////////////////
	@When("user present on dashbord page")
	public void user_present_on_dashbord_page() throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input [@name='username']")).sendKeys("11aa22cc@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123!@#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}

	@When("user click on dropdown")
	public void user_click_on_dropdown() {
		
		driver.findElement(By.xpath("//button[@data-testid='user-dropdown']")).click();
		
	}

	@When("user click on logout button")
	public void user_click_on_logout_button() throws IOException {
	    
		driver.findElement(By.xpath("(//ul[@data-testid='header-user-settings']//li)[4]")).click();
		File sc=pic.getScreenshotAs(OutputType.FILE);
		File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
		FileHandler.copy(sc, dpic);
	}

	@Then("user should be logout")
	public void user_should_be_logout() throws InterruptedException {
	    
		Thread.sleep(10000);
		Assert.assertTrue(driver.getCurrentUrl().endsWith("//www.khanacademy.org/"),"logout un successful");
		System.out.println("logout successful");
		driver.quit();
	}
///////////////////////////////////////////////////////////////////////////////////////////
	@When("user click on searchbox")
	public void user_click_on_searchbox() throws InterruptedException {
	   
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input [@name='username']")).sendKeys("11aa22cc@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123!@#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(15000);
		 driver.findElement(By.xpath("//button [@class='_1pd0xval']")).click();
		
		
	}

	@When("user write physics in searchbox")
	public void user_write_physics_in_searchbox() throws IOException {
	   
			WebElement box = driver.findElement(By.xpath("//input [@class='_amr4iqp']"));
			
			box.sendKeys("physics",Keys.ENTER);
			
			File sc=pic.getScreenshotAs(OutputType.FILE);
			File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
			FileHandler.copy(sc, dpic);
	}
	
	

	@Then("user should see the result")
	public void user_should_see_the_result() {
	   
		Assert.assertTrue(driver.getCurrentUrl().endsWith("search_query=physics"), "test fail");
		System.out.println("user show result wrt physics");
	}
///////////////////////////////////////////////////////////////////////////////////////////
	@When("user show all the physics result")
	public void user_show_all_the_physics_result() throws InterruptedException {
	    
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input [@name='username']")).sendKeys("11aa22cc@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123!@#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(15000);
		 driver.findElement(By.xpath("//button [@class='_1pd0xval']")).click();
		 WebElement box = driver.findElement(By.xpath("//input [@class='_amr4iqp']"));
			
			box.sendKeys("physics",Keys.ENTER);
	}

	@When("user click on video radio button")
	public void user_click_on_video_radio_button() {
	    
		driver.findElement(By.xpath("(//input[@class='_1pjoc0q2'])[17]")).click();
	}

	@When("user select specific video")
	public void user_select_specific_video() {
		
		driver.findElement(By.xpath("(//span [@class='_w68pn83'])[2]")).click();
	}

	@Then("user should go to video page")
	public void user_should_go_to_video_page() throws IOException {
	    
		File sc=pic.getScreenshotAs(OutputType.FILE);
		File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
		FileHandler.copy(sc, dpic);
		Assert.assertTrue(driver.getCurrentUrl().endsWith("one-dimensional-motion/displacement-velocity-time/v/introduction-to-physics"), "test fail");
		System.out.println("see specific video");
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@When("user present on video page")
	public void user_present_on_video_page() throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input [@name='username']")).sendKeys("11aa22cc@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123!@#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(15000);
		 driver.findElement(By.xpath("//button [@class='_1pd0xval']")).click();
		 WebElement box = driver.findElement(By.xpath("//input [@class='_amr4iqp']"));
			
			box.sendKeys("physics",Keys.ENTER); 
		
			driver.findElement(By.xpath("(//input[@class='_1pjoc0q2'])[17]")).click();
			driver.findElement(By.xpath("(//span [@class='_w68pn83'])[2]")).click();
	}

	@When("user click on youtube button")
	public void user_click_on_youtube_button() {
	    
		
		driver.navigate().to("https://www.youtube.com/watch?v=uIojjqSm0m4");
		
	}

	@Then("user should go to youtube page")
	public void user_should_go_to_youtube_page() throws IOException {
	    
		File sc=pic.getScreenshotAs(OutputType.FILE);
		File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
		FileHandler.copy(sc, dpic);
		Assert.assertTrue(driver.getCurrentUrl().endsWith("youtube.com/watch?v=uIojjqSm0m4"), "not navigate to youtube");
		System.out.println("navigate to youtube");
		
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	@When("user click on video")
	public void user_click_on_video() throws InterruptedException {
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input [@name='username']")).sendKeys("11aa22cc@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123!@#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(15000);
		 driver.findElement(By.xpath("//button [@class='_1pd0xval']")).click();
		 WebElement box = driver.findElement(By.xpath("//input [@class='_amr4iqp']"));
			
			box.sendKeys("physics",Keys.ENTER); 
		
			driver.findElement(By.xpath("(//input[@class='_1pjoc0q2'])[17]")).click();
			driver.findElement(By.xpath("(//span [@class='_w68pn83'])[2]")).click();
		
		driver.findElement(By.xpath("//button [@class='_1lwv0f3']")).click();
		Thread.sleep(10000);
	}

	@When("user click on pause button")
	public void user_click_on_pause_button() throws InterruptedException {
	   
	
		driver.switchTo().frame("ka-player-iframe");
		 driver.findElement(By.xpath("//button [@title='Pause (k)']")).click();
		
	}

	@Then("user should show video")
	public void user_should_show_video() throws IOException {
	    
		File sc=pic.getScreenshotAs(OutputType.FILE);
		File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
		FileHandler.copy(sc, dpic);
		Assert.assertTrue(driver.getCurrentUrl().endsWith("introduction-to-physics"),"fail to see video");
		System.out.println("see the video successfully");
	}
/////////////////////////////////////////////////////////////////////////////////////////
	@When("click on Explore dropdown")
	public void click_on_explore_dropdown() throws InterruptedException {
	   
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input [@name='username']")).sendKeys("11aa22cc@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123!@#");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[@class='_19zgqrew']")).click();
	}

	@Then("show all result in console")
	public void show_all_result_in_console() throws IOException {
		//Topic no : 1
				WebElement math = driver.findElement(By.xpath("(//span [@class='_1uk4ltt6'])[1]"));
				System.out.print(math.getText());
				
				List <WebElement> mathsub = driver.findElements(By.xpath("(//ul [@class='_121xeo4'])[1]//span [@class='_u1utz4z']"));
				
				for (WebElement i : mathsub) {
					
					System.out.print("   "+i.getText()+"   ");
				}
				
				System.out.println();
				
				//Topic no : 2
				WebElement foundation = driver.findElement(By.xpath("(//span [@class='_1uk4ltt6'])[2]"));
				System.out.print(foundation.getText());
				
				List <WebElement> foundationsub = driver.findElements(By.xpath("(//ul [@class='_121xeo4'])[2]//span [@class='_u1utz4z']"));
				for (WebElement i1 : foundationsub) {
					
					System.out.print("   "+i1.getText()+"   ");
				}
				System.out.println();
				
				
				//Topic no : 3 
				WebElement maha = driver.findElement(By.xpath("(//span [@class='_1uk4ltt6'])[3]"));
				System.out.print(maha.getText());
				
				List <WebElement> mahasub = driver.findElements(By.xpath("(//ul [@class='_121xeo4'])[3]//span [@class='_u1utz4z']"));
				for (WebElement i2 : mahasub) {
					System.out.print("   "+i2.getText()+"   ");
				}
				System.out.println();
				
				
				//Topic no : 4
				WebElement ncert = driver.findElement(By.xpath("(//span [@class='_1uk4ltt6'])[4]"));
				System.out.print(ncert.getText());
				
				List <WebElement> ncertsub = driver.findElements(By.xpath("(//ul [@class='_121xeo4'])[4]//span [@class='_u1utz4z']"));
				for (WebElement i3 : ncertsub) {
					
					System.out.print("   "+i3.getText()+"   ");
				}
				System.out.println();
				
				// Topic no : 5 
				WebElement state = driver.findElement(By.xpath("(//span [@class='_1uk4ltt6'])[5]"));
				System.out.print(state.getText());
				
				List <WebElement> statesub = driver.findElements(By.xpath("(//ul [@class='_121xeo4'])[5]//span [@class='_u1utz4z']"));
				for (WebElement i4 : statesub) {
					
					System.out.print("   "+i4.getText()+"   ");
				}
				System.out.println();
				
				// Topic no : 6
		 		WebElement more = driver.findElement(By.xpath("(//span [@class='_1uk4ltt6'])[6]"));
		 		System.out.println(more.getText());
		 		
		 		List<WebElement> moresub = driver.findElements(By.xpath("(//ul [@class='_121xeo4'])[6]//span [@class='_u1utz4z']"));
		 		for (WebElement i5 : moresub) {
		 			
		 			System.out.print("   "+i5.getText()+"   ");
		 		}
		 		System.out.println();
				
				// Topic no : 7 
				WebElement khan = driver.findElement(By.xpath("(//span [@class='_1uk4ltt6'])[7]"));
				System.out.print(khan.getText());
				
				List<WebElement> khansub = driver.findElements(By.xpath("(//ul [@class='_121xeo4'])[7]//span [@class='_u1utz4z']"));
		         for (WebElement i6 : khansub) {
		        	 
		        	 System.out.print("   "+i6.getText()+"   ");
		         }
				
		         File sc=pic.getScreenshotAs(OutputType.FILE);
		 		File dpic = new File ("C:\\Users\\biswa\\eclipse-workspace\\coursera\\target\\project_pic"+System.currentTimeMillis()+".png");
		 		FileHandler.copy(sc, dpic);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
