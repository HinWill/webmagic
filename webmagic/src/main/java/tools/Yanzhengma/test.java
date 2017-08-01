package tools.Yanzhengma;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileWriter;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by gray- on 2017/7/19.
 */
public class test implements PageProcessor {

    private File f = new File("E:\\aa.txt");
    private FileWriter fw = null;

    Site site = Site.me()
            .addCookie("Hm_lpvt_b8ccf9ffbbd48293af958655ebf26781","1500535659")
            .addCookie("Hm_lvt_b8ccf9ffbbd48293af958655ebf26781","1500427600,1500457205,1500474845,1500514904")
            .addCookie("IESESSION","alive")
            .addCookie("JSESSIONID","04B6CAAD66AA130FE1FD39948CBA9D7E.tomcat2")
            .addCookie("__utma","44937531.1077606459.1498529576.1500518489.1500531367.23")
            .addCookie("__utmb","44937531.36.10.1500531367")
            .addCookie("__utmc","44937531")
            .addCookie("__utmz","44937531.1498529576.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)")
            .addCookie("pgv_pvi","1922822144")
            .addCookie("pgv_si","s4936352768")

            .setDomain("vip.01hr.com")
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")
            .setSleepTime(1000);

    @Override
    public void process(Page page)   {

//
//        for(int i=39;i<=386;i++){
//            for(int j=39;j<=386;j++)
//            {
//                String url = "http://vip.01hr.com/resume/result.do?asc=1&sort=-1&searcherId=0&degree_item=1&workYear_item=1&dateNum_item=1&salary_item=1&livingPlaceIdList_item=1&text=&locationIdList="+i+"&degree=-1&workYearsStart=&workYearsEnd=&dateNum=365&salary=2076&gender=0&ageStart=&ageEnd=&livingPlaceIdList="+j+"&speciality=&isHavePhoto=0&workType=0&registeredPlaceIdList=&resumeType=0&uid=&jobTypeNameKey=&name=";
//                page.addTargetRequest(url);
//            }
//        }
//
//        String num = page.getHtml().xpath("//*[@id=\"ResultForm\"]/div/div/table[18]/tbody/tr/td[6]/text()").toString();
//        System.out.println("简历数目="+num);
//
//
//        String location = page.getHtml().xpath("//div[@class='sea_fl']/input/@value").toString();
//        System.out.println("意向城市="+location);
//
//        String living = page.getHtml().xpath("//div[@id='livingPlaceIdList_item_d']/input/@value").toString();
//        System.out.println("所在城市="+living);
//
//        try {
//            fw = new FileWriter(f,true);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        PrintWriter pw = new PrintWriter(fw);
//        pw.println("意向城市:"+location+"----所在城市:"+living+"     简历数目="+num+page.getUrl());
//        pw.flush();
//
//        try {
//            fw.flush();
//            pw.close();
//            fw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        if (page.getHtml().xpath("//div[@class='Tishi_content']/p/text()").toString() != null) {
            System.out.println("cookies失效");



        } else {
            System.out.println("cookies有效");
        }


    }

    @Test
    public void yangzhengma() throws IOException{
        WebDriver driver = new ChromeDriver();

        driver.get("http://vip.01hr.com/company/login.do");

        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("willaa");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("18749001836a");


        WebElement ele = driver.findElement(By.id("vipImageCode"));

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        BufferedImage fullImg = ImageIO.read(screenshot);

        Point point = ele.getLocation();

        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();

        System.out.println("宽="+eleWidth+"  长="+eleHeight);




        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(),point.getY(),eleWidth,eleHeight);

        ImageIO.write(eleScreenshot,"png",screenshot);

        File screenshotLocation = new File("E:/11.png");
        FileUtils.copyFile(screenshot,screenshotLocation);



//        String picture = driver.findElement(By.id("vipImageCode")).getAttribute("src");
//
//
//        System.out.println("页面="+picture);


        String picture = null;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("页面验证码="+picture);

        driver.findElement(By.id("checkcode")).sendKeys(picture);

        //driver.findElement(By.id("submitButton")).click();

        //driver.close();
    }

    @Override
    public Site getSite() {
        return site;
    }


    public static void main(String[] args){
        Spider.create(new test())
                .addUrl("http://vip.01hr.com/resume/result.do?asc=1&sort=-1&searcherId=0&degree_item=1&workYear_item=1&dateNum_item=1&salary_item=1&livingPlaceIdList_item=1&text=&locationIdList=42&degree=-1&workYearsStart=&workYearsEnd=&dateNum=365&salary=2076&gender=0&ageStart=&ageEnd=&livingPlaceIdList=42&speciality=&isHavePhoto=0&workType=0&registeredPlaceIdList=&resumeType=0&uid=&jobTypeNameKey=&name=")
                .thread(2)
                .run();
    }
}
