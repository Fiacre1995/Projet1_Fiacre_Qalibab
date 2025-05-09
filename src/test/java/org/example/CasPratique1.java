package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CasPratique1 {

    WebDriver driver;


    @BeforeMethod
    public void ouvrirNavigateur() {
        // Définir le chemin du  webdriver
        driver = new FirefoxDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        //Vérifier le titre de la page
        String titrePageAuthentification = driver.getTitle();    // Récupère le titre de la page sur laquelle on se trouve
        assert titrePageAuthentification.contains("OrangeHRM");

        //Vérifier que mot "Login" est charger
        //Vérifier que mot "Login" est charger
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement testElement = wait2.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5")));
        assert testElement.getText().contains("Login");

    }


    @Test(priority = 1)
    public void loginOrangeHrmValide() throws InterruptedException {
        // Code de Test
        // Localiser le champ "identifiant" et du "mot de passe"
        // Entrées les données des différents champs
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Attente explicite sur le bouton Login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement boutonLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
        boutonLogin.click();

        //Vérifier le chargement de la page de Dashboard
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement testElement = wait3.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")));
        assert testElement.getText().contains("Dashboard");

    }


    @Test(priority = 2)
    public void ajouterEmploye() {
        // Localiser le champ "identifiant" et du "mot de passe"
        // Entrées les données des différents champs
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Attente explicite sur le bouton Login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement boutonLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
        boutonLogin.click();


        //Vérifier que le lien PIM est cliquable
        //cliquer sur le lien PIM
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement lienPIM = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")));
        lienPIM.click();

        //Vérifier que nous sommes rédiriger vers la page de PIM
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement testElement = wait3.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-navigation > header > div.oxd-topbar-header > div.oxd-topbar-header-title > span > h6")));
        assert testElement.getText().contains("PIM");

        //Cliquer sur le bouton add
        WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement boutonAdd = wait4.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div.orangehrm-paper-container > div.orangehrm-header-container > button")));
        boutonAdd.click();

        //Vérifier que nous sommes sur la page du formulaire
        WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titreFormulaireAjout = wait5.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#app > div.oxd-layout.orangehrm-upgrade-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > h6")));
        assert titreFormulaireAjout.getText().contains("Add Employee");

        // Entrées les données des différents champs
        driver.findElement(By.name("firstName")).clear();
        driver.findElement(By.name("firstName")).sendKeys("Prenom2025@");
        driver.findElement(By.name("middleName")).clear();
        driver.findElement(By.name("middleName")).sendKeys("Prenom2025@");
        driver.findElement(By.name("lastName")).clear();
        driver.findElement(By.name("lastName")).sendKeys("Nom2025@");

        //Cocher le checkbox ayant pour libellé "Create Login Details"
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")).click();

        //Vérifier que les champs en plus du formulaire sont affichés
        WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement titreUsername = wait6.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[1]/label")));
        assert titreUsername.getText().contains("Status");

        // Entrées les données pour  les champs supplémentaires
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")).sendKeys("Username2025@13");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")).sendKeys("Password2025");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")).sendKeys("Password2025");

        //Cliquer sur le bouton "Save"
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();

        //Vérifier que nous sommes rédirigé vers la page des informations détaillés
        WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement informationsPersonnels = wait6.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/h6")));
        assert informationsPersonnels.getText().contains("Personal Details");
    }

    @AfterMethod
    public void fermerNavigateur() {
        if(driver!= null) {
            driver.quit();
        }
    }

}
