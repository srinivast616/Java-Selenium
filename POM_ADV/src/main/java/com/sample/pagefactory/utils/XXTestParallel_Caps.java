//import java.net.MalformedURLException; 
//import java.net.URL; 
//import org.openqa.selenium.Platform; 
//import org.openqa.selenium.WebDriver; 
//import org.openqa.selenium.remote.DesiredCapabilities; 
//import org.openqa.selenium.remote.RemoteWebDriver; 
//
//public class TestParallel_Caps
//
//{ 
//
//public static void main(String[] args) throws Exception {
//
//DesiredCapabilities caps = null;
//
//if(browserType.equals(“firefox”)
//
//{
//
//caps = DesiredCapabilities.firefox();
//caps = new DesiredCapabilities();
//
//
//caps.setBrowserName(“firefox”); caps.setVersion("50"); caps.setPlatform(Platform.WINDOWS);
//
//}
//
// else
//
//{
//
//caps = DesiredCapabilities.internetExplorer ();
//
//caps.setBrowserName(“iexplore”); caps.setVersion("50"); caps.setPlatform(Platform.WINDOWS);
//
//} 
//
//URL urlHub=null; 
//
//try 
//
//{ 
//
//urlHub = new URL(" http://localhost:4444/wd/hub"); 
//
//} 
//
//catch(MalformedURLException e) 
//
//{ 
//
//e.printStackTrance(); 
//
//} 
//
//RemoteWebDriver driver = new RemoteWebDriver(urlHub, caps); 
//
//driver.navigate().to(" "); 
//
//Thread.sleep(3000); 
//
//System.out.println(driver.getTitle()); 
//
//driver.quit(); 
//
//}


