package generator;

import client.LmtTestClient;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class LmtTest {
    private LmtTestClient lmtTestClient;

    @Test
    void lmtUiTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        lmtTestClient = new LmtTestClient();
        lmtTestClient.openUrl("https://edlus.lmt.lv");
        lmtTestClient.titleMatch("LMT elektroniskā darbalaika uzskaite – EDLUS");
        lmtTestClient.clickOnLinkText("Funkcijas");
        lmtTestClient.closeCookies();
        lmtTestClient.navigateBack();
        if (lmtTestClient.linkIsVisible("Pieteikties konsultācijai")){
            lmtTestClient.clickOnLinkText("Pieteikties konsultācijai");
        }
        else{
            assertTrue(false);
        }
        lmtTestClient.fillField("companyId2","LMT");
        lmtTestClient.fillField("nameId2","Jānis");
        lmtTestClient.fillField("surnameId2","Bērziņš");
        lmtTestClient.fillField("phone","+37122222222");
        lmtTestClient.fillField("emailId2","janis@berzins.lv");
        lmtTestClient.fillField("commentId2","Komentars");
    }

}
