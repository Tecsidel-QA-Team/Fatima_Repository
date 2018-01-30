package tajikistanConfiguration;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Settingsfields_File {
	public static String dateverTransacciones;	
	public static String hmVersion;
	public static String [] passportLetter= {"A","B","C"};
	public static String companylinkselected;
	public static String [] companyLink = {"Prepayment","Exempt"}; 
	public static boolean passTax = false;
	public static int carModelSel;
	public static String confirmationMessage2;
	public static String errorMessage;
	public static String paymentType;
	public static String accountSelected;
	public static String BoHostUrl="http://virtualbo-qa/BOQAHostTajikistan/web/forms/core/login.aspx";
	public static String BoPlazaUrl="http://virtualbo-qa/BOQAPlazaTajikistan/web/forms/core/login.aspx";
	public static String MCSUrl = "http://virtualmcs-qa/MCS_Tajikistan";
	public static String passPortid = "ctl00_ContentZone_ctrlAccountData_txt_ID_box_data";	
	public static String taxId = "ctl00_ContentZone_ctrlAccountData_txt_taxNumber_box_data";
	public static String infoCuenta0 = "ctl00_ContentZone_ctrlAccountData_radio_company_0";
	public static String infoCuenta1 = "ctl00_ContentZone_ctrlAccountData_radio_company_1";
	public static String titulofield = "ctl00_ContentZone_ctrlAccountData_cmb_title_cmb_dropdown";
	public static String namef = "ctl00_ContentZone_ctrlAccountData_txt_forname_box_data";
	public static String surnamef ="ctl00_ContentZone_ctrlAccountData_txt_surname_box_data";
	public static String addressf = "ctl00_ContentZone_ctrlAccountData_txt_address_box_data";
	public static String cpf = "ctl00_ContentZone_ctrlAccountData_txt_postcode_box_data";
	public static String townf = "ctl00_ContentZone_ctrlAccountData_txt_town_box_data";
	public static String countryf = "ctl00_ContentZone_ctrlAccountData_txt_country_box_data";
	public static String emailf ="ctl00_ContentZone_ctrlAccountData_txt_email_box_data";
	public static String phoneCel = "ctl00_ContentZone_ctrlAccountData_txt_mobile_box_data";
	public static String workPhone = "ctl00_ContentZone_ctrlAccountData_txt_daytimephone_box_data";
	public static String perPhone = "ctl00_ContentZone_ctrlAccountData_txt_homephone_box_data";
	public static String faxPhone = "ctl00_ContentZone_ctrlAccountData_txt_fax_box_data";
	public static String companyf = "ctl00_ContentZone_ctrlAccountData_txt_company_box_data";
	public static String contactf = "ctl00_ContentZone_ctrlAccountData_txt_contact_box_data";	
	public static String confirmationMessage;
	public static boolean errorTagAssignment = false;
	public static String tagIdNmbr;
	public static String [] colorS = new String[]{"Blanco", "Negro", "Azul", "Rojo", "Verde", "Amarillo"};
	public static String matletT = "TRWAGMYFPDXBNJZSQVHLCKE";
	public static String accountNumbr; 
	public static int carSel;
	public static int carModel;
	public static String matriNu;
	public static String vehtypeModel;
	public static String vehtypeKind;
	public static String [][] cocheModels = {{"Seat","Volkswagen","Ford","Fiat"},{"Ibiza","Polo","Fiesta","Punto"},{"León","Passat","Focus","Stilo"}};
	public static String [][] camionModels = {{"Mercedes-Benz","Scania"},{"Axor","R500"},{"Actros","P400"}};
	public static String [][] furgonetaModels = {{"Mercedes-Benz","Fiat"},{"Vito","Scudo"},{"Citan","Ducato"}};
	public static String [][] cicloModels = {{"Yamaha","Honda"},{"XT1200Z","Forza 300"},{"T-MAX SX","X-ADV"}};
	public static String [][] autoBusModels = {{"DAIMLER-BENZ","VOLVO"},{"512-CDI","FM-12380"},{"DB 605","FM 300"}};	
	public static Calendar calF; 
	public static Calendar calT;
	public static SimpleDateFormat sft;
	private static int dateMFrom;
	public static int delm;
	public static String fileDatafilled;
	public static String fileError;
	public static String folderSel;
	public static String projectSel;
	public static String additionalTitle;
	public static String descriptionSubject;
	public static String errorLev;
	public static WebDriver driver;	
	public boolean acceptNextAlert = true;
	public static StringBuffer verificationErrors = new StringBuffer();
	public static int numbering;	
	public static String errorText;
	public static String tipoSel;
	public static String loginField = "BoxLogin";
	public static String passField = "BoxPassword";
	public static String loginButton = "BtnLogin";
	public static String opIdField = "ctl00_ContentZone_operatorId_box_data";
	public static String nameField = "ctl00_ContentZone_forename_box_data";
	public static String lastNameField = "ctl00_ContentZone_surname_box_data";
	public static String emailField = "ctl00_ContentZone_email_box_data";
	public static String groupOperator = "ctl00_ContentZone_group_cmb_dropdown";
	public static String pwdField = "ctl00_ContentZone_password_box_data";
	public static String repeatpwdField = "ctl00_ContentZone_password2_box_data";
	public static String hourNumber = "ctl00_ContentZone_TxtNomHousr_box_data";
	public static String submitBtn = "ctl00_ButtonsZone_BtnSubmit";	
	public static String MCSVersion;
	public static String BOVersion;	
	public static String [] nameOp = new String[] {"Pilar", "Mavi", "Franklyn", "Gemma", "Fatima", "Marc", "Miguel", "Francisco", "Oscar", "Maria"};
	public static String [] genderS = new String[] {"Female", "Female", "Male", "Female", "Female", "Male", "Male", "Male", "Masculino", "Female"};
	public static String [] sexSelc = new String[] {"Mrs", "Mrs", "Mr", "Mrs", "Mrs", "Mr", "Mr", "Mr", "Mr", "Mrs"};
	public static String [] addressTec = new String[] {"CALLE SAN MAXIMO, 3","CALLE SAN MAXIMO, 3","Castanyer 29", "CALLE SAN MAXIMO, 3","CALLE SAN MAXIMO, 3","Catanyer 29","Edificio Tecsidel, P.T. de Boecillo","Edificio Tecsidel, P.T. de Boecillo","Edificio Tecsidel, P.T. de Boecillo","Edificio Tecsidel, P.T. de Boecillo"};
	public static String [] cpAdress = new String[]{"280410", "280410", "080220", "280410", "280410","080220","471510","471510","471510","471510"};
	public static String [] townC = new String []{"Madrid", "Madrid", "Barcelona", "Madrid", "Madrid", "Barcelona", "Valladolid","Valladolid","Valladolid","Valladolid"};
	public static String [] workPhone1 = new String []{"913530810","913530810","932922110","913530810","913530810","932922110","983546603","983546603","983546603","983546603"};
	public static String [] lastNameOp = new String[] {"Bonilla", "Garrido", "Garcia", "Arjonilla", "Romano", "Navarro", "Sanchez", "Castro", "Bailon", "Blanco"};
	public static String [] lastNameOp2 = new String[] {"Rol", "Sanchez", "Noyola", "Yague", "Cerror", "Ordoñez", "Grande", "Castaño", "Azcaray", "Ramos"};
	  //Edit buttons icons configuration.	  	  
	  public static Timestamp timest = new Timestamp (System.currentTimeMillis());
	  public static String timet = timest.toString().replace("-", "").replace(" ", "").replace(":", "").substring(0,14);
	  
	  public static void takeScreenShot(String pathS, String fname) throws Exception {
		    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile, new File(pathS, fname));
	  }
	  
	  public static void borrarArchivosTemp(String tempPath) throws Exception{
			File imagTmp = new File (tempPath);
			if (imagTmp.exists()){
				if (imagTmp.isDirectory()){
					File [] imaglist = imagTmp.listFiles();				
					if (imaglist.length > 0){
					 for (int i = 0; i< imaglist.length;i++){
							File delimg = imaglist[i];						
							delimg.delete();						
						}				
					}
				}
			}
			Thread.sleep(1000);
		  }	
	  
	  

    	public static void elementClick(String byID) {
    		if (byID.contains("//")){
    			driver.findElement(By.xpath(byID)).click();
    		}else{
    			driver.findElement(By.id(byID)).click();
    		}
    		
    	}
    	
    	
    	
   	public static void selectDropDownV(String by) {     		
    		Select vDropdown = new Select (driver.findElement(By.id(by)));
    			List<WebElement> dd = vDropdown.getOptions();		
    			Random rand = new Random();
    		int vdd = rand.nextInt(dd.size());
    			if (vdd<=0){vdd = 1;}	
    			if (vdd>=dd.size()){vdd=vdd-1;}      			      			
    		new Select (driver.findElement(By.id(by))).selectByIndex(vdd);
    		
    		
    	  }
    	
    	public static void selectDropDown(String by) {
    		Select vDropdown = new Select (driver.findElement(By.id(by)));
    			List<WebElement> dd = vDropdown.getOptions();		
    			Random rand = new Random();
    		int vdd = rand.nextInt(dd.size());
    			if (vdd<0){vdd = 0;}	
    			if (vdd>=dd.size()){vdd=vdd-1;}
    		new Select (driver.findElement(By.id(by))).selectByIndex(vdd);
    		
    	  }
    	public static void selectDropDownXPath(String xpath) {
    		Select vDropdown = new Select (driver.findElement(By.xpath(xpath)));
    			List<WebElement> dd = vDropdown.getOptions();		
    			Random rand = new Random();
    		int vdd = rand.nextInt(dd.size());
    			if (vdd<0){vdd = 0;}	
    			if (vdd>=dd.size()){vdd=vdd-1;}
    		new Select (driver.findElement(By.xpath(xpath))).selectByIndex(vdd);
    		
    	  }

   	
   	public static String dateSel(int date1,int date2 ) throws Exception{
			calF = Calendar.getInstance();
			calT = Calendar.getInstance();
		 sft = new SimpleDateFormat("dd/MM/yyyy");
		calF.set(ranNumbr(date1,date2), dateMFrom, ranNumbr(1,31));
		calT.set(ranNumbr(date1,date2), ranNumbr(1,12), ranNumbr(1,31));
		return sft.format(calT.getTime());

	}
   	public static int ranNumbr(int min, int max) {
 		  Random rand = new Random();
 		  numbering = min+rand.nextInt((max-min)+1);
 		  if (numbering <0){
 			 numbering = min+rand.nextInt((max-min)+1);
 		  }
 		  return numbering; 		  
 	  }

   	public static void loginPageMCS(String usr, String pwd) throws Exception{
			driver.findElement(By.id("txt_login")).sendKeys(usr);
			driver.findElement(By.id("txt_password")).sendKeys(pwd);
			driver.findElement(By.id("btn_login")).click();
			Thread.sleep(1000);
	}
   	
   	public static void loginPage(String usr, String pwd) throws Exception{
   			driver.findElement(By.id(loginField)).sendKeys(usr);
   			driver.findElement(By.id(passField)).sendKeys(pwd);
   			driver.findElement(By.id(loginButton)).click();
   			Thread.sleep(1000);
   	}
   	
  /* 	public static String dniLetra (String Dtype, int dni){
   		if (Dtype == "DNI"){
   			return String.valueOf(dni)+(matletT.charAt(dni % 23));
   		}else{
   			return String.valueOf(matletT.charAt(dni % 23))+(dni);
   		}
	  }*/
   	
   	public static void SendKeys (String path, String toSend){
   		
   		if (path.contains("//")){
   			driver.findElement(By.xpath(path)).clear();
   			driver.findElement(By.xpath(path)).sendKeys(toSend);
   		}else{
   			driver.findElement(By.id(path)).clear();
   			driver.findElement(By.id(path)).sendKeys(toSend);    			
   		}
   	}
   	
   	public static String hourFormat(int Hour1,int Hour2,int Min1, int Min2){
			int Hour = ranNumbr(Hour1,Hour2);
			int Min = ranNumbr(Min1,Min2);			
			return String.format("%1$02d",Hour)+":"+String.format("%1$02d",Min);					
		}
		public static boolean isAlertPresent() throws Exception{
			try{
				driver.switchTo().alert();
				return true;
			}catch (Exception e){
				return false;
			}

		}
	public static String getVersion (String BOSelected, String HMSelected){
   		
			
			int versionComponent = BOVersion.length();
			 
			if (BOVersion.contains("_")){								
				if (versionComponent<16){					
					BOVersion = BOVersion.substring(0);
					hmVersion = "HM is not Running";
				}else{
					hmVersion = BOVersion.substring(17);
					BOVersion = BOVersion.substring(0, 15);
					
				}
			}
			if (!BOVersion.contains("_")){
				if (versionComponent<10){
					BOVersion = BOVersion.substring(0);
					hmVersion = "HM is not Running";
				}else{
					hmVersion = BOVersion.substring(11);
					BOVersion = BOVersion.substring(0, 9);					
				}
			}
			if (BOSelected == "BO"){
				BOSelected = "BOHost: "+BOVersion;
				
			}
			if (HMSelected == "HM"){
				HMSelected = "HostManager: "+hmVersion;				
			}
				return BOSelected +" and "+ HMSelected; 
			
			
						
   	}
	
}