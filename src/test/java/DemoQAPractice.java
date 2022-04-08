import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class DemoQAPractice {

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:/Users/My pc/Desktop/test/extension_4_44_0_0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

    }

    @Test
    public void openElementTab(){
        WebDriver driver = new ChromeDriver();
        driver.get(H.MAINSITE);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elemntBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.ELEMENTTABCSS)));
        elemntBtn.click();
    }

    @Test
    public void openRegister() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.MAINSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elemntBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.ELEMENTTABCSS)));
        elemntBtn.click();
        Thread.sleep(3000);
        WebElement checkBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.CHECKBOXXPATH)));
        checkBox.click();
        WebElement expandArrow = driver.findElement(By.cssSelector(H.ARROWEXPANDCSS));
        expandArrow.click();
        WebElement desktopTick = driver.findElement(By.xpath(H.DESKTOPTICKXPATH));
        desktopTick.click();
        WebElement webTable = driver.findElement(By.cssSelector(H.WEBTABLEBTNCSS));
        webTable.click();
        WebElement addBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(H.ADDBTNID)));
        addBtn.click();

    }

    @Test
    public void webTable() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.TOOLTIPSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.ELEMENTMENUXPATH)));
        elementMenu.click();
        Thread.sleep(3000);
        WebElement webTable = driver.findElement(By.cssSelector(H.WEBTABLEBTNCSS));
        webTable.click();
        WebElement addBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(H.ADDBTNID)));
        addBtn.click();
        WebElement nameBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.NAMETXTBOXCSS)));
        WebElement lastNameBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.LASTNAMEBOXXPATH)));
        WebElement emailBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.EMAILBOXXPATH)));
        WebElement ageBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(H.AGEBOXID)));
        WebElement salaryBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.SALARYBOXXPATH)));
        WebElement departmentBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.DEPARTMENTBOXXPATH)));
        WebElement submitBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.SUBMITBTNXPATH)));
        nameBox.sendKeys("yohai");
        lastNameBox.sendKeys("amar");
        emailBox.sendKeys("example@gmail.com");
        ageBox.sendKeys("25");
        salaryBox.sendKeys("25000");
        departmentBox.sendKeys("QA Manager");
        submitBtn.click();
    }

    @Test
    public void webTableDelete() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.TOOLTIPSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.ELEMENTMENUXPATH)));
        elementMenu.click();
        Thread.sleep(4000);
        WebElement webTable = driver.findElement(By.cssSelector(H.WEBTABLEBTNCSS));
        webTable.click();
        WebElement addBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(H.ADDBTNID)));
        addBtn.click();
        WebElement nameBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.NAMETXTBOXCSS)));
        WebElement lastNameBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.LASTNAMEBOXXPATH)));
        WebElement emailBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.EMAILBOXXPATH)));
        WebElement ageBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(H.AGEBOXID)));
        WebElement salaryBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.SALARYBOXXPATH)));
        WebElement departmentBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.DEPARTMENTBOXXPATH)));
        WebElement submitBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.SUBMITBTNXPATH)));
        nameBox.sendKeys("yohai");
        lastNameBox.sendKeys("amar");
        emailBox.sendKeys("example@gmail.com");
        ageBox.sendKeys("25");
        salaryBox.sendKeys("25000");
        departmentBox.sendKeys("QA Manager");
        submitBtn.click();
        Thread.sleep(3000);
        WebElement deleteBtn = driver.findElement(By.cssSelector(H.DELETEFROMTABLECSS));
        deleteBtn.click();
    }

    @Test
    public void webTableSearch() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        for (int i = 0; i < H.NAMEFORSEARCHARR.length; i++) {
            driver.get(H.TOOLTIPSITE);
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement elementMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.ELEMENTMENUXPATH)));
            elementMenu.click();
            Thread.sleep(4000);
            WebElement webTable = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.WEBTABLEBTNCSS)));
            webTable.click();
            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.SEARCHBOXCSS)));
            Thread.sleep(3000);
            searchBox.sendKeys(H.NAMEFORSEARCHARR[i]);
            Thread.sleep(2000);
        }
        driver.quit();
    }

    @Test
    public void deleteAll() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.TOOLTIPSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.ELEMENTMENUXPATH)));
        elementMenu.click();
        Thread.sleep(3000);
        WebElement webTable = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.WEBTABLEBTNCSS)));
        webTable.click();
        Thread.sleep(3000);
        for (int i = 0; i < H.DELETEBTNARRID.length; i++) {
            WebElement deleteBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(H.DELETEBTNARRID[i])));
            deleteBtn.click();
            Thread.sleep(3000);
        }
        driver.quit();
    }

    @Test
    public void moveTab() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.TOOLTIPSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement frameMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.FRAMEMENUCSS)));
        frameMenu.click();
        WebElement browserBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.BROWSERBTNXPATH)));
        Thread.sleep(2000);
        browserBTN.click();
        WebElement newTabBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(H.NEWTABBTNID)));
        newTabBtn.click();
