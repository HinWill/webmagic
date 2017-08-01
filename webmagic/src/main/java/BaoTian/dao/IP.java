package BaoTian.dao;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by gray- on 2017/7/25.
 */
public class IP implements PageProcessor {

    private static String ip;

    Site site = Site.me().setSleepTime(1000);

    @Override
    public void process(Page page) {


        ip = page.getHtml().xpath("/html/allText()").toString();
        System.out.println("ip="+ip);

    }

    @Override
    public Site getSite() {
        return site;
    }


    public static String main(){
        Spider.create(new IP())
                .addUrl("http://api.ip.data5u.com/dynamic/get.html?order=06fc6e30c30139e667735dcd93b50015&sep=3")
                .thread(5)
                .run();
        return ip;
    }
}
