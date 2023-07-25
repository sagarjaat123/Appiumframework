package org.SELMOB;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.android.CartPage;
import org.android.FormPage;
import org.android.ProductCatalogue;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Ec_Tc_4_hybrid extends BaseTest {
    @Test

    public void fillForm() throws InterruptedException {

        FormPage formPage = new FormPage(driver);
        formPage.setNameField("abrakadabra");
        formPage.setGender("female");
        formPage.setCountrySelection("Argentina");
        formPage.submitForm();

        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.goToCartPage();

        CartPage cartPage=new CartPage(driver);
       double totalSum = cartPage.getProdcutsSum();
       double displayFormattedSum =cartPage.getTotalAmountDisplayed();
       Assert.assertEquals(totalSum,displayFormattedSum);
       cartPage.acceptTermsConditions();
       cartPage.submitOrder();





    }

}
