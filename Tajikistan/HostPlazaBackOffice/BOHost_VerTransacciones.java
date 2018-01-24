package HostPlazaBackOffice;

import static org.junit.Assert.*;
import org.openqa.selenium.interactions.Actions;
import tajikistanConfiguration.Settingsfields_File;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class BOHost_VerTransacciones extends Settingsfields_File{
	
			@Before
			public void setUp() throws Exception{
    		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
    			/*DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
    			cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true
    			cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);*/
    				//ChromeOptions opts =  new ChromeOptions(); poner esta opción cuando se vaya a subir a Git
    				//opts.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe"); poner esta opción cuando se vaya a subir a Git
    				driver = new ChromeDriver();//opts); poner esta opción cuando se vaya a subir al Git
    				driver.manage().window().maximize();	
    				driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			}

			@After
			public void tearDown() throws Exception{			  
				    driver.quit();
				    String verificationErrorString = verificationErrors.toString();
				    if (!"".equals(verificationErrorString)) {
				      fail(verificationErrorString);
				    }
				  
			}

			@Test
			public void verTransaccionesInit() throws Exception{
				dateverTransacciones = "01/09/2017";
				verTransacciones();
				String elementsFound = driver.findElement(By.id("ctl00_ContentZone_tablePager_LblCounter")).getText();				
				String endDate = driver.findElement(By.id("ctl00_ContentZone_dateSelector_dt_to_box_date")).getAttribute("value");
				Thread.sleep(1500);
				System.out.println("Hay "+elementsFound.substring(19)+" transacciones desde la fecha "+dateverTransacciones+" hasta la fehca "+endDate);
				Thread.sleep(1000);	
			}
			
			public static void verTransacciones() throws Exception {
				Actions action = new Actions(driver);
				borrarArchivosTemp("E:\\workspace\\Fatima_Repository\\BOHost_VerTranscciones\\attachments\\");
				try{
					driver.get(BoHostUrl);
					Thread.sleep(1000);
					takeScreenShot("E:\\Selenium\\","loginBOTajPage"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_VerTranscciones\\attachments\\","loginBOTajPage.jpg");	
					loginPage("00001","00001");
					takeScreenShot("E:\\Selenium\\","homeHostTajPage"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_VerTranscciones\\attachments\\","homeHostTajPage.jpg");	
					Thread.sleep(2000);					
					action.clickAndHold(driver.findElement(By.linkText("Transactions"))).build().perform();
					action.moveToElement(driver.findElement((By.linkText("Transactions consolidation")))).build().perform();
					Thread.sleep(1000);
					driver.findElement(By.linkText("View transactions")).click();								
					Thread.sleep(1000);
					takeScreenShot("E:\\Selenium\\","verTransaccionesPage"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_VerTranscciones\\attachments\\","verTransaccionesPage.jpg");
					Thread.sleep(500);
					driver.findElement(By.id("ctl00_ContentZone_dateSelector_dt_from_box_date")).clear();
					driver.findElement(By.id("ctl00_ContentZone_dateSelector_dt_from_box_date")).sendKeys(dateverTransacciones);
					Thread.sleep(1000);		
					driver.findElement(By.id("ctl00_ButtonsZone_BtnSearch_IB_Button")).click();
					Thread.sleep(2000);
					takeScreenShot("E:\\Selenium\\","verTransaccionesResults"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_VerTranscciones\\attachments\\","verTransaccionesRetults.jpg");
					Thread.sleep(1000);
				
				}catch(Exception e){
					System.out.println(e.getMessage());
					e.printStackTrace();
					fail();
				}
			}		
      	
	}
