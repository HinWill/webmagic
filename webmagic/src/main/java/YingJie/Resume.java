package YingJie;

import YingJie.dao.PersinfoMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.JsonPathSelector;

import java.sql.SQLException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gray- on 2017/7/25.
 */
public class Resume implements PageProcessor {

    private Site site = Site.me().setSleepTime(1000)
            .setCycleRetryTimes(3)
            .setRetryTimes(3)
            .setSleepTime(3000)
            .setDomain("my.yjbys.com")
            .addCookie("CNZZDATA1253407990","1099215119-1500703226-http%253A%252F%252Fmy.yjbys.com%252F%7C1500953822")
            .addCookie("CNZZDATA1743748","cnzz_eid%3D1865067504-1500856408-%26ntime%3D1500956258")
            .addCookie("CNZZDATA42830","cnzz_eid%3D285463767-1500856597-%26ntime%3D1500959639")
            .addCookie("Hm_lvt_c90425d6f7d882fb67038702d155e16b","1500707037")
            .addCookie("PHPSESSID","ns44vckdeev6k6sjog2sufgaq4")
            .addCookie("UM_distinctid","15d132d8f744e7-08635b5310cbbe-36624308-100200-15d132d8f759b")
            .addCookie("__cfduid","deb8b55f7f8b7b9882d5e23e613f408d11499265343")
            .addCookie("cid","80aac82ab991bf12")
            .addCookie("com_c","7477480")
            .addCookie("is_company","1")
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36");


    private static int num = 67758;
    private static  String url_list = "http://my.yjbys.com/company/index.php?page=2415&m=supermarket&a=plist";
    private ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:Yingjie/spring/spring-dao.xml");
    private PersinfoMapper persinfoMapper = (PersinfoMapper)ac.getBean("persinfoMapper");


    @Override
    public void process(Page page) {

        if(page.getUrl().regex("http://my\\.yjbys\\.com/company/index\\.php\\?page=\\d+&m=supermarket&a=plist").match()){
            url_list = page.getUrl().toString();
            System.out.println("url_list = "+url_list);
        }

            List<String> urls = page.getHtml().links().regex("http://my\\.yjbys\\.com/resume-\\d+\\.htm").all();
            page.addTargetRequests(urls);

            String name = page.getHtml().xpath("/html/body/div[4]/div[3]/div[1]/div[1]/p[1]/span[1]/text()").toString();

            if (name != null) {
                //System.out.println("姓名："+name);

                String id = page.getHtml().xpath("/html/body/div[4]/div[3]/div[1]/div[2]/a/@perid").toString();
                //System.out.println("ID："+id);

                String state = page.getHtml().xpath("/html/body/div[4]/div[3]/div[1]/div[1]/p[2]/font[1]/text()").toString();
                //System.out.println("状态："+state);

                String sex = page.getHtml().xpath("/html/body/div[4]/div[3]/div[1]/div[1]/p[2]/font[2]/text()").toString();
                //System.out.println("性别："+sex);

                String age = page.getHtml().xpath("/html/body/div[4]/div[3]/div[1]/div[1]/p[2]/font[3]/text()").toString();
                //System.out.println("年龄："+age);

                String university = page.getHtml().xpath("/html/body/div[4]/div[3]/div[1]/div[1]/p[2]/font[4]/text()").toString();
                //System.out.println("大学："+university);

                String university_types = page.getHtml().xpath("/html/body/div[4]/div[3]/div[1]/div[1]/p[2]/font[5]/text()").toString();
                //System.out.println("大学类型："+university_types);

                String professional = page.getHtml().xpath("/html/body/div[4]/div[3]/div[1]/div[1]/p[2]/font[6]/text()").toString();
                //System.out.println("专业："+professional);

                String birth = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[2]/table/tbody/tr[1]/td[2]/text()").toString();
                //System.out.println("出生日期："+birth);

                String graduation = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[2]/table/tbody/tr[2]/td[4]/text()").toString();
                //System.out.println("毕业日期："+graduation);

                String live_place = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[2]/table/tbody/tr[4]/td[2]/text()").toString();
                //System.out.println("居住地："+live_place);

                String native_place = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[2]/table/tbody/tr[4]/td[4]/text()").toString();
                //System.out.println("户籍："+native_place);

                String self_description = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[2]/table/tbody/tr[5]/td[2]/p/text()").toString();
                //System.out.println("自我描述："+self_description);

                String position_type = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[4]/table/tbody/tr[1]/td[2]/text()").toString();
                //System.out.println("职位类型："+position_type);

                String expect_salary = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[4]/table/tbody/tr[2]/td[2]/text()").toString();
                //System.out.println("期望月薪："+expect_salary);

                String expect_place = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[4]/table/tbody/tr[3]/td[2]/text()").toString();
                //System.out.println("期望地点："+expect_place);

                String expect_position = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[4]/table/tbody/tr[4]/td[2]/text()").toString();
                //System.out.println("期望职位："+expect_position);

                String summary_intention = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[4]/table/tbody/tr[5]/td[2]/p/text()").toString();
                //System.out.println("意向概述："+summary_intention);


                String education_experience = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[6]/allText()").toString();
                //System.out.println("教育经历："+education_experience);

                String work_experience = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[8]/allText()").toString();
                //System.out.println("工作经验："+work_experience);

                String school_rewards = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[10]/allText()").toString();
                //System.out.println("校内奖励："+school_rewards);

                String campus_jobs = page.getHtml().xpath("/html/body/div[4]/div[3]/div[2]/div[12]/allText()").toString();
                //System.out.println("校内职务："+campus_jobs);

                entity e = new entity(id, name, state, sex, age, university, university_types, professional,
                        birth, graduation, live_place, native_place, self_description, position_type, expect_salary,
                        expect_place, expect_position, summary_intention, education_experience, work_experience, school_rewards, campus_jobs);


                try {
                    persinfoMapper.insert(e);
                    num++;
                    System.out.println("这是第" + num + "条数据！");
                } catch (Exception r) {
                    r.printStackTrace();
                }


            }

            //添加下一页
            String url = page.getHtml().xpath("/html/body/div[2]/div[3]/div[2]/div[32]/div/a[3]/@href").toString();
            page.addTargetRequest(url);




    }

    @Override
    public Site getSite() {
        return site;
    }


    public static void main(String[] args){

        while(num <= 76050){
            Spider.create(new Resume())
                    .addUrl(url_list)
                    .thread(10)
                    .run();

        }

    }
}
