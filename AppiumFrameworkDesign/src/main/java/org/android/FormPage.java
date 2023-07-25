package org.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

public class FormPage extends AndroidActions {
    AndroidDriver driver ;

public FormPage(AndroidDriver driver){
    super(driver);
    this.driver=driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver),this);


}


    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Enter name here']")
    private WebElement nameField;
//driver.findElement(By.xpath("//android.widget.EditText[@text='Enter name here']")).sendKeys("ariella ferrera");

     @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
      private WebElement femaleOption;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
    private WebElement maleOption;
// driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countrySelection;
    // driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();


@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;
    //        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

    public void setNameField(String name)
    {
        nameField.sendKeys(name);
        //driver.hideKeyboard();
    }
    public void setGender(String gender)
    {
        if(gender.contains("female"))
            femaleOption.click();
        else
            maleOption.click();
    }
    public void setCountrySelection(String countryName)
    {
        countrySelection.click();
        scrollToText(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }
    public void submitForm(){
        shopButton.click();
    }

}
