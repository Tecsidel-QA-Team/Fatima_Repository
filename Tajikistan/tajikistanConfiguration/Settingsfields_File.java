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
	public static String BoHostUrl="http://virtualbo-qa/BOQAHostTajikistan/web/forms/core/login.aspx";
	public static String BoPlazaUrl="http://virtualbo-qa/BOQAPlazaTajikistan/web/forms/core/login.aspx";
	public static String MCSUrl = "http://virtualmcs-qa/MCS_Tajikistan";
	public static String RUCid = "ctl00_ContentZone_ctrlAccountData_txt_RUC_box_data";	
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
	public static int carModelSel;
	public static String mcsVersion = "lbl_version"; 
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
	public static String caMe;
	public static String acam;	
	public static String fileDatafilled;
	public static int ad;
	public static int caMer;
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
	public static String linkPartes;
	public static String Types;
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
	public static String HMVersion;
	public static String [] nameOp = new String[] {"Pilar", "Mavi", "Franklyn", "Gemma", "Fatima", "Marc", "Miguel", "Francisco", "Oscar", "Maria"};
	public static String [] genderS = new String[] {"Female", "Female", "Male", "Female", "Female", "Male", "Male", "Male", "Masculino", "Female"};
	public static String [] sexSelc = new String[] {"Mrs", "Mrs", "Mr", "Mrs", "Mrs", "Mr", "Mr", "Mr", "Mr", "Mrs"};
	public static String [] addressTec = new String[] {"CALLE SAN MAXIMO, 3","CALLE SAN MAXIMO, 3","Castanyer 29", "CALLE SAN MAXIMO, 3","CALLE SAN MAXIMO, 3","Catanyer 29","Edificio Tecsidel, P.T. de Boecillo","Edificio Tecsidel, P.T. de Boecillo","Edificio Tecsidel, P.T. de Boecillo","Edificio Tecsidel, P.T. de Boecillo"};
	public static String [] cpAdress = new String[]{"28041", "28041", "08022", "28041", "28041","08022","47151","47151","47151","47151"};
	public static String [] townC = new String []{"Madrid", "Madrid", "Barcelona", "Madrid", "Madrid", "Barcelona", "Valladolid","Valladolid","Valladolid","Valladolid"};
	public static String [] workPhone1 = new String []{"913530810","913530810","932922110","913530810","913530810","932922110","983546603","983546603","983546603","983546603"};
	public static String [] lastNameOp = new String[] {"Bonilla", "Garrido", "Garcia", "Arjonilla", "Romano", "Navarro", "Sanchez", "Castro", "Bailon", "Blanco"};
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
	  
	  public static void selectDropDownClick2(String by)
      {
          Select vDropdown = new Select (driver.findElement(By.id(by)));
          List<WebElement> dd = vDropdown.getOptions();
          Random rand = new Random();
          int vdd = rand.nextInt(dd.size())+1;
          if (vdd <= 0) { vdd = vdd + 1; }
          	
          if (vdd >= dd.size()) { vdd = dd.size() - 1; }
          new Select(driver.findElement(By.id(by))).selectByIndex(vdd);

      }
	  
	  public static void ranSelection(String selId, int len1) throws Exception{
			List <WebElement >mcCameras = driver.findElements(By.xpath("//*[contains(@id, '"+selId+"')]"));        
	        caMe = mcCameras.get(0).getAttribute("id");
	        acam = mcCameras.get(mcCameras.size()-1).getAttribute("id");
	        ad = Integer.parseInt(caMe.substring(len1));
	        caMer = Integer.parseInt(acam.substring(len1));
		}
	  
	  public static void selectDropDownClick(String by)
      {
          Select vDropdown = new Select (driver.findElement(By.id(by)));
          List<WebElement> dd = vDropdown.getOptions();
          Random rand = new Random();
          int vdd = rand.nextInt(dd.size())+1;
          if (vdd < 0) { vdd = 0; }
          	
          if (vdd >= dd.size()) { vdd = dd.size() - 1; }
          new Select(driver.findElement(By.id(by))).selectByIndex(vdd);

      }
	  
	  public static void clickAll(String id, int camp1, int camp2) throws Exception{          
              for (int i = camp1; i <= camp2; i=i +2){
              Thread.sleep(200);
              driver.findElement(By.id(id + i)).click();
              }
	  	}

      	public static void elementClick(String byID) {
      			driver.findElement(By.id(byID)).click();
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
      	
     	public static void ranclickOption(String[] id, int min, int max) throws Exception{
 			
     		Random rand = new Random();
     		int selOp = rand.nextInt(max-min)+1;
     		if (selOp >= id.length){
     			selOp = selOp -1;
     		} 		
     		for (int i = 1; i <= selOp;i++ ){
     			
     			if (selOp == id.length -1){
     				if (!driver.findElement(By.id(id[i])).isSelected()){
     					driver.findElement(By.id(id[i])).click();
     					Thread.sleep(300);
     				}	
     			}else{
     			int selc = rand.nextInt(max-min)+1;
     			if (selc == id.length){
     				selc = selc - 1;
     			}
     			if (!driver.findElement(By.id(id[i])).isSelected()){
     					driver.findElement(By.id(id[selc])).click();
     						Thread.sleep(1000);
     					}	
     	 			}	
     		}	
     		
     	}
     	
     	public static void dateSel() throws Exception{
			calF = Calendar.getInstance();
			calT = Calendar.getInstance();
		 sft = new SimpleDateFormat("dd/MM/yyyy");
		calF.set(ranNumbr(2017,2018), dateMFrom, ranNumbr(1,31));
		calT.set(ranNumbr(1972,1979), ranNumbr(1,12), ranNumbr(1,31));

	}
     	public static int ranNumbr(int min, int max) {
   		  Random rand = new Random();
   		  numbering = min+rand.nextInt((max-min)+1);
   		  return numbering;
   		  
   	  }
     	public static void notEmptyDropDown(String by) throws Exception{
            Select fDropDown = new Select (driver.findElement(By.id(by)));
            List<WebElement> fDsel = fDropDown.getOptions();
            fDsel.size();             
            if (fDsel.size() > 1){
            	selectDropDownClick(by);
            }
            Thread.sleep(1000);
     	}

     	public static int ranYearNumbr(int min, int max) {
     		  Random rand = new Random();
     		  numbering = min+rand.nextInt((max-min)+1);
     		  return numbering;    		  
       	}
     	
     	public static void loginPage(String usr, String pwd) throws Exception{
     			driver.findElement(By.id(loginField)).sendKeys(usr);
     			driver.findElement(By.id(passField)).sendKeys(pwd);
     			driver.findElement(By.id(loginButton)).click();
     			Thread.sleep(1000);
     	}
     	/*public static String dniLetra (int dni){
  		  return String.valueOf(dni)+(NIF_STRING_ASOCIATION.charAt(dni % 23));
  	  }*/
      	
}
