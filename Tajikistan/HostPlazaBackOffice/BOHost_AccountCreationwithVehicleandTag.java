package HostPlazaBackOffice;
import static org.junit.Assert.*;
import tajikistanConfiguration.Settingsfields_File;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class BOHost_AccountCreationwithVehicleandTag extends Settingsfields_File{
	
	@Before
	public void setUp() throws Exception{
	System.setProperty("webdriver.chrome.driver", "E:\\workspace\\fatima_repository\\lib\\chromedriver.exe");
		/*DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/
			//ChromeOptions opts =  new ChromeOptions(); poner esta opción cuando se vaya a subir a Git
			//opts.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); poner esta opción cuando se vaya a subir a Git
			driver = new ChromeDriver();//opts); poner esta opción cuando se vaya a subir al Git
			driver.manage().window().maximize();	
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void accountCreationAssigningTagInit() throws Exception{		
		Thread.sleep(1000);
		borrarArchivosTemp("E:\\workspace\\Fatima_Repository\\accountCreationAssigningTag\\attachments\\");
		BOHost_AccountCreationOnly.accountCreationOnly();		
		if (passTax){
			System.out.println("Unable to create an Account due to: "+errorText);
			fail("Unable to create an Account due to "+errorText);
		}		
		Thread.sleep(1000);					
		BOHost_AccountCreationwithVehicle.vehicleCreation();
		Thread.sleep(1000);
		accountCreationAssigningTag();
		if (errorTagAssignment){
			System.out.println("TAG ASSIGNMENT ERROR to the Account: "+accountNumbr.substring(8, 17)+", "+errorMessage);
			fail("Invalid Tag: Unable to assign Tag to Vehicle "+matriNu+" to the account "+accountNumbr.substring(8, 17));
			return;
		}
		takeScreenShot("E:\\Selenium\\","accountCreated"+timet+".jpg");
		takeScreenShot("E:\\workspace\\Fatima_Repository\\accountCreationVehicle\\attachments\\","accountCreated.jpg");
		System.out.println("Account has been created: "+accountNumbr.substring(8, 17)+" with Vehicle Plate "+matriNu+" and Assigned Tag No.: "+ tagIdNmbr);		
		System.out.println("Tested in Version of: "+ getVersion("BO","HM"));
	}
	public static void accountCreationAssigningTag() throws Exception{
		Thread.sleep(1000);
		Thread.sleep(2000);
		takeScreenShot("E:\\Selenium\\","tagAssignmentMainPage"+timet+".jpg");
		takeScreenShot("E:\\workspace\\Maria_Repository\\accountCreationAssigningTag\\attachments\\","tagAssignmentMainPage.jpg");
		driver.findElement(By.id("ctl00_ContentZone_BtnTags")).click();
		Thread.sleep(500);
		driver.findElement(By.id("ctl00_ContentZone_chk_0")).click();
		Thread.sleep(500);
		driver.findElement(By.id("ctl00_ContentZone_btn_token_assignment")).click();
		Thread.sleep(500);
		driver.findElement(By.id("ctl00_ContentZone_txt_pan_token_txt_token_box_data")).sendKeys(ranNumbr(1,99999)+"");
		Thread.sleep(500);
		driver.findElement(By.id("ctl00_ContentZone_btn_init_tag")).click();
		Thread.sleep(500);
		confirmationMessage = driver.findElement(By.id("ctl00_ContentZone_lbl_operation")).getText();
		confirmationMessage2 = driver.findElement(By.id("ctl00_ContentZone_lbl_information")).getText();
			if (confirmationMessage.contains("Error: This token is already assigned") || confirmationMessage.contains("Este tag no está operativo") || confirmationMessage.contains("Este tag ya está asignado") || confirmationMessage.contains("Luhn incorrecto")){
				errorMessage = driver.findElement(By.id("ctl00_ContentZone_lbl_operation")).getText();;
				errorTagAssignment = true;
				takeScreenShot("E:\\Selenium\\","tagAssignmentPageErr"+timet+".jpg");
				takeScreenShot("E:\\workspace\\Fatima_Repository\\accountCreationAssigningTag\\attachments\\","tagAssignmentPageErr.jpg");
				return;
			}
			if (confirmationMessage2.contains("has already an assigned token")){
				errorMessage = driver.findElement(By.id("ctl00_ContentZone_lbl_information")).getText();;
				errorTagAssignment = true;
				takeScreenShot("E:\\Selenium\\","tagAssignmentPageErr"+timet+".jpg");
				takeScreenShot("E:\\workspace\\Fatima_Repository\\accountCreationAssigningTag\\attachments\\","tagAssignmentPageErr.jpg");
				return;
			}
				tagIdNmbr = driver.findElement(By.xpath("//*[@id='ctl00_ContentZone_m_table_members']/tbody/tr[2]/td[6]")).getText();
				takeScreenShot("E:\\Selenium\\","tagAssignmentPage"+timet+".jpg");
				takeScreenShot("E:\\workspace\\Fatima_Repository\\accountCreationAssigningTag\\attachments\\","tagAssignmentPage.jpg");
				Thread.sleep(1000);
	
	}
	
	
	@After
	public void tearDown() throws Exception{			  
		    driver.quit();
		    String verificationErrorString = verificationErrors.toString();
		    if (!"".equals(verificationErrorString)) {
		      fail(verificationErrorString);
		    }
	}
	
}
