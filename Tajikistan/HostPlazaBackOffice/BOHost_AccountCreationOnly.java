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




public class BOHost_AccountCreationOnly extends Settingsfields_File {
	
	
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
	public void accountCreatoinOnlyInit() throws Exception{				
		Thread.sleep(1000);
		accountCreationOnly();
		if (passTax){
			System.out.println("Unable to create an Account due to: "+errorText);
			fail("Unable to create an Account due to "+errorText);
		}
		Thread.sleep(1000);
		System.out.println("Account created "+accountSelected+" "+accountNumbr.substring(8, 17)+" correctly");
		System.out.println("Tested in Version of: "+ getVersion("BO","HM"));
		
	}
	
	public static void accountCreationOnly() throws Exception{
		Actions action = new Actions(driver);	
		borrarArchivosTemp("E:\\workspace\\Fatima_Repository\\BOHost_accountCreation\\attachments\\");
		try{
			driver.get(BoHostUrl);
			takeScreenShot("E:\\Selenium\\","loginBOTajPage"+timet+".jpg");
			takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","loginBOTajPage.jpeg");
			loginPage("00001","00001");
			takeScreenShot("E:\\Selenium\\","homeBOTajPage"+timet+".jpg");
			takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","homeBOTajPage.jpeg");
			BOVersion = driver.findElement(By.id("ctl00_statusRight")).getText();
			Thread.sleep(2000);			
			action.moveToElement(driver.findElement(By.linkText("Customer service"))).build().perform();
			Thread.sleep(1000);
			action.moveToElement(driver.findElement(By.linkText("Create account"))).build().perform();
			Thread.sleep(1000);
			int selaccount = ranNumbr(0,1);			
			if (selaccount == 0){
				driver.findElement(By.linkText("Individual")).click();
				accountSelected = "Individual";
				individualAccount();				
			}else{
				action.clickAndHold(driver.findElement(By.linkText("Company"))).build().perform();				
				companylinkselected = companyLink[ranNumbr(0,1)];				
				driver.findElement(By.linkText(companylinkselected)).click();	
				companyAccount();
			}
			Thread.sleep(3000);
		}catch (Exception e){
			e.printStackTrace();
			fail(e.getMessage());
		}
		
	}
	
