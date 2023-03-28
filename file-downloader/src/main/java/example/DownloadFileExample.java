package example;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class DownloadFileExample {
   
    public static void main(String args[])
    {
        System.setProperty(
            "webdriver.chrome.driver",
            "C:\\chromedriver.exe");
        // Instantiate a ChromeDriver class.
        WebDriver driver = new ChromeDriver();
        boolean encontrado=false;
        driver.get("https://docs.thoughtmachine.net/vault-core/4-6/EN/open_api_definitions/core_api.json");
        while(encontrado==false){
        	try {
           	 	WebElement email = driver.findElement(By.id("idp-discovery-username"));
                email.sendKeys("juan.pinero@gft.com");
                driver.findElement(By.id("idp-discovery-submit")).click();
                
                encontrado=true;
           }catch(Exception e){
           	System.out.println(e.getMessage());
           }
        }
        encontrado=false;
        while(encontrado==false){
        	try {
        	      driver.findElement(By.id("okta-signin-password")).sendKeys("RP6hCELTqtqwTaMN");
        	      driver.findElement(By.id("okta-signin-submit")).click();
                encontrado=true;
           }catch(Exception e){
           	System.out.println(e.getMessage());
           }
        }
        encontrado=false;
        while(encontrado==false){
        	try {
        		  WebElement webElement = driver.findElement(By.xpath("/html/body/pre"));
        	        String json=(webElement.getText());
        	        Files.writeString(Paths.get("files/core_api.json"), json);
        	        System.out.println(json);
                encontrado=true;
           }catch(Exception e){
           	System.out.println(e.getMessage());
           }
        }
      
    }
}
