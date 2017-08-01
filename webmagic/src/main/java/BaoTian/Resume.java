package BaoTian;

import BaoTian.dao.ResumeDao;
import org.openqa.selenium.support.ui.Sleeper;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.downloader.HttpClientDownloader;
import us.codecraft.webmagic.processor.PageProcessor;

import BaoTian.entity.person;
import us.codecraft.webmagic.proxy.Proxy;
import us.codecraft.webmagic.proxy.SimpleProxyProvider;

import BaoTian.dao.IP;


import java.sql.SQLException;
import java.util.Date;

import static java.lang.Thread.sleep;

/**
 * Created by gray- on 2017/7/24.
 */
public class Resume implements PageProcessor {

    private int resume_id = 1;
    private int number = 0;

    private static HttpClientDownloader httpClientDownloader;

    Site site = Site.me().setTimeOut(6000)
            .setCycleRetryTimes(3)
            .setRetryTimes(3)
            .setSleepTime(5000)
            .addCookie("ASP.NET_SessionId","n2irorap4gzk4smcknrjgy55")
            .setUserAgent("Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Mobile Safari/537.36");




    @Override
    public void process(Page page) {


        String id = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[1]/tbody/tr[1]/td[3]/text()").toString().split("：")[1];
        System.out.println("ID：" + id);

        String name = "http://www.job-sky.com/zhaopin/"+page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[2]/tbody/tr[1]/td[2]/img/@src").toString();
        //System.out.println("姓名："+name);


        String sex = page.getHtml().xpath("//table[2]/tbody/tr[1]/td[4]/text()").toString();
        //System.out.println("性别："+sex);

        String height = page.getHtml().xpath("//table[2]/tbody/tr[2]/td[2]/text()").toString();
        //System.out.println("身高："+height);

        String weight = page.getHtml().xpath("//table[2]/tbody/tr[2]/td[4]/text()").toString();
        //System.out.println("体重："+weight);

        String birth = page.getHtml().xpath("//table[2]/tbody/tr[3]/td[2]/text()").toString();
        //System.out.println("出生日期："+birth);

        String national = page.getHtml().xpath("//table[2]/tbody/tr[3]/td[4]/text()").toString();
        //System.out.println("民族："+national);

        String marriage = page.getHtml().xpath("//table[2]/tbody/tr[4]/td[2]/text()").toString();
        //System.out.println("婚姻状况："+marriage);

        String political = page.getHtml().xpath("//table[2]/tbody/tr[4]/td[4]/text()").toString();
        //System.out.println("政治面貌："+political);

        String identity = page.getHtml().xpath("//table[2]/tbody/tr[5]/td[2]/text()").toString();
        //System.out.println("证件号码："+identity);

        String census_register = page.getHtml().xpath("//table[2]/tbody/tr[6]/td[2]/text()").toString();
        //System.out.println("户口所在地："+census_register);

        String now_living = page.getHtml().xpath("//table[2]/tbody/tr[7]/td[2]/text()").toString();
        //System.out.println("目前所在地："+now_living);


            //求职意向与工作经历


        String working_time = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[4]/tbody/tr[1]/td[2]/text()").toString();
        //System.out.println("工作时间："+working_time);

        String job_type = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[4]/tbody/tr[1]/td[4]/text()").toString();
        //System.out.println("求职类型："+job_type);

        String position_applied = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[4]/tbody/tr[2]/td[2]/text()").toString();
        //System.out.println("应聘职位："+position_applied);

        String position_applied2 = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[4]/tbody/tr[2]/td[4]/text()").toString();
        //System.out.println("应聘职位2："+position_applied2);

        String position_applied3 = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[4]/tbody/tr[3]/td[2]/text()").toString();
        //System.out.println("应聘职位3："+position_applied3);

        String salary_requirement = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[4]/tbody/tr[3]/td[4]/text()").toString();
        //System.out.println("薪资要求："+salary_requirement);

        String location_preference = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[4]/tbody/tr[4]/td[2]/text()").toString();
        //System.out.println("希望工作地点："+location_preference);

        String work_experience = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[4]/tbody/tr[5]/td[2]/text()").toString();
        //System.out.println("个人工作经历："+work_experience);


            //教育培训背景


        String education = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[1]/td[2]/text()").toString();
        //System.out.println("文化程度："+education);

        String school_graduation = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[1]/td[4]/text()").toString();
        //System.out.println("最后毕业学校："+school_graduation);

        String time_graduation = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[2]/td[2]/text()").toString();
        //System.out.println("毕业时间："+time_graduation);

        String computer_level = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[2]/td[4]/text()").toString();
        //System.out.println("计算机水平："+computer_level);

        String foreign_language = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[3]/td[2]/text()").toString();
        //System.out.println("外语类型："+foreign_language);

        String foreign_language_level = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[3]/td[4]/text()").toString();
        //System.out.println("外语水平："+foreign_language_level);

        String mandarin = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[4]/td[2]/text()").toString();
        //System.out.println("国语水平："+mandarin);

        String cantonese = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[4]/td[4]/text()").toString();
        //System.out.println("粤语水平："+cantonese);

        String kind_professions = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[5]/td[2]/text()").toString();
        //System.out.println("所学专业类别："+kind_professions);

        String kind_professions2 = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[5]/td[4]/text()").toString();
        //System.out.println("第二专业类别："+kind_professions2);

        String education_experience = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[6]/td[2]/text()").toString();
        //System.out.println("受教育经历："+education_experience);

        String personal_ability = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[6]/tbody/tr[7]/td[2]/text()").toString();
        //System.out.println("个人能力介绍："+personal_ability);


        String mailing_address = page.getHtml().xpath("/html/body/div/table/tbody/tr/td/table[8]/tbody/tr/td[2]/text()").toString();
        //System.out.println("通信地址："+mailing_address);


        ResumeDao r = new ResumeDao();
        person p = new person(id,name,sex,height,weight,birth,national,marriage,political,identity,census_register,now_living,
                working_time,job_type,position_applied,position_applied2,position_applied3,salary_requirement,location_preference,
                work_experience,education,school_graduation,time_graduation,computer_level,foreign_language,foreign_language_level,
                mandarin,cantonese,kind_professions,kind_professions2,education_experience,personal_ability,mailing_address);

        try{
            r.add(p);
            number++;
            System.out.println("已经爬取了"+number+"条数据！");
//            if(number%20 == 0) {
//                replaceIP();
//            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        for(int i = 0; i<10; i++){
            page.addTargetRequest("http://www.job-sky.com/zhaopin/ShowPerson.aspx?aid="+(++resume_id));
        }

    }


    public static void replaceIP(){
        IP ip = new IP();
        httpClientDownloader = new HttpClientDownloader();

        String host = ip.main().split(":")[0];
        int port = Integer.parseInt(ip.main().split(":")[1]);

        //httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(
         //       new Proxy(host,port)));
        httpClientDownloader.setProxyProvider(SimpleProxyProvider.from(new Proxy(host,port)));


    }





    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args){
        //replaceIP();
        Spider.create(new Resume())
                .addUrl("http://www.job-sky.com/zhaopin/ShowPerson.aspx?aid=1")
                //.setDownloader(httpClientDownloader)
                .thread(1)
                .run();

    }
}
