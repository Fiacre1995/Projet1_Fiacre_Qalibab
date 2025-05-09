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

public class AuthentificationInvalide {


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
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement testElement = wait2.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5")));
        assert testElement.getText().contains("Login");

    }

    @Test
    public void loginOrangeHrmInvalide() {
        // Code de Test
        // Localiser le champ "identifiant" et du "mot de passe"
        // Entrées les données des différents champs
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("AdminInvalide");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Attente explicite sur le bouton Login
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement boutonLogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")));
        boutonLogin.click();

        //Vérifier que nous avons un message d'erreur
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement messageErreur = wait3.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")));
        messageErreur.getText().contains("Invalid credentials");
    }

    @AfterMethod
    public void fermerNavigateur() {
        if(driver!= null) {
            driver.quit();
        }
    }
}
