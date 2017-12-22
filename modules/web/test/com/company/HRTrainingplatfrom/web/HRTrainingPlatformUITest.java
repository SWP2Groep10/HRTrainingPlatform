package com.company.HRTrainingplatfrom.web;



import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HRTrainingPlatformUITest {

    @Test
    public void createManager(){
        //Open Website
        open("http://localhost:8080/app");
        //login as Admin
        $(By.xpath("//*[@cuba-id='loginField']")).shouldBe(visible).setValue("admin");
        $(By.xpath("//*[@cuba-id='passwordField']")).shouldBe(visible).setValue("admin");

        //Click Submit Button
        $(By.xpath("//*[@cuba-id='loginButton']")).shouldBe(visible).click();

        //Test is too fast compared to the Web (Wait for it to load the javascript correctly)
        sleep(1500);

        //Open 'Users' tab
        $x(("//*[@cuba-id='sideMenu']//*[@cuba-id='Users']")).shouldBe(visible).click();

        //Open Managers
        sleep(1000);
        $x(("//*[@cuba-id='sideMenu']//*[text()='Managers']")).shouldBe(visible).click();

        //Click Create Button
        $(By.xpath("//*[@cuba-id='createBtn']")).shouldBe(visible).click();

        //Select 'Lookup'
        $(By.xpath("//*[@cuba-id='lookup']")).shouldBe(visible).click();

        //Create a User
        $(By.xpath("//*[@cuba-id='userTableCreateBtn']")).shouldBe(visible).click();

        //insert user Values
        $(By.xpath("//*[@cuba-id='login']")).shouldBe(visible).setValue("CubaFrameWork@666");
        $(By.xpath("//*[@cuba-id='passw']")).shouldBe(visible).setValue("Pass");
        $(By.xpath("//*[@cuba-id='confirmPassw']")).shouldBe(visible).setValue("Pass");
        $(By.xpath("//*[@cuba-id='firstName']")).shouldBe(visible).setValue("Brent");
        $(By.xpath("//*[@cuba-id='middleName']")).shouldBe(visible).setValue("Amir");
        $(By.xpath("//*[@cuba-id='lastName']")).shouldBe(visible).setValue("Ricardo");

        //commit
        $(By.xpath("//*[@cuba-id='windowCommit']")).shouldBe(visible).click();

        //Select User
        $(By.xpath("//*[@cuba-id='selectButton']")).shouldBe(visible).click();

        //Save
        $(By.xpath("//*[@cuba-id='saveBtn']")).shouldBe(visible).click();

        //Remove
        $(By.xpath("//*[@cuba-id='removeBtn']")).shouldBe(visible).click();
        $(By.xpath("//*[@cuba-id='optionDialog_ok']")).shouldBe(visible).click();

        //logout
        $(By.xpath("//*[@cuba-id='logoutButton']")).shouldBe(visible).click();

    }

    @Test
    public void createTraining(){
        //Open Website
        open("http://localhost:8080/app");
        //login as Admin
        $(By.xpath("//*[@cuba-id='loginField']")).shouldBe(visible).setValue("admin");
        $(By.xpath("//*[@cuba-id='passwordField']")).shouldBe(visible).setValue("admin");

        //Click Submit Button
        $(By.xpath("//*[@cuba-id='loginButton']")).shouldBe(visible).click();

        //Test is too fast compared to the Web (Wait for it to load the javascript correctly)
        sleep(1500);

        //Open 'Training' tab
        $x(("//*[@cuba-id='sideMenu']//*[@cuba-id='Training']")).shouldBe(visible).click();

        //Open Training
        sleep(1000);
        $x(("//*[@cuba-id='sideMenu']//*[text()='Trainings']")).shouldBe(visible).click();

        //Create a Training
        $x("//*[@cuba-id='createBtn']").shouldBe(visible).click();
        //Input Description start/end date of the training + status
        $x("//*[@cuba-id='WebResizableTextArea_trainingDs_description']").shouldBe(visible)
                .setValue("This is the Description of the Training im creating during a test . . .");

        $x("//*[@cuba-id='startDate']//input[@aria-controls='gwt-uid-6']")
                .shouldBe(visible).setValue("10/01/2018");

        $x("//*[@cuba-id='startDate']//input[@id='6cbba21f5b54e9c1bddfae02ce899ec0']")
                .shouldBe(visible).setValue("10:00");

        $x("//*[@cuba-id='endDate']//input[@aria-controls='gwt-uid-8'")
                .shouldBe(visible).setValue("15/01/2018");

        $x("//*[@cuba-id='endDate']//input[@id='4ce1cd5ce482768ca17e3bada6660862']")
                .shouldBe(visible).setValue("22:00");

        $x("//*[@cuba-id='status']//*[@role='button']").shouldBe(visible).click();
        $x("//*[@cuba-id='status']//*[@id='VAADIN_COMBOBOX_OPTIONLIST']//span[text()='Ongoing']")
                .shouldBe(visible).click();

        $x("//*[@cuba-id='add']").shouldBe(visible).click();
        $x("//*[@cuba-id='table_composition']//table//tr[1]").shouldBe(visible).doubleClick();
        //Create Location for The Training
        $x("//*[@cuba-id='Locations']").shouldBe(visible).click();
        $x("//*[@cuba-id='add']").shouldBe(visible).click();
        $x("//*[@cuba-id='createBtn']").shouldBe(visible).click();
        $x("//*[@cuba-id='lookup']").shouldBe(visible).click();
        $x("//*[@cuba-id='createBtn']").shouldBe(visible).click();
        //Input data for the address
        $x("//*[@cuba-id='country']").shouldBe(visible).setValue("Belgium");
        $x("//*[@cuba-id='city']").shouldBe(visible).setValue("Brussels");
        $x("//*[@cuba-id='postalcode']").shouldBe(visible).setValue("1070");
        $x("//*[@cuba-id='street']").shouldBe(visible).setValue("Nijverheidskaai");
        $x("//*[@cuba-id='number']").shouldBe(visible).setValue("170");
        //commit Address
        $x("//*[@cuba-id='windowCommit']").shouldBe(visible).click();
        $x("//*[@cuba-id='selectButton']").shouldBe(visible).click();
        $x("//*[@cuba-id='locationName']").shouldBe(visible).setValue("Auditorium A4");
        $x("//*[@cuba-id='saveBtn']").shouldBe(visible).click();
        $x("//*[@cuba-id='selectButton']").shouldBe(visible).click();

        //Add a Book to the Training
        $x("//*[@cuba-id='RecommendedBooks']").shouldBe(visible).click();
        $x("//*[@cuba-id='add']").shouldBe(visible).click();
        $x("//*[@cuba-id='createBtn']").shouldBe(visible).click();
        $x("//*[@cuba-id='isbn']").shouldBe(visible).setValue("9781306810494");
        $x("//*[@cuba-id='selectButton']").shouldBe(visible).click();
        $x("//*[@cuba-id='windowCommit']").shouldBe(visible).click();

        //Delete Training
        $x("//*[@cuba-id='removeBtn']").shouldBe(visible).click();
        $x("//*[@cuba-id='optionDialog_ok']").shouldBe(visible).click();

    }
}
