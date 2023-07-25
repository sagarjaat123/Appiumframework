package org.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.AndroidActions;

import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;
    public CartPage(AndroidDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);

    }
 @AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
public List<WebElement>productList;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
    public WebElement totalAmount;

    @AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
    public WebElement terms;

    @AndroidFindBy(id="android:id/button1")
    public  WebElement acceptButton;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
    public WebElement proceed;


    @AndroidFindBy(className = "android.widget.CheckBox")
    public WebElement checkBox;


    public List<WebElement>getProductPrice(){
        return productList;

    }
    public double getProdcutsSum(){
        int count = productList.size();
        double totalSum = 0;
        for (int i = 0; i < count; i++) {
            String amountString = productList.get(i).getText();
            Double price = getFormattedAmount(amountString);
            totalSum = totalSum + price;

        }
        return totalSum;
    }

  public Double getTotalAmountDisplayed()
  {
      return getFormattedAmount(totalAmount.getText());
  }

  public void acceptTermsConditions(){
        longPressAction(terms);
        acceptButton.click();
  }
    public  Double getFormattedAmount(String amount) {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }


    public void submitOrder(){
        checkBox.click();
        proceed.click();
    }


}
