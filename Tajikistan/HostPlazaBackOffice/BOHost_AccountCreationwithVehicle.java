package HostPlazaBackOffice;
import static org.junit.Assert.*;
import tajikistanConfiguration.Settingsfields_File;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class BOHost_AccountCreationwithVehicle extends Settingsfields_File{
	
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
	public void vehicleCreatoinOnlyInit() throws Exception{		
		Thread.sleep(1000);
		BOHost_AccountCreationOnly.accountCreationOnly();		
		if (passTax){
			System.out.println("Unable to create an Account due to: "+errorText);
			fail("Unable to create an Account due to "+errorText);
		}
		Thread.sleep(1000);					
		vehicleCreation();
		Thread.sleep(1000);
		takeScreenShot("E:\\Selenium\\","accountCreated"+timet+".jpg");
		takeScreenShot("E:\\workspace\\Fatima_Repository\\accountCreationVehicle\\attachments\\","accountCreated.jpg");
		System.out.println("Account created : "+accountNumbr.substring(8,17)+" correctly and vehicle with Plate No.: "+matriNu);		
		System.out.println("Tested in Version of: "+ getVersion("BO","HM"));
		
	}
	
	public static void vehicleCreation() throws Exception{
		Thread.sleep(1000);
		borrarArchivosTemp("E:\\workspace\\Fatima_Repository\\accountCreationVehicle\\attachments\\");
		elementClick("ctl00_ButtonsZone_BtnValidate_IB_Label"); //Click on Edit button
		Thread.sleep(2000);
		elementClick("ctl00_ContentZone_BtnVehicles");
		Thread.sleep(3000);
		takeScreenShot("E:\\Selenium\\","vehiclePage"+timet+".jpg");
		takeScreenShot("E:\\workspace\\Fatima_Repository\\accountCreationVehicle\\attachments\\","vehiclePage.jpg");
		elementClick("ctl00_ContentZone_BtnCreate");
		Thread.sleep(3000);
		Select optionsCat = new Select (driver.findElement(By.id("ctl00_ContentZone_cmb_vehicle_type")));		
		int catSelected = ranNumbr(0,optionsCat.getOptions().size()-1);
		if (catSelected >=optionsCat.getOptions().size()){
			catSelected =optionsCat.getOptions().size()-1;
		}
		new Select (driver.findElement(By.id("ctl00_ContentZone_cmb_vehicle_type"))).selectByIndex(catSelected);
		Thread.sleep(1000);
		int matNum = ranNumbr(5000,9999);
		int matlet = ranNumbr(0,matletT.length()-1);
		int matlet1 = ranNumbr(0,matletT.length()-1);
		int matlet2 = ranNumbr(0,matletT.length()-1);
		matriNu = String.valueOf(matNum+matletT.substring(matlet, matlet+1)+matletT.substring(matlet1, matlet1+1)+matletT.substring(matlet2, matlet2+1));
		selectDropDown("ctl00_ContentZone_cmb_vehicle_type");
		Thread.sleep(1000);
		if (catSelected==0){
			carSel = ranNumbr(0,3);
			carModel = ranNumbr(1,2);
				if (cocheModels[0][carSel].equals("Seat")){
					carModelSel = 0;
				}
				if (cocheModels[0][carSel].equals("Volkswagen")){
					carModelSel = 1;
				}
				if (cocheModels[0][carSel].equals("Ford")){
					carModelSel = 2;
				}
				if (cocheModels[0][carSel].equals("Fiat")){
					carModelSel = 3;
				}
				vehtypeModel = String.valueOf(cocheModels[0][carSel]);
				vehtypeKind = String.valueOf(cocheModels[carModel][carModelSel]);	
		}
		else{
			carSel = ranNumbr(0,1);
			carModel = ranNumbr(1,2);
				if (camionModels[0][carSel].equals("Mercedes-Benz")){
					carModelSel = 0;
				}
				if (camionModels[0][carSel].equals("Scania")){
					carModelSel = 1;
				}
				vehtypeModel = String.valueOf(camionModels[0][carSel]);
				vehtypeKind = String.valueOf(camionModels[carModel][carModelSel]);
		}
		vehicleFieldsfill(matriNu,vehtypeModel,vehtypeKind,colorS[ranNumbr(0,colorS.length-1)]);
		SendKeys("ctl00_ContentZone_txt_comment", "New Vehicle Created");
		takeScreenShot("E:\\Selenium\\","vehicleDataFilledPage"+timet+".jpg");
		takeScreenShot("E:\\workspace\\Fatima_Repository\\accountCreationVehicle\\attachments\\","vehicleDataFilledPage.jpg");
		Thread.sleep(2000);												
		driver.findElement(By.id("ctl00_ButtonsZone_BtnSubmit_IB_Label")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("ctl00_ButtonsZone_BtnBack_IB_Label")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("ctl00_ButtonsZone_BtnValidate_IB_Label")).click();
		Thread.sleep(2500);
		String sectionTitle = driver.findElement(By.id("ctl00_SectionZone_LblTitle")).getText();
		if (sectionTitle.contains("Payment details") ){
			elementClick("ctl00_ButtonsZone_BtnExecute_IB_Label");
			Thread.sleep(2500);
			takeScreenShot("E:\\Selenium\\","paymentCustomerPage"+timet+".jpeg");
			takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","paymentCustomer.jpeg");
			Thread.sleep(1000);
			
			if (ranNumbr(0,1)==0){
				elementClick("ctl00_ContentZone_CtType_radioButtonList_payBy_0");
				paymentType = "Cash";
			}else{
				elementClick("ctl00_ContentZone_CtType_radioButtonList_payBy_1");
				paymentType="Cheque";
			}
			if (ranNumbr(0,1)==1){
				elementClick("ctl00_ContentZone_CtType_chk_present");
			}
			Thread.sleep(1000);
			elementClick("ctl00_ButtonsZone_BtnExecute_IB_Label");
			Thread.sleep(3000);		
			if (paymentType.equals("Cheque")){
				SendKeys("ctl00_ContentZone_CtbyCheque_txt_number_box_data", ranNumbr(10000,999999999)+"");
			
			}
			Thread.sleep(1000);
			takeScreenShot("E:\\Selenium\\","paymentCustomerPayedPage"+timet+".jpeg");
			takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","paymentCustomerPayed.jpeg");
			elementClick("ctl00_ButtonsZone_BtnExecute_IB_Label");
			Thread.sleep(3000);
			sectionTitle = driver.findElement(By.id("ctl00_SectionZone_LblTitle")).getText();;
			if (sectionTitle.contains("Receipt")){
				takeScreenShot("E:\\Selenium\\","ReceiptPage"+timet+".jpeg");
				takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","Receipt.jpeg");
				elementClick("ctl00_ButtonsZone_BtnBack_IB_Label");
			}
		}
	}
	
	public static void vehicleFieldsfill(String Matricul, String vehtypeM, String vehtypeK, String ColorT) throws Exception{
			Thread.sleep(1000);
			driver.findElement(By.id("ctl00_ContentZone_text_plate_number")).sendKeys(Matricul);
			driver.findElement(By.id("ctl00_ContentZone_text_make")).sendKeys(vehtypeM);
			driver.findElement(By.id("ctl00_ContentZone_text_model")).sendKeys(vehtypeK);
			driver.findElement(By.id("ctl00_ContentZone_text_colour")).sendKeys(ColorT);			
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