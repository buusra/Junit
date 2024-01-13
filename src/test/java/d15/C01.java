package d15;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01 extends TestBase {

    @Test
    public void test01() {

        //facebook sayfasina gidiniz
        driver.get("https://facebook.com");

        //ekran resmi aliniz
        screenShot();
    }

    @Test
    public void webElementScreenShot() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        driver.navigate().refresh();
        driver.navigate().refresh();


        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        //ekran resmini alalım
        screenShot();

        //sonuc yazısı webelementinin resmini alalım

        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format( LocalDateTime.now() );

        String dosyaYolu="src/test/java/screenShots/"+date+"webElementSS.png";

        Files.write(Paths.get(dosyaYolu) , sonucYazisi.getScreenshotAs(OutputType.BYTES) );


    }

    @Test
    public void webElementScreenShot2() throws IOException {

        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");

        driver.navigate().refresh();
        driver.navigate().refresh();


        //Arama kutusunda laptop aratalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        //ekran resmini alalım
        screenShot();

        //sonuc yazısı webelementinin resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        screenShotOfWebElement(sonucYazisi);


    }


}
