package HostPlazaBackOffice;

import static org.junit.Assert.*;
import tajikistanConfiguration.Settingsfields_File;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class BOHost_operatorCreation extends Settingsfields_File {
			 private static String usercreated ;
			 private static WebElement tableResult;
			 private static List<WebElement> userResults;
			 private static String enviarViaVer;
			 private static Statement stmt;
			 private static ResultSet rs;
			 private static String queryString;
			 private static ArrayList<String> transactions = new ArrayList<String>();
			 private static int i;
	
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
			public void OperatorCreation() throws Exception {
				Actions action = new Actions(driver);	
				borrarArchivosTemp("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\");
				try{
					driver.get(BoHostUrl);
					takeScreenShot("E:\\Selenium\\","loginBOTajPage"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","loginBOTajPage.jpg");
					loginPage("00001","00001");
					takeScreenShot("E:\\Selenium\\","homeBOTajPage"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","homeBOTajPage.jpg");
					BOVersion = driver.findElement(By.id("ctl00_statusRight")).getText();
					Thread.sleep(2000);					
					action.clickAndHold(driver.findElement(By.linkText("System settings"))).build().perform();
					Thread.sleep(1000);
					//action.moveToElement(driver.findElement(By.linkText("Configuración de peaje")));
					action.clickAndHold(driver.findElement(By.linkText("Operators"))).build().perform();
					Thread.sleep(500);
					driver.findElement(By.linkText("Operators management")).click();								
					Thread.sleep(1000);
					takeScreenShot("E:\\Selenium\\","gestionOperadoresPage"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","gestionOperadoresPage.jpg");
					Thread.sleep(500);		
					elementClick("ctl00_ContentZone_BtnCreate");
					Thread.sleep(1000);
					takeScreenShot("E:\\Selenium\\","crearOperadoresPage"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Fatima_Repository\\BOHost_crearOperadores\\attachments\\","crearOperadoresPage.jpg");
					usercreated = driver.findElement(By.id("ctl00_ContentZone_operatorId_box_data")).getAttribute("value");
					int userSel = ranNumbr(0,nameOp.length-1);
					new Select(driver.findElement(By.id("ctl00_ContentZone_cmb_title_cmb_dropdown"))).selectByVisibleText(sexSelc[userSel]);
					Thread.sleep(100);
					new Select(driver.findElement(By.id("ctl00_ContentZone_cmb_gender_cmb_dropdown"))).selectByVisibleText(genderS[userSel]);
					driver.findElement(By.id("ctl00_ContentZone_forename_box_data")).sendKeys(nameOp[userSel]);
					Thread.sleep(100);
					driver.findElement(By.id("ctl00_ContentZone_surname_box_data")).sendKeys(lastNameOp[userSel]);
					Thread.sleep(100);
					driver.findElement(By.id("ctl00_ContentZone_txt_address_box_data")).sendKeys(addressTec[userSel]);
					Thread.sleep(100);
					driver.findElement(By.id("ctl00_ContentZone_txt_postcode_box_data")).sendKeys(cpAdress[userSel]);
					Thread.sleep(100);
					driver.findElement(By.id("ctl00_ContentZone_txt_city_box_data")).sendKeys(townC[userSel]);
					Thread.sleep(100);
					driver.findElement(By.id("ctl00_ContentZone_txt_country_box_data")).sendKeys("España");
					Thread.sleep(100);
					driver.findElement(By.id("ctl00_ContentZone_email_box_data")).sendKeys(nameOp[userSel].toLowerCase()+lastNameOp[userSel].toLowerCase()+"@tecsidel.es");
					driver.findElement(By.id("ctl00_ContentZone_txt_phone_box_data")).sendKeys(workPhone1[userSel]);
					selectDropDown("ctl00_ContentZone_group_cmb_dropdown");
					Thread.sleep(100);
					selectDropDown("ctl00_ContentZone_cmb_typeDoc_cmb_dropdown");
					Thread.sleep(1000);
					driver.findElement(By.id("ctl00_ContentZone_txt_numberDoc_box_data")).sendKeys(String.valueOf(ranNumbr(10000000,900000000)+String.valueOf(ranNumbr(1000000,9000000))));		
					Thread.sleep(1000);
					WebElement operatorGroup = new Select (driver.findElement(By.id("ctl00_ContentZone_group_cmb_dropdown"))).getFirstSelectedOption();
					String operatorG = operatorGroup.getText();		
					dateSel();
					driver.findElement(By.id("ctl00_ContentZone_dt_birth_box_date")).clear();
					driver.findElement(By.id("ctl00_ContentZone_dt_birth_box_date")).sendKeys(sft.format(calT.getTime()));
					Thread.sleep(3000);
					driver.findElement(By.id("ctl00_ContentZone_password_box_data")).sendKeys(usercreated);
					driver.findElement(By.id("ctl00_ContentZone_password2_box_data")).sendKeys(usercreated);
					Thread.sleep(5000);
					takeScreenShot("E:\\Selenium\\","allfilleddata"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Maria_Repository\\CAC_crearOperadores\\attachments\\","allfilleddata.jpg");
					elementClick("ctl00_ButtonsZone_BtnSubmit_IB_Label");
					Thread.sleep(2000);
					takeScreenShot("E:\\Selenium\\","userCreated"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Maria_Repository\\CAC_crearOperadores\\attachments\\","userCreated.jpg");		
					elementClick("ctl00_ButtonsZone_BtnDownload_IB_Label");
					if (isAlertPresent()){
						driver.switchTo().alert().accept();
					}
					Thread.sleep(5000);
					String enviarViaLbl = driver.findElement(By.id("ctl00_LblError")).getText();		
					if (enviarViaLbl.contains("OK")){
						enviarViaVer = enviarViaLbl.substring(48).replace("'", "");
						System.out.println("La telecarga de Operadores se ha enviado a Vía con la versión "+enviarViaVer);
					}else{
						fail("Hay un error en envair telecargas a vía");
					}
					elementClick("ctl00_BtnLogOut");
					Thread.sleep(1000);
					if (isAlertPresent()){
						driver.switchTo().alert().accept();
					}	
					Thread.sleep(1000);
					loginPage(usercreated, usercreated);
					System.out.println("Se ha Creado el operador "+usercreated+" con la contraseaña: "+usercreated+ " en el grupo de "+operatorG.substring(04));
					System.out.println("Se ha probado en la versión del BO Host: " + BOVersion.substring(1,16)+" y Host Manager: "+BOVersion.substring(18));
					takeScreenShot("E:\\Selenium\\","userCreatedscreenHome"+timet+".jpg");
					takeScreenShot("E:\\workspace\\Maria_Repository\\BOHost_crearOperadores\\attachments\\","userCreatedscreenHome.jpg");
					Thread.sleep(60000);
					String connectionUrlPlaza = "jdbc:sqlserver://172.18.130.188:1433;DataBaseName=TAJIKISTAN_QA_TOLLPLAZA"; //+ "user=sa; password=lediscet";//" + "user=SENEGAL_QA_TOLLHOST; password=USRTOLLHOST";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection(connectionUrlPlaza, "sa", "lediscet");
					stmt = conn.createStatement();
					queryString = "select version, filename from dbo.atable where tabletype='operators' and version='"+enviarViaVer+"'";
					rs = stmt.executeQuery(queryString);
					String [] transaction = new String[2]; 			   
					while (rs.next()) {
						for (i = 0; i < transaction.length;i++){
							transaction[0]= rs.getString("version");
							transaction[1] = rs.getString("filename");
							transactions.add(transaction[i]);
						}
					}		
					if (transaction[0]==null){
						fail("La Telecarga de Operadores no ha bajado a Plaza");
					}else{
						System.out.println("La telecarga de operadores con la version: "+transactions.get(0)+" ha bajado a la plaza con el nombre de archivo: "+transactions.get(1));
					}
				}catch(Exception e){
					e.printStackTrace();
					fail();
				}
			}
			private static boolean isAlertPresent() throws Exception{
				try{
					driver.switchTo().alert();
					return true;
				}catch (Exception e){
					return false;
				}
			}
	}





