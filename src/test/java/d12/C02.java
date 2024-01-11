package d12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02 extends TestBase {


    @Test
    public void downloadTest() {

        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases, code")).click();

        bekle(5);


        //Dosyanın başarıyla indirilip indirilmediğini test edelim



        //   /Downloads/b10 all test cases, code.docx
        String dosyaYolu = System.getProperty("user.home") + "/Downloads/b10 all test cases, code.docx";

        //Dynamic dosya yolu almanin ikinci yolu
        String userHome = System.getProperty("user.home");
        String herkesteAyniOlanYol="/Downloads/b10 all test cases, code.docx";
        String dynamicPath =userHome+herkesteAyniOlanYol;


        Assert.assertTrue( Files.exists(Paths.get(dosyaYolu)));

    }


    @Test
    public void downloadDynamicTest()  {
        //Dynamic dosya yolu almanin ikinci yolu
        String userHome = System.getProperty("user.home");
        String herkesteAyniOlanYol="/Downloads/b10 all test cases, code.docx";
        String dynamicPath =userHome+herkesteAyniOlanYol;

        try {
            Files.delete(Paths.get(dynamicPath));
        } catch (IOException e) {
            System.out.println("Belirtilen dosya silinemedi ");
        }


        //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.partialLinkText("b10 all test cases, code")).click();

        bekle(5);


        //Dosyanın başarıyla indirilip indirilmediğini test edelim


        //Dynamic dosya yolu almanin birinci yolu
        String dosyaYolu = System.getProperty("user.home") + "/Downloads/b10 all test cases, code.docx";
        Assert.assertTrue( Files.exists(Paths.get(dosyaYolu)));


    }
}