//        Thread.sleep(2000);
//        driver.navigate().forward();
//        String newUrl = driver.getCurrentUrl();
//        Assert.assertEquals(newUrl, H.SAMPLESITE);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "1");
//        goes to 1st tab
    }

    @Test
    public void newMassage() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.TOOLTIPSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement frameMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.FRAMEMENUCSS)));
        frameMenu.click();
        WebElement browserBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.BROWSERBTNXPATH)));
        Thread.sleep(2000);
        browserBTN.click();
        WebElement massageBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(H.NEWMASSAGEID)));
        massageBTN.click();
    }

    @Test
    public void alerts() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.TOOLTIPSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement frameMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.FRAMEMENUCSS)));
        frameMenu.click();
//        Thread.sleep(2000);
        WebElement alertBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.ALERTBTNXPATH)));
        Thread.sleep(3000);
        alertBTN.click();
        WebElement promBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(H.PROMBTNID)));
        promBTN.click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("made it");
        Thread.sleep(5000);
        driver.switchTo().alert().accept();
    }

    @Test
    public void confirmAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.TOOLTIPSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement frameMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.FRAMEMENUCSS)));
        frameMenu.click();
//        Thread.sleep(2000);
        WebElement alertBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.ALERTBTNXPATH)));
        Thread.sleep(3000);
        alertBTN.click();
        WebElement confirmBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(H.CONFIRMALERTID)));
        confirmBTN.click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void radioBTN() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.TOOLTIPSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.ELEMENTMENUXPATH)));
        elementMenu.click();
        Thread.sleep(3000);
        WebElement radioBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.RADIOBTNXPATH)));
        radioBTN.click();
        WebElement yesTICK = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.YESTICKCSS)));
        WebElement impressiveTICK = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.IMPRESSIVETICKCSS)));
        yesTICK.click();
        Thread.sleep(3000);
        impressiveTICK.click();
    }

    @Test
    public void brokenLink() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.TOOLTIPSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement elementMenu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.ELEMENTMENUXPATH)));
        elementMenu.click();
        Thread.sleep(3000);
        WebElement brokenTab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.BROKENTABXPATH)));
        Thread.sleep(3000);
        brokenTab.click();
        WebElement brokenLINK = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.BROKENLINKXPATH)));
        brokenLINK.click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "1");
    }

    @Test
    public void selectAll() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(H.TOOLTIPSITE);
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement interactionTAB = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.INTERACTIONTABXPATH)));
        Thread.sleep(3000);
        interactionTAB.click();
        WebElement selectibleBTN = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(H.SELECTIBLEBTNXPATH)));
        Thread.sleep(3000);
        selectibleBTN.click();
        for (int i = 0; i < H.SELECTBTNARRCSS.length; i++) {
            WebElement justSelect = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(H.SELECTBTNARRCSS[i])));
            justSelect.click();
            Thread.sleep(3000);
        }
    }

}