	public static void individualAccount() throws Exception{
		Thread.sleep(2000);		
		takeScreenShot("E:\\Selenium\\","individualAccountPage"+timet+".jpeg");
		takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","individualAccountPage.jpeg");
		accountNumbr = driver.findElement(By.id("ctl00_SectionZone_LblTitle")).getText();
		SendKeys(passPortid, passportLetter[ranNumbr(0,2)]+ranNumbr(1000000,99999999));		
		Thread.sleep(200);
		elementClick("ctl00_ContentZone_BtnCheckCI");
		Thread.sleep(300);
			if (driver.getPageSource().contains("The passport/tax  value already exists in the system")){
				errorText = driver.findElement(By.id("ctl00_LblError")).getText();
				passTax = true;
				return;
			}
		SendKeys(taxId, ranNumbr(100000000,999999999)+"");
		Thread.sleep(200);
		int selOp = ranNumbr(0,9);
		new Select(driver.findElement(By.id(titulofield))).selectByVisibleText(sexSelc[selOp]);
		Thread.sleep(200);
		SendKeys(surnamef,lastNameOp[selOp]);
		Thread.sleep(200);
		SendKeys(namef,nameOp[selOp]);
		Thread.sleep(200);
		SendKeys("ctl00_ContentZone_ctrlAccountData_txt_surname2_box_data",lastNameOp2[selOp]);
		Thread.sleep(200);
		SendKeys(addressf,addressTec[selOp]);
		Thread.sleep(200);
		if (ranNumbr(0,1)==0){
			SendKeys("ctl00_ContentZone_ctrlAccountData_txt_Settlements_box_data","Test Settlements");
		}else{
			elementClick("ctl00_ContentZone_ctrlAccountData_chk_settlements");
			Thread.sleep(300);
			selectDropDown("ctl00_ContentZone_ctrlAccountData_cmb_settlements_cmb_dropdown");
		}
		Thread.sleep(200);
		SendKeys(countryf, "España");
		Thread.sleep(200);
		SendKeys(cpf, cpAdress[selOp]);
		Thread.sleep(200);
		SendKeys(emailf, nameOp[selOp].toLowerCase()+"."+lastNameOp[selOp].toLowerCase()+"@tecsidel.com");
		Thread.sleep(200);
		SendKeys(phoneCel,ranNumbr(600000000,699999999)+"");
		Thread.sleep(200);
		SendKeys(workPhone,workPhone1[selOp]);
		Thread.sleep(200);
		SendKeys(perPhone,ranNumbr(900000000,999999999)+"");
		Thread.sleep(200);
		SendKeys(faxPhone,workPhone1[selOp]);
		Thread.sleep(200);
		if (ranNumbr(0,1)==0){
			elementClick("ctl00_ContentZone_ctrlAccountData_chk_dtEnd");
			Thread.sleep(200);
			SendKeys("ctl00_ContentZone_ctrlAccountData_dt_end_box_date", dateSel(2019,2020));
			Thread.sleep(200);
			SendKeys("ctl00_ContentZone_ctrlAccountData_txt_warningThreshold_box_data",ranNumbr(1,15)+"");
		}
		Thread.sleep(200);
		selectDropDownV("ctl00_ContentZone_type_payment_cmb_dropdown");
		Thread.sleep(200);
		int radbutton = ranNumbr(0,2);
		if (radbutton == 0){
			elementClick("ctl00_ContentZone_discount_strategy_0");
		}
		if (radbutton == 1){
			elementClick("ctl00_ContentZone_discount_strategy_1");
		}
		if (radbutton == 2){
			elementClick("ctl00_ContentZone_discount_strategy_2");
		}
		Thread.sleep(1000);
		takeScreenShot("E:\\Selenium\\","individualAccountFilledPage"+timet+".jpeg");
		takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","individualAccountFilledage.jpeg");
		elementClick("ctl00_ButtonsZone_BtnSave_IB_Label"); //click on Save button
		Thread.sleep(3000);
		takeScreenShot("E:\\Selenium\\","paymentDetailsPage"+timet+".jpeg");
		takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","paymentDetailsPage.jpeg");
		elementClick("ctl00_ButtonsZone_BtnExecute_IB_Label");
		Thread.sleep(3000);
		String sectionTitle = driver.findElement(By.id("ctl00_SectionZone_LblTitle")).getText();
		if (sectionTitle.contains("Payment from customer")){
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
	
	public static void companyAccount() throws Exception{
		Thread.sleep(2000);		
			takeScreenShot("E:\\Selenium\\","CompanyAccountPage"+timet+".jpeg");
			takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","CompanyAccountPage.jpeg");
			accountNumbr = driver.findElement(By.id("ctl00_SectionZone_LblTitle")).getText();
			SendKeys(passPortid, ranNumbr(100000000,999999999)+"");		
			Thread.sleep(200);
			elementClick("ctl00_ContentZone_BtnCheckCI");
			Thread.sleep(300);
			if (driver.getPageSource().contains("The passport/tax  value already exists in the system")){
				errorText = driver.findElement(By.id("ctl00_LblError")).getText();
				passTax = true;
				return;
			}
			selectDropDown("ctl00_ContentZone_ctrlAccountData_cmb_companyType_cmb_dropdown");
			Thread.sleep(200);
			SendKeys(companyf, "Tecsidel, S.A.");
			Thread.sleep(200);
			int selOp = ranNumbr(0,9);
			int selOp2 = ranNumbr(0,9);
			SendKeys(contactf, nameOp[selOp]+" "+lastNameOp[selOp]+", "+nameOp[selOp2]+" "+lastNameOp[selOp2]);
			Thread.sleep(200);
			SendKeys(addressf, "C/Castanyer No. 29");
			Thread.sleep(200);
			SendKeys("ctl00_ContentZone_ctrlAccountData_txt_Settlements_box_data", "New Settlements Data");
			Thread.sleep(200);
			SendKeys(countryf, "España");
			Thread.sleep(200);
			SendKeys(cpf, "080220");
			Thread.sleep(200);
			SendKeys(emailf, "info@tecsidel.es");
			Thread.sleep(200);
			SendKeys(phoneCel, ranNumbr(600000000,699999999)+"");
			Thread.sleep(200);
			SendKeys(workPhone,workPhone1[2]);
			Thread.sleep(200);
			SendKeys(perPhone,workPhone1[2]);
			Thread.sleep(200);
			SendKeys(faxPhone,workPhone1[2]);
			Thread.sleep(300);
			if (companylinkselected.equals("Prepayment")){
				accountSelected = "Prepago";
				if (ranNumbr(0,1)==0){
					elementClick("ctl00_ContentZone_ctrlAccountData_chk_dtEnd");
					Thread.sleep(200);
					SendKeys("ctl00_ContentZone_ctrlAccountData_dt_end_box_date", dateSel(2019,2020));
					Thread.sleep(200);
					SendKeys("ctl00_ContentZone_ctrlAccountData_txt_warningThreshold_box_data",ranNumbr(1,15)+"");
				}
			}
			if (companylinkselected.equals("Exempt")){
				accountSelected = "Exenta";
				elementClick("ctl00_ContentZone_ctrlAccountExempt_mck_plaza_img_expand");
				String [] excentpToll = {"ctl00_ContentZone_ctrlAccountExempt_mck_plaza_ctl01", "ctl00_ContentZone_ctrlAccountExempt_mck_plaza_ctl03","ctl00_ContentZone_ctrlAccountExempt_mck_plaza_ctl05", "ctl00_ContentZone_ctrlAccountExempt_mck_plaza_ctl07", "ctl00_ContentZone_ctrlAccountExempt_mck_plaza_ctl09", "ctl00_ContentZone_ctrlAccountExempt_mck_plaza_ctl11", "ctl00_ContentZone_ctrlAccountExempt_mck_plaza_ctl13", "ctl00_ContentZone_ctrlAccountExempt_mck_plaza_ctl15"};
				Thread.sleep(200);
				int selectOption = ranNumbr(1,8);
				for (int i=1;i<=selectOption;i++){
					int clickOp = ranNumbr(0,7);
					elementClick(excentpToll[clickOp]);
					Thread.sleep(300);
				}
				Thread.sleep(300);
				elementClick("ctl00_ContentZone_ctrlAccountExempt_mck_plaza_img_expand");;
				Thread.sleep(300);
				selectDropDown("ctl00_ContentZone_ctrlAccountExempt_combo_exempts_cmb_dropdown");
				Thread.sleep(300);
				if (ranNumbr(0,1)==0){
					elementClick("ctl00_ContentZone_ctrlAccountExempt_radio_expiry_0");
				}else{
					elementClick("ctl00_ContentZone_ctrlAccountExempt_radio_expiry_1");
					SendKeys("ctl00_ContentZone_ctrlAccountExempt_cal_date_expiry_box_date",dateSel(2019,2020));
					Thread.sleep(100);
					SendKeys("ctl00_ContentZone_ctrlAccountExempt_txt_days_warning",ranNumbr(1,20)+"");
				}
				if (ranNumbr(0,1)==0){
					elementClick("ctl00_ContentZone_ctrlAccountExempt_radio_trips_0");
				}else{
					elementClick("ctl00_ContentZone_ctrlAccountExempt_radio_trips_1");
					SendKeys("ctl00_ContentZone_ctrlAccountExempt_txt_max_trips",ranNumbr(100,999)+"");
					Thread.sleep(100);
					SendKeys("ctl00_ContentZone_ctrlAccountExempt_txt_trips_warning",ranNumbr(1,20)+"");
				}
			}			
			if (ranNumbr(0,1)==0){
				elementClick("ctl00_ContentZone_chk_PublicTransport");
				Thread.sleep(200);
				selectDropDown("ctl00_ContentZone_cmb_PublicTransport_cmb_dropdown");
			}
			Thread.sleep(300);
			selectDropDownV("ctl00_ContentZone_type_payment_cmb_dropdown");
			Thread.sleep(300);
			selectDropDown("ctl00_ContentZone_type_threshold_cmb_dropdown");
			Thread.sleep(200);
			int radbutton = ranNumbr(0,2);
			if (radbutton == 0){
				elementClick("ctl00_ContentZone_discount_strategy_0");
			}
			if (radbutton == 1){
				elementClick("ctl00_ContentZone_discount_strategy_1");
			}
			if (radbutton == 2){
				elementClick("ctl00_ContentZone_discount_strategy_2");
			}
			Thread.sleep(300);
			takeScreenShot("E:\\Selenium\\","CompanyAccountFilledPage"+timet+".jpeg");
			takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","CompanyAccountFilledPage.jpeg");
			elementClick("ctl00_ButtonsZone_BtnSave_IB_Label"); //click on Save Button
			Thread.sleep(3000);
			if (companylinkselected.equals("Prepayment")){
				takeScreenShot("E:\\Selenium\\","CompanyAccountPayedPage"+timet+".jpeg");
				takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","CompanyAccountPayedPage.jpeg");
				elementClick("ctl00_ButtonsZone_BtnExecute_IB_Label"); //click on Continue button
				Thread.sleep(4000);
			}
			takeScreenShot("E:\\Selenium\\","CompanyAccountCreatedPage"+timet+".jpeg");
			takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","CompanyAccountCreatedPage.jpeg");
		
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