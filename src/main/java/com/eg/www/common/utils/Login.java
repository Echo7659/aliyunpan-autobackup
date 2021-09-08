package com.eg.www.common.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * @author: Eg
 * @Date: 2021/9/8 13:19
 */
public class Login {


    /**
     * @param user 用户名
     * @param pwd  密码
     * @return token
     */
    public static String getToken(String user, String pwd) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //谷歌浏览器
        WebDriver driver = new ChromeDriver();
        //设置访问网址
        String baseurl = "https://www.aliyundrive.com/sign/in?spm=aliyundrive.index.0.0.2d836020snGCDV";

        driver.get(baseurl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement loginFrame = driver.findElement(By.className("login-frame")).findElement(By.tagName("iframe"));
        WebElement frame = driver.switchTo().frame(loginFrame).findElement(By.id("alibaba-login-box"));
        //点击切换到账号登陆
        driver.switchTo().frame(frame).findElement(By.className("block0")).findElements(By.className("sms-login-link")).get(0).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //账号框 && 密码框
        driver.findElement(By.name("fm-login-id")).sendKeys(user);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.name("fm-login-password")).sendKeys(pwd);

        Thread.sleep(2000L);

        //登陆按钮
        driver.findElement(By.className("password-login")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //滑动验证
        WebDriver yzm = driver.switchTo().frame("baxia-dialog-content");
        WebElement moveButton = yzm.findElement(By.id("nc_1_n1z"));

        Actions action = new Actions(yzm);
        //移到滑块元素并悬停
        action.moveToElement(moveButton).clickAndHold(moveButton);
        action.dragAndDropBy(moveButton,270, 0).perform();
        action.release();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //执行js脚本
        String getToken = "JSON.parse(localStorage.getItem('token'))."+"refresh_token";

        return ((JavascriptExecutor) driver).executeScript(getToken).toString();
    }

}
