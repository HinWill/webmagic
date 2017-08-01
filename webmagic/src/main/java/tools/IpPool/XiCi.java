package tools.IpPool;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gray- on 2017/7/18.
 * 爬取西刺上前10页的ip
 */
public class XiCi implements PageProcessor {
    private Site site = Site.me().setSleepTime(10000).setRetrySleepTime(3000).setCycleRetryTimes(3);
    private static Map<String,Integer> map = new HashMap<String, Integer>();


    public void process(Page page) {
        List<String> ips = page.getHtml().xpath("//tr[@class='odd']/allText()").all();

        for(String ip : ips){
            String id = ip.split(" ")[0];
            Integer port = Integer.parseInt(ip.split(" ")[1]);
            System.out.println("id = " + id + "  port = " + port);
            map.put(id,port);
        }

        for(int i=2;i<10;i++){
            page.addTargetRequest("http://www.xicidaili.com/nn/"+i);
        }
    }



    public Site getSite() {
        return site;
    }

    public static void main(String[] args){
        while(true){
            Spider.create(new XiCi())
                    .addUrl("http://www.xicidaili.com/nn/1")
                    .thread(5)
                    .run();

            new CheckIp().main(map);
        }

    }
}
