package HostPlazaBackOffice;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;


import org.openqa.selenium.chrome.ChromeDriver;


import tajikistanConfiguration.Settingsfields_File;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;




public class verConfirmación_TransitosSubidos extends Settingsfields_File {
		private static Statement stmt;
		private static String transSearch;
		private static ResultSet rs;
		public static int i;
		private static String queryString;
		private static ArrayList<String> transactionsHIds = new ArrayList<String>();
		private static ArrayList<String> transactionsPIds = new ArrayList<String>();	
		private static String Hour1;
		private static String Min1;
		private static String Sec1;

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
		

		
@Test		
			public void verConfirmacion_Transitos() throws Exception{			
			//borrarArchivosTemp("E:\\workspace\\Mavi_Repository\\conexion_BBDDSenac\\attachments\\");
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
				DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();			
				dateverTransacciones = dateF.format(date);
				transSearch = dateFormat.format(date);
				String connectionUrlPlaza = "jdbc:sqlserver://172.18.130.188:1433;DataBaseName=TAJIKISTAN_QA_TOLLPLAZA"; //+ "user=sa; password=lediscet";//" + "user=SENEGAL_QA_TOLLHOST; password=USRTOLLHOST";
				String connectionUrlHost = "jdbc:sqlserver://172.18.130.188:1433;DataBaseName=TAJIKISTAN_QA_TOLLHOST"; //+ "user=sa; password=lediscet";//" + "user=SENEGAL_QA_TOLLHOST; password=USRTOLLHOST";
			    stmt = null;
			    rs = null;
			    try {
			    		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			    		Connection conn = DriverManager.getConnection(connectionUrlPlaza, "sa", "lediscet");
			    		stmt = conn.createStatement();
			    		queryString = "select passagetime, transactionid from dbo.atransaction where passagetime like '"+transSearch+"%' ORDER BY passagetime ASC";
			    		rs = stmt.executeQuery(queryString);
			    		String [] transactions = new String[2]; 			   
			    		while (rs.next()) {
			    			for (i = 0; i < transactions.length;i++){
			    				transactions[0]= rs.getString("passagetime");
			    				transactions[1] = rs.getString("transactionid");
			    				transactionsPIds.add(transactions[i]);
			    			}
			    		}
			    		if (transactions[0]==null&&transactions[1]==null){
			    			System.out.println("No han subido tránsitos a Plaza con fecha de hoy "+dateverTransacciones);
			    			fail("No han subido tránsitos a Plaza con fecha de hoy "+dateverTransacciones);
			    		}else{
			    			System.out.println("En Plaza han subido hoy: "+transactionsPIds.size()/2);
			    			Connection conn2 = DriverManager.getConnection(connectionUrlHost, "sa", "lediscet");
			    			stmt = conn2.createStatement();
				    		queryString = "select passagetime, transactionid from dbo.atransaction where passagetime like '"+transSearch+"%' ORDER BY passagetime ASC";
				    		rs = stmt.executeQuery(queryString);
				    		while (rs.next()) {
				    			for (i = 0; i < transactions.length;i++){
				    				transactions[0]= rs.getString("passagetime");
				    				transactions[1] = rs.getString("transactionid");
				    				transactionsHIds.add(transactions[i]);
				    			}				    			
				    		}
				    		if (transactions[0]==null&&transactions[1]==null){
				    			System.out.println("No han subido tránsitos a Host con fecha de hoy "+dateverTransacciones);
				    			fail("No han subido tránsitos a Host con fecha de hoy "+dateverTransacciones);
				    		}else{
				    			Hour1 = transactionsHIds.get(0).substring(8,10);
								Min1 = transactionsHIds.get(0).substring(10,12);
								Sec1 = transactionsHIds.get(0).substring(12,14);
				    			System.out.println("En Host han subido hoy: "+transactionsPIds.size()/2);
				    			Thread.sleep(1000);
				    			HostPlazaBackOffice.BOHost_VerTransacciones.verTransacciones();
				    			Thread.sleep(1000);
				    			WebElement tablResult = driver.findElement(By.id("ctl00_ContentZone_tbl_logs"));
				    			List<WebElement> transResult = tablResult.findElements(By.tagName("tr"));				    			
				    			if (transResult.size()<3){
				    				System.out.println("No hay Transacciones en el BackOffice Web con fecha de hoy");
					    			fail("No hay Transacciones en el BackOffice Web con fecha de hoy");
					    			return;
				    			}
				    			String elementsFound = driver.findElement(By.id("ctl00_ContentZone_tablePager_LblCounter")).getText();				    			
				    			int elementBg=17;				    			
				    			if (transResult.size()>11){
			    					elementBg = 18;			    					
			    				}
				    			if (transResult.size()<19){
				    				String transRes = driver.findElement(By.xpath("//*[@id='ctl00_ContentZone_tbl_logs']/tbody/tr["+transResult.size()+"]/td[1]/a")).getText();				    				
				    				if (transRes.equals(transactionsHIds.get(1))){
				    					System.out.println("Hay "+elementsFound.substring(elementBg)+" transacciones y el último tránsito: "+transactionsHIds.get(1)+" ha subido satisfactoriamente el dia de hoy "+dateverTransacciones+" "+Hour1+":"+Min1+":"+Sec1);
				    					return;
				    				}else{
				    					System.out.println("No se ha subido el último tránsito a BackOffice Web desde HostManage de hoy");
						    			fail("No se ha subido el último tránsito a BackOffice Web HostManage con fecha de hoy");
						    			return;
				    				}
				    			}else{
				    				elementClick("ctl00_ContentZone_tablePager_BtnLast");
				    				tablResult = driver.findElement(By.id("ctl00_ContentZone_tbl_logs"));
					    			transResult = tablResult.findElements(By.tagName("tr"));
					    			String transRes = driver.findElement(By.xpath("//*[@id='ctl00_ContentZone_tbl_logs']/tbody/tr["+transResult.size()+"]/td[1]/a")).getText();
				    				if (transRes.equals(transactionsHIds.get(1))){
				    					System.out.println("Hay "+elementsFound.substring(elementBg)+" transacciones y el último tránsito: "+transactionsHIds.get(1)+" ha sido satisfactoriamente el dia de hoy "+dateverTransacciones+" "+Hour1+":"+Min1+":"+Sec1);
				    					return;
				    				}else{
				    					System.out.println("No se ha subido el último tránsito a BackOffice Web desde HostManage de hoy");
						    			fail("No se ha subido el último tránsito a BackOffice Web HostManage con fecha de hoy");
						    			return;
				    				}
				    				
				    			}
				    		}
							
			    		}

				}catch(Exception e){					
					e.printStackTrace();
					fail(e.getMessage());
				}
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