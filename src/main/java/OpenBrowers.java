import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by pc on 2017/3/25.
 */
public class OpenBrowers {

    /**
     *打开默认安装的Firefox,只支持v48以下的版本，
     * 超出v48的版本也需要firefox的driver文件
     */
    @Test
    public void openDefalutFirefox(){
        WebDriver wb = new FirefoxDriver();
        wb.get("http://www.baidu.com");
    }

    /**
     *打开非默认安装的Firefox,只支持v48以下的版本，
     * 超出v48的版本需要firefox的driver文件
     */
    @Test
    public void openNotDefaultFirefox(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver wb = new FirefoxDriver();
        wb.manage().window().maximize();
        wb.get("http://www.baidu.com");
        wb.findElement(By.id("kw")).sendKeys("frist selenium!");
        wb.findElement(By.id("su")).click();
        String s = wb.getTitle();
        Assert.assertEquals(s,"百度一下，你就知道");
        wb.quit();
    }

    @Test
    public void openChrome(){
        System.setProperty("webdriver.chrome.driver","F:\\IdeaProjectsWork\\selenium2\\drivers\\chromedriver.exe");
        WebDriver wb = new ChromeDriver();
        wb.get("http://www.baidu.com");
    }

    public void openIe(){
//        System.setProperty("webdriver.ie.driver","F:\\IdeaProjectsWork\\selenium2\\drivers\\chromedriver.exe");
//        WebDriver wb = new InternetExplorerDriver();

    }
}
